package com.example.appli;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Main8_gestion_user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity8_gestion_user);
        //declaration des variables
        EditText username;
        EditText role;
        EditText nom;
        EditText prenom;

        //mise en relation des variables avec le xml
        username = (EditText)findViewById(R.id.username);
        role = (EditText)findViewById(R.id.role);
        nom = (EditText)findViewById(R.id.nom);
        prenom = (EditText)findViewById(R.id.prenom);
        boolean[] success = new boolean[1];
        //Mise en relation bouton enregistrer
        final Button btn_enregistrer=(Button)findViewById(R.id.enregistrer);
        btn_enregistrer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Debut GET
                //copnvertir le texte en string
                String username1 = username.getText().toString();
                String role1 = role.getText().toString();
                String nom1 = nom.getText().toString();
                String prenom1 = prenom.getText().toString();
                //declaration url api
                String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/ajouterUtilisateur.php?username="+username1+"&firstname="+prenom1+"&lastname="+nom1+"&perm="+role1;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response!=null)
                                {
                                    JSONObject jObject = null;
                                    try
                                    {
                                        jObject = new JSONObject(response);
                                        //mise en relation avec l'api
                                        success[0] = jObject.getBoolean("success");
                                        //status[0] = jObject.getInt("status");
                                        System.out.println("test : "+ success[0]);

                                        if(success[0]==true)
                                        {
                                            //recupere le message de l'api
                                            String msg = jObject.getString("message");
                                            Toast.makeText(Main8_gestion_user.this,msg, Toast.LENGTH_SHORT).show();
                                        }
                                        //Sinon
                                        else
                                        {
                                            //recupere le message de l'api
                                            String msg = jObject.getString("message");
                                            Toast.makeText(Main8_gestion_user.this, msg, Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    catch (JSONException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                }
            },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Toast.makeText(Main8_gestion_user.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                //permets d'executer le code dans la page
                RequestQueue requestQueue = Volley.newRequestQueue(Main8_gestion_user.this);
                requestQueue.add(stringRequest);
                // Fin GET
            }
        });
//----------------------------------------------------------------------------------------------------------------------------------------------------------------

        EditText suppr;
        suppr = (EditText)findViewById(R.id.suppr);
        //int[] status = new int[1];
        final Button btn_supprimer=(Button)findViewById(R.id.supprimer);
        btn_supprimer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Debut GET
                String suppr1 = suppr.getText().toString();
                //declaration url api
                String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/supprimerUtilisateur.php?username="+suppr1;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response!=null)
                                {
                                    JSONObject jObject = null;
                                    try
                                    {
                                        jObject = new JSONObject(response);
                                        //mise en relation avec l'api
                                        success[0] = jObject.getBoolean("success");
                                        //status[0] = jObject.getInt("status");
                                        System.out.println("test : "+ success[0]);

                                        if(success[0]==true)
                                        {
                                            String msg = jObject.getString("message");
                                            Toast.makeText(Main8_gestion_user.this,msg, Toast.LENGTH_SHORT).show();
                                        }
                                        //Sinon
                                        else
                                        {
                                            String msg = jObject.getString("message");
                                            Toast.makeText(Main8_gestion_user.this, msg, Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    catch (JSONException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Toast.makeText(Main8_gestion_user.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                //permets d'executer le code dans la page
                RequestQueue requestQueue = Volley.newRequestQueue(Main8_gestion_user.this);
                requestQueue.add(stringRequest);
                // Fin GET
            }
        });











//--------------------------------------------------------------------------------------------------
//Barre de menue pour acceder au autre fonctionnalité de l'admin
        Button button = (Button) findViewById(R.id.portail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_portail) {
                Intent portail = new Intent(Main8_gestion_user.this, Main7_boutton_admin.class);
                Toast.makeText(Main8_gestion_user.this, "Ouverture du portail.", Toast.LENGTH_SHORT).show();
                startActivity(portail);
            }
        });

        Button button_video = (Button) findViewById(R.id.Image);
        button_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_video) {
                Intent video = new Intent(Main8_gestion_user.this, Main5_video.class);
                startActivity(video);
            }
        });


        Button button_accueil = (Button) findViewById(R.id.retour);
        button_accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_accueil) {
                Intent accueil = new Intent(Main8_gestion_user.this, Main4_accueil.class);
                startActivity(accueil);
            }
        });

        Button button_log = (Button) findViewById(R.id.log);
        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_log) {
                Intent log = new Intent(Main8_gestion_user.this, Main6_log.class);
                startActivity(log);
            }
        });
//--------------------------------------------------------------------------------------------------
    }
}