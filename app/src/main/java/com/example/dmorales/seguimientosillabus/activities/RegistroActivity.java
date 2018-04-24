package com.example.dmorales.seguimientosillabus.activities;


import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmorales.seguimientosillabus.R;
import com.example.dmorales.seguimientosillabus.fragments.ResumenFragment;
import com.example.dmorales.seguimientosillabus.fragments.SemanasFragment;
import com.example.dmorales.seguimientosillabus.fragments.UnidadDidacticaFragment;

public class RegistroActivity extends AppCompatActivity {
    TextView txtTitulo;
    TextView txtDot1;
    TextView txtDot2;
    TextView txtDot3;
    ImageView imgSiguiente;
    ImageView imgAnterior;
    int fragmentActual = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtTitulo = (TextView) findViewById(R.id.txtTituloFragment);
        txtDot1 = (TextView) findViewById(R.id.txtDot1);
        txtDot2 = (TextView) findViewById(R.id.txtDot2);
        txtDot3 = (TextView) findViewById(R.id.txtDot3);
        imgAnterior = (ImageView) findViewById(R.id.img_anterior);
        imgSiguiente = (ImageView) findViewById(R.id.img_siguiente);

        imgSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragmentActual + 1 <= 3){
                    fragmentActual++;
                    setTitulo(fragmentActual);
                    setFragment(fragmentActual,1);
                }
            }
        });

        imgAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragmentActual - 1 >= 1){
                    fragmentActual--;
                    setTitulo(fragmentActual);
                    setFragment(fragmentActual,-1);
                }
            }
        });
        txtDot1.setText(Html.fromHtml("&#9679;") + " ");
        txtDot2.setText(Html.fromHtml("&#9675;") + " ");
        txtDot3.setText(Html.fromHtml("&#9675;") + " ");
        setFragment(1,0);
    }


    public void setFragment(int numeroPagina,int direccion){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if(direccion > 0){
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        }else{
            if (direccion<0){
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
            }
        }
        switch (numeroPagina){
            case 1:
                UnidadDidacticaFragment unidadDidacticaFragment = new UnidadDidacticaFragment(RegistroActivity.this);
                fragmentTransaction.replace(R.id.layout_fragment,unidadDidacticaFragment);
                break;
            case 2:
                SemanasFragment semanasFragment = new SemanasFragment(RegistroActivity.this);
                fragmentTransaction.replace(R.id.layout_fragment, semanasFragment);
                break;
            case 3:
                ResumenFragment resumenFragment = new ResumenFragment(RegistroActivity.this);
                fragmentTransaction.replace(R.id.layout_fragment,resumenFragment);
                break;
        }
        fragmentTransaction.commit();
    }

    public void setTitulo(int numPagina){
        switch (numPagina){
            case 1:
                txtTitulo.setText("UNIDADES DIDÁCTICAS");
                txtDot1.setText(Html.fromHtml("&#9679;") + " ");
                txtDot2.setText(Html.fromHtml("&#9675;") + " ");
                txtDot3.setText(Html.fromHtml("&#9675;") + " ");
                break;
            case 2: txtTitulo.setText("SEMANAS");
                txtDot1.setText(Html.fromHtml("&#9675;") + " ");
                txtDot2.setText(Html.fromHtml("&#9679;") + " ");
                txtDot3.setText(Html.fromHtml("&#9675;") + " ");
                break;
            case 3: txtTitulo.setText("RESUMEN");
                txtDot1.setText(Html.fromHtml("&#9675;") + " ");
                txtDot2.setText(Html.fromHtml("&#9675;") + " ");
                txtDot3.setText(Html.fromHtml("&#9679;") + " ");
                break;
        }
    }
}
