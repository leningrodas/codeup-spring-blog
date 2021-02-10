package com.spring.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    public int number;




    @GetMapping(path = "/posts")
    @ResponseBody
    public String postsIndex (){ return "viewing all posts.";

    }

    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public String postsView (){ return "viewing individual id.";

    }

    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String postsCreate (){ return "Create apost here";

    }
    @PostMapping(path = "/posts/create")
    @ResponseBody
    public String postsCreated (){ return "Create a post here";

    }













}
