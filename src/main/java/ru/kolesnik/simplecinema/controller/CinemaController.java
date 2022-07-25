package ru.kolesnik.simplecinema.controller;

import org.springframework.web.bind.annotation.*;
import ru.kolesnik.simplecinema.model.Cinema;
import ru.kolesnik.simplecinema.payload.*;


@RestController
public class CinemaController {

    private final Cinema cinema = new Cinema();

    @GetMapping("/cinema")
    public CinemaStateDto getCinemaState() {
        return cinema.getState();
    }

    @PostMapping("/purchase")
    public TicketPurchaseResponse purchaseTicket(@RequestBody TicketPurchaseRequest purchaseRequest) {
        return cinema.purchaseTicket(purchaseRequest.getRow(), purchaseRequest.getColumn());
    }

    @PostMapping("/return")
    public TicketReturnResponse returnTicket(@RequestBody TicketReturnRequest returnRequest) {
        return cinema.returnTicket(returnRequest.getToken());
    }

    @PostMapping("/stats")
    public CinemaStatisticsDto getStatistics(@RequestParam(required = false) String password) {
        return cinema.getStatistics(password);
    }

}
