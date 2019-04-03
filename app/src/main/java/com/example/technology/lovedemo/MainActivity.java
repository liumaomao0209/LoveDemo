package com.example.technology.lovedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private GestureDetector myGestureDetector;
    private Love ll_love;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_love = (Love) findViewById(R.id.lovelayout);
        ImageView iamge = findViewById(R.id.iamge);
        //实例化GestureDetector
        myGestureDetector = new GestureDetector(this, new myOnGestureListener());
        //增加监听事件

        iamge.setOnTouchListener(new View.OnTouchListener() {

            @Override//可以捕获触摸屏幕发生的Event事件
            public boolean onTouch(View v, MotionEvent event) {
                //使用GestureDetector转发MotionEvent对象给OnGestureListener
                myGestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }
    class myOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            ll_love.addLoveView(e.getRawX(),e.getRawY());
            return super.onDoubleTap(e);
        }
    }

}

