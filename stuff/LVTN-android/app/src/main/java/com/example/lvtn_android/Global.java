package com.example.lvtn_android;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;


import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class Global extends Application {

    public static Socket mSocket;
    {
//        try {
//            mSocket = IO.socket("http://172.20.10.9:3000");
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }

        try {
//            mSocket = IO.socket("http://172.20.10.9:3003");
            mSocket = IO.socket("http://172.28.241.55:3003");
            mSocket.connect();
            mSocket.emit("join", "Android device");
        } catch (URISyntaxException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

//        Log.i("here?","hreeee");
//        mSocket.connect();
    }
}
