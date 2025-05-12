package com.fernandopaniagua.ifct0062_2025_supergamesspring.controller;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {
    VideogameService videogameService;
    public AppController(VideogameService videogameService) {
        this.videogameService = videogameService;
    }

    @GetMapping("/")
    public String showMain(Model model){
        List<Videogame> videogameList = this.videogameService.getAllVideogames();
        model.addAttribute("videogames", videogameList);
        return "index";
    }

    @PostMapping("/videogames/")
    public String createVideogame(@ModelAttribute Videogame newVideogame) {
        this.videogameService.createVideogame(newVideogame);
        return "index";
    }
}
