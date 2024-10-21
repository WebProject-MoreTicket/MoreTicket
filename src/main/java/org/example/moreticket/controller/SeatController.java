package org.example.moreticket.controller;

import org.example.moreticket.entity.Seat;
import org.example.moreticket.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    // 좌석 예약
    @PostMapping("/reserve")
    public String reserveSeat(@RequestParam String seatRow, @RequestParam String seatNumber) {
        System.out.println("컨트롤러에서 전달된 seatRow: " + seatRow);
        System.out.println("컨트롤러에서 전달된 seatNumber: " + seatNumber);

        return seatService.reserveSeat(seatRow, seatNumber);
    }


    // 좌석 생성
    @PostMapping("/create")
    public String createSeats() {
        seatService.createSeatsForEvent();
        return "좌석 생성 완료!";
    }

    // 모든 좌석 조회
    @GetMapping("/list")
    public List<Seat> listSeats() {
        return seatService.findAllSeats();
    }
}
