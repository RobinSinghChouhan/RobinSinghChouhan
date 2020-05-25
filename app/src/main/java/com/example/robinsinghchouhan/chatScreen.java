package com.example.robinsinghchouhan;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class chatScreen extends Fragment{

    CustomAdapter adapter;

    ArrayList<Chat> data;
    ArrayList<Chat> chats;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        data=new ArrayList<>();
        data.add(new Chat("1","Hi!",0));
        data.add(new Chat("0","Hi!",0));
        data.add(new Chat("1","Hey I got a chat layout to show you",0));
        data.add(new Chat("0","Sure go on",0));
        data.add(new Chat("1","Here are two messages",0));
        data.add(new Chat("1","on after other",0));
        data.add(new Chat("0","Mine",0));
        data.add(new Chat("0","messages too",0));
        data.add(new Chat("1","picture examples",0));
        data.add(new Chat("1","",R.drawable.chat_bg_image));
        data.add(new Chat("0","My turn",0));
        data.add(new Chat("0","",R.drawable.chat_msg_1));
        data.add(new Chat("1","Two images now",0));
        data.add(new Chat("1","",R.drawable.chat_img_2));
        data.add(new Chat("1","",R.drawable.chat_img4));
        data.add(new Chat("0","try alter images",0));
        data.add(new Chat("0","",R.drawable.chat_img5));
        data.add(new Chat("1","",R.drawable.chat_img6));
        data.add(new Chat("0","",R.drawable.chat_img7));
        data.add(new Chat("1","I will try to type the longest text to see layout",0));
        data.add(new Chat("0","I will also try to writhe the max length of sentence to display two lines",0));
        data.add(new Chat("1","Image between two chats",0));
        data.add(new Chat("1","",R.drawable.chat_img8));
        data.add(new Chat("1","Image above",0));
        data.add(new Chat("0","My turn",0));
        data.add(new Chat("0","",R.drawable.chat_img9));
        data.add(new Chat("0","Image above",0));
        data.add(new Chat("1","Your Image",0));
        data.add(new Chat("0","",R.drawable.chat_img11));
        data.add(new Chat("0","My text",0));
        data.add(new Chat("0","",R.drawable.chat_img10));
        data.add(new Chat("1","So here was my chat layout",0));
        data.add(new Chat("0","Network connection is required!",0));

        chats=new ArrayList<>();
            for(int j=0;j<variables.count_messages;j++){
                chats.add(data.get(j));
            }
        View rootView=inflater.inflate(R.layout.chat_linear_screen,container,false);
        LinearLayout chat=rootView.findViewById(R.id.chat);
        TextView to=rootView.findViewById(R.id.to);
        TextView from=rootView.findViewById(R.id.from);
        to.setText("Kabir");
        from.setText("Robin");
        final ListView list=rootView.findViewById(R.id.list);
        adapter=new CustomAdapter(getActivity(), chats);
        list.setAdapter(adapter);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    addChatMessage();

            }
        });
        list.post(new Runnable() {
            @Override
            public void run() {
            list.smoothScrollToPosition(data.size()-1);
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addChatMessage();
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public static chatScreen newInstance() {

        Bundle args = new Bundle();

        chatScreen fragment = new chatScreen();
        fragment.setArguments(args);
        return fragment;
    }

    public boolean checkConnection(){
        ((MainActivity)getActivity()).broadcastIntent();
        if(!variables.isConnection) {
            Fragment f2= NoInternet.newInstance();
            ((MainActivity)getActivity()).createFragment(f2);
            return false;
        }else{
            return true;
        }
    }

    public void addChatMessage(){
        if(checkConnection()) {
            if (variables.count_messages < data.size()) {
                variables.count_messages = variables.count_messages + 1;
                chats.clear();
                for (int i = 0; i < variables.count_messages; i++) {
                    chats.add(data.get(i));
                }
                adapter.notifyDataSetChanged();
    //            adapter.notifyItemInserted(data.size()-1);


            } else {
                Toast.makeText(getContext(), "End of chats!", Toast.LENGTH_LONG).show();
            }
        }
    }

}
