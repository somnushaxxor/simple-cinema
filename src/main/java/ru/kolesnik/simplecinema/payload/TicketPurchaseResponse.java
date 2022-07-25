package ru.kolesnik.simplecinema.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class TicketPurchaseResponse {

    private final UUID token;
    private final TicketDto ticketDto;

    public TicketPurchaseResponse(UUID token, TicketDto ticketDto) {
        this.token = token;
        this.ticketDto = ticketDto;
    }

    public UUID getToken() {
        return token;
    }

    @JsonProperty("ticket")
    public TicketDto getTicket() {
        return ticketDto;
    }

}
