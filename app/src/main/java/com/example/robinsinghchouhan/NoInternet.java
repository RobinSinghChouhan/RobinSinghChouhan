package com.example.robinsinghchouhan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class NoInternet extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.no_internet,container,false);
        Button retry=rootView.findViewById(R.id.retry);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment ft=chatScreen.newInstance();

                FragmentTransaction ftt=getFragmentManager().beginTransaction();
                ftt.replace(R.id.container,ft).commit();
            }
        });
        TextView errorMessage=rootView.findViewById(R.id.textViewError);
        TextView errorMessage1=rootView.findViewById(R.id.textViewError1);
        TextView errorMessage2=rootView.findViewById(R.id.textViewError2);
        errorMessage.setText("No Internet");
        errorMessage1.setText("Connection");
        errorMessage2.setText("Please  check  your  network  connection  and  try again");
        return rootView;
    }

    public static NoInternet newInstance() {
        
        Bundle args = new Bundle();
        
        NoInternet fragment = new NoInternet();
        fragment.setArguments(args);
        return fragment;
    }
}
