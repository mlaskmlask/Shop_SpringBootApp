package com.pl.project.database;

import com.pl.project.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFurnitureRepository extends JpaRepository<Furniture, Long> {

    @Query("SELECT f FROM Furniture f WHERE f.name=?1")
    Optional<Furniture> findFurnitureByName(String name);
}
