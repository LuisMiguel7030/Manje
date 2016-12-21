package com.example.manjeinc.manje;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;




public class MainActivity extends Activity {



    TextView manje, email, password, sign, log;
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manje = (TextView)findViewById(R.id.manje);
        email = (TextView)findViewById(R.id.textEmail);
        password = (TextView)findViewById(R.id.textPassword);
        sign = (TextView)findViewById(R.id.buttonSign);
        log = (TextView)findViewById(R.id.buttonLog);

        String font_path = "font/Roboto-Black.ttf";

        Typeface TF = Typeface.createFromAsset(getAssets(),font_path);
        manje.setTypeface(TF);
        email.setTypeface(TF);
        password.setTypeface(TF);
        sign.setTypeface(TF);
        log.setTypeface(TF);

        final Conexion conexion = new Conexion(this);
        button = (Button) findViewById(R.id.buttonSign);
        editText = (EditText)findViewById(R.id.email);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(conexion.Datos());
            }
        });


    }




}
