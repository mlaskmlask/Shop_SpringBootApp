package com.pl.project.database;

import com.pl.project.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFurnitureRepository extends JpaRepository <Furniture, Long>{
}
