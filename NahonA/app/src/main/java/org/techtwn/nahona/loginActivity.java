package org.techtwn.nahona;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputLayout passwordLayout = findViewById(R.id.input_password);

        passwordLayout.setPasswordVisibilityToggleEnabled(true);

        Button button = (Button)findViewById(R.id.login_button);
        TextView signup = (TextView)findViewById(R.id.signupText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                startActivityForResult(intent,1001);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), registerActivity.class);
                startActivityForResult(intent,1003);
            }
        });

    }

}