package ru.kolesnik.simplecinema.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CinemaStateDto {

    private final int totalRows;
    private final int totalColumns;
    private final List<TicketDto> availableTicketsDto;

    public CinemaStateDto(int totalRows, int totalColumns, List<TicketDto> availableTicketsDto) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableTicketsDto = availableTicketsDto;
    }

    @JsonProperty("total_rows")
    public int getTotalRows() {
        return totalRows;
    }

    @JsonProperty("total_columns")
    public int getTotalColumns() {
        return totalColumns;
    }

    @JsonProperty("available_tickets")
    public List<TicketDto> getAvailableTicketsDto() {
        return availableTicketsDto;
    }

}
