// RecipeManager.java
package com.example.resepsehat;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    private static final String FILE_NAME = "recipes.json";
    private Context context;

    public RecipeManager(Context context) {
        this.context = context;
    }

    public void saveRecipe(Recipe recipe) {
        try {
            List<Recipe> existingRecipes = getRecipes();
            existingRecipes.add(recipe);

            JSONArray jsonArray = new JSONArray();
            for (Recipe r : existingRecipes) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", r.getName());
                jsonObject.put("description", r.getDescription());
                jsonObject.put("rating", r.getRating());
                jsonObject.put("duration", r.getDuration());
                jsonObject.put("ingredients", r.getIngredients());
                jsonObject.put("steps", r.getSteps());
                jsonObject.put("imagePath", r.getImagePath());
                jsonArray.put(jsonObject);
            }

            FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(jsonArray.toString().getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        try {
            File file = new File(context.getFilesDir(), FILE_NAME);
            if (!file.exists()) {
                return recipes;
            }

            FileInputStream fis = context.openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            JSONArray jsonArray = new JSONArray(sb.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Recipe recipe = new Recipe(
                        jsonObject.getString("name"),
                        jsonObject.getString("description"),
                        jsonObject.getString("rating"),
                        jsonObject.getString("duration"),
                        jsonObject.getString("ingredients"),
                        jsonObject.getString("steps"),
                        jsonObject.getString("imagePath")
                );
                recipes.add(recipe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipes;
    }

    public List<Recipe> searchRecipes(String query) {
        List<Recipe> allRecipes = getRecipes();
        List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : allRecipes) {
            if (recipe.getName().toLowerCase().contains(query.toLowerCase()) ||
                    recipe.getDescription().toLowerCase().contains(query.toLowerCase())) {
                filteredRecipes.add(recipe);
            }
        }
        return filteredRecipes;
    }
}