package com.ching.frankproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ching.frankproject.R;
import com.github.barteksc.pdfviewer.PDFView;

public class FlujogramaFragment extends Fragment {

    PDFView pdfView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flujograma,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Context context = view.getContext();

        pdfView = view.findViewById(R.id.pdfViewver);

        pdfView.fromAsset("FLUJOGRAMA-ING.-MECÁNICA.pdf").load();
    }

}
