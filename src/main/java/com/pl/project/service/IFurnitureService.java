package com.pl.project.service;

import com.pl.project.model.Furniture;

import java.util.List;

public interface IFurnitureService {
    List<Furniture> getAllFurniture();

    void addNewFurniture(Furniture furniture);

    void deleteFurniture(Long furnitureId);

    void updateFurnitureName(Long furnitureId, String name);

    void updateFurniturePieces(Long furnitureId, Integer pieces);
}
