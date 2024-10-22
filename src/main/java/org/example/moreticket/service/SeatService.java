package org.example.moreticket.service;

import jakarta.annotation.PostConstruct;
import org.example.moreticket.entity.Seat;
import org.example.moreticket.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    // 좌석 예약
    public String reserveSeat(String seatRow, String seatNumber) {
        System.out.println("선택한 좌석: Row = " + seatRow + ", Seat = " + seatNumber);

        Seat seat = seatRepository.findBySeatRowAndSeatNumber(seatRow, seatNumber);

        if (seat == null) {
            return "해당 좌석을 찾을 수 없습니다.";
        } else if (seat.isReserved()) {
            return "이미 예약된 좌석입니다.";
        } else {
            seat.setReserved(true);
            seatRepository.save(seat);
            return "좌석 예약 성공!";
        }
    }

    @PostConstruct
    public void init() {
        createSeatsForEvent();
    }

    public void createSeatsForEvent() {
        int seatCount = 10;  // 첫 번째 줄 좌석 수

        for (int row = 1; row <= 9; row++) {
            for (int seatNumber = 1; seatNumber <= seatCount; seatNumber++) {
                // 이미 해당 좌석이 존재하는지 확인
                if (!seatRepository.existsBySeatRowAndSeatNumber("Row" + row, "Seat" + seatNumber)) {
                    Seat seat = new Seat();
                    seat.setSeatRow("Row" + row);
                    seat.setSeatNumber("Seat" + seatNumber);
                    seat.setReserved(false);

                    // 티켓 정보 없이 좌석만 생성
                    seat.setTicket(null);  // ticket 필드에 명시적으로 null 할당

                    seatRepository.save(seat);
                }
            }

            // 2행마다 좌석 수 증가
            if (row % 2 == 0) {
                seatCount++;
            }
        }
    }


    // 모든 좌석 조회
    public List<Seat> findAllSeats() {
        return seatRepository.findAll();
    }
}
