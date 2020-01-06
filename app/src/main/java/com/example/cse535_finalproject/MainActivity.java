package com.example.cse535_finalproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button login;
    public static final String USERNAME = "";
    String uname, pword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Sample Code for Login Screen//
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        login.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
//                if(Objects.equals(username.getText().toString(), "admin")&&Objects.equals(password.getText().toString(),"admin"))
//                {
//                    Toast.makeText(MainActivity.this,"You have Authenticated Successfully",Toast.LENGTH_LONG).show();
//                }else
//                {
//                    Toast.makeText(MainActivity.this,"Authentication Failed",Toast.LENGTH_LONG).show();
//                }
//
                uname = username.getText().toString();
                pword = password.getText().toString();

                String URL="http://ec2-3-16-129-147.us-east-2.compute.amazonaws.com:8000/authen/login/";

                JSONObject postparams = new JSONObject();
                try {
                    postparams.put("username", uname);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    postparams.put("password", pword);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest objectRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        URL,
                        postparams,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                //on log in button press, go to preferences page
                                Intent intent = new Intent(MainActivity.this, Form.class);
                                intent.putExtra(USERNAME, response.toString());
                                startActivity(intent);

                                //Log.e("Rest Response", response.toString());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("Rest Response", error.toString());
                            }
                        }
                );
                requestQueue.add(objectRequest);




            }
        });

    }
}
