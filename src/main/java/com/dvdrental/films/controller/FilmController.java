package com.dvdrental.films.controller;


import com.dvdrental.films.model.Film;
import com.dvdrental.films.model.Inventory;
import com.dvdrental.films.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;


    @GetMapping()
    public List<Film> getFilms() {
        List<Film> film = filmService.getFilms();
        return film;
    }

    @GetMapping("/availables")
    public List<Inventory> get () {
        List<Inventory> film = filmService.getAvailableFilms();
        return film;
    }

    @GetMapping("/{id}")
    public ResponseEntity getFilmById(@PathVariable("id") Long id ) {
        Optional<Film> film = filmService.getFilmbyId(id);
        return  film.map(c -> ResponseEntity.ok(film))
                .orElse((ResponseEntity.notFound().build()));
    }

    @GetMapping("/availablesbystore/{id}")
    public ResponseEntity getFilmByLanguage(@PathVariable("id") Long id) {
        List<Inventory> film = filmService.getAvailableByIdStore(id);
        return  film.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(film);
    }

}
