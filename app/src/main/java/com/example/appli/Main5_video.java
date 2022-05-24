package com.example.appli;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.VideoView;


public class Main5_video extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5_video_admin);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://91.81.88.254/");

//        final VideoView videoView;
//        videoView = (VideoView)findViewById(R.id.videoView);
//        videoView.setVideoPath("http://91.81.88.254/");
//        videoView.start();



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
//        String videoUrl = "http://91.81.88.254/";
//
//
//
//             // trouver videoview par son identifiant
//            VideoView videoView = findViewById(R.id.videoView);
//
//              // Objet Uri pour référencer le
//             // ressource de la videoUrl
//            Uri uri = Uri.parse(videoUrl);
//
//             // définit la ressource à partir du
//            // videoUrl vers la videoView
//            videoView.setVideoURI(uri);
//
//             // création de l'objet de
//            // classe de contrôleur multimédia
//            MediaController mediaController = new MediaController(this);
//
//             // définit la vue d'ancrage
//            // vue d'ancrage pour la vidéoView
//            mediaController.setAnchorView(videoView);
//
//            // définit le lecteur multimédia sur la vidéoView
//            mediaController.setMediaPlayer(videoView);
//
//            // définit le contrôleur multimédia sur la vidéoView
//            videoView.setMediaController(mediaController);
//
//            // démarre la vidéo
//            videoView.start();
        }
    }







