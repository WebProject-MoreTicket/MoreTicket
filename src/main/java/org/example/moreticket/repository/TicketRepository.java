package org.example.moreticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.moreticket.entity.Ticket;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUser_Id(Long userId);  // User의 ID를 기준으로 티켓 검색
}

