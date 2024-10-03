package org.example.moreticket.controller;

import jakarta.servlet.http.HttpSession;
import org.example.moreticket.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyPageController {

    private final TicketService ticketService;

    @GetMapping("/mypage")
    public String myPage() {
        return "mypage/mypage";  // templates/mypage/mypage.html로 이동
    }

    // 내 정보 페이지
    @GetMapping("/mypage/info")
    public String myInfo() {
        return "mypage/myInfo";
    }

    // 티켓 페이지
    @GetMapping("/mypage/tickets")
    public String myTickets() {
        return "mypage/myTickets";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/";  // 메인 페이지로 리다이렉트
    }


    public MyPageController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

}
