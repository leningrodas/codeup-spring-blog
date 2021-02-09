package com.spring.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
//    can name this method any name i want
    public String Hello (@PathVariable String name) {
        return "Hello from Spring!";
    }



    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOn(@PathVariable int number){
        return number + " plus one is " + (number + 1) + "!";
    }
}
