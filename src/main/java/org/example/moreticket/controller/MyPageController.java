package org.example.moreticket.controller;

import jakarta.servlet.http.HttpSession;
import org.example.moreticket.entity.Ticket;
import org.example.moreticket.entity.User;
import org.example.moreticket.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/mypage/info")
    public String myInfo() {
        return "mypage/myInfo";
    }

    @GetMapping("/mypage/tickets")
    public String myTickets(Model model, HttpSession session) {
        User userId = (User) session.getAttribute("loggedInUser");
        System.out.println("Session User ID: " + userId);

        if (userId != null) {
            try {
                List<Ticket> tickets = ticketService.findByUser_Id(userId.getId());
                System.out.println("Tickets found: " + tickets.size());
                model.addAttribute("tickets", tickets);
            } catch (Exception e) {
                System.err.println("Error fetching tickets: " + e.getMessage());
                model.addAttribute("tickets", List.of());
            }
        } else {
            model.addAttribute("tickets", List.of());
        }
        return "mypage/myTickets";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/";  // 메인 페이지로 리다이렉트
    }
}
