package com.sdproject.sogand.hackathon;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.toolbox.JsonObjectRequest;

public class MainActivity extends AppCompatActivity {
    public static String loguser;
    static int x = 0;

    Button login, register;

    private static EditText username;
    private static EditText password;
    String URL = Config.BASE_URL + "/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.login_btn);
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        register = (Button) findViewById(R.id.reg_btn);

        register.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent register = new Intent(v.getContext(), Register.class);
                                            startActivity(register);
                                        }
                                    }

        );


        login.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {


                                         JSONArray jsonArray = new JSONArray();
                                         JSONObject jsonObject = new JSONObject();
                                         try {

                                             jsonObject.put("username", username.getText());
                                             String value = password.getText().toString();
                                             int password2 = Integer.parseInt(value);
                                             jsonObject.put("password", password2);
                                             jsonArray.put(jsonObject);


                                         } catch (Exception e) {

                                         }
                                         send(jsonObject);
                                     }

            public void send(JSONObject jsonObject){

                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST, URL, jsonObject,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                Toast.makeText(MainActivity.this, "Logged in!", Toast.LENGTH_LONG).show();
                                System.out.println(response);
                                Intent profile = new Intent(MainActivity.this, home.class);
                                startActivity(profile);

                            }


                        },
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, "Login failed-> "+error, Toast.LENGTH_LONG).show();;

                            }

                        }
                );

                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                requestQueue.add(request);
            }



        });

                                     }
                                 }






