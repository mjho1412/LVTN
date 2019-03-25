package com.example.lvtn_android.screens.theme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lvtn_android.R;
import com.example.lvtn_android.screens.lesson.LessonActivity;

import java.util.ArrayList;

public class ThemeChooseActivity extends AppCompatActivity implements ThemeChooseAdapter.ItemClickListener {
    RecyclerView mRecy;
    ThemeChooseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_choose);

        setupRecy();
    }

    void setupRecy(){
        ArrayList<String> themeList = new ArrayList<>();
        themeList.add("Horse");
        themeList.add("Cow");
        themeList.add("Camel");
        themeList.add("Sheep");
        themeList.add("Goat");
        themeList.add("Camel");
        themeList.add("Sheep");
        themeList.add("Goat");

        mRecy = findViewById(R.id.mRecy);

        mRecy.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new ThemeChooseAdapter(this, themeList);
        adapter.setClickListener(this);
        mRecy.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        if(position == 0) {
            Intent intent = new Intent(this, LessonActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
