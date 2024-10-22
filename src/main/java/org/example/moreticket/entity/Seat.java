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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "seat_row", nullable = false)
    private String seatRow;

    @Column(name = "is_reserved", nullable = false)
    private boolean isReserved;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = true)  // 예약되지 않은 좌석은 ticket_id가 null일 수 있음
    private Ticket ticket;

    @PrePersist
    protected void onCreate() {
        this.isReserved = false;  // 초기 예약 상태는 false로 설정
    }

}
