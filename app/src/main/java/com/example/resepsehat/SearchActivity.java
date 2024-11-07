package com.example.resepsehat;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search); // Pastikan ini sesuai dengan XML layout

        // Inisialisasi komponen UI
        searchView = findViewById(R.id.search_view);

        // Mengatur listener untuk SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Menampilkan hasil pencarian
                if (!query.isEmpty()) {
                    Toast.makeText(SearchActivity.this, "Mencari: " + query, Toast.LENGTH_SHORT).show();
                    Log.d("SearchActivity", "Pencarian dilakukan untuk: " + query);
                } else {
                    Toast.makeText(SearchActivity.this, "Masukkan kata kunci pencarian!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Digunakan saat teks dalam SearchView berubah
                return false;
            }
        });
    }
}
