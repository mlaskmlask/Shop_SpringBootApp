package com.pl.project.service;

import com.pl.project.database.IFurnitureRepository;
import com.pl.project.model.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public void addNewFurniture(Furniture furniture) {
        Optional<Furniture> furnitureOptional = furnitureRepository.findFurnitureByName(furniture.getName());
        if (furnitureOptional.isPresent()) {
            throw new IllegalStateException("Artykuł istnieje już w bazie.");
        }
        furnitureRepository.save(furniture);
    }

    @Override
    public void deleteFurniture(Long furnitureId) {
        boolean exists = furnitureRepository.existsById(furnitureId);
        if (!exists) {
            throw new IllegalStateException("Artykuł o id " + furnitureId + " nie istnieje");
        }
        furnitureRepository.deleteById(furnitureId);
    }

    @Transactional
    @Override
    public void updateFurnitureName(Long furnitureId, String name) {
        Furniture furniture = furnitureRepository.findById(furnitureId).orElseThrow(()
                -> new IllegalStateException("Produkt o id " + furnitureId + " nie istnieje w bazie."));
        if (name != null && name.length() > 0 && !Objects.equals(furniture.getName(),name)) {
            furniture.setName(name);
        }
    }

    @Transactional
    @Override
    public void updateFurniturePieces (Long furnitureId, Integer pieces) {
        Furniture furniture = furnitureRepository.findById(furnitureId).orElseThrow(()
                -> new IllegalStateException("Produkt o id " + furnitureId + " nie istnieje w bazie."));

        if(pieces>0){
            furniture.setPieces(furniture.getPieces()+pieces);
        }
    }
}
