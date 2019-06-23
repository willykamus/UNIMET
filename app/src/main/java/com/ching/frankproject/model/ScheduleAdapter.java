package com.ching.frankproject.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ching.frankproject.R;

import java.util.ArrayList;

public class ScheduleAdapter extends BaseAdapter {

    private static final int SCHEDULE_ITEM = 0;
    private static final int HEADER = 1;

    private ArrayList<Object> data;

    private LayoutInflater inflater;

    public ScheduleAdapter(Context context, ArrayList<Object> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        if(data.get(position) instanceof ScheduleListItem){
            return SCHEDULE_ITEM;
        } else {
            return HEADER;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
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
            switch (getItemViewType(position)){
                case SCHEDULE_ITEM:
                    convertView = inflater.inflate(R.layout.listview_child,null);
                    break;
                case HEADER:
                    convertView = inflater.inflate(R.layout.listview_header,null);
                    break;
            }
        }

        switch (getItemViewType(position)){
            case SCHEDULE_ITEM:

                TextView startHour = convertView.findViewById(R.id.startTime_TV);
                TextView endHour = convertView.findViewById(R.id.endTime_TV);
                TextView room = convertView.findViewById(R.id.room_TV);
                TextView className = convertView.findViewById(R.id.className_TV);
                TextView classCode = convertView.findViewById(R.id.classCode_TV);


                ScheduleListItem newObject = (ScheduleListItem) data.get(position);

                startHour.setText(newObject.getStartHour());
                endHour.setText(newObject.getEndHour());
                room.setText(newObject.getRoom());
                className.setText(newObject.getSubjectName());
                classCode.setText(newObject.getSubjectCode());

                break;

            case HEADER:

                TextView day = convertView.findViewById(R.id.header_textView);

                String string = (String) data.get(position);

                day.setText(string);

                break;
        }

        return convertView;
    }

}
