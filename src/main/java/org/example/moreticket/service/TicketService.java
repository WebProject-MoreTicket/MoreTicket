package org.example.moreticket.service;

import org.example.moreticket.entity.Ticket;
import org.example.moreticket.entity.User;
import org.example.moreticket.repository.TicketRepository;
import org.example.moreticket.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public Ticket saveTicket(int price, String seatGrade, Long userId) {
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setPrice(price);
        ticket.setSeatGrade(seatGrade);

        // userId를 통해 User 객체를 조회하고 Ticket에 설정
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 ID의 유저를 찾을 수 없습니다."));
        ticket.setUser(user);  // setUser를 통해 User 객체 설정

        return ticketRepository.save(ticket);
    }
}


