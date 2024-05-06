package com.example.quiz1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get data from Intent
        String menuName = getIntent().getStringExtra("menuName");
        int menuPrice = getIntent().getIntExtra("menuPrice", 0);
        String jumlahPorsi = getIntent().getStringExtra("jumlahPorsi");

        // Initialize Views
        TextView menuTextView = findViewById(R.id.etmenupesanan);
        TextView jumlahPorsiTextView = findViewById(R.id.etjumlahporsi);
        TextView totalHargaTextView = findViewById(R.id.totalharga);

        // Display data
        menuTextView.setText(getString(R.string.menu_pesanan) + ": " + menuName);
        jumlahPorsiTextView.setText(getString(R.string.jumlah_porsi1) + ": " + jumlahPorsi);

        // Calculate total harga
        int totalHarga = menuPrice * Integer.parseInt(jumlahPorsi);
        totalHargaTextView.setText(getString(R.string.total_harga) + ": " + totalHarga);
    }
}
