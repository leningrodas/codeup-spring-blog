package com.spring.springblog.controllers;

import com.spring.springblog.models.Post;
import com.spring.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {

    private final PostRepository postDao;

    public PostsController(PostRepository postDao) {
        this.postDao = postDao;

    }






    @GetMapping("/posts")
    public String Posts(Model model){
        Post post1 = new Post("defcon1", "festival", 1);
        Post post2 = new Post("burningman", "psychadelic", 2);
        Post post3 = new Post("software eng", "jobs", 3);

        List<Post> postList = new ArrayList<>();
        postList.add(post1);
        postList.add(post2);
        postList.add(post3);

        model.addAttribute("title", "all posts");
        model.addAttribute("posts", postList);

        return "posts/index";

    }


    @GetMapping("/posts/{id}")
    public String postView(Model model){
        Post post = new Post("first post", "this is the first flyer for the festival", 1);
        model.addAttribute("title", "packages for sale");
        model.addAttribute("post", post);
        return "posts/show";
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
