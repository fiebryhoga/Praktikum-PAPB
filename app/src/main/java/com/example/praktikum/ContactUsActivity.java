package com.example.praktikum;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ContactUsActivity extends AppCompatActivity {

    private Button btnCall, btnEmail, btnWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        btnCall = findViewById(R.id.btnCall);
        btnEmail = findViewById(R.id.btnEmail);
        btnWebsite = findViewById(R.id.btnWebsite);

        btnCall.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:+628123456789"));
            startActivity(callIntent);
        });

        btnEmail.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:dimasfiebry@student.ub.ac.id"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact Us");
            startActivity(emailIntent);
        });

        btnWebsite.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fiebryhoga.vercel.app"));
            startActivity(browserIntent);
        });
    }
}
