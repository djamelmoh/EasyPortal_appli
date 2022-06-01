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

public class Main3_boutton extends AppCompatActivity {
//    private ImageView image;
//    private ToggleButton on;
//    private FrameLayout myLayout;
//    private boolean etat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_bouton_user);
        boolean[] success = new boolean[1];
        final Button btn_ouvrir=(Button)findViewById(R.id.ouvrir);
        String username = getIntent().getExtras().get("username").toString();
        btn_ouvrir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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
                                            Toast.makeText(Main3_boutton.this,msg, Toast.LENGTH_SHORT).show();
                                        }
                                        //Sinon
                                        else
                                        {
                                            //recupere le message de l'api
                                            String msg = jObject.getString("message");
                                            Toast.makeText(Main3_boutton.this, msg, Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(Main3_boutton.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                //permets d'executer le code dans la page
                RequestQueue requestQueue = Volley.newRequestQueue(Main3_boutton.this);
                requestQueue.add(stringRequest);
                // Fin GET
            }
        });
        //variable boutton deconnexion
        Button button_retour = (Button) findViewById(R.id.retour);
        button_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_deconnexion) {
                Intent deconnexion = new Intent(Main3_boutton.this, Main2_users.class);
                startActivity(deconnexion);
            }


        });

    }

}

