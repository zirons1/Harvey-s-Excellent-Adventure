package edu.udel.crclark.harveysexcellentadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    TextView t;
    int score;
    Intent i, i2;
    Bundle extras;
    String newScore, retryGame;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        i = getIntent();
        extras = i.getExtras();
        if (extras != null){
            score = extras.getInt("Score");
            retryGame = extras.getString("Game");
            newScore = Integer.toString(score);

            t = (TextView) findViewById(R.id.textView);
            if (newScore != null && t != null)
                t.setText(newScore);
        }

        b1 = (Button) findViewById(R.id.button5);
        b2 = (Button) findViewById(R.id.button6);
    }
    @Override
    protected void onResume(){
        super.onResume();
    }

    public void onClickRetry(View v){
        switch (retryGame) {
            case "Episode 1":
                i2 = new Intent(this, Ep1MainActivity.class);
                break;
            case "Episode 2":
                i2 = new Intent(this, Ep2MainActivity.class);
                break;
            case "Episode 3":
                i2 = new Intent(this, Ep3MainActivity.class);
                break;
        }
        startActivity(i2);
    }
    public void onClickMainMenu(View v){
        i2 = new Intent(this, MainMenu.class);
        startActivity(i2);
    }
}
