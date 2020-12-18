package com.dvdrental.films.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getFilms() {
        List<Film> list = filmRepository.findAll();//.stream().map(FilmDto::create).collect(Collectors.toList());
        return list;
    }

    public Optional<Film> getFilmbyId(Long id) {
        Optional<Film> film = filmRepository.findById(id);
        return film;
    }

    /*public List<FilmDto> getFilmsByLanguage(Integer id) {
        return filmRepository.findByLanguage(id).stream().map(FilmDto::create).collect(Collectors.toList());
    }*/

}
