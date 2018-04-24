package com.example.dmorales.seguimientosillabus.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.dmorales.seguimientosillabus.R;
import com.example.dmorales.seguimientosillabus.adapters.ResumenAdapter;
import com.example.dmorales.seguimientosillabus.pojos.Actividad;
import com.example.dmorales.seguimientosillabus.pojos.Semana;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResumenFragment extends Fragment {

    Context contexto;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ResumenAdapter resumenAdapter;
    ArrayList<Semana> semanas;
    Button btnfinalizar;


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
        View rootView = inflater.inflate(R.layout.fragment_resumen, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.resumen_recycler);
        btnfinalizar = (Button) rootView.findViewById(R.id.resumen_btnFinalizar);

        cargaData();
        linearLayoutManager =  new LinearLayoutManager(contexto);
        resumenAdapter =  new ResumenAdapter(semanas,contexto);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(resumenAdapter);

        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return rootView;
    }

    public void cargaData(){
        semanas = new ArrayList<>();
        ArrayList<Actividad> actividads = new ArrayList<>();
        actividads.add(new Actividad("Actividad 1"));
        actividads.add(new Actividad("Actividad 2"));
        actividads.add(new Actividad("Actividad 3"));
        actividads.add(new Actividad("Actividad 4"));
        actividads.add(new Actividad("Actividad 5"));
        actividads.add(new Actividad("Actividad 6"));
        actividads.add(new Actividad("Actividad 7"));

        semanas.add(new Semana(1,1,"Arquitectura de computadoras. Funciones de los sitemas operativos",actividads));
        semanas.add(new Semana(2,1,"Tipos de sistemas operativos. Estructura y diseño de los sistemas operativos",actividads));
        semanas.add(new Semana(3,2,"Tipos de procesamiento",actividads));
        semanas.add(new Semana(4,2,"Estados de un proceso",actividads));
        semanas.add(new Semana(5,3,"El bloque de control de procesos",actividads));
    }

}
