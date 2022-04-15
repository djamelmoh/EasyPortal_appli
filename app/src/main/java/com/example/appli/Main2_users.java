package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class Main2_users extends AppCompatActivity {
    //declaration variable
    private EditText email;
    private EditText mdp;
    private Button valider1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_page_user);//page xml





//---------------------------------------------------------------------------------------------------
//cette partie du code sert à aller de la page user à admin
                Button button_admin=(Button)findViewById(R.id.admin);
        button_admin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //redirection de la page 2 à la 1
                //admin est un bouton
                Intent admin= new Intent(Main2_users.this, Main1_admins.class);
                startActivity(admin);
            }
        });
//---------------------------------------------------------------------------------------------------
//        Button button_valider=(Button)findViewById(R.id.valider1);
//        button_valider.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View w)
//            {
//
//            }
//
//
//        });

//-------------------------------------------------------------------------------------------------------------------
//code pour la securité en local
        email = findViewById(R.id.email);
        mdp = findViewById(R.id.mdp);
        valider1 = findViewById(R.id.valider1);
        valider1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //si la lignes email et mots ont des caracteres alors:
                if (email.getText().length() >0 && mdp.getText().length() > 0) {
                  
                    //redirection vers de la page 2 à 3
                    Intent valider = new Intent(Main2_users.this, Main3_boutton.class);
                    startActivity(valider);

                    //si email=admin et mdp=12345
                    if (email.getText().toString().equals("admin") && mdp.getText().toString().equals("12345")) {
                        //redirection vers de la page 2 à 7
                        Intent valider1 = new Intent(Main2_users.this, Main7_accueil.class);
                        startActivity(valider1);
                    }
                }

                //s'il n'y a pas d'identifiant
                else if (email.getText().length() ==0 && mdp.getText().length() > 0) {
                    //alors il affiche le message suivant
                    String toastMessage = "L'identifiant n'est pas entré ";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }

                //s'il n'y a pas de mdp
                else if (email.getText().length() >0 && mdp.getText().length() == 0) {
                    //alors le message suivant est affiché
                    String toastMessage = "Le mot de passe n'est pas entré ";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }

                //s'il n'y a pas de mdp+identifiant
                else {
                    //alors le message suivant est affiché
                    String toastMessage = "L'identifiant et le mot de passe ne sont pas entrés ";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}


