package com.example.dmorales.seguimientosillabus.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmorales.seguimientosillabus.R;
import com.example.dmorales.seguimientosillabus.activities.RegistrarTemasActivity;
import com.example.dmorales.seguimientosillabus.adapters.SemanaAdapter;
import com.example.dmorales.seguimientosillabus.pojos.Semana;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SemanasFragment extends Fragment {

    Context contexto;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    SemanaAdapter semanaAdapter;
    public static ArrayList<Semana> semanas = new ArrayList<>();
    FloatingActionButton fab;

    public SemanasFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ValidFragment")
    public SemanasFragment(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_semanas, container, false);
        recyclerView = rootView.findViewById(R.id.semanas_recycler);
        fab = rootView.findViewById(R.id.fab_semanas);

        cargaData();
        linearLayoutManager =  new LinearLayoutManager(contexto);
        semanaAdapter = new SemanaAdapter(semanas, contexto, new SemanaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(semanaAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, RegistrarTemasActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    public void cargaData(){
        semanas = new ArrayList<>();
        semanas.add(new Semana(1,1,"Arquitectura de computadoras. Funciones de los sitemas operativos",null));
        semanas.add(new Semana(2,1,"Tipos de sistemas operativos. Estructura y diseño de los sistemas operativos",null));
        semanas.add(new Semana(3,2,"Tipos de procesamiento",null));
        semanas.add(new Semana(4,2,"Estados de un proceso",null));
        semanas.add(new Semana(5,3,"El bloque de control de procesos",null));
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        semanaAdapter.notifyDataSetChanged();
//    }
//
    @Override
    public void onResume() {
        super.onResume();
        semanaAdapter.notifyDataSetChanged();
    }
}
