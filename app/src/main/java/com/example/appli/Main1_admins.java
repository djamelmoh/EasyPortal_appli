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

public class Main1_admins extends AppCompatActivity {

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
        setContentView(R.layout.activity2_page_admin);

        mail = (EditText)findViewById(R.id.mail);
        password = (EditText)findViewById(R.id.password);
        final boolean[] succes = new boolean[1];
        final int[] perm = new int[1];

        final Button button=(Button)findViewById(R.id.valider1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Debut GET
                String mail1 = mail.getText().toString();
                String password1 = password.getText().toString();
                String url = "http://51.210.151.13/btssnir/projets2022/easyportal/api/utilisateurs.php?username="+mail1+"&password="+password1;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response != null)
                                {
                                    JSONObject jObject = null;
                                    try
                                    {
                                        jObject = new JSONObject(response);
                                        succes[0] = jObject.getBoolean("succes");
                                        perm[0] = jObject.getInt("perm");
                                        System.out.println("test : " + succes[0]);
                                    }
                                    catch (JSONException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                                if (succes[0] == true)
                                {
                                    if (perm[0] == 1)
                                    {
                                        Intent launchactivity = new Intent(Main1_admins.this, Main6_log.class);
                                    }
                                    else
                                    {
                                        Toast.makeText(Main1_admins.this, "pas ok", Toast.LENGTH_SHORT).show();
                                    }
                                    Toast.makeText(Main1_admins.this, url.toString(), Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(Main1_admins.this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                                }
                            } },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Main1_admins.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });

                RequestQueue requestQueue = Volley.newRequestQueue(Main1_admins.this);
                requestQueue.add(stringRequest);

                // Fin GET
            }
        });
    }
}



//
//import androidx.appcompat.app.AppCompatActivity;
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Bundle;
//import android.telecom.Call;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Main1_admins extends AppCompatActivity {
//
//    EditText mail;
//    EditText password;
//    Button btn;
//    String info;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity2_page_admin);
//
//        mail = (EditText)findViewById(R.id.mail);
//        password = (EditText)findViewById(R.id.password);
//
//        final Button button=(Button)findViewById(R.id.valider1);
//        button.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                // Debut de la requete GET
//                String email = mail.getText().toString();    //creation d'un variable mail
//                String mdp = password.getText().toString();  //creation d'un variable mdp
//                //creation d'un variable url
//                // String url ="https://0d5987d2-70b7-4a7d-a8bd-6ee8c8d649dc.mock.pstmn.io/ajouterUtilisateur?username=djamelmoh&firstName=Djamel&lastName=Mohamedi&perm=admin<string>" +email+"&password="+mdp;
//                String url ="http://51.210.151.13/btssnir/projets2022/easyportal/api/utilisateurs.php" ;
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Toast.makeText(Main1_admins.this, response.trim(), Toast.LENGTH_SHORT).show();
//                    }
//                },
//                        new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                Toast.makeText(Main1_admins.this, error.toString(), Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//                RequestQueue requestQueue = Volley.newRequestQueue(Main1_admins.this);
//                requestQueue.add(stringRequest);
//
//                // Fin de la requete GET
//
//
//
////                Intent launchactivity= new Intent(Main1_admins.this, Main7_accueil.class);
////                startActivity(launchactivity);
//
//
////                Button button_valider=(Button)findViewById(R.id.users);
////       button_valider.setOnClickListener(new View.OnClickListener()
////        {
////            @Override
////            public void onClick(View w)
////           {
////               Intent vereturnr= new Intent(Main1_admins.this, Main2_users.class);
////               startActivity(vereturnr);
////           }
////
////
////        });
//
//
//            }
//        });
//    }
//}
























//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//public class Main1_admins extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity2_page_admin);
//
//        Button button_users = (Button) findViewById(R.id.user);
//        button_users.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent users = new Intent(Main1_admins.this, Main2_users.class);
//                startActivity(users);
//            }
//
//
//        });
////        Button t = (Button) findViewById(R.id.valider1);
////        t.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View w) {
////                Intent users = new Intent(Main1_admins.this, Main4_boutton_admin.class);
////                startActivity(users);
////            }
////
////
////        });
//       Button button_valider=(Button)findViewById(R.id.valider1);
//       button_valider.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View w)
//           {
//               Intent ver= new Intent(Main1_admins.this, Main7_accueil.class);
//               startActivity(ver);
//           }
//
//
//        });
//    }
//}
//
