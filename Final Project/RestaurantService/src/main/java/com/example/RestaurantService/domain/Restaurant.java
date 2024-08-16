package com.example.RestaurantService.domain;
import org.springframework.data.annotation.Id;

public class Restaurant {
    @Id
    private String restaurantId;
    private String name;
    private String location;
    private Cuisine cuisine;


    public Restaurant(){

    }

    public Restaurant(String restaurantId, String name, String location, Cuisine cuisine) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.location = location;
        this.cuisine = cuisine;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }
}
