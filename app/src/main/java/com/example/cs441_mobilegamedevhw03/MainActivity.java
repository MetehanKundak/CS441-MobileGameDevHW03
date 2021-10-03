package com.example.cs441_mobilegamedevhw03;




import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ImageView image;
    private ViewGroup main;
    private int xDelta;
    private int yDelta;
    //@SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);
        main = (RelativeLayout) findViewById(R.id.Main);

        image.setOnTouchListener(onTouchListener());



    }



   // @SuppressLint("ClickableViewAccessibility")
    private OnTouchListener onTouchListener() {
        return (view, event) -> {
            final int x = (int) event.getRawX();
            final int y = (int) event.getRawY();

            switch (event.getAction() & MotionEvent.ACTION_MASK){
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    xDelta = x - Params.leftMargin;
                    yDelta = y - Params.topMargin;
                    break;

                case MotionEvent.ACTION_UP:
                    Toast.makeText(MainActivity.this, "I am here", Toast.LENGTH_SHORT).show();
                    break;



                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin = x - xDelta;
                    layoutParams.rightMargin = 0;
                    layoutParams.topMargin = y - yDelta;
                    layoutParams.bottomMargin = 0;
                    view.setLayoutParams(layoutParams);
                    break;




            }
            main.invalidate();
            return true;
        };
    }
}