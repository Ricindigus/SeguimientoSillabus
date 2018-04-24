package com.example.dmorales.seguimientosillabus.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dmorales.seguimientosillabus.R;
import com.example.dmorales.seguimientosillabus.adapters.UnidadDidacticaAdapter;
import com.example.dmorales.seguimientosillabus.pojos.UnidadDidactica;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnidadDidacticaFragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    Context contexto;
    ArrayList<UnidadDidactica> unidadDidacticas;

    @SuppressLint("ValidFragment")
    public UnidadDidacticaFragment(Context contexto) {
        this.contexto = contexto;
    }

    public UnidadDidacticaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_unidad_didactica, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_unidad_didactica);
        fab = rootView.findViewById(R.id.fab_unidad_didactica);

        cargarData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(contexto);
        UnidadDidacticaAdapter unidadDidacticaAdapter = new UnidadDidacticaAdapter(unidadDidacticas, contexto, new UnidadDidacticaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(unidadDidacticaAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_unidad_didactica,null);
                final TextInputEditText txtNombreUnidad = (TextInputEditText) dialogView.findViewById(R.id.txtNombreUnidad);
                builder.setTitle("INDIQUE EL NOMBRE DE LA UNIDAD DIDACTICA");
                builder.setView(dialogView);
                builder.setPositiveButton("ACEPTAR", null);
                builder.setNegativeButton("CANCELAR",null);
                final AlertDialog alertDialog = builder.create();
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(final DialogInterface dialog) {
                        txtNombreUnidad.requestFocus();
                        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (!txtNombreUnidad.getText().toString().trim().equals("")){
                                    unidadDidacticas.add(new UnidadDidactica(
                                            (unidadDidacticas.size()+1),
                                            txtNombreUnidad.getText().toString()
                                    ));
                                    recyclerView.getAdapter().notifyDataSetChanged();
                                    dialog.dismiss();
                                }else Toast.makeText(contexto, "EL CAMPO NOMBRE NO PUEDE ESTAR VACIO", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                alertDialog.show();
            }
        });
        return rootView;
    }

    public void cargarData(){
        unidadDidacticas = new ArrayList<>();
        unidadDidacticas.add(new UnidadDidactica(1,"Introducción y conceptos básicos"));
        unidadDidacticas.add(new UnidadDidactica(2,"Administración del procesador"));
        unidadDidacticas.add(new UnidadDidactica(3,"Administración de la memoria real"));
        unidadDidacticas.add(new UnidadDidactica(4,"Administración de la memoria virtual"));
        unidadDidacticas.add(new UnidadDidactica(5,"Administración de Entrada/Salida"));

    }

}
