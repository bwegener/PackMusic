package edu.orangecoastcollege.cs273.bwegener.packmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The <code>SplashActivity</code> displays the album
 * artwork and loads the videos so the user
 * can access them.
 *
 * @author Brian Wegener
 * @version 1.0
 *
 * Created on 10/25/2017
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * The onCreate loads the splash screen
     * which delays the <code>MusicActivity</code>
     * from beginning.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();

                Intent musicIntent = new Intent(SplashActivity.this, MusicActivity.class);

                startActivity(musicIntent);
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }
}
