package com.spring.springblog.controllers;

import com.spring.springblog.models.Ad;
import com.spring.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdController {

    private final AdRepository adsDao;

    public AdController(AdRepository adsdao){
        this.adsDao = adsdao;
    }


    @GetMapping("/ads/jpa")
    @ResponseBody
    public List<Ad> jpaIndex() {
        return adsDao.findAll();
    }
//
//    @GetMapping("/ads/jpa{id}")
//    @ResponseBody
//    public Ad viewJpaAd(@PathVariable long id){
//        return adsDao.getOne(id).toString();
//    }

}
