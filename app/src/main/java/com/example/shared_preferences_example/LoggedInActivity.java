package com.example.shared_preferences_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {
    private SharedPreferencesConfig preferencesConfig;
    private TextView userWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        userWelcome = findViewById(R.id.user_welcome);
        userWelcome.setText("Welcome "+getResources().getString(R.string.user_name));
        preferencesConfig = new SharedPreferencesConfig(getApplicationContext());
    }

    public void logoutUser(View view)
    {
        preferencesConfig.writeLoginStatus(false);
        startActivity(new Intent(LoggedInActivity.this,MainActivity.class));
        finish();
    }
}
