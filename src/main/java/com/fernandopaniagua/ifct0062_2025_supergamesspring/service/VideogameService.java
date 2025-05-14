package com.fernandopaniagua.ifct0062_2025_supergamesspring.service;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.logsystem.LogEvent;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.logsystem.LogPublisher;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.repository.IVideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideogameService implements IVideogameService {
    @Autowired
    LogPublisher logPublisher;

    @Autowired
    IVideogameRepository videogameRepository;

    @Override
    public List<Videogame> getAllVideogames(){
        return videogameRepository.findAll();
    }

    @Override
    public Videogame createVideogame(Videogame videogame) {
        return videogameRepository.save(videogame);
    }

    @Override
    public void deleteVideogame(Integer id) {
        videogameRepository.deleteById(id);
        //Emitimos el evento de tipo LogEvent
        this.logPublisher.publishLogEvent("Has borrado " + id);
    }

    @Override
    public Videogame findVideogameById(Integer id) {
        return videogameRepository.findById(id).orElse(null);
    }

    @Override
    public void updateVideogame(Videogame videogame) {
        videogameRepository.save(videogame);
    }

    @Override
    public List<String> getAllPlatforms() {
        return videogameRepository.getPlatformNames();
    }

    @Override
    public List<Videogame> findVideogamesByPlatform(String platform) {
        return videogameRepository.findByPlatform(platform);
    }
}
