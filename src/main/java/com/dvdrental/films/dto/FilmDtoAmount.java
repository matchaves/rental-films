package com.dvdrental.films.dto;

import com.dvdrental.films.model.Film;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class FilmDtoAmount {

    private Long rental_duration;
    private Double rental_rate;
    private Double replacement_cost;

    public static FilmDtoAmount create(Film film) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(film, FilmDtoAmount.class);
    }
}
