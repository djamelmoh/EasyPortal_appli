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

    EditText mail;
    EditText password;
    Button btn;
    int id;
    String name;
    String info;
    String reponse1;
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_page_user);

        mail = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.mdp);
        final boolean[] success = new boolean[1];
        final int[] status = new int[1];

        final Button button=(Button)findViewById(R.id.valider1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Debut GET
                String email = mail.getText().toString();
                String mdp = password.getText().toString();
                String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/connexion.php?username="+email+"&password="+mdp;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                if(response!=null){
                                    JSONObject jObject = null;
                                    try {
                                        jObject = new JSONObject(response);
                                        success[0] = jObject.getBoolean("success");
                                        status[0] = jObject.getInt("status");
                                        System.out.println("test : "+ success[0]);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }

                                if(success[0]==true)
                                {

                                    if(status[0]==2)
                                    {
                                        Intent redirection= new Intent(Main2_users.this, Main7_accueil.class);
                                        startActivity(redirection);
                                    }
                                    else if(status[0]==1)
                                    {
                                        Intent redirection1= new Intent(Main2_users.this, Main3_boutton.class);
                                        startActivity(redirection1);
                                    }
                                    }

                                else
                                {
                                    Toast.makeText(Main2_users.this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                                }
                                Toast.makeText(Main2_users.this, url.toString(), Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Main2_users.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });

                RequestQueue requestQueue = Volley.newRequestQueue(Main2_users.this);
                requestQueue.add(stringRequest);

                // Fin GET
            }
        });
    }
}