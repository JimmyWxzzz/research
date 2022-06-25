package modules.boot.controller;

import modules.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/hello")
    public String handler() {
        return "Hello, SpringBoot2";
    }
    @Autowired
    Car car;
    @RequestMapping("/car")
    public Car car() {
        return car;
    }
}
