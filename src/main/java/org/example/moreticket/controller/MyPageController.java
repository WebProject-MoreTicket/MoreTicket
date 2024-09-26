package org.example.moreticket.controller;

import org.example.moreticket.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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



    public MyPageController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

//    @GetMapping("/mypage/tickets")
//    public String myTickets(HttpSession session, Model model) {
//        // 세션에서 사용자 정보 가져오기
//        User sessionUser = (User) session.getAttribute("user");
//        if (sessionUser == null) {
//            return "redirect:/login"; // 로그인 페이지로 리디렉션
//        }
//
//        // 사용자의 티켓 목록 조회
//        List<Ticket> tickets = ticketService.getTicketsByUserId(sessionUser.getId());
//
//        // 티켓 정보를 모델에 추가
//        model.addAttribute("tickets", tickets);
//
//        return "myTickets";  // 티켓 정보를 보여주는 페이지로 이동
//    }

}
