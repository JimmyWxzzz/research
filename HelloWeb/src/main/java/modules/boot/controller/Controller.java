package modules.boot.controller;

import modules.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/hello")
    public String handler(@RequestParam("name")String name) {
        return "Hello, SpringBoot2" + name;
    }
    @Autowired
    Car car;
    @RequestMapping("/car")
    public Car car() {
        return car;
    }
}
