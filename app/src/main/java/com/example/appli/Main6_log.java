package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class Main6_log extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //lien avec la page layout
        setContentView(R.layout.activity6_log);
        TextView logText = (TextView)findViewById(R.id.log_info);
        boolean[] success = new boolean[1];


        String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/logs.php";
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
                                //informations json on les reconnais grace à l'acolade
                                JSONObject rslt = new JSONObject(jObject.getString("result"));
                                //tableau donc "results "
                                JSONArray logs = new JSONArray(rslt.getString("results"));
                                String temp= "";
                                for(int i=0;i<=rslt.getInt("count")-1;i++){
                                    JSONObject log = new JSONObject(logs.getString(i));
                                    temp += log.getString("date") + " : " + log.getString("user") + " a ouvert le portail avec le site \n";
                                }
                                logText.setText(temp);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(Main6_log.this, "erreur", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(Main6_log.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
              RequestQueue requestQueue = Volley.newRequestQueue(Main6_log.this);
              requestQueue.add(stringRequest);


//--------------------------------------------------------------------------------------------------
//Barre de menue pour acceder au autre fonctionnalité de l'admin

        Button button_portail = (Button) findViewById(R.id.portail);
        button_portail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View btn_portail)
            {
                Intent portail = new Intent(Main6_log.this, Main7_boutton_admin.class);
                startActivity(portail);
            }
        });

        Button button_video = (Button) findViewById(R.id.image2);
        button_video.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View btn_video)
            {
                Intent video = new Intent(Main6_log.this, Main5_video.class);
                startActivity(video);
            }
        });


        Button button_user = (Button) findViewById(R.id.users);
        button_user.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View btn_user)
            {
                Intent user = new Intent(Main6_log.this, Main8_gestion_user.class);
                startActivity(user);
            }
        });

        Button button_accueil = (Button) findViewById(R.id.retour);
        button_accueil.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View btn_accueil)
            {
                Intent accueil = new Intent(Main6_log.this, Main4_accueil.class);
                startActivity(accueil);
            }
        });
    }
}