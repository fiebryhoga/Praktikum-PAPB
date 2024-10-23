package com.example.praktikum;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MrheadActivity extends AppCompatActivity {

    private CheckBox checkHead, checkHair, checkEyebrow, checkEyes, checkMoustache, checkBeard;
    private ImageView imgBody, imgHair, imgEyebrows, imgEyes, imgMoustache, imgBeard;

    TextView tvEmail, tvPassword;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mrhead);

        tvEmail = findViewById(R.id.tvEmail);
        tvPassword = findViewById(R.id.tvPassword);

        String email = getIntent().getStringExtra("email_key");
        String password = getIntent().getStringExtra("password_key");

        tvEmail.setText("Email: " + email);
        tvPassword.setText("Password: " + password);

        checkHead = findViewById(R.id.checkHead);
        checkHair = findViewById(R.id.checkHair);
        checkEyebrow = findViewById(R.id.checkEyebrow);
        checkEyes = findViewById(R.id.checkEyes);
        checkMoustache = findViewById(R.id.checkMoustache);
        checkBeard = findViewById(R.id.checkBeard);

        imgBody = findViewById(R.id.imgBody);
        imgHair = findViewById(R.id.imgHair);
        imgEyebrows = findViewById(R.id.imgEyebrows);
        imgEyes = findViewById(R.id.imgEyes);
        imgMoustache = findViewById(R.id.imgMoustache);
        imgBeard = findViewById(R.id.imgBeard);

        checkHead.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imgBody.setVisibility(View.VISIBLE);
            } else {
                imgBody.setVisibility(View.INVISIBLE);
            }
        });

        checkHair.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imgHair.setVisibility(View.VISIBLE);
            } else {
                imgHair.setVisibility(View.INVISIBLE);
            }
        });

        checkEyebrow.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imgEyebrows.setVisibility(View.VISIBLE);
            } else {
                imgEyebrows.setVisibility(View.INVISIBLE);
            }
        });

        checkEyes.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imgEyes.setVisibility(View.VISIBLE);
            } else {
                imgEyes.setVisibility(View.INVISIBLE);
            }
        });

        checkMoustache.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imgMoustache.setVisibility(View.VISIBLE);
            } else {
                imgMoustache.setVisibility(View.INVISIBLE);
            }
        });

        checkBeard.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imgBeard.setVisibility(View.VISIBLE);
            } else {
                imgBeard.setVisibility(View.INVISIBLE);
            }
        });

        Button btnProfile = findViewById(R.id.btnProfile);

        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MrheadActivity.this, ProfileActvity.class);
            startActivity(intent);
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}