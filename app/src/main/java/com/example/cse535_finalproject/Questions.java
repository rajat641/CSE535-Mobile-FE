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

public class Questions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String q1answer, q2answer, q3answer, q4answer, q5answer, q6answer, q7answer = "";
    String q8answer, q9answer, q10answer, q11answer, q12answer, q13answer, q14answer = "";
    String q15answer, q16answer, q17answer, q18answer, q19answer, q20answer = "";
    private String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Intent intent = getIntent();

        // gets the user ID from the first login screen in main activity
        userid = intent.getStringExtra(MainActivity.USERNAME);

        //Q1 drop down menu spinner
        Spinner spinner1 = findViewById(R.id.q1spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        //Q2 drop down menu spinner
        Spinner spinner2 = findViewById(R.id.q2spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        //Q3 drop down menu spinner
        Spinner spinner3 = findViewById(R.id.q3spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        //Q4 drop down menu spinner
        Spinner spinner4 = findViewById(R.id.q4spinner);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(this);

        //Q5 drop down menu spinner
        Spinner spinner5 = findViewById(R.id.q5spinner);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);
        spinner5.setOnItemSelectedListener(this);

        //Q6 drop down menu spinner
        Spinner spinner6 = findViewById(R.id.q6spinner);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter6);
        spinner6.setOnItemSelectedListener(this);

        //Q7 drop down menu spinner
        Spinner spinner7 = findViewById(R.id.q7spinner);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter7);
        spinner7.setOnItemSelectedListener(this);

        //Q8 drop down menu spinner
        Spinner spinner8 = findViewById(R.id.q8spinner);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(adapter8);
        spinner8.setOnItemSelectedListener(this);

        //Q9 drop down menu spinner
        Spinner spinner9 = findViewById(R.id.q9spinner);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner9.setAdapter(adapter9);
        spinner9.setOnItemSelectedListener(this);

        //Q10 drop down menu spinner
        Spinner spinner10 = findViewById(R.id.q10spinner);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner10.setAdapter(adapter10);
        spinner10.setOnItemSelectedListener(this);

        //Q11 drop down menu spinner
        Spinner spinner11 = findViewById(R.id.q11spinner);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner11.setAdapter(adapter11);
        spinner11.setOnItemSelectedListener(this);

        //Q12 drop down menu spinner
        Spinner spinner12 = findViewById(R.id.q12spinner);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner12.setAdapter(adapter12);
        spinner12.setOnItemSelectedListener(this);

        //Q13 drop down menu spinner
        Spinner spinner13 = findViewById(R.id.q13spinner);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner13.setAdapter(adapter13);
        spinner13.setOnItemSelectedListener(this);

        //Q14 drop down menu spinner
        Spinner spinner14 = findViewById(R.id.q14spinner);
        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner14.setAdapter(adapter14);
        spinner14.setOnItemSelectedListener(this);

        //Q15 drop down menu spinner
        Spinner spinner15 = findViewById(R.id.q15spinner);
        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner15.setAdapter(adapter15);
        spinner15.setOnItemSelectedListener(this);

        //Q16 drop down menu spinner
        Spinner spinner16 = findViewById(R.id.q16spinner);
        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner16.setAdapter(adapter16);
        spinner16.setOnItemSelectedListener(this);

        //Q17 drop down menu spinner
        Spinner spinner17 = findViewById(R.id.q17spinner);
        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner17.setAdapter(adapter17);
        spinner17.setOnItemSelectedListener(this);

        //Q18 drop down menu spinner
        Spinner spinner18 = findViewById(R.id.q18spinner);
        ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner18.setAdapter(adapter18);
        spinner18.setOnItemSelectedListener(this);

        //Q19 drop down menu spinner
        Spinner spinner19 = findViewById(R.id.q19spinner);
        ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner19.setAdapter(adapter19);
        spinner19.setOnItemSelectedListener(this);

        //Q20 drop down menu spinner
        Spinner spinner20 = findViewById(R.id.q20spinner);
        ArrayAdapter<CharSequence> adapter20 = ArrayAdapter.createFromResource(this, R.array.questionChoices, android.R.layout.simple_spinner_item);
        adapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner20.setAdapter(adapter20);
        spinner20.setOnItemSelectedListener(this);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        final Button button = findViewById(R.id.qsubmitbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("button: ", "pressed");
                //save solutions to questions to database
                String URL="http://ec2-3-16-129-147.us-east-2.compute.amazonaws.com:8000/questions/QuestionsView/";

                JSONObject postparams = new JSONObject();
                try {
                    int id = Integer.parseInt(userid);
                    postparams.put("user", id);
                    postparams.put("solution1", q1answer);
                    postparams.put("solution2", q2answer);
                    postparams.put("solution3", q3answer);
                    postparams.put("solution4", q4answer);
                    postparams.put("solution5", q5answer);
                    postparams.put("solution6", q6answer);
                    postparams.put("solution7", q7answer);
                    postparams.put("solution8", q8answer);
                    postparams.put("solution9", q9answer);
                    postparams.put("solution10", q10answer);
                    postparams.put("solution11", q11answer);
                    postparams.put("solution12", q12answer);
                    postparams.put("solution13", q13answer);
                    postparams.put("solution14", q14answer);
                    postparams.put("solution15", q15answer);
                    postparams.put("solution16", q16answer);
                    postparams.put("solution17", q17answer);
                    postparams.put("solution18", q18answer);
                    postparams.put("solution19", q19answer);
                    postparams.put("solution20", q20answer);
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

//                on  in button press, go to preferences page
//                Intent intent = new Intent(MainActivity.this, Form.class);
//                intent.putExtra(USERNAME, uname);
//                startActivity(intent);
            }
        });
    }

    //function for setting text of drop down menu as selected item
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        selection =parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), selection, Toast.LENGTH_SHORT).show();
        switch (parent.getId()) {
            case R.id.q1spinner:
                q1answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q1answer, Toast.LENGTH_SHORT).show();
                Log.i("1", q1answer);
                break;
            case R.id.q2spinner:
                q2answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q2answer, Toast.LENGTH_SHORT).show();
                Log.i("2", q2answer);
                break;
            case R.id.q3spinner:
                q3answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q3answer, Toast.LENGTH_SHORT).show();
                Log.i("3", q3answer);
                break;
            case R.id.q4spinner:
                q4answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q4answer, Toast.LENGTH_SHORT).show();
                Log.i("4", q4answer);
                break;
            case R.id.q5spinner:
                q5answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q5answer, Toast.LENGTH_SHORT).show();
                Log.i("5", q5answer);
                break;
            case R.id.q6spinner:
                q6answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q6answer, Toast.LENGTH_SHORT).show();
                Log.i("6", q6answer);
                break;
            case R.id.q7spinner:
                q7answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q7answer, Toast.LENGTH_SHORT).show();
                Log.i("7", q7answer);
                break;
            case R.id.q8spinner:
                q8answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q8answer, Toast.LENGTH_SHORT).show();
                Log.i("8", q8answer);
                break;
            case R.id.q9spinner:
                q9answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q9answer, Toast.LENGTH_SHORT).show();
                Log.i("9", q9answer);
                break;
            case R.id.q10spinner:
                q10answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q10answer, Toast.LENGTH_SHORT).show();
                Log.i("10", q10answer);
                break;
            case R.id.q11spinner:
                q11answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q11answer, Toast.LENGTH_SHORT).show();
                Log.i("11", q11answer);
                break;
            case R.id.q12spinner:
                q12answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q12answer, Toast.LENGTH_SHORT).show();
                Log.i("12", q12answer);
                break;
            case R.id.q13spinner:
                q13answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q13answer, Toast.LENGTH_SHORT).show();
                Log.i("13", q13answer);
                break;
            case R.id.q14spinner:
                q14answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q14answer, Toast.LENGTH_SHORT).show();
                Log.i("14", q14answer);
                break;
            case R.id.q15spinner:
                q15answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q15answer, Toast.LENGTH_SHORT).show();
                Log.i("15", q15answer);
                break;
            case R.id.q16spinner:
                q16answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q16answer, Toast.LENGTH_SHORT).show();
                Log.i("16", q16answer);
                break;
            case R.id.q17spinner:
                q17answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q17answer, Toast.LENGTH_SHORT).show();
                Log.i("17", q17answer);
                break;
            case R.id.q18spinner:
                q18answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q18answer, Toast.LENGTH_SHORT).show();
                Log.i("18", q18answer);
                break;
            case R.id.q19spinner:
                q19answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q19answer, Toast.LENGTH_SHORT).show();
                Log.i("19", q19answer);
                break;
            case R.id.q20spinner:
                q20answer = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), q20answer, Toast.LENGTH_SHORT).show();
                Log.i("20", q20answer);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
