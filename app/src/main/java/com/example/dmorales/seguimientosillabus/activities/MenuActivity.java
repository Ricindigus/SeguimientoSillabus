package com.example.dmorales.seguimientosillabus.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.dmorales.seguimientosillabus.R;

public class MenuActivity extends AppCompatActivity {

    CardView cvRegistroSillabus;
    CardView cvControlSillabus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cvControlSillabus = (CardView) findViewById(R.id.cardview_control_sillabus);
        cvRegistroSillabus = (CardView) findViewById(R.id.cardview_registro_sillabus);

        cvControlSillabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cvRegistroSillabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MenuActivity.this, CursosDisponiblesActivity.class);
                startActivity(intent);
            }
        });
    }
}
