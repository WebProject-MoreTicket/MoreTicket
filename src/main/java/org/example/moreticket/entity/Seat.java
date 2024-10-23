package org.example.moreticket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 기본 키로 auto_increment 사용
    @Column(name = "seat_id")
    private Long seatId;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "seat_row", nullable = false)
    private String seatRow;

    @Column(name = "is_reserved", nullable = false)
    private boolean isReserved;

    @OneToOne(mappedBy = "seat")
    private Ticket ticket;

    @PrePersist
    protected void onCreate() {
        this.isReserved = false;  // 초기 예약 상태를 false로 설정
    }
}
