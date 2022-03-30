package com.example.appli;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;
import android.os.Bundle;
import android.widget.FrameLayout;

public class Main4_boutton_admin extends AppCompatActivity {
    private ImageView image;
    private ToggleButton on;
    private FrameLayout myLayout;
    private boolean etat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_bouton_admin);

        //  on = (ToggleButton) findViewById(R.id.on);
        //myLayout =(FrameLayout) findViewById(R.id.FrameLayout) ;
        on = (ToggleButton) findViewById(R.id.on);
        image = (ImageView) findViewById(R.id.image);

        on.setOnClickListener((v) -> {
            if (etat == false) {

                image.setImageResource(R.drawable.led_on);
                on.setBackgroundResource(R.drawable.toggle_off);
                etat = true;

            } else if (etat == true) {
                image.setImageResource(R.drawable.led_off);
                on.setBackgroundResource(R.drawable.toggle_on);
                etat = false;
            }


        });

        Button button_video = (Button) findViewById(R.id.Image);
        button_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video = new Intent(Main4_boutton_admin.this, Main5_image.class);
                startActivity(video);
            }
        });


        Button button_user = (Button) findViewById(R.id.users);
        button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(Main4_boutton_admin.this, Main8_gestion_user.class);
                startActivity(user);
            }


        });

        Button button_log = (Button) findViewById(R.id.log);
        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(Main4_boutton_admin.this, Main6_log.class);
                startActivity(log);
            }


        });

        Button button_accueil = (Button) findViewById(R.id.retour);
        button_accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accueil = new Intent(Main4_boutton_admin.this, Main7_accueil.class);
                startActivity(accueil);
            }


        });
    }
}