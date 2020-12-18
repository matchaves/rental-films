package com.dvdrental.films.controller;


import com.dvdrental.customer.model.Film;
import com.dvdrental.customer.service.FilmService;
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
    public List<Film> get () {
        return filmService.getFilms();
    }

    @GetMapping("/{id}")
    public ResponseEntity getFilmById(@PathVariable("id") Long id ) {
        Optional<Film> film = filmService.getFilmbyId(id);
        return  film.map(c -> ResponseEntity.ok(film))
                .orElse((ResponseEntity.notFound().build()));
    }

    /*@GetMapping("/lang/{id}")
    public ResponseEntity getFilmByLanguage(@PathVariable("id") Integer id ) {
        List<FilmDto> film = filmService.getFilmsByLanguage(id);
        return  film.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(film);
    }*/

}
