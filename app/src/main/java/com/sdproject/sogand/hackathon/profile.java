package com.sdproject.sogand.hackathon;

import android.widget.Button;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

public class profile extends AppCompatActivity {

    public static int funmoney;
    public static int org;
    Button submit;
    EditText income, expense, saving;
    String URL = Config.BASE_URL + "/expenses";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        submit = (Button) findViewById(R.id.incexp_btn);
        income = (EditText) findViewById(R.id.inc);
        expense = (EditText) findViewById(R.id.exp);
        saving = (EditText) findViewById(R.id.sav);

        submit.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(final View v) {


                                       JSONArray jsonArray = new JSONArray();
                                       JSONObject jsonObject = new JSONObject();

                                       try {

                                           String value = saving.getText().toString();
                                           int password = Integer.parseInt(value);


                                           String value2 = income.getText().toString();
                                           int password2 = Integer.parseInt(value);


                                           String value3 = expense.getText().toString();
                                           int password3 = Integer.parseInt(value);

                                           org = password2 - (password + password3);

                                           jsonObject.put("username", MainActivity.loguser);

                                           jsonObject.put("income", password2);
                                           jsonObject.put("saving", password);

                                           jsonObject.put("expense", password3);
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

                            Toast.makeText(profile.this, "Create Account Successful", Toast.LENGTH_LONG).show();
                            System.out.println(response);

                            Intent intent = new Intent(profile.this, fun.class);
                            startActivity(intent);

                        }


                    },
                    new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(profile.this, "Some error occurred -> "+error, Toast.LENGTH_LONG).show();;
                            Intent intent = new Intent(profile.this, fun.class);
                            startActivity(intent);
                        }

                    }
            );

            RequestQueue requestQueue = Volley.newRequestQueue(profile.this);
            requestQueue.add(request);
        }






                                  }
        );
    }




}