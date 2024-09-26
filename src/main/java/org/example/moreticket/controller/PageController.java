package org.example.moreticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // 스포츠 카테고리 선택 시 띄우는 예메 메인 페이지
    @GetMapping("/Sports")
    public String Sports() {
        return "Sports";
    }

    // 원하는 경기 선택하고 띄우는 예매 페이지
    @GetMapping("/firstsportsmatch")
    public String firstSportsMatch() {
        return "firstsportsmatch";
    }

}
