package com.pl.project.model;
import javax.persistence.*;

@Entity
@Table
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer pieces;
    @Enumerated(EnumType.STRING)
    private Category category;

    public enum Category{
        KRZESŁA, STOŁY, SOFY, SZAFY
    }

    public Furniture(String name, Integer pieces, Category category) {
        this.name = name;
        this.pieces = pieces;
        this.category = category;
    }

    public Furniture() {
    }

    public Furniture(Long id, String name, Integer pieces, Category category) {
        this.id = id;
        this.name = name;
        this.pieces = pieces;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
