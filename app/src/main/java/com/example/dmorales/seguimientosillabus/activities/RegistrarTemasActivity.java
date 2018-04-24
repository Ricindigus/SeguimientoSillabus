package com.example.dmorales.seguimientosillabus.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmorales.seguimientosillabus.R;
import com.example.dmorales.seguimientosillabus.adapters.ActividadAdapter;
import com.example.dmorales.seguimientosillabus.fragments.SemanasFragment;
import com.example.dmorales.seguimientosillabus.pojos.Actividad;
import com.example.dmorales.seguimientosillabus.pojos.Semana;
import com.example.dmorales.seguimientosillabus.pojos.UnidadDidactica;

import java.util.ArrayList;

public class RegistrarTemasActivity extends AppCompatActivity {
    TextView txtSemana;
    TextInputEditText txtTema;
    Spinner spUnidad;
    Button btnGuardar;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ActividadAdapter actividadAdapter;
    ArrayList<Actividad> actividades;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_temas);

        txtSemana =  (TextView) findViewById(R.id.registrar_temas_txtSemana);
        txtTema = (TextInputEditText) findViewById(R.id.registrar_temas_txtTema);
        btnGuardar = (Button) findViewById(R.id.registrar_temas_btnGuardar);
        recyclerView = (RecyclerView) findViewById(R.id.registrar_temas_recycler);
        fab = (FloatingActionButton) findViewById(R.id.registrar_temas_fab);
        spUnidad = (Spinner) findViewById(R.id.registrar_temas_spinner);

        crearData();
        linearLayoutManager = new LinearLayoutManager(this);
        actividadAdapter =new ActividadAdapter(actividades, RegistrarTemasActivity.this, new ActividadAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(actividadAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegistrarTemasActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_actividad,null);
                final EditText textArea = (EditText) dialogView.findViewById(R.id.textArea);
                builder.setTitle("INDIQUE LA ACTIVIDAD A REALIZAR");
                builder.setView(dialogView);
                builder.setPositiveButton("ACEPTAR", null);
                builder.setNegativeButton("CANCELAR",null);
                final AlertDialog alertDialog = builder.create();
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(final DialogInterface dialog) {
                        textArea.requestFocus();
                        mostrarTeclado(textArea);
                        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (!textArea.getText().toString().trim().equals("")){
                                    actividades.add(new Actividad(textArea.getText().toString()));
                                    recyclerView.getAdapter().notifyDataSetChanged();
                                    dialog.dismiss();
                                }else Toast.makeText(RegistrarTemasActivity.this, "EL CAMPO NO PUEDE ESTAR VACIO", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                alertDialog.show();
            }
        });
        txtSemana.requestFocus();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemanasFragment.semanas.add(new Semana(SemanasFragment.semanas.size()+1,spUnidad.getSelectedItemPosition(),txtTema.getText().toString(),actividades));
                finish();
            }
        });
    }

    public void mostrarTeclado(View view){
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public void crearData(){
        actividades =  new ArrayList<Actividad>();
        actividades.add(new Actividad("Actividad 1"));
        actividades.add(new Actividad("Actividad 2"));
        actividades.add(new Actividad("Actividad 3"));
        actividades.add(new Actividad("Actividad 4"));
        actividades.add(new Actividad("Actividad 5"));
        actividades.add(new Actividad("Actividad 6"));
    }
}
