package com.example.appli;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Main7_boutton_admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_bouton_admin);
        boolean[] success = new boolean[1];
        final Button btn_ouvrir=(Button)findViewById(R.id.ouvrir);
//        String username = getIntent().getExtras().get("admin").toString();
        btn_ouvrir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String username="admin";
                // Debut GET
                //copnvertir le texte en string
                //declaration url api
                String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/open.php?username="+username;
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
                                            Toast.makeText(Main7_boutton_admin.this,msg, Toast.LENGTH_SHORT).show();
                                        }
                                        //Sinon
                                        else
                                        {
                                            //recupere le message de l'api
                                            String msg = jObject.getString("message");
                                            Toast.makeText(Main7_boutton_admin.this, msg, Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(Main7_boutton_admin.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                //permets d'executer le code dans la page
                RequestQueue requestQueue = Volley.newRequestQueue(Main7_boutton_admin.this);
                requestQueue.add(stringRequest);
                // Fin GET
            }
        });
        //variable boutton deconnexion
        Button button_retour = (Button) findViewById(R.id.retour);
        button_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_deconnexion) {
                Intent deconnexion = new Intent(Main7_boutton_admin.this, Main1_connexion.class);
                startActivity(deconnexion);
            }


        });
//--------------------------------------------------------------------------------------------------
//Barre de menue pour acceder au autre fonctionnalité de l'admin
        Button button_video = (Button) findViewById(R.id.Image);
        button_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_video) {
                Intent video = new Intent(Main7_boutton_admin.this, Main5_video.class);
                startActivity(video);
            }
        });
        Button button_user = (Button) findViewById(R.id.users);
        button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_user) {
                Intent user = new Intent(Main7_boutton_admin.this, Main8_gestion_user.class);
                startActivity(user);
            }
        });
        Button button_log = (Button) findViewById(R.id.log);
        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_log) {
                Intent log = new Intent(Main7_boutton_admin.this, Main6_log.class);
                startActivity(log);
            }
        });
        Button button_accueil = (Button) findViewById(R.id.retour);
        button_accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_accueil) {
                Intent accueil = new Intent(Main7_boutton_admin.this, Main4_accueil.class);
                startActivity(accueil);
            }

        });
//--------------------------------------------------------------------------------------------------
    }
}