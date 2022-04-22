package com.example.appli;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;


public class Main5_video extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        String videoUrl = "http://172.16.200.147:8081";


            // finding videoview by its id
            VideoView videoView = findViewById(R.id.videoView);

            // Uri object to refer the
            // resource from the videoUrl
            Uri uri = Uri.parse(videoUrl);

            // sets the resource from the
            // videoUrl to the videoView
            videoView.setVideoURI(uri);

            // creating object of
            // media controller class
            MediaController mediaController = new MediaController(this);

            // sets the anchor view
            // anchor view for the videoView
            mediaController.setAnchorView(videoView);

            // sets the media player to the videoView
            mediaController.setMediaPlayer(videoView);

            // sets the media controller to the videoView
            videoView.setMediaController(mediaController);

            // starts the video
            videoView.start();
        }
    }


