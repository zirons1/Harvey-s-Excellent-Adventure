package edu.udel.crclark.harveysexcellentadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Episode1Menu extends AppCompatActivity {
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode1_menu);
    }
    public void gotoEp1MainActivityDunkin(View v){
        i = new Intent(this, Ep1MainActivity.class);
        i.putExtra("colorScheme", "Dunkin Donuts");
        startActivity(i);
    }
    public void gotoEp1MainActivityStarbucks(View v){
        i = new Intent(this, Ep1MainActivity.class);
        i.putExtra("colorScheme", "Starbucks");
        startActivity(i);
    }
}
