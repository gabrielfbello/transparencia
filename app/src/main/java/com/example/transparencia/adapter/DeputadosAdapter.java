package com.example.transparencia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transparencia.R;
import com.example.transparencia.model.Deputado;

import java.util.ArrayList;
import java.util.List;

public class DeputadosAdapter extends RecyclerView.Adapter<DeputadosAdapter.ViewHolder> {

    private List<Deputado> deputados;
    private LayoutInflater mInflater;

    public DeputadosAdapter(Context context, List<Deputado> deputados) {
        this.mInflater = LayoutInflater.from(context);
        this.deputados = deputados;
    }

    public void filterList(List<Deputado> filteredList) {
        deputados = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_deputado_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Deputado deputado = deputados.get(position);
        holder.textViewNomeDeputado.setText(deputado.getNome());
        holder.textViewPartidoDeputado.setText(deputado.getSiglaPartido());
        holder.textViewEstadoDeputado.setText(deputado.getSiglaUf());
    }

    @Override
    public int getItemCount() {
        return deputados.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNomeDeputado;
        TextView textViewPartidoDeputado;
        TextView textViewEstadoDeputado;

        ViewHolder(View itemView) {
            super(itemView);
            textViewNomeDeputado = itemView.findViewById(R.id.textViewNomeDeputado);
            textViewPartidoDeputado = itemView.findViewById(R.id.textViewPartidoDeputado);
            textViewEstadoDeputado = itemView.findViewById(R.id.textViewEstadoDeputado);
        }
    }

}
