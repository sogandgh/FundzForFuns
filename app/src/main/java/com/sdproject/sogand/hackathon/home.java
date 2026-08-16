package com.sdproject.sogand.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ImageView;

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

public class home extends AppCompatActivity {

    ImageView img;
    Button fun;
    String URL = Config.BASE_URL + "/post/login";
    int remaining;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        img = findViewById(R.id.cupcake); // in your onCreate
        fun = (Button)findViewById(R.id.fun);
        int percent =0;
        if (profile.org!= 0) {
//             percent = math.
        }


System.out.print("THE PERCENT IS" + percent);


        switch(MainActivity.x){

            case 1 :

                img.setImageResource(R.drawable.cupcake2);


            break;

            case 2:

                img.setImageResource(R.drawable.cupcake3);

                break;

            case 3 :

                img.setImageResource(R.drawable.cupcake4);

                break;


            case 4:

                img.setImageResource(R.drawable.cupcake5);

                break;


            case 5 :

                img.setImageResource(R.drawable.cupcake6);

                break;


            case 6:

                img.setImageResource(R.drawable.cupcake7);

                break;


            case 7 :

                img.setImageResource(R.drawable.cupcake8);

                break;


            case 8 :

                img.setImageResource(R.drawable.cupcake9);

                break;

            case 9 :

                img.setImageResource(R.drawable.cupcake10);

                break;

          default:

                img.setImageResource(R.drawable.cupcake1);

                break;

        }
        MainActivity.x++;


        fun.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent register = new Intent(v.getContext(), fun.class);
                                            startActivity(register);
                                        }
                                    }

        );
    }


}
