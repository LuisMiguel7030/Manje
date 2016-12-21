package com.example.manjeinc.manje;

// se referencian las clases para la conexion db

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

// Json librerias

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by luismiguel on 12/20/16.
 */

public class Conexion {

    private RequestQueue requestQueue;

    private static final String URL_BASE = "http://www.manje.info/manjeconnect/get_data.php";
    String editText;


    public Conexion(Context context) {


        // Crear nueva cola de peticiones
        requestQueue= Volley.newRequestQueue(context);

        // Nueva petición JSONObject
        JsonObjectRequest request = new JsonObjectRequest(URL_BASE, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Procesar JSONObject
                editText = response.toString();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Procesar VolleyError
                if (error instanceof AuthFailureError){
                    Log.e("VOLLEY", "Se ha producido un fallo con las credenciales. " + error.getMessage() );
                } else if (error instanceof NetworkError) {
                    Log.e("VOLLEY", "Se ha producido un fallo fallo en la red. "+ error.getMessage());
                }

            }
        });

        requestQueue.add(request);

    }

    public String Datos(){
        return editText;
    }


}
