package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.telecom.Call;
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

import java.util.HashMap;
import java.util.Map;

public class Main1_admins extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button btn;
    String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_page_admin);

        mail = (EditText)findViewById(R.id.mail);
        password = (EditText)findViewById(R.id.password);

        final Button button=(Button)findViewById(R.id.valider1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Debut de la requete GET
                String email = mail.getText().toString();    //creation d'un variable mail
                String mdp = password.getText().toString();  //creation d'un variable mdp
//creation d'un variable url
                String url ="https://f802cccc-d0d4-4a92-a4a7-9d99442afcff.mock.pstmn.io/utilisateurs?firstname=%3Cstring%3E&lastname=%3Cstring%3E&perm=%3Cstring%3E&plates=%3Carray/string%3E" +email+"&password="+mdp;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(Main1_admins.this, response.trim(), Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Main1_admins.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });

                RequestQueue requestQueue = Volley.newRequestQueue(Main1_admins.this);
                requestQueue.add(stringRequest);

                // Fin de la requete GET



                Intent launchactivity= new Intent(Main1_admins.this, Main7_accueil.class);
                startActivity(launchactivity);


                Button button_valider=(Button)findViewById(R.id.valider1);
       button_valider.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View w)
           {
               Intent vereturnr= new Intent(Main1_admins.this, Main2_users.class);
               startActivity(vereturnr);
           }


        });
//    }

            }
        });
    }
}
























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
