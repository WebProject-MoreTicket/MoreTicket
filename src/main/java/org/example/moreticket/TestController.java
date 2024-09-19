package org.example.moreticket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @GetMapping("/main")
    public String main() {
        return "Main";


    }

}
