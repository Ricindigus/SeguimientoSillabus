package com.example.dmorales.seguimientosillabus.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dmorales.seguimientosillabus.R;
import com.example.dmorales.seguimientosillabus.adapters.CursoDisponibleAdapter;
import com.example.dmorales.seguimientosillabus.pojos.Curso;

import java.util.ArrayList;

public class CursosDisponiblesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CursoDisponibleAdapter cursoDisponibleAdapter;
    ArrayList<Curso> cursosDisponibles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos_disponibles);
        recyclerView = (RecyclerView) findViewById(R.id.registro_cursos_recycler);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager =  new LinearLayoutManager(this);
        cargaData();
        cursoDisponibleAdapter = new CursoDisponibleAdapter(cursosDisponibles, this, new CursoDisponibleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent =  new Intent(CursosDisponiblesActivity.this,RegistroActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cursoDisponibleAdapter);
    }


    public void cargaData(){
        cursosDisponibles = new ArrayList<>();
        cursosDisponibles.add(new Curso("SS","I","Algoritmica I","1"));
        cursosDisponibles.add(new Curso("SW","VI","Redes y Transmision de Datos","1"));
        cursosDisponibles.add(new Curso("SS","V","Sistemas Operativos","1"));
    }
}
