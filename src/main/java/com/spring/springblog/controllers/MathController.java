package com.spring.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    public int number;
    public int number2;

    @GetMapping(path = "/add/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int number, @PathVariable int number2){
        return number + " plus " + number2 + "equals" + (number2 + number);
    }

    @RequestMapping(path = "/subtract/{number}/and{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int number, @PathVariable int number2){
        return number + " subtract " + number2 + "equals" + (number2 - number);
    }

    @RequestMapping(path = "/divide/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int number, @PathVariable int number2){
        return number + " multiply " + number2 + " equals " + (number / number2);
    }

    @RequestMapping(path = "/multiply/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int number, @PathVariable int number2){
        return number + " divided by " + number2 + " equals " + (number2 * number);
    }






}
