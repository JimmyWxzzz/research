package modules;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class secondController {
    @RequestMapping("/second")
    public String handler() {
        return "This is the second page";
    }
}