package org.example.moreticket.controller;

import org.example.moreticket.entity.Concert; // Concert 엔티티 추가
import org.example.moreticket.service.ConcertService; // ConcertService 추가
import org.example.moreticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    private final TicketService ticketService;
    private final ConcertService concertService; // ConcertService 주입

    @Autowired
    public PaymentController(TicketService ticketService, ConcertService concertService) {
        this.ticketService = ticketService;
        this.concertService = concertService;
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
            // 콘서트 정보 조회
            Concert concert = concertService.findConcertById(concertId);
            if (concert == null) {
                System.out.println("Concert not found for ID: " + concertId);
                return "redirect:/mypage?error";  // 콘서트가 없을 경우 처리
            }

            // 티켓 저장
            ticketService.saveTicket(price, seatGrade, userId, concertId);

            // 추가: 콘서트가 없을 경우, 새로 생성하여 저장 (optional)
            // concertService.saveConcert(concert); // 필요한 경우 uncomment

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/mypage?error";  // 에러 발생 시 처리
        }

        return "redirect:/mypage";
    }
}
