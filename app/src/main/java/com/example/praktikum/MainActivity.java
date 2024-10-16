package com.example.praktikum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etEmail;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btn_login);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Email dan Password tidak boleh kosong",
                            Toast.LENGTH_SHORT).show();
                } else if (email.equals("dimasfiebry@student.ub.ac.id") &&
                        password.equals("225150600111002")) {
                    Toast.makeText(MainActivity.this,
                            "Berhasil Log In", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, MrheadActivity.class);
                    intent.putExtra("email_key", email);
                    intent.putExtra("password_key", password);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,
                            "Login Gagal, Email atau Password salah",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
