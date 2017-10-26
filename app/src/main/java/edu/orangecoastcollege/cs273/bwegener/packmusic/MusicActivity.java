package edu.orangecoastcollege.cs273.bwegener.packmusic;

import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * The <code>MusicActivity</code> allows the user
 * to choose from three videos by clicking buttons
 * associated with each video.
 *
 * @author Brian Wegener
 * @version 1.0
 *
 * Created on 10/25/2017
 */
public class MusicActivity extends AppCompatActivity {

    Button coalButton;
    Button fourSeasonsButton;
    Button whiteThronesButton;

    VideoView coalView;
    VideoView fourSeasonsView;
    VideoView whiteThronesView;

    /**
     * This connects the buttons and the videos
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        coalButton = (Button) findViewById(R.id.coalButton);
        fourSeasonsButton = (Button) findViewById(R.id.fourSeasonsButton);
        whiteThronesButton = (Button) findViewById(R.id.whiteThronesButton);

        coalView = (VideoView) findViewById(R.id.coalView);
        fourSeasonsView = (VideoView) findViewById(R.id.fourSeasonsView);
        whiteThronesView = (VideoView) findViewById(R.id.whiteThronesView);

        String coalUri = "android.resource://" + getPackageName() + "/" + R.raw.coal;
        String fourSeasonsUri = "android.resource://" + getPackageName() + "/" + R.raw.four_seasons;
        String whiteThronesUri = "android.resource://" + getPackageName() + "/" + R.raw.white_thrones;

        coalView.setVideoURI(Uri.parse(coalUri));
        fourSeasonsView.setVideoURI(Uri.parse(fourSeasonsUri));
        whiteThronesView.setVideoURI(Uri.parse(whiteThronesUri));

        coalView.setMediaController(new MediaController(this));
        fourSeasonsView.setMediaController(new MediaController(this));
        whiteThronesView.setMediaController(new MediaController(this));
    }

    /**
     * This acts as the onClick and allows the user to
     * choose a video to play
     * @param v
     */
    public void playMedia(View v)
    {
        switch(v.getId()) {
            case R.id.coalButton:
                if (coalView.isPlaying()) {
                    coalView.pause();
                    coalButton.setText(R.string.coal_button_watch_text);
                    fourSeasonsButton.setVisibility(View.VISIBLE);
                    whiteThronesButton.setVisibility(View.VISIBLE);
                } else {
                    coalView.start();
                    coalButton.setText(R.string.coal_button_pause_text);
                    fourSeasonsButton.setVisibility(View.INVISIBLE);
                    whiteThronesButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.fourSeasonsButton:
                if (fourSeasonsView.isPlaying()) {
                    fourSeasonsView.pause();
                    fourSeasonsButton.setText(R.string.four_seasons_button_watch_text);
                    coalButton.setVisibility(View.VISIBLE);
                    whiteThronesButton.setVisibility(View.VISIBLE);
                } else {
                    fourSeasonsView.start();
                    fourSeasonsButton.setText(R.string.four_seasons_button_pause_text);
                    coalButton.setVisibility(View.INVISIBLE);
                    whiteThronesButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.whiteThronesButton:
                if (whiteThronesView.isPlaying()) {
                    whiteThronesView.pause();
                    whiteThronesButton.setText(R.string.white_thrones_button_watch_text);
                    coalButton.setVisibility(View.VISIBLE);
                    fourSeasonsButton.setVisibility(View.VISIBLE);
                } else {
                    whiteThronesView.start();
                    whiteThronesButton.setText(R.string.white_thrones_button_pause_text);
                    coalButton.setVisibility(View.INVISIBLE);
                    fourSeasonsButton.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }
}
