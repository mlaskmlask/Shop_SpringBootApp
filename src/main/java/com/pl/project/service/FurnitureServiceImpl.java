package com.pl.project.service;

import com.pl.project.database.IFurnitureRepository;
import com.pl.project.model.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements IFurnitureService {

    private final IFurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureServiceImpl(IFurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }
}
