package com.dvdrental.films.service;



import com.dvdrental.films.model.Film;
import com.dvdrental.films.model.Inventory;
import com.dvdrental.films.repository.FilmRepository;
import com.dvdrental.films.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Film> getFilms() {
        List<Film> list = filmRepository.findAll();//.stream().map(FilmDto::create).collect(Collectors.toList());
        return list;
    }

    public List<Inventory> getAvailableFilms() {
        List<Inventory> films = inventoryRepository.getAvailableFilms();
        return films;
    }


    public Optional<Film> getFilmbyId(Long id) {
        Optional<Film> film = filmRepository.findById(id);
        return film;
    }

    public List<Inventory> getAvailableByIdStore(Long id) {
        List<Inventory> films = inventoryRepository.getAvailableByIdStore(id);
        return films;
    }
}
