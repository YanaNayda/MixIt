package com.example.mixit;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CocktailLibrary {
    private final FirebaseFirestore db;

    public CocktailLibrary() {
        db = FirebaseFirestore.getInstance();
    }

    // Create cocktail data
    public void createCocktailData() {
        addCocktailIfNotExists("Mojito", createMojitoData());
        addCocktailIfNotExists("Margarita", createMargaritaData());
        // Add more cocktails here
    }

    private Map<String, Object> createMojitoData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Rum", "amount", "30ml"),
                Map.of("name", "Mint leaves", "amount", "10"),
                Map.of("name", "Sugar", "amount", "1 tbsp"),
                Map.of("name", "Lime", "amount", "1")
        );

        return Map.of(
                "name", "Mojito",
                "recipe", "Muddle mint leaves, mix with lime juice and sugar, add rum, top with soda water.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Refreshing"),
                "rating", 4.5,
                "time", 10.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createMargaritaData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Tequila", "amount", "50ml"),
                Map.of("name", "Lime juice", "amount", "30ml"),
                Map.of("name", "Cointreau", "amount", "20ml"),
                Map.of("name", "Salt", "amount", "1 pinch")
        );

        return Map.of(
                "name", "Margarita",
                "recipe", "Shake tequila, lime juice, and Cointreau with ice, strain into a salt-rimmed glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Citrus"),
                "rating", 4.8,
                "time", 8.0,
                "levelOfDifficulty", 3,
                "amountOfPeople", 1
        );
    }

    private void addCocktailIfNotExists(String name, Map<String, Object> data) {
        db.collection("cocktails")
                .whereEqualTo("name", name)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (queryDocumentSnapshots.isEmpty()) {
                        // Cocktail does not exist; add it
                        db.collection("cocktails")
                                .document(name) // Use cocktail name as the document ID
                                .set(data)
                                .addOnSuccessListener(unused ->
                                        System.out.println(name + " added to Firebase."))
                                .addOnFailureListener(e ->
                                        System.err.println("Error adding " + name + ": " + e.getMessage()));
                    } else {
                        System.out.println(name + " already exists in Firebase.");
                    }
                })
                .addOnFailureListener(e ->
                        System.err.println("Error checking for " + name + ": " + e.getMessage()));
    }
}
