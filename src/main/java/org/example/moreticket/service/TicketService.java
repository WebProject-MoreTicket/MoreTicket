package org.example.moreticket.service;

import org.example.moreticket.entity.Ticket;
import org.example.moreticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // 사용자 ID를 통해 티켓 목록 조회
    public List<Ticket> getTicketsByUserId(Long userId) {
        return ticketRepository.findByUserId(userId);
    }
}

