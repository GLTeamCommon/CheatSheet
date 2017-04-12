package cheatsheet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexForm(Model model) {
        model.addAttribute("request", new Request());
        return "index";
    }

    @PostMapping("/result")
    public String answerShow(@ModelAttribute Request request) {
        return "result";
    }
}