package org.example.moreticket.controller;

import org.example.moreticket.service.TicketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    private final TicketService ticketService;

    public PaymentController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/payment/complete")
    public String completePayment(@RequestParam int price, @RequestParam String seatGrade,
                                  @RequestParam Long userId, @RequestParam Long concertId) {
        // 로그 추가
        System.out.println("Price: " + price);
        System.out.println("Seat Grade: " + seatGrade);
        System.out.println("User ID: " + userId);
        System.out.println("Concert ID: " + concertId);

        // 결제 완료 후 티켓 저장
        try {
            ticketService.saveTicket(price, seatGrade, userId, concertId);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/mypage?error";  // 에러 발생 시 처리
        }

        return "redirect:/mypage";
    }


}
