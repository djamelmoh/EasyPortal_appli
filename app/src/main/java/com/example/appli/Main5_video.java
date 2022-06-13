package com.example.appli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Main5_video extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //lien avec la page layout
        setContentView(R.layout.activity5_video_admin);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://172.16.250.251:8081/");
//      myWebView.loadUrl("http://91.81.88.254/");



//--------------------------------------------------------------------------------------------------
        //Barre de menue pour acceder au autre fonctionnalité de l'admin
        Button button_user = (Button) findViewById(R.id.users);
        button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_user) {
                Intent user = new Intent(Main5_video.this, Main8_gestion_user.class);
                startActivity(user);
            }
        });

        Button button_log = (Button) findViewById(R.id.log);
        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_log) {
                Intent log = new Intent(Main5_video.this, Main6_log.class);
                startActivity(log);
            }
        });

        Button button_accueil = (Button) findViewById(R.id.retour);
        button_accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_accueil) {
                Intent accueil = new Intent(Main5_video.this, Main4_accueil.class);
                startActivity(accueil);
            }
        });

        Button button_portail = (Button) findViewById(R.id.portail);
        button_portail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_portail) {
                Intent portail = new Intent(Main5_video.this, Main7_boutton_admin.class);
                startActivity(portail);
            }
        });
    }
}







