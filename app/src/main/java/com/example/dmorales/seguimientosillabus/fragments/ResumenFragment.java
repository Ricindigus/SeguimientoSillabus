package com.example.dmorales.seguimientosillabus.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmorales.seguimientosillabus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResumenFragment extends Fragment {

    Context contexto;

    public ResumenFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ResumenFragment(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resumen, container, false);
    }

}
