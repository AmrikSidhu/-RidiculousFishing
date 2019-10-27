package com.example.ridiculousfishing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.Random;



public class GameEngine extends SurfaceView implements Runnable
{

    // debug varable
    final static String TAG = "RIDICULOUS_FISHING";

    // SCREEN SIZE
    int screenHeight;
    int screenWidth;

    // game State
    boolean gameIsRunning;

    // THREADING
    Thread gameThread;

    // Drawing Variables

    SurfaceHolder holder;
    Canvas canvas;
    Paint paintBrush;


    public GameEngine(Context context, int w, int h) {
        super(context);

        this.holder = this.getHolder();
        this.paintBrush = new Paint();
        this.screenWidth = w;
        this.screenHeight = h;

        this.printScreenSize();
    }

    private void printScreenSize() {

            Log.d(TAG, "Screen (w, h) = " + this.screenWidth + "," + this.screenHeight);

    }
// GAME STATE FUNCTIONS
    @Override
    public void run() {
        while (gameIsRunning == true) {
            this.updatePositions();
            this.redrawSprites();
            this.setFPS();
        }

    }

    public void pauseGame()
    {
        gameIsRunning = false;
    try {
    gameThread.join();
        }
        catch (InterruptedException e)
        {

        }
    }

    public  void  startGame()
    {
        gameIsRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }



    private void setFPS() {
    }

    private void redrawSprites() {
    }

    private void updatePositions() {
    }
    
    
}
