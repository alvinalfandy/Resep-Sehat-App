package com.example.resepsehat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menghubungkan tombol Lihat Resep
        Button btnNasiGoreng = findViewById(R.id.btn_detail_resep_nasi_goreng);
        btnNasiGoreng.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResepDetailActivity.class);
            intent.putExtra("RESEP_NAME", "Nasi Goreng Sehat");
            startActivity(intent);
        });

        Button btnSaladBuah = findViewById(R.id.btn_detail_resep_salad_buah);
        btnSaladBuah.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResepDetailActivity.class);
            intent.putExtra("RESEP_NAME", "Salad Buah Segar");
            startActivity(intent);
        });

        Button btnSupAyam = findViewById(R.id.btn_detail_resep_sup_ayam);
        btnSupAyam.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResepDetailActivity.class);
            intent.putExtra("RESEP_NAME", "Sup Ayam Jahe");
            startActivity(intent);
        });

        // Menambahkan bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()) {
                    case R.id.nav_home: // Sudah di halaman ini, tidak perlu melakukan apapun
                        return true;
                    case R.id.nav_favorite: // Menambahkan navigasi ke FavoriteActivity
                        intent = new Intent(MainActivity.this, FavoriteActivity.class);
                        break;
                    case R.id.nav_add_resep: // Menambahkan navigasi ke AddResepActivity
                        intent = new Intent(MainActivity.this, AddResepActivity.class);
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}
