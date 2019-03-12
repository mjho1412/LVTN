package com.example.lvtn_android.screens.lesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.lvtn_android.R;

public class LessonActivity extends AppCompatActivity {

//    private float x1,x2;
//    static final int MIN_DISTANCE = 150;

//    FrameLayout mFrame;
    RelativeLayout mRela;
    int counter=1;
    ViewStub mStub;
    ViewStub mStub2;
    ViewStub mStub3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        mStub = findViewById(R.id.layout_stub);
        mStub2 = findViewById(R.id.layout_stub2);
        mStub3 = findViewById(R.id.layout_stub3);
//        mFrame = findViewById(R.id.mFrame);
        mRela = findViewById(R.id.mRela);

        mStub.setLayoutResource(R.layout.fragment_lesson_1);
        View inflated = mStub.inflate();

        mStub2.setLayoutResource(R.layout.fragment_lesson_2);
        View inflated2 = mStub2.inflate();

        mStub3.setLayoutResource(R.layout.fragment_lesson_3);
        View inflated3 = mStub3.inflate();

        mStub2.setVisibility(View.GONE);
        mStub3.setVisibility(View.GONE);

        mRela.setOnTouchListener(new OnSwipeTouchListener(LessonActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(LessonActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                counter++;
                if(counter>3)counter=3;
                switch (counter){
                    case 1:
                        mStub.setVisibility(View.VISIBLE);
                        mStub2.setVisibility(View.GONE);
                        mStub3.setVisibility(View.GONE);
                        break;
                    case 2:
                        mStub.setVisibility(View.GONE);
                        mStub2.setVisibility(View.VISIBLE);
                        mStub3.setVisibility(View.GONE);
                        break;
                    case 3:
                        mStub.setVisibility(View.GONE);
                        mStub2.setVisibility(View.GONE);
                        mStub3.setVisibility(View.VISIBLE);
                        break;
                }
            }
            public void onSwipeLeft() {
                counter--;
                if(counter<1)counter=1;
                switch (counter){
                    case 1:
                        mStub.setVisibility(View.VISIBLE);
                        mStub2.setVisibility(View.GONE);
                        mStub3.setVisibility(View.GONE);
                        break;
                    case 2:
                        mStub.setVisibility(View.GONE);
                        mStub2.setVisibility(View.VISIBLE);
                        mStub3.setVisibility(View.GONE);
                        break;
                    case 3:
                        mStub.setVisibility(View.GONE);
                        mStub2.setVisibility(View.GONE);
                        mStub3.setVisibility(View.VISIBLE);
                        break;
                }
            }
            public void onSwipeBottom() {
                Toast.makeText(LessonActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });

        findViewById(R.id.arrowBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                if(counter<1)counter=1;
                switch (counter){
                    case 1:
                        mStub.setVisibility(View.VISIBLE);
                        mStub2.setVisibility(View.GONE);
                        mStub3.setVisibility(View.GONE);
                        break;
                    case 2:
                        mStub.setVisibility(View.GONE);
                        mStub2.setVisibility(View.VISIBLE);
                        mStub3.setVisibility(View.GONE);
                        break;
                    case 3:
                        mStub.setVisibility(View.GONE);
                        mStub2.setVisibility(View.GONE);
                        mStub3.setVisibility(View.VISIBLE);
                        break;
                }

            }
        });

        findViewById(R.id.arrowForward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if(counter>3)counter=3;
                switch (counter){
                    case 1:
                        mStub.setVisibility(View.VISIBLE);
                        mStub2.setVisibility(View.GONE);
                        mStub3.setVisibility(View.GONE);
                        break;
                    case 2:
                        mStub.setVisibility(View.GONE);
                        mStub2.setVisibility(View.VISIBLE);
                        mStub3.setVisibility(View.GONE);
                        break;
                    case 3:
                        mStub.setVisibility(View.GONE);
                        mStub2.setVisibility(View.GONE);
                        mStub3.setVisibility(View.VISIBLE);
                        break;
                }

            }
        });

    }

    private void replaceSensors(View oldSensor, View newSensor) {
        ViewGroup parent = (ViewGroup) oldSensor.getParent();

        if (parent == null) {
            return;
        }

        int indexOldSensor = parent.indexOfChild(oldSensor);
        int indexNewSensor = parent.indexOfChild(newSensor);
        parent.removeView(oldSensor);
        parent.addView(oldSensor, indexNewSensor);
        parent.removeView(newSensor);
        parent.addView(newSensor, indexOldSensor);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event)
//    {
//        switch(event.getAction())
//        {
//            case MotionEvent.ACTION_DOWN:
//                x1 = event.getX();
//                break;
//            case MotionEvent.ACTION_UP:
//                x2 = event.getX();
//                float deltaX = x2 - x1;
//                if (Math.abs(deltaX) > MIN_DISTANCE)
//                {
//                    Toast.makeText(this, "left2right swipe", Toast.LENGTH_SHORT).show ();
//                }
//                else
//                {
//                    // consider as something else - a screen tap for example
//                }
//                break;
//        }
//        return super.onTouchEvent(event);
//    }
}
