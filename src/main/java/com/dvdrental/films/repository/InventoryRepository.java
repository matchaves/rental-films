package com.dvdrental.films.repository;

import com.dvdrental.films.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Modifying
    @Transactional
    @Query(value = "SELECT i2.*, f2.title " +
            "FROM inventory i2, film f2 " +
            "where i2.film_id = f2.film_id " +
            "and inventory_id not in (select inventory_id from rental where return_date is null and status IN ( 'processando', 'aprovado'))", nativeQuery = true)
    List<Inventory> getAvailableFilms();


    @Modifying
    @Transactional
    @Query(value = "SELECT i2.*, f2.title " +
            "FROM inventory i2, film f2 " +
            "where i2.film_id = f2.film_id " +
            "and i2.store_id = ?1 " +
            "and inventory_id not in (select inventory_id from rental where return_date is null and status IN ( 'processando', 'aprovado'))", nativeQuery = true)
    List<Inventory> getAvailableByIdStore(Long id);




}
