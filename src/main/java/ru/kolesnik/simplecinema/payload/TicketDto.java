package ru.kolesnik.simplecinema.payload;

import ru.kolesnik.simplecinema.model.Ticket;

public class TicketDto {

    private final int row;
    private final int column;
    private final int price;

    public TicketDto(Ticket ticket) {
        row = ticket.getRow();
        column = ticket.getColumn();
        price = ticket.getPrice();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

}
