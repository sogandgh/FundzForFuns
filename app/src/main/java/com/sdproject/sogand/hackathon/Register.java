package com.sdproject.sogand.hackathon;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import com.android.volley.toolbox.JsonObjectRequest;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText name, user, pass;
    Button registerButton;

    String URL = Config.BASE_URL + "/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        name = (EditText)findViewById(R.id.name);
        user = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);

        registerButton = (Button)findViewById(R.id.reg_btn);

        registerButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(final View v) {
                                                  JSONArray jsonArray = new JSONArray();
                                                  JSONObject jsonObject = new JSONObject();

                                                  try {

                                                      jsonObject.put("username", user.getText());
                                                      jsonObject.put("name", name.getText());
                                                      String value = pass.getText().toString();
                                                        int password = Integer.parseInt(value);
                                                      jsonObject.put("password", password);
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

                                                                  Toast.makeText(Register.this, "Create Account Successful", Toast.LENGTH_LONG).show();
                                                                System.out.println(response);

                                                                  Intent intent = new Intent(Register.this, profile.class);
                                                                  startActivity(intent);

                                                             }


                                                          },
                                                          new Response.ErrorListener() {

                                                              @Override
                                                              public void onErrorResponse(VolleyError error) {
                                                                  Toast.makeText(Register.this, "Some error occurred -> "+error, Toast.LENGTH_LONG).show();;

                                                              }

                                                          }
                                                          );

                                                  RequestQueue requestQueue = Volley.newRequestQueue(Register.this);
                                                  requestQueue.add(request);
                                              }






                                          }
        );
    }




}
