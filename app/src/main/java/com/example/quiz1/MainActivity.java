package com.example.quiz1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText jumlahPorsiEditText;
    private Button orderButton;
    private RadioButton nasgorRadioButton, migorRadioButton, mibusRadioButton, nasdukRadioButton, tehEsRadioButton, esJerukRadioButton;

    // Define menu items
    private Map<String, MenuItem> menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        jumlahPorsiEditText = findViewById(R.id.jumlah);
        orderButton = findViewById(R.id.btnorder);
        nasgorRadioButton = findViewById(R.id.btnnasgor);
        migorRadioButton = findViewById(R.id.btnmigor);
        mibusRadioButton = findViewById(R.id.btnmibus);
        nasdukRadioButton = findViewById(R.id.btnnnasduk);
        tehEsRadioButton = findViewById(R.id.btntehes);
        esJerukRadioButton = findViewById(R.id.btnesjeruk);

        // Initialize menu items
        menuItems = new HashMap<>();
        menuItems.put(getString(R.string.nasi_goreng), new MenuItem(getString(R.string.nasi_goreng), 10000));
        menuItems.put(getString(R.string.mie_goreng), new MenuItem(getString(R.string.mie_goreng), 8000));
        menuItems.put(getString(R.string.mie_rebus), new MenuItem(getString(R.string.mie_rebus), 8000));
        menuItems.put(getString(R.string.teh_es), new MenuItem(getString(R.string.teh_es), 5000));
        menuItems.put(getString(R.string.es_jeruk), new MenuItem(getString(R.string.es_jeruk), 7000));

        // Set click listener for order button
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle order button click
                // Get selected menu
                String menuName = "";
                int menuPrice = 0;
                if (nasgorRadioButton.isChecked()) {
                    menuName = getString(R.string.nasi_goreng);
                    menuPrice = menuItems.get(menuName).getPrice();
                } else if (migorRadioButton.isChecked()) {
                    menuName = getString(R.string.mie_goreng);
                    menuPrice = menuItems.get(menuName).getPrice();
                } else if (mibusRadioButton.isChecked()) {
                    menuName = getString(R.string.mie_rebus);
                    menuPrice = menuItems.get(menuName).getPrice();
                } else if (nasdukRadioButton.isChecked()) {
                    menuName = getString(R.string.nasi_uduk);
                    menuPrice = menuItems.get(menuName).getPrice();
                } else if (tehEsRadioButton.isChecked()) {
                    menuName = getString(R.string.teh_es);
                    menuPrice = menuItems.get(menuName).getPrice();
                } else if (esJerukRadioButton.isChecked()) {
                    menuName = getString(R.string.es_jeruk);
                    menuPrice = menuItems.get(menuName).getPrice();
                }

                // Get jumlah porsi
                String jumlahPorsi = jumlahPorsiEditText.getText().toString();

                // Pass data to ResultActivity using Intent
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("menuName", menuName);
                intent.putExtra("menuPrice", menuPrice);
                intent.putExtra("jumlahPorsi", jumlahPorsi);
                startActivity(intent);
            }
        });
    }
}
