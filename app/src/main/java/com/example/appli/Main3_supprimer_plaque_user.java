package com.example.appli;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class Main3_supprimer_plaque_user extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_page_user_supprimer);
        //Page d'accueil pour acceder au autre fonctionnalité de l'admin
        EditText plaque_imma;
        plaque_imma = (EditText)findViewById(R.id.suppr_plaque);
        boolean[] success = new boolean[1];
        final Button btn_supprimer=(Button)findViewById(R.id.supprimer_plaque_1);
       btn_supprimer.setOnClickListener(new View.OnClickListener()
        {
            @Override
           public void onClick(View v)
           {
//                 Debut GET
                String plaque_imma_suppr = plaque_imma.getText().toString();
                //declaration url api
               String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/supprimerPlaque.php?platenumber="+plaque_imma_suppr;
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
                                            Toast.makeText(Main3_supprimer_plaque_user.this,msg, Toast.LENGTH_SHORT).show();
                                        }
                                        //Sinon
                                        else
                                        {
                                            String msg = jObject.getString("message");
                                           Toast.makeText(Main3_supprimer_plaque_user.this, msg, Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(Main3_supprimer_plaque_user.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                //permets d'executer le code dans la page
                RequestQueue requestQueue = Volley.newRequestQueue(Main3_supprimer_plaque_user.this);
                requestQueue.add(stringRequest);
                // Fin GET
            }
        });

    }
 }