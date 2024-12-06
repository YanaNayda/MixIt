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
        addCocktailIfNotExists("Cosmopolitan", createCosmopolitanData());
        addCocktailIfNotExists("Pina Colada", createPinaColadaData());
        addCocktailIfNotExists("Negroni", createNegroniData());
        addCocktailIfNotExists("Old Fashione", createOldFashionedData());
        addCocktailIfNotExists("Daiquiri", createDaiquiriData());
        addCocktailIfNotExists("Whiskey Sour", createWhiskeySourData());
        addCocktailIfNotExists("Tom Collins", createTomCollinsData());
        addCocktailIfNotExists("Mai Tai", createMaiTaiData());
        addCocktailIfNotExists("Long Is land Iced Tea", createLongIslandIcedTeaData());
        addCocktailIfNotExists("Bloody Mary",createBloodyMaryData());
        addCocktailIfNotExists("Caipirinh",  createCaipirinhaData());
        addCocktailIfNotExists("Zombie",  createZombieData());
        addCocktailIfNotExists("Mint Julep", createMintJulepData());
        addCocktailIfNotExists("Gin Tonic", createGinTonicData());
        addCocktailIfNotExists("Rum Punch", createRumPunchData());
        addCocktailIfNotExists("Black Russian", createBlackRussianData());
        addCocktailIfNotExists("Sazerac", createSazeracData());
        addCocktailIfNotExists("Tequila Sunrise", createTequilaSunriseData());
        addCocktailIfNotExists("Manhattan", createManhattanData());
        addCocktailIfNotExists("Sex On The Beach", createSexOnTheBeachData());
        addCocktailIfNotExists("B52", createB52Data());
        addCocktailIfNotExists("Bellini", createBelliniData());
        addCocktailIfNotExists("Blue Lagoon", createBlueLagoonData());
        addCocktailIfNotExists("Singapore Sling", createSingaporeSlingData());
        addCocktailIfNotExists("Pisco Sour", createPiscoSourData());
        addCocktailIfNotExists("Clover Club", createCloverClubData());
        addCocktailIfNotExists("French75", createFrench75Data());
        addCocktailIfNotExists("Aperol Spritz", createAperolSpritzData());
        addCocktailIfNotExists("Rum Runner", createRumRunnerData());
        addCocktailIfNotExists("Moscow Mule", createMoscowMuleData());
        addCocktailIfNotExists("Apple Martini", createAppleMartiniData());
        addCocktailIfNotExists("Amaretto Sour", createAmarettoSourData());
        addCocktailIfNotExists("CoffeeMartini", createCoffeeMartiniData());
        addCocktailIfNotExists("Paloma", createPalomaData());
        addCocktailIfNotExists("B&B", createBBData());
        addCocktailIfNotExists("Banana Batshee", createBananaBatsheeData());
        addCocktailIfNotExists("Americano", createAmericanoData());
        addCocktailIfNotExists("Between The Sheets", createBetweenTheSheetsData());
        addCocktailIfNotExists("Blue Bazar", createBlueBazarData());
        addCocktailIfNotExists("Brandy Alexander", createBrandyAlexanderData());
        addCocktailIfNotExists("Cuba Libre", createCubaLibreData());
        addCocktailIfNotExists("Dark And Stormy", createDarkAndStormyData());
        addCocktailIfNotExists("El Diablo", createElDiabloData());
        addCocktailIfNotExists("Flaming Lamborghini", createFlamingLamborghiniData());
        addCocktailIfNotExists("God father",createGodfatherData());
        addCocktailIfNotExists("Flatliner", createFlatlinerData());
        addCocktailIfNotExists("Gimlet", createGimletData());
        addCocktailIfNotExists("Golden Cadillac",createGoldenCadillacData());
        addCocktailIfNotExists("Harvey Wallbanger", createHarveyWallbangerData());
        addCocktailIfNotExists("Jasmine", createJasmineData());
        addCocktailIfNotExists("Kamikaze", createKamikazeData());
        addCocktailIfNotExists("Kir", createKirData());
        addCocktailIfNotExists("La Paloma", createLaPalomaData());
        addCocktailIfNotExists("Dirty Martini",createDirtyMartiniData());
        addCocktailIfNotExists("Dry Martini",createDryMartiniData());
        addCocktailIfNotExists("Martinez",createMartinezData());
        addCocktailIfNotExists("PerfectMartini",createPerfectMartiniData());
        addCocktailIfNotExists("VodkaMartini",createVodkaMartiniData());
        addCocktailIfNotExists("Orgasm",createOrgasmData());
        addCocktailIfNotExists("Pink Squirrel",createPinkSquirrelData());

        // Add more cocktails here
    }
    private Map<String, Object> createPinkSquirrelData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Creme de noyaux", "amount", "20ml"),
                Map.of("name", "Baileys Irish Cream", "amount", "20ml"),
                Map.of("name", "Milk", "amount", "40ml")
        );

        return Map.of(
                "name", "Pink Squirrel",
                "recipe", "Pour all ingredients into a glass and stir.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Creamy", "Sweet"),
                "rating", 4.5,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createOrgasmData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Amaretto", "amount", "20ml"),
                Map.of("name", "Baileys Irish Cream", "amount", "20ml"),
                Map.of("name", "Kahlua", "amount", "20ml")
        );

        return Map.of(
                "name", "Orgasm",
                "recipe", "Pour all ingredients into a glass and stir.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Creamy", "Sweet"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createVodkaMartiniData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "50ml"),
                Map.of("name", "Dry vermouth", "amount", "10ml")
        );

        return Map.of(
                "name", "Vodka Martini",
                "recipe", "Stir vodka and dry vermouth with ice and strain into a glass, garnish with an olive.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Strong"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createPerfectMartiniData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "50ml"),
                Map.of("name", "Dry vermouth", "amount", "5ml"),
                Map.of("name", "Sweet vermouth", "amount", "5ml")
        );

        return Map.of(
                "name", "Perfect Martini",
                "recipe", "Stir gin, dry vermouth, and sweet vermouth with ice and strain into a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Strong"),
                "rating", 4.7,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createDryMartiniData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "50ml"),
                Map.of("name", "Dry vermouth", "amount", "10ml")
        );

        return Map.of(
                "name", "Dry Martini",
                "recipe", "Stir gin and dry vermouth with ice and strain into a glass, garnish with an olive.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Strong"),
                "rating", 4.9,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createDirtyMartiniData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "50ml"),
                Map.of("name", "Dry vermouth", "amount", "10ml"),
                Map.of("name", "Olive brine", "amount", "15ml")
        );

        return Map.of(
                "name", "Dirty Martini",
                "recipe", "Stir gin, dry vermouth, and olive brine with ice, strain into a glass, and garnish with an olive.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Salty"),
                "rating", 4.8,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createMartinezData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "50ml"),
                Map.of("name", "Sweet vermouth", "amount", "20ml"),
                Map.of("name", "Maraschino liqueur", "amount", "10ml"),
                Map.of("name", "Angostura bitters", "amount", "2 dashes")
        );

        return Map.of(
                "name", "Martinez",
                "recipe", "Stir all ingredients with ice and strain into a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Strong"),
                "rating", 4.7,
                "time", 5.0,
                "levelOfDifficulty", 3,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createLaPalomaData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Tequila", "amount", "50ml"),
                Map.of("name", "Grapefruit juice", "amount", "100ml"),
                Map.of("name", "Soda water", "amount", "50ml"),
                Map.of("name", "Lime juice", "amount", "15ml")
        );

        return Map.of(
                "name", "La Paloma",
                "recipe", "Mix tequila, lime juice, and grapefruit juice in a glass, top with soda water.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Fruity", "Refreshing"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createKirData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "White wine", "amount", "100ml"),
                Map.of("name", "Creme de cassis", "amount", "10ml")
        );

        return Map.of(
                "name", "Kir",
                "recipe", "Pour white wine into a glass, then add creme de cassis.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Sweet"),
                "rating", 4.5,
                "time", 3.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createKamikazeData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "30ml"),
                Map.of("name", "Triple sec", "amount", "30ml"),
                Map.of("name", "Lime juice", "amount", "10ml")
        );

        return Map.of(
                "name", "Kamikaze",
                "recipe", "Shake all ingredients with ice and strain into a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Strong", "Citrusy"),
                "rating", 4.4,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createJasmineData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "40ml"),
                Map.of("name", "Cointreau", "amount", "15ml"),
                Map.of("name", "Lemon juice", "amount", "15ml"),
                Map.of("name", "Maraschino liqueur", "amount", "5ml")
        );

        return Map.of(
                "name", "Jasmine",
                "recipe", "Shake all ingredients with ice and strain into a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Fruity", "Citrusy"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createHarveyWallbangerData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "40ml"),
                Map.of("name", "Galliano", "amount", "20ml"),
                Map.of("name", "Orange juice", "amount", "100ml")
        );

        return Map.of(
                "name", "Harvey Wallbanger",
                "recipe", "Pour vodka and orange juice into a glass, then float Galliano on top.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Citrusy"),
                "rating", 4.5,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createGoldenCadillacData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Galliano", "amount", "30ml"),
                Map.of("name", "Creme de cacao", "amount", "20ml"),
                Map.of("name", "Heavy cream", "amount", "20ml")
        );

        return Map.of(
                "name", "Golden Cadillac",
                "recipe", "Shake all ingredients with ice and strain into a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Creamy", "Classic"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createGimletData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "50ml"),
                Map.of("name", "Lime juice", "amount", "15ml"),
                Map.of("name", "Sugar syrup", "amount", "10ml")
        );

        return Map.of(
                "name", "Gimlet",
                "recipe", "Shake gin, lime juice, and sugar syrup with ice and strain into a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Citrusy"),
                "rating", 4.7,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createFlatlinerData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Tequila", "amount", "25ml"),
                Map.of("name", "Tabasco sauce", "amount", "3 dashes")
        );

        return Map.of(
                "name", "Flatliner",
                "recipe", "Pour tequila into a glass, add tabasco sauce, and shoot.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Spicy", "Strong"),
                "rating", 4.4,
                "time", 3.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createGodfatherData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Scotch whisky", "amount", "40ml"),
                Map.of("name", "Amaretto", "amount", "20ml")
        );

        return Map.of(
                "name", "Godfather",
                "recipe", "Pour whisky and amaretto into a glass and stir.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Strong", "Classic"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createFlamingLamborghiniData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Limoncello", "amount", "20ml"),
                Map.of("name", "Blue Curacao", "amount", "20ml"),
                Map.of("name", "Baileys Irish Cream", "amount", "20ml"),
                Map.of("name", "151 rum", "amount", "15ml")
        );

        return Map.of(
                "name", "Flaming Lamborghini",
                "recipe", "Layer ingredients in a glass. Light the 151 rum and serve with a straw.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Flaming", "Sweet"),
                "rating", 4.5,
                "time", 5.0,
                "levelOfDifficulty", 4,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createElDiabloData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Tequila", "amount", "50ml"),
                Map.of("name", "Creme de cassis", "amount", "20ml"),
                Map.of("name", "Ginger beer", "amount", "100ml"),
                Map.of("name", "Lime juice", "amount", "15ml")
        );

        return Map.of(
                "name", "El Diablo",
                "recipe", "Shake tequila, creme de cassis, and lime juice with ice, strain into a glass, and top with ginger beer.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Fruity", "Spicy"),
                "rating", 4.7,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createDarkAndStormyData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Dark rum", "amount", "50ml"),
                Map.of("name", "Ginger beer", "amount", "100ml"),
                Map.of("name", "Lime juice", "amount", "15ml")
        );

        return Map.of(
                "name", "Dark & Stormy",
                "recipe", "Fill a glass with ice, add rum and lime juice, and top with ginger beer.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Spicy", "Strong"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createCubaLibreData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Rum", "amount", "50ml"),
                Map.of("name", "Cola", "amount", "100ml"),
                Map.of("name", "Lime", "amount", "1/2")
        );

        return Map.of(
                "name", "Cuba Libre",
                "recipe", "Pour rum into a glass, squeeze in lime juice, top with cola, and stir.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Refreshing"),
                "rating", 4.4,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createBrandyAlexanderData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Brandy", "amount", "40ml"),
                Map.of("name", "Creme de cacao", "amount", "20ml"),
                Map.of("name", "Heavy cream", "amount", "20ml")
        );

        return Map.of(
                "name", "Brandy Alexander",
                "recipe", "Shake all ingredients with ice and strain into a chilled cocktail glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Creamy", "Classic"),
                "rating", 4.7,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }


    private Map<String, Object> createBlueBazarData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "30ml"),
                Map.of("name", "Blue Curacao", "amount", "20ml"),
                Map.of("name", "Lemon juice", "amount", "20ml"),
                Map.of("name", "Sugar syrup", "amount", "10ml")
        );

        return Map.of(
                "name", "Blue Bazar",
                "recipe", "Shake all ingredients with ice and strain into a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Fruity", "Refreshing"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createBetweenTheSheetsData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Brandy", "amount", "25ml"),
                Map.of("name", "Rum", "amount", "25ml"),
                Map.of("name", "Triple sec", "amount", "25ml"),
                Map.of("name", "Lemon juice", "amount", "10ml")
        );

        return Map.of(
                "name", "Between the Sheets",
                "recipe", "Shake all ingredients with ice and strain into a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Strong"),
                "rating", 4.7,
                "time", 5.0,
                "levelOfDifficulty", 3,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createAmericanoData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Campari", "amount", "30ml"),
                Map.of("name", "Sweet vermouth", "amount", "30ml"),
                Map.of("name", "Soda water", "amount", "60ml")
        );

        return Map.of(
                "name", "Americano",
                "recipe", "Pour Campari and sweet vermouth into a glass, add ice, and top with soda water.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Bitter"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createBananaBatsheeData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Banana liqueur", "amount", "30ml"),
                Map.of("name", "Rum", "amount", "40ml"),
                Map.of("name", "Pineapple juice", "amount", "100ml"),
                Map.of("name", "Grenadine", "amount", "10ml")
        );

        return Map.of(
                "name", "Banana Batshee",
                "recipe", "Shake all ingredients with ice and strain into a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Tropical", "Sweet"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createBBData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Brandy", "amount", "50ml"),
                Map.of("name", "Benedictine", "amount", "25ml")
        );

        return Map.of(
                "name", "B&B",
                "recipe", "Pour brandy and Benedictine into a glass and stir gently.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Strong"),
                "rating", 4.5,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createCoffeeMartiniData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "40ml"),
                Map.of("name", "Kahlúa", "amount", "20ml"),
                Map.of("name", "Freshly brewed coffee", "amount", "30ml")
        );

        return Map.of(
                "name", "Coffee Martini",
                "recipe", "Shake vodka, Kahlúa, and coffee with ice, strain into a martini glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Coffee", "Strong"),
                "rating", 4.7,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createPalomaData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Tequila", "amount", "50ml"),
                Map.of("name", "Grapefruit soda", "amount", "100ml"),
                Map.of("name", "Lime juice", "amount", "15ml"),
                Map.of("name", "Salt", "amount", "pinch")
        );

        return Map.of(
                "name", "Paloma",
                "recipe", "Pour tequila and lime juice into a glass, top with grapefruit soda, and garnish with salt.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Tropical", "Citrusy"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createAmarettoSourData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Amaretto", "amount", "50ml"),
                Map.of("name", "Lemon juice", "amount", "25ml"),
                Map.of("name", "Egg white", "amount", "1")
        );

        return Map.of(
                "name", "Amaretto Sour",
                "recipe", "Shake amaretto, lemon juice, and egg white with ice, strain into a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Sour", "Nutty"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createRumRunnerData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Rum", "amount", "30ml"),
                Map.of("name", "Banana liqueur", "amount", "15ml"),
                Map.of("name", "Blackberry brandy", "amount", "15ml"),
                Map.of("name", "Orange juice", "amount", "50ml"),
                Map.of("name", "Grenadine", "amount", "10ml")
        );

        return Map.of(
                "name", "Rum Runner",
                "recipe", "Shake all ingredients with ice, strain into a glass, and garnish with fruit.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Tropical", "Fruity"),
                "rating", 4.7,
                "time", 10.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createAppleMartiniData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "40ml"),
                Map.of("name", "Apple schnapps", "amount", "20ml"),
                Map.of("name", "Lime juice", "amount", "10ml")
        );

        return Map.of(
                "name", "Apple Martini",
                "recipe", "Shake all ingredients with ice and strain into a martini glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Fruity", "Sour"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createMoscowMuleData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "50ml"),
                Map.of("name", "Ginger beer", "amount", "100ml"),
                Map.of("name", "Lime juice", "amount", "15ml")
        );

        return Map.of(
                "name", "Moscow Mule",
                "recipe", "Pour vodka and lime juice into a glass, top with ginger beer, and garnish with mint.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Spicy"),
                "rating", 4.7,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createAperolSpritzData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Aperol", "amount", "45ml"),
                Map.of("name", "Prosecco", "amount", "90ml"),
                Map.of("name", "Soda water", "amount", "30ml")
        );

        return Map.of(
                "name", "Aperol Spritz",
                "recipe", "Pour Aperol into a glass, top with prosecco and soda water, and stir gently.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Sparkling"),
                "rating", 4.7,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createFrench75Data() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "30ml"),
                Map.of("name", "Champagne", "amount", "Top"),
                Map.of("name", "Lemon juice", "amount", "15ml"),
                Map.of("name", "Simple syrup", "amount", "10ml")
        );

        return Map.of(
                "name", "French 75",
                "recipe", "Shake gin, lemon juice, and simple syrup with ice, strain into a glass, and top with champagne.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Sparkling"),
                "rating", 4.8,
                "time", 10.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createCloverClubData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "50ml"),
                Map.of("name", "Raspberry syrup", "amount", "15ml"),
                Map.of("name", "Lemon juice", "amount", "15ml"),
                Map.of("name", "Egg white", "amount", "1 egg")
        );

        return Map.of(
                "name", "Clover Club",
                "recipe", "Shake all ingredients with ice, strain into a glass, and garnish with raspberries.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Fruity"),
                "rating", 4.6,
                "time", 10.0,
                "levelOfDifficulty", 3,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createPiscoSourData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Pisco", "amount", "50ml"),
                Map.of("name", "Lemon juice", "amount", "25ml"),
                Map.of("name", "Egg white", "amount", "1 egg"),
                Map.of("name", "Simple syrup", "amount", "10ml")
        );

        return Map.of(
                "name", "Pisco Sour",
                "recipe", "Shake all ingredients with ice, strain into a glass, and garnish with a dash of bitters.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Sour", "Classic"),
                "rating", 4.7,
                "time", 10.0,
                "levelOfDifficulty", 3,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createSingaporeSlingData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "30ml"),
                Map.of("name", "Cherry brandy", "amount", "15ml"),
                Map.of("name", "Lime juice", "amount", "15ml"),
                Map.of("name", "Grenadine", "amount", "10ml"),
                Map.of("name", "Pineapple juice", "amount", "90ml"),
                Map.of("name", "Angostura bitters", "amount", "2 dashes")
        );

        return Map.of(
                "name", "Singapore Sling",
                "recipe", "Shake all ingredients with ice, strain into a glass, and garnish with a cherry.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Tropical", "Fruity"),
                "rating", 4.8,
                "time", 10.0,
                "levelOfDifficulty", 3,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createBlueLagoonData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "30ml"),
                Map.of("name", "Blue Curacao", "amount", "15ml"),
                Map.of("name", "Lemonade", "amount", "90ml")
        );

        return Map.of(
                "name", "Blue Lagoon",
                "recipe", "Mix vodka and blue curacao with lemonade, serve over ice.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Fruity", "Refreshing"),
                "rating", 4.5,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createBelliniData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Prosecco", "amount", "60ml"),
                Map.of("name", "Peach puree", "amount", "30ml")
        );

        return Map.of(
                "name", "Bellini",
                "recipe", "Pour peach puree into a glass, top with prosecco, and stir gently.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Fruity"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createB52Data() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Kahlúa", "amount", "15ml"),
                Map.of("name", "Baileys Irish Cream", "amount", "15ml"),
                Map.of("name", "Grand Marnier", "amount", "15ml")
        );

        return Map.of(
                "name", "B52",
                "recipe", "Layer Kahlúa, Baileys Irish Cream, and Grand Marnier in a shot glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Layered"),
                "rating", 4.7,
                "time", 5.0,
                "levelOfDifficulty", 3,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createSexOnTheBeachData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "30ml"),
                Map.of("name", "Peach schnapps", "amount", "15ml"),
                Map.of("name", "Cranberry juice", "amount", "45ml"),
                Map.of("name", "Orange juice", "amount", "45ml")
        );

        return Map.of(
                "name", "Sex on the Beach",
                "recipe", "Mix vodka, peach schnapps, cranberry juice, and orange juice with ice, serve in a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Fruity", "Sweet"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createManhattanData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Rye whiskey", "amount", "50ml"),
                Map.of("name", "Sweet vermouth", "amount", "20ml"),
                Map.of("name", "Angostura bitters", "amount", "2 dashes")
        );

        return Map.of(
                "name", "Manhattan",
                "recipe", "Stir all ingredients with ice, strain into a chilled glass, and garnish with a cherry.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Strong"),
                "rating", 4.8,
                "time", 5.0,
                "levelOfDifficulty", 3,
                "amountOfPeople", 1
        );
    }


    private Map<String, Object> createTequilaSunriseData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Tequila", "amount", "45ml"),
                Map.of("name", "Orange juice", "amount", "90ml"),
                Map.of("name", "Grenadine", "amount", "10ml")
        );

        return Map.of(
                "name", "Tequila Sunrise",
                "recipe", "Pour tequila and orange juice into a glass, add grenadine, and let it settle.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Tropical", "Fruity"),
                "rating", 4.5,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createSazeracData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Rye whiskey", "amount", "50ml"),
                Map.of("name", "Absinthe", "amount", "1 tsp"),
                Map.of("name", "Peychaud's bitters", "amount", "2 dashes"),
                Map.of("name", "Sugar", "amount", "1 cube")
        );

        return Map.of(
                "name", "Sazerac",
                "recipe", "Rinse a glass with absinthe, add whiskey, bitters, and sugar cube, stir, and garnish with lemon peel.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Spicy"),
                "rating", 4.8,
                "time", 10.0,
                "levelOfDifficulty", 4,
                "amountOfPeople", 1
        );
    }


    private Map<String, Object> createMintJulepData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Bourbon", "amount", "60ml"),
                Map.of("name", "Mint leaves", "amount", "10"),
                Map.of("name", "Sugar", "amount", "1 tbsp"),
                Map.of("name", "Water", "amount", "Splash")
        );

        return Map.of(
                "name", "Mint Julep",
                "recipe", "Muddle mint leaves and sugar with water, add bourbon and ice, stir and garnish with mint.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Minty"),
                "rating", 4.4,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createGinTonicData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "50ml"),
                Map.of("name", "Tonic water", "amount", "100ml"),
                Map.of("name", "Lime", "amount", "1 slice")
        );

        return Map.of(
                "name", "Gin Tonic",
                "recipe", "Pour gin into a glass filled with ice, top up with tonic water, and garnish with a slice of lime.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Citrusy"),
                "rating", 4.3,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createRumPunchData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Rum", "amount", "40ml"),
                Map.of("name", "Pineapple juice", "amount", "60ml"),
                Map.of("name", "Orange juice", "amount", "60ml"),
                Map.of("name", "Grenadine", "amount", "15ml")
        );

        return Map.of(
                "name", "Rum Punch",
                "recipe", "Mix rum, pineapple juice, orange juice, and grenadine. Stir well and serve over ice.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Tropical", "Fruity"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createBlackRussianData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "40ml"),
                Map.of("name", "Coffee liqueur", "amount", "20ml")
        );

        return Map.of(
                "name", "Black Russian",
                "recipe", "Pour vodka and coffee liqueur into a glass filled with ice and stir.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Strong"),
                "rating", 4.5,
                "time", 5.0,
                "levelOfDifficulty", 1,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createZombieData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "White rum", "amount", "30ml"),
                Map.of("name", "Dark rum", "amount", "30ml"),
                Map.of("name", "Apricot brandy", "amount", "15ml"),
                Map.of("name", "Lime juice", "amount", "30ml"),
                Map.of("name", "Pineapple juice", "amount", "60ml"),
                Map.of("name", "Grenadine", "amount", "10ml")
        );

        return Map.of(
                "name", "Zombie",
                "recipe", "Mix all ingredients with ice, shake well, and serve with a garnish of fruit.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Tropical", "Strong"),
                "rating", 4.7,
                "time", 10.0,
                "levelOfDifficulty", 3,
                "amountOfPeople", 1
        );
    }



    private Map<String, Object> createCaipirinhaData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Cachaça", "amount", "50ml"),
                Map.of("name", "Lime", "amount", "1"),
                Map.of("name", "Sugar", "amount", "2 tsp")
        );

        return Map.of(
                "name", "Caipirinha",
                "recipe", "Muddle lime with sugar, add cachaça and ice, stir well.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Brazilian", "Refreshing"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createBloodyMaryData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "40ml"),
                Map.of("name", "Tomato juice", "amount", "100ml"),
                Map.of("name", "Lemon juice", "amount", "15ml"),
                Map.of("name", "Worcestershire sauce", "amount", "2 dashes"),
                Map.of("name", "Tabasco", "amount", "1 dash"),
                Map.of("name", "Celery salt", "amount", "Pinch")
        );

        return Map.of(
                "name", "Bloody Mary",
                "recipe", "Mix vodka, tomato juice, lemon juice, Worcestershire sauce, Tabasco, and celery salt. Serve with ice and garnish with celery.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Savory", "Spicy"),
                "rating", 4.5,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createLongIslandIcedTeaData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "15ml"),
                Map.of("name", "Tequila", "amount", "15ml"),
                Map.of("name", "Rum", "amount", "15ml"),
                Map.of("name", "Gin", "amount", "15ml"),
                Map.of("name", "Triple sec", "amount", "15ml"),
                Map.of("name", "Lemon juice", "amount", "25ml"),
                Map.of("name", "Sugar syrup", "amount", "10ml"),
                Map.of("name", "Coke", "amount", "Top up")
        );

        return Map.of(
                "name", "Long Island Iced Tea",
                "recipe", "Mix all liquors with lemon juice and sugar syrup. Top up with Coke.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Strong"),
                "rating", 4.7,
                "time", 10.0,
                "levelOfDifficulty", 4,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createMaiTaiData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Rum", "amount", "30ml"),
                Map.of("name", "Dark rum", "amount", "15ml"),
                Map.of("name", "Orange liqueur", "amount", "15ml"),
                Map.of("name", "Lime juice", "amount", "10ml"),
                Map.of("name", "Orgeat syrup", "amount", "10ml")
        );

        return Map.of(
                "name", "Mai Tai",
                "recipe", "Shake rum, dark rum, orange liqueur, lime juice, and orgeat syrup with ice. Serve in a glass with mint.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Tropical", "Strong"),
                "rating", 4.6,
                "time", 10.0,
                "levelOfDifficulty", 3,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createTomCollinsData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "40ml"),
                Map.of("name", "Lemon juice", "amount", "20ml"),
                Map.of("name", "Sugar syrup", "amount", "10ml"),
                Map.of("name", "Soda water", "amount", "Top up")
        );

        return Map.of(
                "name", "Tom Collins",
                "recipe", "Mix gin, lemon juice, sugar syrup, and soda water. Serve in a tall glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Citrusy"),
                "rating", 4.3,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );

    }


        private Map<String, Object> createWhiskeySourData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Whiskey", "amount", "40ml"),
                Map.of("name", "Lemon juice", "amount", "15ml"),
                Map.of("name", "Sugar syrup", "amount", "10ml"),
                Map.of("name", "Egg white", "amount", "1")
        );

        return Map.of(
                "name", "Whiskey Sour",
                "recipe", "Shake whiskey, lemon juice, sugar syrup, and egg white. Strain into a glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Sour"),
                "rating", 4.4,
                "time", 5.0,
                "levelOfDifficulty", 3,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createDaiquiriData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Rum", "amount", "40ml"),
                Map.of("name", "Lime juice", "amount", "15ml"),
                Map.of("name", "Sugar syrup", "amount", "10ml")
        );

        return Map.of(
                "name", "Daiquiri",
                "recipe", "Shake rum, lime juice, and sugar syrup with ice. Strain into a chilled glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Sour"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }

    private Map<String, Object> createOldFashionedData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Sugar", "amount", "1 cube"),
                Map.of("name", "Angostura bitters", "amount", "2 dashes"),
                Map.of("name", "Whiskey", "amount", "50ml"),
                Map.of("name", "Citrus peel", "amount", "1 twist")
        );

        return Map.of(
                "name", "Old Fashioned",
                "recipe", "Muddle sugar with bitters, add whiskey, and stir. Serve with ice and a citrus peel.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Strong"),
                "rating", 4.5,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createNegroniData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Gin", "amount", "30ml"),
                Map.of("name", "Vermouth rosso", "amount", "30ml"),
                Map.of("name", "Campari", "amount", "30ml"),
                Map.of("name", "Orange", "amount", "1 slice")
        );

        return Map.of(
                "name", "Negroni",
                "recipe", "Stir gin, vermouth rosso, and Campari with ice. Strain into a glass with a twist of orange.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Bitter"),
                "rating", 4.3,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
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
    private Map<String, Object> createCosmopolitanData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Vodka", "amount", "40ml"),
                Map.of("name", "Triple sec", "amount", "15ml"),
                Map.of("name", "Lime juice", "amount", "10ml"),
                Map.of("name", "Cranberry juice", "amount", "30ml")
        );

        return Map.of(
                "name", "Cosmopolitan",
                "recipe", "Shake vodka, triple sec, lime juice, and cranberry juice with ice. Strain into a martini glass.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Classic", "Fruity"),
                "rating", 4.8,
                "time", 5.0,
                "levelOfDifficulty", 2,
                "amountOfPeople", 1
        );
    }
    private Map<String, Object> createPinaColadaData() {
        List<Map<String, Object>> ingredients = Arrays.asList(
                Map.of("name", "Rum", "amount", "30ml"),
                Map.of("name", "Coconut cream", "amount", "30ml"),
                Map.of("name", "Pineapple juice", "amount", "60ml"),
                Map.of("name", "Ice", "amount", "As needed")
        );

        return Map.of(
                "name", "Pina Colada",
                "recipe", "Blend rum, coconut cream, pineapple juice, and ice until smooth.",
                "image", "image_url_here",
                "ingredients", ingredients,
                "types", Arrays.asList("Tropical", "Sweet"),
                "rating", 4.6,
                "time", 5.0,
                "levelOfDifficulty", 2,
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
