package com.example.mycanteen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {

    Button loginButton, signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        loginButton = findViewById(R.id.loginButtonAdmin);
        signupButton = findViewById(R.id.signupButtonAdmin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin.this, loginJava.class);
                startActivity(intent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Admin.this, signupJava.class);
                startActivity(intent2);
            }
        });
    }

    /**
    public void onAdminLoginClick(View view) {
        // Handle the click action, for example, start the AdminLoginActivity
        Intent intent = new Intent(this, AdminLoginActivity.class);
        startActivity(intent);
    }
     **/
}
