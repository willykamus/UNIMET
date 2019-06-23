package com.ching.frankproject.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;

import com.ching.frankproject.R;
import com.ching.frankproject.dao.MessagesDao;
import com.ching.frankproject.dao.MessagesFactory;
import com.ching.frankproject.model.Message;
import com.ching.frankproject.model.MessageAdapter;

public class MessagesListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listmessages,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Context context = view.getContext();

        SharedPreferences sharedPreferences = context.getSharedPreferences(getString(R.string.preference_key),Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("firstName", "Not found");

        MessagesDao messagesDao = MessagesFactory.getMessageDao();

        ListView listViewMessages = view.findViewById(R.id.messagesList);

        MessageAdapter adapter = new MessageAdapter(view.getContext(),messagesDao.getMessagesFromUser("Abrahin"));

        listViewMessages.setAdapter(adapter);





    }
}
