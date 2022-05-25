package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main6_log extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity6_log);

        String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/logs.php";
        Toast.makeText(Main6_log.this, url, Toast.LENGTH_SHORT).show();

//--------------------------------------------------------------------------------------------------
//Barre de menue pour acceder au autre fonctionnalité de l'admin

        Button button_portail = (Button) findViewById(R.id.portail);
        button_portail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View btn_portail)
            {
                Intent portail = new Intent(Main6_log.this, Main4_boutton_admin.class);
                startActivity(portail);
            }
        });

        Button button_video = (Button) findViewById(R.id.image2);
        button_video.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View btn_video)
            {
                Intent video = new Intent(Main6_log.this, Main5_video.class);
                startActivity(video);
            }
        });


        Button button_user = (Button) findViewById(R.id.users);
        button_user.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View btn_user)
            {
                Intent user = new Intent(Main6_log.this, Main8_gestion_user.class);
                startActivity(user);
            }
        });

        Button button_accueil = (Button) findViewById(R.id.retour);
        button_accueil.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View btn_accueil)
            {
                Intent accueil = new Intent(Main6_log.this, Main7_accueil.class);
                startActivity(accueil);
            }
        });
    }
}