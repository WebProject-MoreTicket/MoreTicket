package org.example.moreticket.service;

import org.example.moreticket.entity.Concert;
import org.example.moreticket.entity.Ticket;
import org.example.moreticket.entity.User;
import org.example.moreticket.repository.ConcertRepository;
import org.example.moreticket.repository.TicketRepository;
import org.example.moreticket.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final ConcertRepository concertRepository;

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository, ConcertRepository concertRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.concertRepository = concertRepository;
    }

    public void saveTicket(int price, String seatGrade, Long userId, Long concertId) {
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
            Concert concert = concertRepository.findById(concertId).orElseThrow(() -> new RuntimeException("콘서트를 찾을 수 없습니다."));

            Ticket ticket = new Ticket();
            ticket.setPrice(price);
            ticket.setSeatGrade(seatGrade);
            ticket.setUser(user);
            ticket.setConcert(concert);

            ticketRepository.save(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("티켓 저장 중 오류 발생");
        }
    }
    public List<Ticket> findByUserId(Long userId) {
        return ticketRepository.findByUserId(userId);
    }
}



