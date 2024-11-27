package com.example.mixit;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CocktailData {

    public String nameCocktail;
    public String recipeCocktail;
    public String imageCocktail;
    public List<Map<String, Object>> ingredientsCocktail;
    public List<String> cocktailType;
    public double ratingCocktail; // Use double for ratings
    public double timeForCocktail;
    public int levelOfDifficulty;
    public int amountOfPeople;

    private FirebaseFirestore db;

    // Default constructor
    public CocktailData() {
    }

    // Parameterized constructor
    public CocktailData(String nameCocktail, String recipeCocktail, String imageCocktail,
                        List<Map<String, Object>> ingredientsCocktail, List<String> cocktailType,
                        double ratingCocktail, double timeForCocktail, int levelOfDifficulty, int amountOfPeople) {
        this.nameCocktail = nameCocktail;
        this.recipeCocktail = recipeCocktail;
        this.imageCocktail = imageCocktail;
        this.ingredientsCocktail = ingredientsCocktail;
        this.cocktailType = cocktailType;
        this.ratingCocktail = ratingCocktail;
        this.timeForCocktail = timeForCocktail;
        this.levelOfDifficulty = levelOfDifficulty;
        this.amountOfPeople = amountOfPeople;

        db = FirebaseFirestore.getInstance();
    }


    // Getters and Setters
    public String getNameCocktail() {
        return nameCocktail;
    }

    public void setNameCocktail(String nameCocktail) {
        this.nameCocktail = nameCocktail;
    }

    public String getRecipeCocktail() {
        return recipeCocktail;
    }

    public void setRecipeCocktail(String recipeCocktail) {
        this.recipeCocktail = recipeCocktail;
    }

    public String getImageCocktail() {
        return imageCocktail;
    }

    public void setImageCocktail(String imageCocktail) {
        this.imageCocktail = imageCocktail;
    }

    public List<Map<String, Object>> getIngredientsCocktail() {
        return ingredientsCocktail;
    }

    public void setIngredientsCocktail(List<Map<String, Object>> ingredientsCocktail) {
        this.ingredientsCocktail = ingredientsCocktail;
    }

    public List<String> getCocktailType() {
        return cocktailType;
    }

    public void setCocktailType(List<String> cocktailType) {
        this.cocktailType = cocktailType;
    }

    public double getRatingCocktail() {
        return ratingCocktail;
    }

    public void setRatingCocktail(double ratingCocktail) {
        this.ratingCocktail = ratingCocktail;
    }

    public double getTimeForCocktail() {
        return timeForCocktail;
    }

    public void setTimeForCocktail(double timeForCocktail) {
        this.timeForCocktail = timeForCocktail;
    }

    public int getLevelOfDifficulty() {
        return levelOfDifficulty;
    }

    public void setLevelOfDifficulty(int levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }
}
