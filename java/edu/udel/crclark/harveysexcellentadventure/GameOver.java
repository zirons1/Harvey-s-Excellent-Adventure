package edu.udel.crclark.harveysexcellentadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    TextView t;
    int score;
    Intent i;
    Bundle extras;
    String newScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        i = getIntent();
        extras = i.getExtras();
        if (extras != null){
            score = extras.getInt("Score");
            newScore = Integer.toString(score);

            t = (TextView) findViewById(R.id.textView);
            if (newScore != null && t != null)
                t.setText(newScore);
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
}
