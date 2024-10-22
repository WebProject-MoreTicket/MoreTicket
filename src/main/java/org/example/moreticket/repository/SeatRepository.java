package org.example.moreticket.repository;

import org.example.moreticket.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat findBySeatRowAndSeatNumber(String seatRow, String seatNumber);
    boolean existsBySeatRowAndSeatNumber(String seatRow, String seatNumber);
}
