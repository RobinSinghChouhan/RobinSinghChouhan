package com.example.robinsinghchouhan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyReceiver extends BroadcastReceiver {
//    Fragment fragment;
//    FragmentTransaction ft;
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean status=NetworkUtil.getConnectivityStatusString(context);
        if(!status){
            status=false;
        }
        variables.isConnection=status;
        if(!status){
          //  Toast.makeText(context,"NO!",Toast.LENGTH_LONG).show();
        }else{
          //  Toast.makeText(context,"YES!",Toast.LENGTH_LONG).show();
        }
    }
}
