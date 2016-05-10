package edu.udel.crclark.harveysexcellentadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ep1MainActivity extends AppCompatActivity {
    Intent i;
    Button br, bl;
    edu.udel.crclark.harveysexcellentadventure.Ep1AnimationView am;
    float xPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ep1_main);
        //setContentView(new AnimationView(this));
        am = (edu.udel.crclark.harveysexcellentadventure.Ep1AnimationView) findViewById(R.id.view);
        br = (Button) findViewById(R.id.button2);
        bl = (Button) findViewById(R.id.button);
    }
    public void gotoCredits(View v){
        i = new Intent(this, Credits.class);
    }
    public void gotoGameOver(View v){
        i = new Intent(this, GameOver.class);
    }
    public void onClickRight(View v){
        xPosition = am.getxPosition();
        if (xPosition < 750)
            am.setxPosition(xPosition + 250);
    }
    public void onClickLeft(View v){
        xPosition = am.getxPosition();
        if (xPosition > 250)
            am.setxPosition(xPosition - 250);
    }
}
