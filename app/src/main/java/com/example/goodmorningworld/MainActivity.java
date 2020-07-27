package com.example.goodmorningworld;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hsalf.smilerating.SmileRating;
import com.hsalf.smileyrating.SmileyRating;

public class MainActivity extends AppCompatActivity {
MediaPlayer mySong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Adding audio to onclick of button*/
        mySong=MediaPlayer.create(MainActivity.this,R.raw.audio);

        /*Step 3:complete void playIT button*/
        /*Adding audio to onclick of button end*/

        ///////////////////////////////////////////////////////////////////////////////////
        /*Adding smiley rating bar start*/
     SmileRating smileRating=(SmileRating) findViewById(R.id.smile_rating);
     smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
         @Override
         public void onSmileySelected(int smiley, boolean reselected) {
             switch (smiley) {
                 case SmileRating.BAD:
                     Toast.makeText(MainActivity.this, "BAD", Toast.LENGTH_SHORT).show();
                     break;
                 case SmileRating.GOOD:
                     Toast.makeText(MainActivity.this, "GOOD", Toast.LENGTH_SHORT).show();
                     break;
                 case SmileRating.GREAT:
                     Toast.makeText(MainActivity.this, "GREAT", Toast.LENGTH_SHORT).show();
                     break;
                 case SmileRating.OKAY:
                     Toast.makeText(MainActivity.this, "OKAY", Toast.LENGTH_SHORT).show();
                     break;
                 case SmileRating.TERRIBLE:
                     Toast.makeText(MainActivity.this, "TERRIBLE", Toast.LENGTH_SHORT).show();
                     break;
             }
         }
     });
     smileRating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
         @Override
         public void onRatingSelected(int level, boolean reselected) {
             Toast.makeText(MainActivity.this, "Selected rating "+level, Toast.LENGTH_SHORT).show();
         }
     });

         
    }
    /*Adding smiley rating bar end */

     public void playIT(View v){
        mySong.start();

     }

     /* Create on pause method to stop the audio*/

    @Override
    protected void onPause() {
        super.onPause();
        mySong.release();
    }
}
