package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class Main2_users extends AppCompatActivity {
    private EditText email;
    private EditText mdp;
    private Button valider1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_page_user);





//---------------------------------------------------------------------------------------------------
//cette partie du code sert à aller de la page user à admin
                Button button_admin=(Button)findViewById(R.id.admin);
        button_admin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent admin= new Intent(Main2_users.this, Main1_admins.class);
                startActivity(admin);
            }
        });
//---------------------------------------------------------------------------------------------------
        Button button_valider=(Button)findViewById(R.id.valider1);
        button_valider.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View w)
            {

            }


        });

//-------------------------------------------------------------------------------------------------------------------
        email = findViewById(R.id.email);
        mdp = findViewById(R.id.mdp);
        valider1 = findViewById(R.id.valider1);
        valider1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().length() >0 && mdp.getText().length() > 0) {
                    Intent valider = new Intent(Main2_users.this, Main3_boutton.class);
                    startActivity(valider);

                    if (email.getText().toString().equals("admin") && mdp.getText().toString().equals("12345")) {
                        Intent valider1 = new Intent(Main2_users.this, Main7_accueil.class);
                        startActivity(valider1);
                    }
                }
                else if (email.getText().length() ==0 && mdp.getText().length() > 0) {
                    String toastMessage = "L'identifiant n'est pas entré ";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }

                else if (email.getText().length() >0 && mdp.getText().length() == 0) {
                    String toastMessage = "Le mot de passe n'est pas entré ";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }

                else {
                    String toastMessage = "L'identifiant et le mot de passe ne sont pas entrés ";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}


