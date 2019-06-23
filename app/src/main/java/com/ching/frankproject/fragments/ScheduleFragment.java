package com.ching.frankproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.ching.frankproject.R;
import com.ching.frankproject.dao.ScheduleDao;
import com.ching.frankproject.dao.ScheduleFactory;
import com.ching.frankproject.model.ScheduleAdapter;
import com.ching.frankproject.model.ScheduleListItem;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ScheduleDao scheduleDao = ScheduleFactory.getScheduleDao();

        ArrayList<Object> scheduleListItems = scheduleDao.getItemArrayList();

        Context context = view.getContext();

        ListView listView = view.findViewById(R.id.schedule_listView);

        listView.setAdapter(new ScheduleAdapter(context, scheduleListItems));

    }
}
