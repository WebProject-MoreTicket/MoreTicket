package org.example.moreticket.service;

import org.example.moreticket.entity.Concert;
import org.example.moreticket.entity.Ticket;
import org.example.moreticket.repository.ConcertRepository;
import org.example.moreticket.repository.TicketRepository;
import org.example.moreticket.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final ConcertRepository concertRepository;  // ConcertRepository 주입

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository, ConcertRepository concertRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.concertRepository = concertRepository;  // 주입된 ConcertRepository 사용
    }

    public void saveTicket(int price, String seatGrade, Long userId, Long concertId) {
        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setSeatGrade(seatGrade);
        ticket.setUser(userRepository.findById(userId).orElseThrow());

        // 콘서트 정보 설정
        Concert concert = concertRepository.findById(concertId).orElseThrow();  // 콘서트 정보를 가져옴
        ticket.setConcert(concert);

        ticketRepository.save(ticket);
    }

    public List<Ticket> findTicketsByUser(Long userId) {
        return ticketRepository.findAllByUserId(userId);
    }
}
