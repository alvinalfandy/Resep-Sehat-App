package com.example.resepsehat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> favoriteRecipes;
    private FavoriteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite); // Pastikan ini sesuai dengan nama layout

        recyclerView = findViewById(R.id.recycler_favorite_recipes); // Pastikan ini ID yang benar
        favoriteRecipes = new ArrayList<>();
        favoriteRecipes.add("Nasi Goreng Sehat");
        favoriteRecipes.add("Salad Buah Segar");
        favoriteRecipes.add("Sup Ayam Jahe");

        // Menambahkan konteks sebagai parameter kedua
        adapter = new FavoriteAdapter(favoriteRecipes, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Mengatur LayoutManager
        recyclerView.setAdapter(adapter); // Mengatur adapter

        // Inisialisasi tombol kembali
        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Menutup activity ini dan kembali ke activity sebelumnya
            }
        });
    }
}
