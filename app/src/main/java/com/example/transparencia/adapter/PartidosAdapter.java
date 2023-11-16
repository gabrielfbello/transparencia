package com.example.transparencia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transparencia.R;
import com.example.transparencia.model.Partido;

import java.util.List;

public class PartidosAdapter extends RecyclerView.Adapter<PartidosAdapter.ViewHolder> {

    private List<Partido> partidos;
    private LayoutInflater mInflater;

    public PartidosAdapter(Context context, List<Partido> partidos) {
        this.mInflater = LayoutInflater.from(context);
        this.partidos = partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_partido_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Partido partido = partidos.get(position);
        holder.textViewNomePartido.setText(partido.getSigla());
    }

    @Override
    public int getItemCount() {
        return partidos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNomePartido;

        ViewHolder(View itemView) {
            super(itemView);
            textViewNomePartido = itemView.findViewById(R.id.textViewNomePartido);
        }
    }
}
