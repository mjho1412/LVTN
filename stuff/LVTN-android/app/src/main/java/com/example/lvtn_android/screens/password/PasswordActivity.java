package com.example.lvtn_android.screens.password;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;

import com.example.lvtn_android.R;
import com.example.lvtn_android.data.PasswordSample;
import com.example.lvtn_android.screens.theme.ThemeChooseActivity;
import com.example.lvtn_android.screens.theme.ThemeChooseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasswordActivity extends AppCompatActivity implements PasswordInterface.View, PasswordAdapter.ItemClickListener{
    Button mBtn ;
    RecyclerView mRecy;
    PasswordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        mBtn = findViewById(R.id.button);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this, ThemeChooseActivity.class);
                startActivity(intent);
            }
        });

        setupRecy();

    }

    void setupRecy(){
        ArrayList<String> themeList = new ArrayList<>();
        themeList.add("Horse");
        themeList.add("Cow");
        themeList.add("Camel");
        themeList.add("Sheep");
        themeList.add("Goat");

        mRecy = findViewById(R.id.mListView);

        mRecy.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new PasswordAdapter(this, themeList);
        adapter.setClickListener(this);
        mRecy.setAdapter(adapter);
    }


    @Override
    public void showServerReponse() {

    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
