package com.fernandopaniagua.ifct0062_2025_supergamesspring.service;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Genre;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.repository.IGenreRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService {
    @Autowired
    IGenreRepository genreRepository;

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @PostConstruct
    public void postConstruct(){
        System.err.println("Ejecutando postConstruct de GenreService");
    }

    @PreDestroy
    public void preDestroy(){
        System.err.println("Ejecutando preDestroy de GenreService");
    }
}
