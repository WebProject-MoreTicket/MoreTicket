package org.example.moreticket.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TicketController {

    @GetMapping("/ticket")
    public String showTicketPage(HttpSession session, Model model) {
        //세션에 로그인되어있는지 확인
        if (session.getAttribute("loggedInUser") == null) {
            // 사용자가 로그인되어 있지 않으면 로그인 페이지로 리다이렉트
            model.addAttribute("error", "로그인이 필요합니다.");
            return "redirect:/login";
        }
        // 좌석 선택 페이지로 이동
        return "ticket";
    }

    @GetMapping("/checkLogin")
    @ResponseBody
    public ResponseEntity<String> checkLogin(HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            // 로그인되지 않은 상태면 401 응답 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        // 로그인된 상태면 200 OK 응답 반환
        return ResponseEntity.ok("로그인 상태입니다.");
    }


    @PostMapping("/payment")
    public String showPaymentPage(@RequestParam("seatGrade") String seatGrade, Model model) {
        int amount = 0;
        switch (seatGrade) {
            case "A": amount = 100000; break;
            case "B": amount = 50000; break;
            case "C": amount = 30000; break;
        }

        model.addAttribute("seatGrade", seatGrade);
        model.addAttribute("amount", amount);

        return "payment";
    }

    @GetMapping("/payment")
    public String showPaymentPage(Model model) {
        // 예시로 콘서트, 좌석, 날짜 데이터를 세팅
        model.addAttribute("seatGrade", "VIP");
        model.addAttribute("amount", 100000);
        model.addAttribute("selectedDate", "2024-10-10");
        model.addAttribute("concertId", 1L);

        return "payment";
    }


    ///////////////////////////////////////////////////// 수정

    // 좌석표를 보여주는 핸들러
    @GetMapping("/seatmap")
    public String showSeatMap(@RequestParam("date") String date, Model model) {
        // 좌석표를 구성하는 데 필요한 데이터가 있다면 여기에 추가 가능
        model.addAttribute("date", date); // 선택된 날짜를 모델에 추가
        return "seatmap";  // seatmap.html을 반환
    }

}

