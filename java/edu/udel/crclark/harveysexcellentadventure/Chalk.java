package edu.udel.crclark.harveysexcellentadventure;

import android.graphics.Bitmap;

public class Chalk {
    Bitmap bitmap;
    float yLocation,xLocation, xVelocity, yVelocity;
    int xDirection, yDirection, bounce;

    Chalk(Bitmap b, float xLocation, float yLocation, float xVelocity, float yVelocity, int xDirection, int yDirection){
        bitmap = Bitmap.createScaledBitmap(b, b.getWidth()*5, b.getHeight()*5, true);
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
        bounce = 0;
    }

    Chalk(Bitmap b, float xLocation, float yLocation, float xVelocity, float yVelocity){
        bitmap = Bitmap.createScaledBitmap(b, b.getWidth()*5, b.getHeight()*5, true);
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.xDirection = (xVelocity > 0 ? 1 : -1);
        this.yDirection = (yVelocity > 0 ? 1 : -1);
        bounce = 0;
    }

}