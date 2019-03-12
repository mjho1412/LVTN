package com.example.lvtn_android.screens.login;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lvtn_android.R;
import com.example.lvtn_android.screens.main.MainActivity;
import com.example.lvtn_android.screens.password.PasswordActivity;

public class LoginActivity extends AppCompatActivity {

    LoginFragment loginFragment = new LoginFragment();
    AnonymousFragment anonymousFragment = new AnonymousFragment();

    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;

    String choice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupToMainButton();
        setupTabLayout();

    }

    void setupToMainButton(){
        Button toMain = findViewById(R.id.button2);
        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(choice.equals("2")){
                    Intent toMain = new Intent(LoginActivity.this, MainActivity.class);
                    toMain.putExtra("username","Vô Danh cháu bà Đanh");
                    startActivity(toMain);
                } else {
                    Intent toPass = new Intent(LoginActivity.this, PasswordActivity.class);
                    EditText a= findViewById(R.id.usernameTxt);
                    toPass.putExtra("username",""+a.getText().toString());
                    startActivity(toPass);
                }


            }
        });

    }

    void setupTabLayout(){
        viewPager = findViewById(R.id.mViewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.mTabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        choice="1";
                        break;
                    case 1:
                        choice="2";
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position == 0)
            {
                fragment = loginFragment;
            }
            else if (position == 1)
            {
                fragment = anonymousFragment;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = null;
            if (position == 0)
            {
                title = "Login";
            }
            else if (position == 1)
            {
                title = "Anonymous";
            }
            return title;
        }


    }
}
