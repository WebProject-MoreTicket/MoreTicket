package org.example.moreticket.service;

import org.example.moreticket.entity.Concert;
import org.example.moreticket.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConcertService {

    private final ConcertRepository concertRepository;

    @Autowired
    public ConcertService(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    // 모든 콘서트 목록 가져오기
    public List<Concert> findAllConcerts() {
        return concertRepository.findAll();
    }

    // 콘서트 저장
    public Concert saveConcert(Concert concert) {
        return concertRepository.save(concert);
    }

    // 특정 콘서트 조회
    public Concert findConcertById(Long id) {
        return concertRepository.findById(id).orElse(null);
    }

    // 특정 콘서트 삭제
    public void deleteConcert(Long id) {
        concertRepository.deleteById(id);
    }
}

