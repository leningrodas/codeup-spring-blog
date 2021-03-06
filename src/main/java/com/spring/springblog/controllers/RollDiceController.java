package com.spring.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;


@Controller
public class RollDiceController {



    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model){
           String message;

            int random = ThreadLocalRandom.current().nextInt(1, 6 + 1);

            if(random == guess) {
                message = "you guess win some bucks on his roll";
            } else {
                message = "you lost money, foo. pay up.";
            }

            model.addAttribute("randomNumber", random);
            model.addAttribute("guessed", guess);
            model.addAttribute("message", message);

        //This will return a file named howdy-final.html that is inside of resources/templates
        return "DiceResults";
    }


    @GetMapping("/roll-dice")
    public String showdiceform() {
        return "rolldice";
    }


}
