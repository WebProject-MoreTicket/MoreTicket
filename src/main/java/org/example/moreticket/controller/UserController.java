package org.example.moreticket.controller;

import jakarta.servlet.http.HttpSession;
import org.example.moreticket.entity.User;
import org.example.moreticket.service.UserService; // UserService 임포트
import org.example.moreticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService; // UserService 추가

    // 로그인 페이지 반환
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // 메인 페이지 반환
    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    // 회원가입 페이지 반환
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model, HttpSession session) {
        userRepository.save(user);
        model.addAttribute("message", "Signup successful");
        return "main"; // 성공 메시지와 함께 다시 메인 페이지로 리다이렉트
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String password, Model model, HttpSession session) {
        User user = userRepository.findByUserId(userId); // userId로 사용자 찾기

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("loggedInUser", user); // 로그인 성공 시 세션에 사용자 정보 저장
            model.addAttribute("message", "Login successful");
            return "main";
        } else {
            model.addAttribute("error", "잘못된 아이디거나 비밀번호입니다.");
            return "login";
        }
    }

    // 로그아웃 처리 메서드
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션을 제거하는 메서드
        return "redirect:/"; // 메인 페이지로 리다이렉트
    }

}
