package org.example.moreticket.repository;

import org.example.moreticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // 특정 사용자의 티켓 목록 조회
    List<Ticket> findByUserId(Long userId);
}

