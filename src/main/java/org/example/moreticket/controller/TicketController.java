package org.example.moreticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {

    @GetMapping("/ticket")
    public String showTicketPage() {
        // 좌석 선택 페이지로 이동
        return "ticket";
    }

    @PostMapping("/payment")
    public String showPaymentPage(@RequestParam("seatGrade") String seatGrade, Model model) {
        // 좌석 등급에 따른 결제 금액 설정
        int amount = 0;
        switch (seatGrade) {
            case "A":
                amount = 100000;
                break;
            case "B":
                amount = 50000;
                break;
            case "C":
                amount = 30000;
                break;
        }

        // 모델에 데이터 추가
        model.addAttribute("seatGrade", seatGrade);
        model.addAttribute("amount", amount);

        // 결제 페이지로 이동
        return "payment";
    }
}
