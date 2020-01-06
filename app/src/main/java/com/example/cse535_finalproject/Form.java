package com.example.cse535_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Form extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String statsSelection, linalgSelection, discreteSelection, calculusSelection = "";
    private String user;
    public static final String USERNAME_Q = "";
    private String userid;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Intent intent = getIntent();

        // gets the user ID from the first login screen in main activity
        user = intent.getStringExtra(MainActivity.USERNAME);

        try {
            JSONObject jObject = new JSONObject(user);
            Log.i("JOBJECT::: ", "" + jObject);
            userid = jObject.getString("id");
            Log.i("USERIDDD::: ", "" + userid);

        } catch (JSONException e) {
            Log.e("MYAPP", "unexpected JSON exception", e);
        }

        //statistics drop down menu spinner
        Spinner spinner1 = findViewById(R.id.statsSpinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.spinnerChoice, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        //lin alg drop down menu spinner
        Spinner spinner2 = findViewById(R.id.linalgSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spinnerChoice, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        //discrete drop down menu spinner
        Spinner spinner3 = findViewById(R.id.discreteSpinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.spinnerChoice, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        //calculus drop down menu spinner
        Spinner spinner4 = findViewById(R.id.calculusSpinner);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.spinnerChoice, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(this);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        final Button button = findViewById(R.id.submitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save preferences to database
                String URL="http://ec2-3-16-129-147.us-east-2.compute.amazonaws.com:8000/preferences/pref_save/";

                JSONObject postparams = new JSONObject();
                try {
                    id = Integer.parseInt(userid);
                    postparams.put("userid", id);
                    postparams.put("topic1", statsSelection);
                    postparams.put("topic2", linalgSelection);
                    postparams.put("topic3", discreteSelection);
                    postparams.put("topic4", calculusSelection);
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
                                Log.e("Rest Response", response.toString());
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

                //on comfortability preferences button press, go to questions page
                Intent intent = new Intent(Form.this, Questions.class);
                intent.putExtra(USERNAME_Q, userid);
                startActivity(intent);
            }
        });


    }

    //function for setting text of drop down menu as selected item
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        selection =parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), selection, Toast.LENGTH_SHORT).show();
        switch (parent.getId()) {
            case R.id.statsSpinner:
                statsSelection = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), statsSelection, Toast.LENGTH_SHORT).show();
                Log.i("statistics", statsSelection);
                break;
            case R.id.linalgSpinner:
                linalgSelection = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), linalgSelection, Toast.LENGTH_SHORT).show();
                Log.i("lin alg", linalgSelection);
                break;
            case R.id.discreteSpinner:
                discreteSelection = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), discreteSelection, Toast.LENGTH_SHORT).show();
                Log.i("discrete math", discreteSelection);
                break;
            case R.id.calculusSpinner:
                calculusSelection = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), calculusSelection, Toast.LENGTH_SHORT).show();
                Log.i("calculus", calculusSelection);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
