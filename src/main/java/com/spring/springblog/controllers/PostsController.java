package com.spring.springblog.controllers;

import com.spring.springblog.models.Post;
import com.spring.springblog.models.User;
import com.spring.springblog.repositories.PostRepository;
import com.spring.springblog.repositories.UserRepository;
import jdk.jfr.Frequency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostsController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping(path = "/posts")
    public String index(Model model){
        List<Post> posts = postDao.findAll();
        model.addAttribute("title", "all posts");
        model.addAttribute("posts", posts);
        return "/posts/Index";
    }

    @GetMapping(path = "/posts/{id}")
    public String indexById(@PathVariable Long id, Model model) {
        model.addAttribute("title", "Single Post");
        model.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
     public String create() {
        return "view creating a post";
    }

    @PostMapping(path = "/posts/create")
    public String creating(@RequestParam String title, @RequestParam String body) {
        Post post  = new Post();
        post.setTitle(title);
        post.setBody(body);

        User user = userDao.findAll().get(0);
        post.setUser(user);

        postDao.save(post);

        return "redirect:/posts/show";
    }

    @GetMapping("/posts/delete/{id}")
    public RedirectView deletePost(@PathVariable Long id, Model model) {
        if (postDao.findById(id).isPresent()) {
            postDao.deleteById(id);
            return new RedirectView("/posts");
        }
        return new RedirectView("/posts");
    }

    @GetMapping("/posts/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("title", "Edit Post");
        Post postToEdit = postDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String edited(@RequestParam Long id, @RequestParam String title, @RequestParam String body) {
        Post post = postDao.getOne(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";
    }



}
