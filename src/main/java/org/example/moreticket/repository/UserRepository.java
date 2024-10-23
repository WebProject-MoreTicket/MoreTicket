package org.example.moreticket.repository;

import org.example.moreticket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
    User findByEmail(String email);
    User findByUserPhoneNumber(String userPhoneNumber);
}
