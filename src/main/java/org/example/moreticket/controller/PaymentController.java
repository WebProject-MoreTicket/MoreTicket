package org.example.moreticket.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

    @Value("${shortweather-key}") // API 키를 프로퍼티 파일에서 로드
    private String shortWeatherKey;

    @GetMapping("/payment")
    public String paymentPage(Model model) {
        model.addAttribute("shortWeatherKey", shortWeatherKey); // 모델에 API 키 추가
        // 다른 필요한 모델 속성 추가
        return "payment"; // Thymeleaf 템플릿의 이름
    }

}
