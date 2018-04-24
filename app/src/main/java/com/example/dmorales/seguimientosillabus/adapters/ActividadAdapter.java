package com.example.dmorales.seguimientosillabus.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dmorales.seguimientosillabus.R;
import com.example.dmorales.seguimientosillabus.pojos.Actividad;
import com.example.dmorales.seguimientosillabus.pojos.Semana;

import java.util.ArrayList;

/**
 * Created by dmorales on 23/04/2018.
 */

public class ActividadAdapter extends RecyclerView.Adapter<ActividadAdapter.ViewHolder>{
    ArrayList<Actividad> actividades;
    Context context;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public ActividadAdapter(ArrayList<Actividad> actividades, Context context, OnItemClickListener onItemClickListener) {
        this.actividades = actividades;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_actividad,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtDescripcion.setText(actividades.get(position).getDescripcion());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtDescripcion;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            txtDescripcion = (TextView) itemView.findViewById(R.id.txtItemActividad);
            cardView = (CardView) itemView.findViewById(R.id.cardview_actividad);
        }
    }
}
