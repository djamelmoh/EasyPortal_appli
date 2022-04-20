package com.example.appli;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
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

        //declartration pour le swith case
        on.setOnClickListener((v) -> {
            //si faux (si on clique pas dessus, l'image du xml reste la même)
            if (etat == false) {

                image.setImageResource(R.drawable.led_on);
                on.setBackgroundResource(R.drawable.toggle_off);
                for(int j=5; j>0;j--){
                    String toastMessage = "Le portail s'ouvre. Temps d'attente "+j+" secondes ";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();


                    etat = true;
                }}


            //si vrai (si on clique pas dessus, l'image change)
            else if (etat == true) {

                image.setImageResource(R.drawable.led_off);
                on.setBackgroundResource(R.drawable.toggle_on);
                for (int j = 5; j > 0; j--) {
                    String toastMessage = "Le portail se ferme. Temps d'attente " + j + " secondes ";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();


                    etat = true;
                }

            }

        });

        //variable boutton deconnexion
        Button button_retour = (Button) findViewById(R.id.retour);
        button_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deconnexion = new Intent(Main3_boutton.this, Main2_users.class);
                startActivity(deconnexion);
            }


        });

    }

}
