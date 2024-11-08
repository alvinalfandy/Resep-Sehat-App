public class Resep {
    private String name;
    private String description;
    private String ingredients;
    private String steps;
    private String duration;
    private String category;
    private float rating;

    // Constructor
    public Resep(String name, String description, String ingredients, String steps, String duration, String category, float rating) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.steps = steps;
        this.duration = duration;
        this.category = category;
        this.rating = rating;
    }

    // Getter and Setter methods
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getIngredients() { return ingredients; }
    public String getSteps() { return steps; }
    public String getDuration() { return duration; }
    public String getCategory() { return category; }
    public float getRating() { return rating; }
}
