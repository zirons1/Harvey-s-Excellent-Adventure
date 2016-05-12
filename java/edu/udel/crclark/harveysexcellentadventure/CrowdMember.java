package edu.udel.crclark.harveysexcellentadventure;

import android.graphics.Bitmap;

public class CrowdMember {
    Bitmap bitmap;
    float yLocation,xLocation;

    CrowdMember(Bitmap b, float xLocation){
        bitmap = Bitmap.createScaledBitmap(b, b.getWidth()*3, b.getHeight()*3, true);
        this.xLocation = xLocation;
        yLocation = 0;
    }
}
