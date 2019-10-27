package com.example.ridiculousfishing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class MainActivity extends AppCompatActivity {
    GameEngine ridiculousFishing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // getting size of the screen
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        //game Engine object

        ridiculousFishing = new GameEngine(this, size.x, size.y);

        // setting GameEngine as view of the activity

        setContentView(ridiculousFishing);
        //setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ridiculousFishing.startGame();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ridiculousFishing.pauseGame();
    }
}
