package com.example.thirdproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin, btnChoose;
    RadioButton tt, hbhp, hbsh, hbtp;
    CheckBox ngoaingu, vanhoa;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("tranvanchien") && pass.equals("test")){
                    setContentView(R.layout.activity_option);
                }else{
                    Toast.makeText(MainActivity.this, "Dang nhap that bai", Toast.LENGTH_SHORT).show();
                }

                tt = findViewById(R.id.rdTutuc);
                hbhp = findViewById(R.id.rdhbhp);
                hbsh = findViewById(R.id.rdhbsh);
                hbtp = findViewById(R.id.rdhbtp);
                ngoaingu = findViewById(R.id.cbccngoaingu);
                vanhoa = findViewById(R.id.vanhoa);
                btnChoose = findViewById(R.id.btnChoose);
                btnChoose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(tt.isChecked() && ngoaingu.isChecked()){
                            Toast.makeText(MainActivity.this, "Tu tuc: Chung chi ngoai ngu", Toast.LENGTH_SHORT).show();
                        }
                        if(tt.isChecked() && ngoaingu.isChecked() && vanhoa.isChecked()){
                            Toast.makeText(MainActivity.this, "Tu tuc: Chung chi ngoai ngu & Trao doi trai nghiem van hoa", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}