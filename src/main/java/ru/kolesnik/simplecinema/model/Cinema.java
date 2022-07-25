package ru.kolesnik.simplecinema.model;

import ru.kolesnik.simplecinema.exception.RowColumnOutOfBoundsException;
import ru.kolesnik.simplecinema.exception.TicketAlreadyPurchasedException;
import ru.kolesnik.simplecinema.exception.WrongPasswordException;
import ru.kolesnik.simplecinema.exception.WrongTokenException;
import ru.kolesnik.simplecinema.payload.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Cinema {

    private static final String PASSWORD = "super_secret";

    private final int totalRows;
    private final int totalColumns;
    private final List<Ticket> allTickets;
    private final Map<UUID, Ticket> purchasedTickets;
    private int currentIncome;
    private int numberOfAvailableTickets;
    private int numberOfPurchasedTickets;

    public Cinema() {
        totalRows = 9;
        totalColumns = 9;
        allTickets = new ArrayList<>();
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumns; j++) {
                allTickets.add(new Ticket(i, j));
            }
        }
        purchasedTickets = new ConcurrentHashMap<>();
        numberOfAvailableTickets = totalRows * totalColumns;
    }

    public CinemaStateDto getState() {
        return new CinemaStateDto(totalRows, totalColumns, getAvailableTicketsDto());
    }

    public TicketPurchaseResponse purchaseTicket(int row, int column) {
        Ticket requestedTicket = getTicket(row, column);
        if (requestedTicket != null && requestedTicket.isAvailable()) {
            requestedTicket.setAvailable(false);
            UUID token = UUID.randomUUID();
            purchasedTickets.put(token, requestedTicket);
            currentIncome += requestedTicket.getPrice();
            numberOfAvailableTickets--;
            numberOfPurchasedTickets++;
            return new TicketPurchaseResponse(token, new TicketDto(requestedTicket));
        } else {
            throw new TicketAlreadyPurchasedException();
        }
    }

    public TicketReturnResponse returnTicket(UUID token) {
        if (purchasedTickets.containsKey(token)) {
            Ticket returnedTicket = purchasedTickets.remove(token);
            returnedTicket.setAvailable(true);
            currentIncome -= returnedTicket.getPrice();
            numberOfAvailableTickets++;
            numberOfPurchasedTickets--;
            return new TicketReturnResponse(new TicketDto(returnedTicket));
        } else {
            throw new WrongTokenException();
        }
    }

    public CinemaStatisticsDto getStatistics(String password) {
        if (password == null || !password.equals(PASSWORD)) {
            throw new WrongPasswordException();
        } else {
            return new CinemaStatisticsDto(currentIncome, numberOfAvailableTickets, numberOfPurchasedTickets);
        }
    }

    private List<TicketDto> getAvailableTicketsDto() {
        List<TicketDto> availableTicketsDto = new ArrayList<>();
        for (Ticket ticket : allTickets) {
            if (ticket.isAvailable()) {
                availableTicketsDto.add(new TicketDto(ticket));
            }
        }
        return availableTicketsDto;
    }

    private Ticket getTicket(int row, int column) {
        if (row < 1 || row > totalRows || column < 1 || column > totalColumns) {
            throw new RowColumnOutOfBoundsException();
        }
        for (Ticket ticket : allTickets) {
            if (ticket.getRow() == row && ticket.getColumn() == column) {
                return ticket;
            }
        }
        return null;
    }

}
