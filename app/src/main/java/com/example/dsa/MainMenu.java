package com.example.dsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dsa.models.Credentials;

public class MainMenu extends AppCompatActivity {

    Credentials c;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        c = new Credentials(username, password);
    }

    public void exitBtn_Click(View v) {
        ControllerLogOut ctrl = new ControllerLogOut();
        ctrl.start(this, c);
    }
}