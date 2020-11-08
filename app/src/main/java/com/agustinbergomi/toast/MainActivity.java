package com.agustinbergomi.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //final String TAG = "Rest Response";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL="https://saposapo43.000webhostapp.com/json_object";

//instancio clase JsonObjectRequest
//paso los respectivos parametros
        JsonObjectRequest objectRequest  = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null, //parametro que se envia
        //listener (interface) => implementar sus metodos

            new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                Log.i("Response JSON",response.toString());

            }
        },
        //en caso de error:
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Response JSON",error.toString());

            }

        });

//la lista de solicitudes requiere un objeto request como parametro:
        requestQueue.add(objectRequest);

    }
}