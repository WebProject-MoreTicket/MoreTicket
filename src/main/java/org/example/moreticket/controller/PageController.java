package org.example.moreticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // 스포츠 카테고리 선택 시 띄우는 예메 메인 페이지
    @GetMapping("/Sports")
    public String Sports() {
        return "Category/Sports";
    }

    @GetMapping("/Concert")
    public String Concert() {
        return "Category/Concert";
    }

    @GetMapping("/Musical")
    public String Musical() {
        return "Category/Musical";
    }

    @GetMapping("/Classic")
    public String Classic() {
        return "Category/Classic";
    }




    @GetMapping("/inf")
    public String inf() { return "Inf/MusicalInf"; }

    @GetMapping("/inf2")
    public String inf2() { return "Inf/ConcertInf"; }

    @GetMapping("/inf3")
    public String inf3() { return "Inf/SportsInf"; }

    @GetMapping("/inf4")
    public String inf4() { return "Inf/ClassicInf"; }

}
