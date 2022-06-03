package com.example.appli;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main2_page_users extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_page_user);
        //Page d'accueil pour acceder au autre fonctionnalité de l'admin

        //variable boutton deconnexion
        Button button_retour = (Button) findViewById(R.id.retour);
        button_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_deconnexion) {
                Intent deconnexion = new Intent(Main2_page_users.this, Main1_connexion.class);
                startActivity(deconnexion);
            }


        });
        //variable boutton deconnexion
        Button button_supprimer_plaque = (Button) findViewById(R.id.supprimer_plaque);
        button_supprimer_plaque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button_supprimer) {
                Intent supprimer = new Intent(Main2_page_users.this, Main3_page_supprimer_user.class);
                startActivity(supprimer);
            }


        });
//----------------------------------------------------------------------------------------
      //Ouvrir portail
        boolean[] success = new boolean[1];
        final Button btn_ouvrir = (Button) findViewById(R.id.ouvrir);
        String username = getIntent().getExtras().get("username").toString();
        btn_ouvrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Debut GET
                //copnvertir le texte en string
                //declaration url api
                String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/open.php?username=" + username;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response != null) {
                                    JSONObject jObject = null;
                                    try {
                                        jObject = new JSONObject(response);
                                        //mise en relation avec l'api
                                        success[0] = jObject.getBoolean("success");
                                        //status[0] = jObject.getInt("status");
                                        System.out.println("test : " + success[0]);
                                        if (success[0] == true) {
                                            //recupere le message de l'api
                                            String msg = jObject.getString("message");
                                            Toast.makeText(Main2_page_users.this, msg, Toast.LENGTH_SHORT).show();
                                        }
                                        //Sinon
                                        else {
                                            //recupere le message de l'api
                                            String msg = jObject.getString("message");
                                            Toast.makeText(Main2_page_users.this, msg, Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Main2_page_users.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                //permets d'executer le code dans la page
                RequestQueue requestQueue = Volley.newRequestQueue(Main2_page_users.this);
                requestQueue.add(stringRequest);
                // Fin GET
            }
        });

//-----------------------------------------------------------------------------------------------------------------------------------------------
      //AJoutrer Plaque
        EditText plaque;

        //mise en relation des variables avec le xml
        plaque = (EditText) findViewById(R.id.plaque);

        //Mise en relation bouton enregistrer
        final Button btn_ajouter = (Button) findViewById(R.id.ajouter);
        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Debut GET
                //copnvertir le texte en string
                String plaque1 = plaque.getText().toString();
                //declaration url api
                String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/ajouterPlaque.php?owner=" + username + "&platenumber=" + plaque1;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response != null) {
                                    JSONObject jObject = null;
                                    try {
                                        jObject = new JSONObject(response);
                                        //mise en relation avec l'api
                                        success[0] = jObject.getBoolean("success");
                                        //status[0] = jObject.getInt("status");
                                        System.out.println("test : " + success[0]);

                                        if (success[0] == true) {
                                            //recupere le message de l'api
                                            String msg = jObject.getString("message");
                                            Toast.makeText(Main2_page_users.this, msg, Toast.LENGTH_SHORT).show();
                                        }
                                        //Sinon
                                        else {
                                            //recupere le message de l'api
                                            String msg = jObject.getString("message");
                                            Toast.makeText(Main2_page_users.this, msg, Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Main2_page_users.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                //permets d'executer le code dans la page
                RequestQueue requestQueue = Volley.newRequestQueue(Main2_page_users.this);
                requestQueue.add(stringRequest);
                // Fin GET
            }
        });

//-------------------------------------------------------------------------------------------------------------------
     //Voir les plaques

        TextView logText = (TextView) findViewById(R.id.info);
        String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/plaques.php?owner="+username;
        Toast.makeText(Main2_page_users.this, url, Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {
                            JSONObject jObject = null;
                            try {
                                jObject = new JSONObject(response);
                                //mise en relation avec l'api
                                success[0] = jObject.getBoolean("success");
                                JSONArray rslt = new JSONArray(jObject.getString("result"));
                                String temp= "MES PLAQUES :\n ";
                                String nbr ="";
                                //Toast.makeText(Main3_page_users.this, nbr.valueOf(rslt.length()), Toast.LENGTH_SHORT).show();
                                for(int i=0;i<=rslt.length()-1;i++){
                                    JSONArray plaque = new JSONArray(rslt.getString(i));
                                    temp += plaque.getString(0)+"\n";
                                }
                                logText.setText(temp);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(Main2_page_users.this, "message", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(Main2_page_users.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(Main2_page_users.this);
        requestQueue.add(stringRequest);

    }
}

//---------------------------------------------------------------------------------------------------------------------

