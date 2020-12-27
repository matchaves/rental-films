package com.dvdrental.films.repository;


import com.dvdrental.films.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findAll();

    Optional<Film> findById(Long id);




}