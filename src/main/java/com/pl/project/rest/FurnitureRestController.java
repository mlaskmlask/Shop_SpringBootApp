package com.pl.project.rest;

import com.pl.project.model.Furniture;
import com.pl.project.service.FurnitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/furniture")
public class FurnitureRestController {

    private final FurnitureServiceImpl furnitureService;

    @Autowired
    public FurnitureRestController(FurnitureServiceImpl furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping
    public List<Furniture> getAllFurniture() {
        return furnitureService.getAllFurniture();
    }

}
