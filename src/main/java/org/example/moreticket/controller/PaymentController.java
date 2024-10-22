package org.example.moreticket.controller;

import jakarta.servlet.http.HttpSession;
import org.example.moreticket.entity.User;
import org.example.moreticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    private final TicketService ticketService;

    @Autowired
    public PaymentController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/payment/complete")
    public String completePayment(@RequestParam int price, @RequestParam String seatGrade,
                                  HttpSession session) {
        User userId = (User) session.getAttribute("loggedInUser");  // 세션에서 userId 가져오기
        if (userId == null) {
            throw new RuntimeException("로그인이 필요합니다.");
        }

        // 로그로 확인
        System.out.println("Price: " + price);
        System.out.println("Seat Grade: " + seatGrade);
        System.out.println("User ID: " + userId);

        try {
            // 티켓 저장
            ticketService.saveTicket(price, seatGrade, userId.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/mypage?error";
        }

        return "redirect:/mypage";
    }
}
