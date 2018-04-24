package com.example.dmorales.seguimientosillabus.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.dmorales.seguimientosillabus.R;
import com.example.dmorales.seguimientosillabus.pojos.Actividad;
import com.example.dmorales.seguimientosillabus.pojos.Semana;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by dmorales on 23/04/2018.
 */

public class ResumenAdapter extends RecyclerView.Adapter<ResumenAdapter.ViewHolder>{
    ArrayList<Semana> semanas;
    Context context;

    public ResumenAdapter(ArrayList<Semana> semanas, Context context) {
        this.semanas = semanas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resumen,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtUnidad.setText("UNIDAD "+semanas.get(position).getUnidad());
        holder.txtSemana.setText("SEMANA "+semanas.get(position).getNumero());
        holder.txtTema.setText("Tema: "+semanas.get(position).getTema());
        ArrayList<Actividad> actividades = semanas.get(position).getActividades();
        for (Actividad a: actividades){
            float scale = context.getResources().getDisplayMetrics().density;
            int dpAsPixels = (int) (5.0f*scale + 0.5f);
            TextView textView = new TextView(context);
            textView.setText(a.getDescripcion());
            textView.setPadding(dpAsPixels,dpAsPixels,dpAsPixels,dpAsPixels);
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            View vline = new View(context);
            vline.setBackgroundColor(Color.GRAY);
            int dpAsPixels1 = (int) (1.0f*scale + 0.5f);
            vline.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dpAsPixels1));
            holder.lytActividades.addView(textView);
            holder.lytActividades.addView(vline);
        }
    }

    @Override
    public int getItemCount() {
        return semanas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtUnidad;
        TextView txtSemana;
        TextView txtTema;
        LinearLayout lytActividades;
        public ViewHolder(View itemView) {
            super(itemView);
            txtUnidad = (TextView) itemView.findViewById(R.id.item_resumen_txtUnidad);
            txtSemana = (TextView) itemView.findViewById(R.id.item_resumen_txtSemana);
            txtTema = (TextView) itemView.findViewById(R.id.item_resumen_txtTema);
            lytActividades = (LinearLayout) itemView.findViewById(R.id.resumen_lista_actividades);
        }
    }
}
