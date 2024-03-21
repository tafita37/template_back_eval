package eval.mikolo.mikolo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
@CrossOrigin("*")
public class HelloController {
    @GetMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Welcome to our application!");
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    // @GetMapping("/deux")
    // public String 

    @GetMapping("/hello")
    public String hello() {
        return "ezfezfezfezfz";
    }
}
