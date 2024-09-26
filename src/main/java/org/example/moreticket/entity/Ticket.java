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

    private String seatGrade;
    private int price;
    private LocalDateTime createdAt;

    // userId 필드 추가
    private Long userId;

}


