// Recipe.java
package com.example.resepsehat;

public class Recipe {
    private String name;
    private String description;
    private String rating;
    private String duration;
    private String ingredients;
    private String steps;
    private String imagePath;

    public Recipe(String name, String description, String rating, String duration, String ingredients, String steps, String imagePath) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.duration = duration;
        this.ingredients = ingredients;
        this.steps = steps;
        this.imagePath = imagePath;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public String getSteps() { return steps; }
    public void setSteps(String steps) { this.steps = steps; }
    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}