package com.example.robinsinghchouhan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.Html;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver MyReceiver=null;
    ConstraintLayout container;
    Fragment fragment;
    FragmentTransaction ft;
    int start=0;
   ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.home);
        actionBar.setTitle(Html.fromHtml("<font color='#000000'>Robin </font>"));
        MyReceiver=new MyReceiver();
        container=findViewById(R.id.container);
        fragment=chatScreen.newInstance();
        if(start==0){
            broadcastIntent();
            start=1;
        }
        createFragment(fragment);
    }
    public void broadcastIntent(){
        registerReceiver(MyReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
    public void createFragment(Fragment fragment){
        ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,fragment).commit();
    }
}
