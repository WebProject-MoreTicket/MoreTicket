package org.example.moreticket.service;

import org.example.moreticket.entity.Ticket;
import org.example.moreticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket saveTicket(int price, String seatGrade, Long userId) {
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setPrice(price);
        ticket.setSeatGrade(seatGrade);
        ticket.setUserId(userId);
        return ticketRepository.save(ticket);
    }
}


