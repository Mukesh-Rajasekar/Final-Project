package com.example.RestaurantService.domain;




public class Cuisine {
    private Long cuisineId;
    private String name;
    private String type;
    private String description;

    public Cuisine(Long cuisineId, String name, String type, String description) {
        this.cuisineId = cuisineId;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Cuisine() {
    }

    public Long getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Long cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
