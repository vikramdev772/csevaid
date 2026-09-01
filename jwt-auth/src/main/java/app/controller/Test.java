package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {

    @GetMapping("/test")
    public static String test() {
        return "Test";
    }

    @GetMapping("/index")
    public String t() {
        return "redirect:/web/Index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/web/login.html";
    }

    @GetMapping("/main")
    public String main() {
        return "redirect:/web/Main.html";
    }
}
