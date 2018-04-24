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
import com.example.dmorales.seguimientosillabus.pojos.UnidadDidactica;

import java.util.ArrayList;

/**
 * Created by dmorales on 23/04/2018.
 */

public class UnidadDidacticaAdapter extends RecyclerView.Adapter<UnidadDidacticaAdapter.ViewHolder>{
    ArrayList<UnidadDidactica> unidadDidacticas;
    Context context;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public UnidadDidacticaAdapter(ArrayList<UnidadDidactica> unidadDidacticas, Context context, OnItemClickListener onItemClickListener) {
        this.unidadDidacticas = unidadDidacticas;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_unidad_didactica,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtNumero.setText(unidadDidacticas.get(position).getNumero()+"");
        holder.txtNombre.setText(unidadDidacticas.get(position).getNombre());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return unidadDidacticas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNumero;
        TextView txtNombre;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            txtNumero = (TextView) itemView.findViewById(R.id.txtItemNumero);
            txtNombre = (TextView) itemView.findViewById(R.id.txtItemNombreUnidad);
            cardView = (CardView) itemView.findViewById(R.id.cardview_unidad_didactica);
        }
    }
}
