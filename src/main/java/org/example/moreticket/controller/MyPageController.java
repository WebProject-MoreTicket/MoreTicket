package org.example.moreticket.controller;

import java.util.List;
import jakarta.servlet.http.HttpSession;
import org.example.moreticket.entity.Ticket;
import org.example.moreticket.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyPageController {

    private final TicketService ticketService;

    public MyPageController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

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
    public String myTickets(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId"); // 세션에서 userId를 가져옴
        if (userId != null) {
            List<Ticket> tickets = ticketService.findByUserId(userId);  // 메서드 이름 변경
            model.addAttribute("tickets", tickets);  // 조회한 티켓 리스트를 모델에 추가
        } else {
            model.addAttribute("tickets", List.of()); // userId가 null인 경우 빈 리스트 추가
        }
        return "mypage/myTickets";  // templates/mypage/myTickets.html로 이동
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/";  // 메인 페이지로 리다이렉트
    }
}
