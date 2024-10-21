package org.example.moreticket.service;

import org.example.moreticket.entity.Ticket;
import org.example.moreticket.entity.User;
import org.example.moreticket.repository.TicketRepository;
import org.example.moreticket.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public void saveTicket(int price, String seatGrade, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));  // 유저 유효성 검사

        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setSeatGrade(seatGrade);
        ticket.setUser(user);

        ticketRepository.save(ticket);  // 티켓 저장
    }


    public List<Ticket> findByUser_Id(Long userId) {
        return ticketRepository.findByUser_Id(userId);
    }
}




