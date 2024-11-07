package com.example.resepsehat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResepDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep_detail);

        String resepName = getIntent().getStringExtra("RESEP_NAME");
        if (resepName == null) {
            resepName = "Detail resep tidak ditemukan.";
        }

        TextView resepTitle = findViewById(R.id.tv_judul_resep);
        resepTitle.setText(resepName);

        displayRecipeDetails(resepName);

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());
    }

    private void displayRecipeDetails(String resepName) {
        TextView resepDetails = findViewById(R.id.tv_detail_resep);
        ImageView imageResep = findViewById(R.id.image_resep);

        String details = "";
        switch (resepName) {
            case "Nasi Goreng Sehat":
                details = "Bahan:\n- Nasi putih\n- Sayuran\n- Telur\n- Kecap\n\nCara Membuat:\n1. Tumis sayuran.\n2. Tambahkan nasi dan telur.\n3. Aduk hingga merata.";
                imageResep.setImageResource(R.drawable.nasigoreng);
                break;
            case "Salad Buah Segar":
                details = "Bahan:\n- Berbagai buah\n- Yogurt\n- Madu\n\nCara Membuat:\n1. Potong buah-buahan.\n2. Campurkan dengan yogurt dan madu.";
                imageResep.setImageResource(R.drawable.salad); // Pastikan gambar ini ada
                break;
            case "Sup Ayam Jahe":
                details = "Bahan:\n- Ayam\n- Jahe\n- Sayuran\n- Kaldu\n\nCara Membuat:\n1. Rebus ayam dan jahe.\n2. Tambahkan sayuran dan kaldu.\n3. Masak hingga matang.";
                imageResep.setImageResource(R.drawable.supayam); // Pastikan gambar ini ada
                break;
            default:
                details = "Detail resep tidak ditemukan.";
                break;
        }

        resepDetails.setText(details);
    }
}
