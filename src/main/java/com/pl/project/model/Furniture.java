package com.pl.project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String pieces;
    @Enumerated(EnumType.STRING)
    private Category category;

    public enum Category{
        KRZESŁA, STOŁY, SOFY, SZAFY
    }
}
