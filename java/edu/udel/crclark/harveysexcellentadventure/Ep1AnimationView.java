package edu.udel.crclark.harveysexcellentadventure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Ep1AnimationView extends View{
    int width;
    int height;
    private float xLoc = 0;
    private float yLoc = 0;
    private boolean first_time;

    final int FRAME_RATE = 30;
    final int TIME_PER_FRAME = 1000/FRAME_RATE;
    private float acceleration;
    private long lastDrawTime;
    private long total_elapsed;
    private float yVelocity;
    private float xVelocity;
    private int direction_factor;
    final int MAX_HEIGHT = 1000; // the height of my model world (not same as screen)
    final int MIN_HEIGHT = 0;
    final int MAX_WIDTH = 1000;
    final int MIN_WIDTH = 0;
    private float yPosition; //position in my model world
    private float xPosition;
    private float height_scale; //how to convert from model to screen
    private float width_scale;
    private int circleRadius;

    Bitmap bm,b;

    public Ep1AnimationView(Context context){
        super(context);

    }
    public Ep1AnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Ep1AnimationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        xLoc = 0;
        yLoc = 0;
        first_time = true;

        acceleration = .15F;
        lastDrawTime = 0;
        total_elapsed = 0;
        yVelocity = 0.000F; //should start at zero when dropped
        xVelocity = 0.000F;
        direction_factor = 1;
    }

    private void initialize(){
        lastDrawTime = System.currentTimeMillis();
        first_time = false;
        float scale = width < height ? width : height;
        circleRadius = (int) scale/10;
        height_scale = ((float)height - circleRadius) / MAX_HEIGHT;
        //width_scale = ((float)width - circleRadius) / MAX_WIDTH;
        width_scale = (float) width / MAX_WIDTH;
        xLoc = width/2;
        yPosition = (int)(.85 * MAX_HEIGHT);
        xPosition = (int)(.5 * MAX_WIDTH);
    }

    @Override
    /**
     *  You may only use the variables given here. Do not make new variables or methods.
     */
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (first_time)
            initialize();

        long elapsed = System.currentTimeMillis() - lastDrawTime;

        if (elapsed > TIME_PER_FRAME){

            System.out.println("xPOS: " + xPosition + " yPOS: " + yPosition + " TOTAL_ELAPSED: " + total_elapsed);
            lastDrawTime = System.currentTimeMillis();
        }
        yLoc = height_scale * yPosition;
        xLoc = width_scale * xPosition;
        drawHarvey(canvas);
        //drawCircle(canvas);
        this.invalidate();

    }
    private void drawHarvey(Canvas canvas){
        bm = BitmapFactory.decodeResource(getResources(), R.drawable.harvey);
        b = Bitmap.createScaledBitmap(bm, bm.getWidth()*3, bm.getHeight()*3, true);
        Paint harveyPaint = new Paint();
        canvas.drawBitmap(b, xLoc - (b.getWidth()/2), yLoc, harveyPaint);
    }

    private void drawCircle(Canvas canvas) {
        Paint circlePaint = new Paint();
        circlePaint.setColor(Color.CYAN);
        circlePaint.setStrokeWidth(4);
        circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        circlePaint.setAntiAlias(true);

        canvas.drawCircle(xLoc, yLoc, circleRadius, circlePaint);
    }

//    private void drawCircle(Canvas canvas) {
//        Paint circlePaint = new Paint();
//        circlePaint.setColor(Color.CYAN);
//        circlePaint.setStrokeWidth(4);
//        circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        circlePaint.setAntiAlias(true);
//
//        canvas.drawCircle(xLoc, yLoc, circleRadius, circlePaint);
//    }


    /**
     * This method is called by the Android platform when the app window size changes.
     * We store the initial setting of these so that we can compute the exact locations
     * to draw the components of our View.
     */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;
        height = h;
    }
    public float getxVelocity(){
        return xVelocity;
    }
    public void setxVelocity(float f){
        xVelocity = f;
    }
    public float getxPosition(){
        return xPosition;
    }
    public void setxPosition(float f) {
        xPosition = f;
    }
}
