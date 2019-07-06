package com.ching.frankproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ching.frankproject.R;
import com.ching.frankproject.dao.EventsDao;
import com.ching.frankproject.dao.EventsFactory;
import com.ching.frankproject.model.Event;
import com.ching.frankproject.model.RecyclerAdapter;

import java.util.ArrayList;

public class CalendarioFragment extends Fragment {

    EventsDao dao = EventsFactory.getEventsDao();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calendar,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//
//        ArrayList<Event> events = dao.getAllEvents();
//
//        Context context = view.getContext();
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
//
//        RecyclerView recyclerView = view.findViewById(R.id.eventsRecycler);
//
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        RecyclerAdapter adapter = new RecyclerAdapter(context,events);
//
//        recyclerView.setAdapter(adapter);

    }
}
