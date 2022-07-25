package ru.kolesnik.simplecinema.payload;

import java.util.UUID;

public class TicketReturnRequest {

    private UUID token;

    public void setToken(UUID token) {
        this.token = token;
    }

    public UUID getToken() {
        return token;
    }

}
