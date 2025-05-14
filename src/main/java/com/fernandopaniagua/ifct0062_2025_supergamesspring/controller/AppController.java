package com.fernandopaniagua.ifct0062_2025_supergamesspring.controller;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Genre;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.service.IGenreService;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.service.IVideogameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
    IVideogameService videogameService;
    IGenreService genreService;
    public AppController(IVideogameService videogameService, IGenreService genreService) {
        this.videogameService = videogameService;
        this.genreService = genreService;
    }

    @GetMapping("/")
    public String showMain(Model model){
        List<Videogame> videogameList = this.videogameService.getAllVideogames();
        model.addAttribute("videogames", videogameList);
        return "index";
    }

    @GetMapping("/create-videogame")
    public String initCreateVideogame(Model model){
        List<Genre> genreList = this.genreService.getAllGenres();
        model.addAttribute("genres",genreList);
        return "create_videogame";
    }

    @PostMapping("/videogames")
    public String createVideogame(@ModelAttribute Videogame newVideogame) {
        this.videogameService.createVideogame(newVideogame);
        return "redirect:/";
    }

    @GetMapping("/delete-videogame")
    public String deleteVideogame(@RequestParam Integer id) {
        this.videogameService.deleteVideogame(id);
        return "redirect:/";
    }

    @GetMapping("/edit-videogame")
    public ModelAndView editVideogame(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("/edit_videogame");
        List<Genre> genreList = this.genreService.getAllGenres();
        Videogame videogame = videogameService.findVideogameById(id);
        mav.addObject("genres", genreList);
        mav.addObject("videogame", videogame);
        return mav;
    }

    @PostMapping("/edit-videogame")
    public String doEditVideogame(@ModelAttribute Videogame updatedVideogame) {
        videogameService.updateVideogame(updatedVideogame);
        return "redirect:/";
    }

    @GetMapping("/find-videogame")
    public String searchVideogame(Model model, @RequestParam(required = false) String platformName){
        List<String> platformNames = videogameService.getAllPlatforms();
        List<Videogame> videogameList = new ArrayList<>();
        if (platformName==null) {
             videogameList = videogameService.getAllVideogames();
        } else {
            videogameList = videogameService.findVideogamesByPlatform(platformName);
        }
        model.addAttribute("platform_names", platformNames);
        model.addAttribute("videogames", videogameList);
        return "search-page";
    }
}
