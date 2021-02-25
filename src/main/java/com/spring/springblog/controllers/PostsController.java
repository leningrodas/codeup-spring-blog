package com.spring.springblog.controllers;

import com.spring.springblog.services.EmailService;
import com.spring.springblog.models.Post;
import com.spring.springblog.models.User;
import com.spring.springblog.services.UserService;
import com.spring.springblog.repositories.PostRepository;
import com.spring.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostsController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;
    private final UserService userService;

    public PostsController(PostRepository postDao, UserRepository userDao, EmailService emailService, UserService userService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
        this.userService = userService;
    }

    @GetMapping(path = "/posts")
    public String index(Model model){
//        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String indexById(@PathVariable Long id, Model model) {
        model.addAttribute("title", "Single Post");
        model.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
     public String create(Model model) {
        model.addAttribute("post", new Post());

        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String createPost(@ModelAttribute Post post) {

        User user = userService.loggedInUser();
        post.setUser(user);


        Post savePost = postDao.save(post);

        String subject = "new ad created";
        String body = "yo, user " + savePost.getUser().getUsername() +
                " you created this ad " + savePost.getId();

        emailService.prepareAndSend(savePost, subject, body);

        return "redirect:/posts";
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
