package com.dvdrental.films.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Inventory {
    @Id
    @GeneratedValue
    private Long inventory_id;
    private Long film_id;
    private Long store_id;
    private LocalDateTime last_update;
    private String title;
}
