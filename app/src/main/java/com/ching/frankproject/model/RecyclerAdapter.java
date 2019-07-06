package com.ching.frankproject.model;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ching.frankproject.R;

import java.text.DateFormatSymbols;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Event> eventArrayList;
    private Context context;
    private String months[] = new DateFormatSymbols().getMonths();

    public RecyclerAdapter(Context context, ArrayList<Event> eventArrayList) {
        this.eventArrayList = eventArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d("Tag", "binderCalled");

        Log.d("typeEvent", String.valueOf(eventArrayList.size()));

        holder.day.setText(String.valueOf(eventArrayList.get(position).getDayOfEvent()));
        holder.weekDay.setText(eventArrayList.get(position).getDayOfTheWeek());
        int month = eventArrayList.get(position).getMonthOfEvent();
        holder.month.setText(months[month]);
        int color = 0;

        switch (eventArrayList.get(position).getType()) {

            case "Feriado":

                color = Color.parseColor("#20639B");
                holder.description.setText("Feriado\n" + String.valueOf(eventArrayList.get(position).getDescription()));
                holder.type.setBackgroundColor(color);

                break;

            case "Examen":
                color = Color.parseColor("#F6D55C");
                holder.description.setText("Feriado\n" + String.valueOf(eventArrayList.get(position).getDescription()));
                holder.type.setBackgroundColor(color);
                break;

        }

    }

    @Override
    public int getItemCount() {
        return eventArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView day;
        View type;
        TextView description;
        TextView weekDay;
        TextView month;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            weekDay = itemView.findViewById(R.id.cardDay);
            month = itemView.findViewById(R.id.cardMonth);
            day = itemView.findViewById(R.id.eventDayText);
            type = itemView.findViewById(R.id.typeEventRibbon);
            description = itemView.findViewById(R.id.eventDescriptionText);



        }
    }

}
