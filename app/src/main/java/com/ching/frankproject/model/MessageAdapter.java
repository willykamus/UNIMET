package com.ching.frankproject.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.ching.frankproject.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MessageAdapter extends BaseAdapter {

    private static final int SCHEDULE_ITEM = 0;
    private static final int HEADER = 1;

    private ArrayList<Message> data;

    private LayoutInflater inflater;

    public MessageAdapter(Context context, ArrayList<Message> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.message_list_item,null);
        }

        TextView recipientTV = convertView.findViewById(R.id.recipientTV);
        TextView recipientMessageTV = convertView.findViewById(R.id.recipientMessagePreviewTV);
        TextView dateTV = convertView.findViewById(R.id.messageStampTV);
        ImageView imageView = convertView.findViewById(R.id.recipientIV);

        Message message = data.get(position);

        recipientTV.setText(message.getRecipient());
        recipientMessageTV.setText(message.getText());

        Bitmap img = BitmapFactory.decodeResource(convertView.getResources(), R.drawable.profile_default);

        RoundedBitmapDrawable round = RoundedBitmapDrawableFactory.create(convertView.getResources(),img);

        round.setCircular(true);

        imageView.setImageDrawable(round);


//        Date now = new Date();
//        long timeNow = now.getTime()/1000;
//        long messageDate = message.getDateStamp().getTime()/1000;
//
//        String txt = "";
//
//        if((timeNow - messageDate) >= 86400 ) {
//            txt = "Yesterday";
//        }


        return convertView;
    }
}
