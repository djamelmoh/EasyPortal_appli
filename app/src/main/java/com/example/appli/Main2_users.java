package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import java.io.Serializable;
import java.lang.reflect.Type;

import android.content.Intent;
import android.os.Bundle;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Main2_users extends AppCompatActivity {
    //declaration des variables
    EditText mail;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_page_user);
//mise en relation des variable avec le nom des boutton du xml
        mail = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.mdp);
        boolean[] success = new boolean[1];
        int[] status = new int[1];
        final Button button=(Button)findViewById(R.id.valider1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Debut GET
                String username = mail.getText().toString();
                String mdp = password.getText().toString();
                //declaration url api
                String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/connexion.php?username="+username+"&password="+mdp;
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
                                        status[0] = jObject.getInt("status");
                                        System.out.println("test : "+ success[0]);
                                    }
                                    catch (JSONException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                                //si l'utilisateur est reconnue alors:
                                if(success[0]==true)
                                {
                                    if(status[0]==2)
                                    {
                                        //redirection ver le Main_7 pour l'admin
                                        Intent redirection= new Intent(Main2_users.this, Main7_accueil.class);
                                        startActivity(redirection);
                                    }
                                    else if(status[0]==1)
                                    {
                                        //redirection ver le Main_3 pour l'utilisateur
                                        Intent redirection1= new Intent(Main2_users.this, Main1_page_user.class);
                                        redirection1.putExtra("username",username);
                                        startActivity(redirection1);

                                    }
                                }
                                //Si mdp ou identifiant son mauvais alors affiche messager suivant
                                else
                                {
                                    Toast.makeText(Main2_users.this, "L'utilisateur ou le mot de passe n'est pas reconnu dans la base de donnée.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Toast.makeText(Main2_users.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                //permets d'executer le code dans la page
                RequestQueue requestQueue = Volley.newRequestQueue(Main2_users.this);
                requestQueue.add(stringRequest);
                // Fin GET
            }
        });
    }
}