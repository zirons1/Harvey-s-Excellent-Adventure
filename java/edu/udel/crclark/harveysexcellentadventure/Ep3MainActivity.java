package edu.udel.crclark.harveysexcellentadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ep3MainActivity extends AppCompatActivity {
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ep3_main);
    }
    public void gotoCredits(View v){
        i = new Intent(this, Credits.class);
    }
    public void gotoGameOver(View v){
        i = new Intent(this, GameOver.class);
    }
}
