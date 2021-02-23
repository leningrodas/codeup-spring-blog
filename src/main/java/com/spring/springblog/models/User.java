package com.spring.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {


    public User (){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
//    syntax for the relation ship, one user can create many post
    @OneToMany(mappedBy = "user")
    private List<Post> Posts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    constructors for the posts
    public List<Post> getPosts() {
        return Posts;
    }

    public void setPosts(List<Post> posts) {
        this.Posts = posts;
    }
}
