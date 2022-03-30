package com.example.appli;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;


public class Main5_image extends AppCompatActivity {

        private VideoView videoView;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity5_video_admin);


            Button button_user = (Button) findViewById(R.id.users);
            button_user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent user = new Intent(Main5_image.this, Main8_gestion_user.class);
                    startActivity(user);
                }


            });

            Button button_log = (Button) findViewById(R.id.log);
            button_log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent log = new Intent(Main5_image.this, Main6_log.class);
                    startActivity(log);
                }


            });

            Button button_accueil = (Button) findViewById(R.id.retour);
            button_accueil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent accueil = new Intent(Main5_image.this, Main7_accueil.class);
                    startActivity(accueil);
                }


            });




            //Button btn = findViewById(R.id.veo);
            //    btn.setOnClickListener(view -> Toast.makeText(getApplicationContext(),"L'intervention va débuter",Toast.LENGTH_LONG).show());

            videoView = findViewById(R.id.videoView);


            Uri vidUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
            videoView.setVideoURI(vidUri);
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

