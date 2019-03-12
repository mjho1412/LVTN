package com.example.lvtn_android.screens.password;

public interface PasswordInterface {
    interface View{
        void showServerReponse();

    }

    interface Presenter{
        void sendUsername();

        void sendAccount();

    }
}
