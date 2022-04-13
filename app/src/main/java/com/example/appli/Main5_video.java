package com.example.appli;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;


public class Main5_video extends AppCompatActivity {

        private VideoView videoView;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity5_video_admin);

//--------------------------------------------------------------------------------------------------
//Barre de menue pour acceder au autre fonctionnalité de l'admin

            Button button_user = (Button) findViewById(R.id.users);
            button_user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent user = new Intent(Main5_video.this, Main8_gestion_user.class);
                    startActivity(user);
                }


            });

            Button button_log = (Button) findViewById(R.id.log);
            button_log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent log = new Intent(Main5_video.this, Main6_log.class);
                    startActivity(log);
                }


            });

            Button button_accueil = (Button) findViewById(R.id.retour);
            button_accueil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent accueil = new Intent(Main5_video.this, Main7_accueil.class);
                    startActivity(accueil);
                }


            });

            Button button_portail = (Button) findViewById(R.id.portail);
            button_portail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent portail = new Intent(Main5_video.this, Main4_boutton_admin.class);
                    startActivity(portail);
                }
            });
//--------------------------------------------------------------------------------------------------

            //Button btn = findViewById(R.id.veo);
            //    btn.setOnClickListener(view -> Toast.makeText(getApplicationContext(),"L'intervention va débuter",Toast.LENGTH_LONG).show());

            //carre xml
            videoView = findViewById(R.id.videoView);

            //cherche la video pour la lire
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
            videoView.setVideoURI(video);
        }


        @Override
        protected void onResume () {
            super.onResume();
            videoView.start();
        }

        @Override
        protected void onPause () {
            super.onPause();
            videoView.suspend();
        }
}

