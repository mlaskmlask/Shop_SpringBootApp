package com.pl.project.rest.configuration;

import com.pl.project.database.IFurnitureRepository;
import com.pl.project.model.Furniture;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FurnitureConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(IFurnitureRepository furnitureRepository){
        return args -> {
            Furniture table = new Furniture("Stół Klara",20 , Furniture.Category.STOŁY);
            Furniture table1 = new Furniture("Stół Antox",10 , Furniture.Category.STOŁY);

        furnitureRepository.saveAll(List.of(table1,table));
        };
    }
}
