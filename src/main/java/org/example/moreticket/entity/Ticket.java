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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "seat_grade", nullable = false)
    private String seatGrade;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    // Getters and setters
    // 생성자 및 기타 필요한 메서드들
}



