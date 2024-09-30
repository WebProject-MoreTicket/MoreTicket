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
                                  @RequestParam Long userId) {
        // 결제 완료 후 티켓 저장
        ticketService.saveTicket(price, seatGrade, userId);
        return "redirect:/mypage";
    }

}
