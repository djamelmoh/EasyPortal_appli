package com.example.appli;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main8_gestion_user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity8_gestion_user);


//--------------------------------------------------------------------------------------------------
//Barre de menue pour acceder au autre fonctionnalité de l'admin
        Button button = (Button) findViewById(R.id.portail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent portail = new Intent(Main8_gestion_user.this, Main4_boutton_admin.class);
                startActivity(portail);
            }
        });

        Button button_video = (Button) findViewById(R.id.Image);
        button_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video = new Intent(Main8_gestion_user.this, Main5_video.class);
                startActivity(video);
            }
        });


        Button button_accueil = (Button) findViewById(R.id.retour);
        button_accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accueil = new Intent(Main8_gestion_user.this, Main7_accueil.class);
                startActivity(accueil);
            }
        });

        Button button_log = (Button) findViewById(R.id.log);
        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(Main8_gestion_user.this, Main6_log.class);
                startActivity(log);
            }
        });
//--------------------------------------------------------------------------------------------------
    }
}