package com.example.lvtn_android.screens.name;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lvtn_android.Global;
import com.example.lvtn_android.R;
import com.example.lvtn_android.screens.main.MainActivity;
import com.example.lvtn_android.screens.password.PasswordActivity;
import com.example.lvtn_android.screens.theme.ThemeChooseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class NameActivity extends AppCompatActivity {

    ImageView toPass;
    Boolean isNameNotRegisted;
    EditText nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nameText = findViewById(R.id.nameText);
        toPass = findViewById(R.id.toPass);
        toPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.mSocket.emit("check_name", nameText.getText());

                Intent intent = new Intent(NameActivity.this, PasswordActivity.class);
//                intent.putExtra("name",nameText.getText());
//                intent.putExtra("isNameNotRegistered",isNameNotRegisted);
                startActivity(intent);

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String data) {
        isNameNotRegisted = data.equals("success");

        Intent intent = new Intent(NameActivity.this, PasswordActivity.class);
        intent.putExtra("name",nameText.getText());
        intent.putExtra("isNameNotRegistered",isNameNotRegisted);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
