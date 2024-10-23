package com.example.praktikum;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActvity extends AppCompatActivity {

    private Button btnContact, btnEdit;
    private ImageView profileImage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_actvity);

        btnContact = findViewById(R.id.btnContact);
        btnEdit = findViewById(R.id.btnEdit);
        profileImage = findViewById(R.id.ProfileImage);


        btnContact.setOnClickListener(view -> {
            Uri uri = Uri.parse("tel:085730979637");
            Intent it = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(it);
        });

        btnEdit.setOnClickListener(view -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraLauncher.launch(intent);
        });
    }

    private final ActivityResultLauncher<Intent> cameraLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bitmap photo = (Bitmap) result.getData().getExtras().get("data");
                    profileImage.setImageBitmap(photo);
                }
            }
    );

}
