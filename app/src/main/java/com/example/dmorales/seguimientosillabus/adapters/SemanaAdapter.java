package com.example.dmorales.seguimientosillabus.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dmorales.seguimientosillabus.R;
import com.example.dmorales.seguimientosillabus.pojos.Semana;
import com.example.dmorales.seguimientosillabus.pojos.UnidadDidactica;

import java.util.ArrayList;

/**
 * Created by dmorales on 23/04/2018.
 */

public class SemanaAdapter extends RecyclerView.Adapter<SemanaAdapter.ViewHolder>{
    ArrayList<Semana> semanas;
    Context context;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public SemanaAdapter(ArrayList<Semana> semanas, Context context, OnItemClickListener onItemClickListener) {
        this.semanas = semanas;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_semana,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtNumero.setText(semanas.get(position).getNumero()+"");
        holder.txtTema.setText(semanas.get(position).getTema());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return semanas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNumero;
        TextView txtTema;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            txtNumero = (TextView) itemView.findViewById(R.id.txtItemSemanaNumero);
            txtTema = (TextView) itemView.findViewById(R.id.txtItemSemanaTema);
            cardView = (CardView) itemView.findViewById(R.id.cardview_semana);
        }
    }
}
