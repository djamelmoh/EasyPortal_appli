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

public class Main9_voir_user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //lien avec la page layout
        setContentView(R.layout.activity9_voir_user);


        Button button_voir_user = (Button) findViewById(R.id.retour_gestion);
        button_voir_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View voir_user) {
                Intent voir_user1 = new Intent(Main9_voir_user.this, Main8_gestion_user.class);
                startActivity(voir_user1);
            }
        });

//--------------------------------------------------------------------
        TextView user_info1 = (TextView) findViewById(R.id.user_info);
        boolean[] success = new boolean[1];


        String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/utilisateurs.php";
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
                               // JSONObject rslt = new JSONObject(jObject.getString("result"));
                                JSONArray rslt = new JSONArray(jObject.getString("result"));
                                String temp = "";
                                for (int i = 0; i <= rslt.length() - 1; i++) {
                                    JSONObject user = new JSONObject(rslt.getString(i));
                                    temp +=  "Username: " + user.getString("username")+ " | "+ "Nom: " + user.getString("lastname")+ " | "+ "Prenom: " + user.getString("firstname")+ "\n";
                                                                }
                                user_info1.setText(temp);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(Main9_voir_user.this, "message", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Main9_voir_user.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(Main9_voir_user.this);
        requestQueue.add(stringRequest);
    }
}