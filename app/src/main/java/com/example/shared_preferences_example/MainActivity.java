package com.example.shared_preferences_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferencesConfig preferencesConfig;
    private EditText UserName, UserPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesConfig = new SharedPreferencesConfig(getApplicationContext());

        UserName = findViewById(R.id.user_name);
        UserPassword = findViewById(R.id.user_password);
        if (preferencesConfig.readLoginStatus())
        {
            startActivity(new Intent(this,LoggedInActivity.class));
            finish();
        }
    }

    public void loginUser(View view)
    {
        String username = UserName.getText().toString();
        String userpassword = UserPassword.getText().toString();

        if (username.equals(getResources().getString(R.string.user_name)) &&
                userpassword.equals(getResources().getString(R.string.user_password)))
        {
            startActivity(new Intent(this,LoggedInActivity.class));
            preferencesConfig.writeLoginStatus(true);
            finish();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Login Failed...Try Again...",Toast.LENGTH_SHORT).show();
            UserPassword.setText("");
            UserName.setText("");
        }
    }
}
