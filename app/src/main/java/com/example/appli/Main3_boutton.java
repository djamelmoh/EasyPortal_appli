package com.example.appli;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;
import android.os.Bundle;
import android.widget.FrameLayout;

public class Main3_boutton extends AppCompatActivity {
    private ImageView image;
    private ToggleButton on;
    private FrameLayout myLayout;
    private boolean etat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_bouton_user);

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
        Button button_retour = (Button) findViewById(R.id.retour);
        button_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retour = new Intent(Main3_boutton.this, Main2_users.class);
                startActivity(retour);
            }


        });

    }

}
