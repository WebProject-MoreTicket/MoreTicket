package org.example.moreticket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false, length = 50)
    private String username;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "phone_number", length = 15)
    private String userPhoneNumber; // 전화번호는 보통 최대 15자

    @Column(name = "birth_date")
    private LocalDate userBirthDate;

    @Column(length = 6)
    private String gender; // 성별은 보통 6자 이내로 가능 ("Male", "Female" 등)


}
