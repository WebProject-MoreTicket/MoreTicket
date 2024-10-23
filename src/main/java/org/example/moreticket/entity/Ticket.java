package org.example.moreticket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 기본 키로 auto_increment 사용
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "seat_grade", nullable = false)
    private String seatGrade;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "seat_id")  // Seat와의 관계 정의
    private Seat seat;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
