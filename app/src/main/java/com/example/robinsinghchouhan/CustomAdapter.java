package com.example.robinsinghchouhan;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Chat> {
private Activity context;
private List<Chat> chat;
    public CustomAdapter(@NonNull Activity context, List<Chat> chat) {
        super(context, R.layout.chat_layout_from,chat);
        this.context=context;
        this.chat=chat;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem;
        Chat chat1=chat.get(position);
        if(chat1.getImage()==0) {
            if (chat1.getId().equals("1")) {
                listViewItem = inflater.inflate(R.layout.chat_layout_from, null, true);
            } else {
                listViewItem = inflater.inflate(R.layout.chat_layout_to, null, true);
            }
            TextView textView = listViewItem.findViewById(R.id.textViewName);
            textView.setText(chat1.getChat());
        }else{
            if(chat1.getId().equals("1")) {
                listViewItem = inflater.inflate(R.layout.chat_image_from, null, true);
            }else{
                listViewItem = inflater.inflate(R.layout.chat_image_to, null, true);
            }
            ImageView img=listViewItem.findViewById(R.id.chat_img);
            Glide.with(getContext())
                    .load(chat1.getImage())
                    .centerCrop()
                 //   .skipMemoryCache(true)
                    .placeholder(R.drawable.holder)
                    .into(img);
        }
        return listViewItem;
    }

}
