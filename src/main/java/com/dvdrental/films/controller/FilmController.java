package com.dvdrental.films.controller;


import com.dvdrental.films.dto.FilmDtoAmount;
import com.dvdrental.films.model.Film;
import com.dvdrental.films.model.Inventory;
import com.dvdrental.films.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;


    @GetMapping("/catalog")
    public List<Film> getFilms() {
        List<Film> film = filmService.getFilms();
        return film;
    }

    @GetMapping("/availables")
    public List<Inventory> get () {
        List<Inventory> film = filmService.getAvailableFilms();
        return film;
    }

    @GetMapping("")
    public ResponseEntity getFilmById(@RequestParam Long film_id ) {
        Optional<Film> film = filmService.getFilmbyId(film_id);
        return  film.map(c -> ResponseEntity.ok(film))
                .orElse((ResponseEntity.notFound().build()));
    }

    @GetMapping("/cost")
    public ResponseEntity<Optional<FilmDtoAmount>> getCostFilm(@RequestParam Long film_id ) {
        Optional<FilmDtoAmount> filmCost = filmService.getCostFilm(film_id);
        return  filmCost.map(c -> ResponseEntity.ok(filmCost))
                .orElse((ResponseEntity.notFound().build()));
    }

    @GetMapping("/availablesbystore")
    public ResponseEntity getFilmByLanguage(@RequestParam Long store_id) {
        List<Inventory> film = filmService.getAvailableByIdStore(store_id);
        return  film.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(film);
    }

}
