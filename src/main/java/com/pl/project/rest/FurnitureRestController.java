package com.pl.project.rest;

import com.pl.project.model.Furniture;
import com.pl.project.service.FurnitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void addNewFurniture(@RequestBody Furniture furniture) {
        furnitureService.addNewFurniture(furniture);
    }

    @DeleteMapping(path = "{furnitureId}")
    public void deleteFurniture(@PathVariable("furnitureId") Long furnitureId) {
        furnitureService.deleteFurniture(furnitureId);
    }

    @PutMapping(path = "{furnitureId}")
    public void updateFurnitureName(@PathVariable("furnitureId") Long furnitureId,
                                @RequestParam(required = false) String name){
        furnitureService.updateFurnitureName(furnitureId, name);
    }

    @PutMapping(path = "{furnitureId}/pieces")
    public void updateFurniturePieces (@PathVariable("furnitureId")Long furnitureId,
                                       @RequestParam Integer pieces){
        furnitureService.updateFurniturePieces(furnitureId, pieces);
    }

}
