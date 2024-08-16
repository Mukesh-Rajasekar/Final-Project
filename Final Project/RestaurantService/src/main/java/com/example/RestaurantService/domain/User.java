package com.example.RestaurantService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {
    @Id
    private String userId;
    private String password;
    private String username;
    private String email;
    private String profileImage;
    private List<Restaurant> favoriteRestaurants;
    private List<Cuisine> favoriteCuisines;

    public User() {}

    public User(String userId, String username, String password, String email, String profileImage, List<Restaurant> favoriteRestaurants, List<Cuisine> favoriteCuisines) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.profileImage = profileImage;
        this.favoriteRestaurants = favoriteRestaurants;
        this.favoriteCuisines = favoriteCuisines;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public List<Restaurant> getFavoriteRestaurants() {
        return favoriteRestaurants;
    }

    public void setFavoriteRestaurants(List<Restaurant> favoriteRestaurants) {
        this.favoriteRestaurants = favoriteRestaurants;
    }

    public List<Cuisine> getFavoriteCuisines() {
        return favoriteCuisines;
    }

    public void setFavoriteCuisines(List<Cuisine> favoriteCuisines) {
        this.favoriteCuisines = favoriteCuisines;
    }
}
