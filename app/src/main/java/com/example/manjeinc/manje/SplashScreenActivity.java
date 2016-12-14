package com.example.manjeinc.manje;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;



/**
 * Created by MANJE INC on 12/8/2016.
 */

public class SplashScreenActivity extends Activity{

    //configurar el timpo del splash
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.splash_screen);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // comenzar la nueva actividad
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                // Cerramos la actividad para que el usuario no pueda volver atras
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);



    }


}
