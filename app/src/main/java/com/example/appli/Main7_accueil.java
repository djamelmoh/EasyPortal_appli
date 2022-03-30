package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main7_accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity7_accueil);

        Button button = (Button) findViewById(R.id.portail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent portail = new Intent(Main7_accueil.this, Main4_boutton_admin.class);
                startActivity(portail);
            }
        });

        Button button_video = (Button) findViewById(R.id.image);
        button_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video = new Intent(Main7_accueil.this, Main5_image.class);
                startActivity(video);
            }
        });


        Button button_user = (Button) findViewById(R.id.users);
        button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(Main7_accueil.this, Main8_gestion_user.class);
                startActivity(user);
            }


        });

        Button button_log = (Button) findViewById(R.id.log);
        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(Main7_accueil.this, Main6_log.class);
                startActivity(log);
            }


        });







        Button button_deconnexion = (Button) findViewById(R.id.deconnexion);
        button_deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deconnexion = new Intent(Main7_accueil.this, Main2_users.class);
                startActivity(deconnexion);
            }
        });

    }
}