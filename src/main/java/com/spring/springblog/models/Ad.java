package com.spring.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad {

    public Ad(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 1000000)
    private String description;

    @Column(nullable = false)
    private String title;









}
