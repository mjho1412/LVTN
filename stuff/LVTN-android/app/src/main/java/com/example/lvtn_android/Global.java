package com.example.lvtn_android;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;


import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

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
//            mSocket = IO.socket("http://172.28.241.55:3003");
            mSocket = IO.socket("http://192.168.1.9:3005");
            mSocket.connect();
//            mSocket.emit("join", "Android device");
        } catch (URISyntaxException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mSocket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i("Socket.io", ">>>>>>>>> The socket is now connected <<<<<<<<<<");
            }
        })
                .on("response", messageHandler)
//                .on("MKT_INFO", messageHandler)
//                .on("NTF_MSG", messageHandler)
//                .on("SYS_MSG", messageHandler)
//                .on("RES_MSG", messageHandler)
//                .on("RES_AMS", messageHandler)
//                .on("PUSH_AMS", messageHandler)

                .on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {
                        Log.i("Socket.io", ">>>>>>>>> The socket is now disconnected <<<<<<<<<<");
                    }
                });
//        mSocket.connect();

    }

    private Emitter.Listener messageHandler= new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            JSONObject data = (JSONObject) args[0];
            Log.i("Raw data", data.toString());

            EventBus.getDefault().post(data.toString());

        }
    };
}
