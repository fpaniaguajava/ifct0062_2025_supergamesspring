package com.fernandopaniagua.ifct0062_2025_supergamesspring.service;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;

import java.util.List;

public interface IVideogameService {
    public List<Videogame> getAllVideogames();
    public Videogame createVideogame(Videogame videogame);
    public void deleteVideogame(Integer id);
    public Videogame findVideogameById(Integer id);
    public void updateVideogame(Videogame videogame);
    public List<String> getAllPlatforms();
    public List<Videogame> findVideogamesByPlatform(String platform);
}
