package com.example.resepsehat;

import android.os.Bundle;
import android.view.View; // Tambahkan impor ini
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText searchInput;
    private Button searchButton;
    private TextView searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Inisialisasi komponen UI
        searchInput = findViewById(R.id.search_input);
        searchButton = findViewById(R.id.search_button);
        searchResults = findViewById(R.id.search_results);

        // Set listener untuk tombol cari
        searchButton.setOnClickListener(v -> {
            String query = searchInput.getText().toString();
            if (!query.isEmpty()) {
                List<Recipe> results = new RecipeManager(this).searchRecipes(query);
                if (results.isEmpty()) {
                    searchResults.setText("Tidak ada hasil ditemukan.");
                } else {
                    StringBuilder resultText = new StringBuilder();
                    for (Recipe recipe : results) {
                        resultText.append(recipe.getName()).append("\n");
                    }
                    searchResults.setText(resultText.toString());
                }
                searchResults.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(this, "Masukkan kata kunci pencarian!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
