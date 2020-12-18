package com.dvdrental.films.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rental_id;
    private LocalDateTime rental_date;
    private Long inventory_id;
    private Integer customer_id;
    private LocalDateTime return_date;
    private Long staff_id;
    private LocalDateTime last_update;


}
