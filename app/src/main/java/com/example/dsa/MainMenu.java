package com.example.dsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.dsa.models.Credentials;

public class MainMenu extends AppCompatActivity {

    RelativeLayout rellayNewGame, rellayMyItems, rellayStore, rellayMyProfile, rellayStatistics, rellayLogout, rellayInsignias;
    Credentials c;
    Toast toast;
    MainMenu main = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        int ID = getIntent().getIntExtra("ID", 0);
        c = new Credentials(username, password);

        rellayNewGame = this.findViewById(R.id.rellayNewGame);
        rellayMyItems = this.findViewById(R.id.rellayMyItems);
        rellayStore = this.findViewById(R.id.rellayStore);
        rellayMyProfile = this.findViewById(R.id.rellayMyProfile);
        rellayStatistics = this.findViewById(R.id.rellayStatistics);
        rellayLogout = this.findViewById(R.id.rellayLogout);
        rellayInsignias = this.findViewById(R.id.rellayInsignias);

        rellayNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Activity_New_Game.class);



                startActivity(intent);
            }
        });

        rellayMyItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Activity_My_Items.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        rellayStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Activity_Store.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        rellayMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Activity_My_Profile.class);
                intent.putExtra("ID", ID);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        rellayStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Activity_Statistics.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        rellayLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControllerLogOut ctrl = new ControllerLogOut();
				ctrl.start(main, c);
            }
        });

        rellayInsignias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Activity_Insignias.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }
}