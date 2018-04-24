package com.example.dmorales.seguimientosillabus.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dmorales.seguimientosillabus.R;
import com.example.dmorales.seguimientosillabus.pojos.Curso;

import java.util.ArrayList;

/**
 * Created by dmorales on 23/04/2018.
 */

public class CursoDisponibleAdapter extends RecyclerView.Adapter<CursoDisponibleAdapter.ViewHolder>{
    ArrayList<Curso> cursosDisponibles;
    Context context;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public CursoDisponibleAdapter(ArrayList<Curso> cursosDisponibles, Context context, OnItemClickListener onItemClickListener) {
        this.cursosDisponibles = cursosDisponibles;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_curso_disponible,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtEap.setText(cursosDisponibles.get(position).getEscuela());
        holder.txtCiclo.setText(cursosDisponibles.get(position).getCiclo());
        holder.txtNombre.setText(cursosDisponibles.get(position).getNombre());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cursosDisponibles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtEap;
        TextView txtCiclo;
        TextView txtNombre;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            txtEap = (TextView) itemView.findViewById(R.id.txtEap);
            txtCiclo = (TextView) itemView.findViewById(R.id.txtCiclo);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            cardView = (CardView) itemView.findViewById(R.id.cardview_curso_disponible);
        }
    }
}
