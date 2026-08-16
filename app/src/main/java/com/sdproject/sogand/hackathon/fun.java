package com.sdproject.sogand.hackathon;

import android.widget.ImageButton;

import android.widget.Button;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class fun extends AppCompatActivity {


    ImageButton food;
    ImageButton event;
    ImageButton movie;
    ImageButton subscription;
    ImageButton clothes;
    ImageButton others;
    EditText amount;
    String URL = Config.BASE_URL + "/post/login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.fun);
        food = (ImageButton) findViewById(R.id.food);
        event = (ImageButton) findViewById(R.id.event);
        movie = (ImageButton) findViewById(R.id.movie);
        subscription = (ImageButton) findViewById(R.id.subscription);
        clothes = (ImageButton) findViewById(R.id.clothes);
        others = (ImageButton) findViewById(R.id.others);
        amount = (EditText) findViewById(R.id.amount);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();

                try {


                    jsonObject.put("username",MainActivity.loguser);
                    String value = amount.getText().toString();
                    int am = Integer.parseInt(value);
                    jsonObject.put("EatOut", am);
                    profile.funmoney = profile.funmoney + am;

                    jsonArray.put(jsonObject);


                } catch (Exception e) {

                }

                send(jsonObject);
                Intent intent = new Intent(fun.this, home.class);
                startActivity(intent);


            }
            public void send(JSONObject jsonObject){

                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST, URL, jsonObject,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                Toast.makeText(fun.this, "Create Account Successful", Toast.LENGTH_LONG).show();
                                System.out.println(response);

                            }


                        },
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(fun.this, "Some error occurred -> "+error, Toast.LENGTH_LONG).show();;

                            }

                        }
                );

                RequestQueue requestQueue = Volley.newRequestQueue(fun.this);
                requestQueue.add(request);
            }

        });

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();

                try {


                    jsonObject.put("username",MainActivity.loguser);
                    String value = amount.getText().toString();
                    int am = Integer.parseInt(value);
                    jsonObject.put("events", am);
                    profile.funmoney = profile.funmoney + am;

                    jsonArray.put(jsonObject);


                } catch (Exception e) {

                }

                send(jsonObject);
                Intent intent = new Intent(fun.this, home.class);
                startActivity(intent);

            }
            public void send(JSONObject jsonObject){

                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST, URL, jsonObject,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                Toast.makeText(fun.this, "Create Account Successful", Toast.LENGTH_LONG).show();
                                System.out.println(response);

                            }


                        },
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(fun.this, "Some error occurred -> "+error, Toast.LENGTH_LONG).show();;

                            }

                        }
                );

                RequestQueue requestQueue = Volley.newRequestQueue(fun.this);
                requestQueue.add(request);
            }

        });
        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();

                try {


                    jsonObject.put("username",MainActivity.loguser);
                    String value = amount.getText().toString();
                    int am = Integer.parseInt(value);
                    jsonObject.put("movies", am);
                    profile.funmoney = profile.funmoney + am;

                    jsonArray.put(jsonObject);


                } catch (Exception e) {

                }

                send(jsonObject);

                Intent intent = new Intent(fun.this, home.class);
                startActivity(intent);

            }
            public void send(JSONObject jsonObject){

                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST, URL, jsonObject,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                Toast.makeText(fun.this, "Create Account Successful", Toast.LENGTH_LONG).show();
                                System.out.println(response);

                            }


                        },
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(fun.this, "Some error occurred -> "+error, Toast.LENGTH_LONG).show();;

                            }

                        }
                );

                RequestQueue requestQueue = Volley.newRequestQueue(fun.this);
                requestQueue.add(request);
            }

        });
        subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();

                try {


                    jsonObject.put("username",MainActivity.loguser);
                    String value = amount.getText().toString();
                    int am = Integer.parseInt(value);
                    jsonObject.put("Subscriptions", am);
                    profile.funmoney = profile.funmoney + am;
                    jsonArray.put(jsonObject);


                } catch (Exception e) {

                }

                send(jsonObject);

                Intent intent = new Intent(fun.this, home.class);
                startActivity(intent);
            }
            public void send(JSONObject jsonObject){

                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST, URL, jsonObject,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                Toast.makeText(fun.this, "Create Account Successful", Toast.LENGTH_LONG).show();
                                System.out.println(response);

                            }


                        },
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(fun.this, "Some error occurred -> "+error, Toast.LENGTH_LONG).show();;

                            }

                        }
                );

                RequestQueue requestQueue = Volley.newRequestQueue(fun.this);
                requestQueue.add(request);
            }

        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();

                try {


                    jsonObject.put("username",MainActivity.loguser);
                    String value = amount.getText().toString();
                    int am = Integer.parseInt(value);
                    jsonObject.put("others", am);
                    profile.funmoney = profile.funmoney + am;

                    jsonArray.put(jsonObject);


                } catch (Exception e) {

                }

                send(jsonObject);
                Intent intent = new Intent(fun.this, home.class);
                startActivity(intent);

            }
            public void send(JSONObject jsonObject){

                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST, URL, jsonObject,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                Toast.makeText(fun.this, "Create Account Successful", Toast.LENGTH_LONG).show();
                                System.out.println(response);

                            }


                        },
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(fun.this, "Some error occurred -> "+error, Toast.LENGTH_LONG).show();;

                            }

                        }
                );

                RequestQueue requestQueue = Volley.newRequestQueue(fun.this);
                requestQueue.add(request);
            }

        });
        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();

                try {


                    jsonObject.put("username", MainActivity.loguser);
                    String value = amount.getText().toString();
                    int am = Integer.parseInt(value);
                    jsonObject.put("others", am);
                    profile.funmoney = profile.funmoney + am;

                    jsonArray.put(jsonObject);


                } catch (Exception e) {

                }

                send(jsonObject);
                Intent intent = new Intent(fun.this, home.class);
                startActivity(intent);

            }
            public void send(JSONObject jsonObject){

                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST, URL, jsonObject,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                Toast.makeText(fun.this, "Create Account Successful", Toast.LENGTH_LONG).show();
                                System.out.println(response);

                            }


                        },
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(fun.this, "Some error occurred -> "+error, Toast.LENGTH_LONG).show();;

                            }

                        }
                );

                RequestQueue requestQueue = Volley.newRequestQueue(fun.this);
                requestQueue.add(request);
            }


        });



    }

}