package com.example.lvtn_android.screens.login;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lvtn_android.Global;
import com.example.lvtn_android.R;


public class LoginFragment extends Fragment {
    TextView createAccTxt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_login, container, false);

        createAccTxt=view.findViewById(R.id.createAccTxt);
        createAccTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder =	new AlertDialog.Builder(getActivity());
                LayoutInflater inflater	= getActivity().getLayoutInflater();
                View dialogView	=	inflater.inflate(R.layout.dialog_create_acc,null);



                dialogBuilder.setView(dialogView);
                dialogBuilder.setTitle("Create new account");
                AlertDialog b = dialogBuilder.create();
                b.show();

                Button registerBtn = dialogView.findViewById(R.id.button4);
                registerBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Global.mSocket.emit("create","aaaaaa","asasas");
                    }
                });
            }
        });

        return view;

    }


}
