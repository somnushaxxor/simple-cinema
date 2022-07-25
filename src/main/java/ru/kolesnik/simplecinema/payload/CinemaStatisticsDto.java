package ru.kolesnik.simplecinema.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CinemaStatisticsDto {

    private final int currentIncome;
    private final int numberOfAvailableTickets;
    private final int numberOfPurchasedTickets;

    public CinemaStatisticsDto(int currentIncome, int numberOfAvailableTickets, int numberOfPurchasedTickets) {
        this.currentIncome = currentIncome;
        this.numberOfAvailableTickets = numberOfAvailableTickets;
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    @JsonProperty("current_income")
    public int getCurrentIncome() {
        return currentIncome;
    }

    @JsonProperty("number_of_available_tickets")
    public int getNumberOfAvailableTickets() {
        return numberOfAvailableTickets;
    }

    @JsonProperty("number_of_purchased_tickets")
    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

}
