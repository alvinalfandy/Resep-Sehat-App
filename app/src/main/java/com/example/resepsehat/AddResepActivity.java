package com.example.resepsehat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddResepActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1; // Request code untuk memilih gambar

    private Button btnSelectImage, btnSaveResep, btnBack;
    private EditText editResepName, editDescription, editIngredients, editSteps, editDuration;
    private RatingBar ratingBar;
    private RadioGroup radioGroupKategori;
    private RadioButton radioSarapan, radioMakanSiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resep);

        // Inisialisasi komponen
        btnSelectImage = findViewById(R.id.btn_select_image);
        btnSaveResep = findViewById(R.id.btn_save_resep);
        btnBack = findViewById(R.id.btn_back);

        editResepName = findViewById(R.id.edit_resep_name);
        editDescription = findViewById(R.id.edit_description);
        editIngredients = findViewById(R.id.edit_ingredients);
        editSteps = findViewById(R.id.edit_steps);
        editDuration = findViewById(R.id.edit_duration);
        ratingBar = findViewById(R.id.rating_bar);

        radioGroupKategori = findViewById(R.id.radioGroupKategori);
        radioSarapan = findViewById(R.id.radioSarapan);
        radioMakanSiang = findViewById(R.id.radioMakanSiang);

        // Tombol Pilih Gambar
        btnSelectImage.setOnClickListener(v -> {
            // Membuka galeri untuk memilih gambar
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PICK_IMAGE);
        });

        // Tombol Kembali
        btnBack.setOnClickListener(v -> {
            // Kembali ke halaman sebelumnya
            onBackPressed();
        });

        // Tombol Tambah Resep
        btnSaveResep.setOnClickListener(v -> {
            // Mendapatkan kategori yang dipilih
            String kategori = "";
            if (radioSarapan.isChecked()) {
                kategori = "Sarapan";
            } else if (radioMakanSiang.isChecked()) {
                kategori = "Makan Siang";
            }

            // Simpan resep baru (misalnya dengan menyimpan ke database atau list)
            if (!kategori.isEmpty()) {
                // Simpan resep (logika untuk menambah resep ke halaman utama)
                Toast.makeText(this, "Resep " + kategori + " berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                finish(); // Kembali ke halaman utama
            } else {
                Toast.makeText(this, "Pilih kategori terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Mengambil gambar dari galeri
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            // Menangani pemilihan gambar
            // Gambar bisa diambil dari data.getData() dan disimpan atau ditampilkan
            Toast.makeText(this, "Gambar berhasil dipilih", Toast.LENGTH_SHORT).show();
        }
    }
}
