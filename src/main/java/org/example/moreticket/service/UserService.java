package org.example.moreticket.service;

import org.example.moreticket.entity.User;
import org.example.moreticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 사용자 ID로 사용자 정보를 가져오는 메서드
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null); // 사용자 정보를 가져오고, 없으면 null 반환
    }
}
