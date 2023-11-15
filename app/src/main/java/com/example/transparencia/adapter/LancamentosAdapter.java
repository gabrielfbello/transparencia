package com.example.transparencia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transparencia.R;
import com.example.transparencia.model.Lancamento;

import java.util.List;

public class LancamentosAdapter extends RecyclerView.Adapter<LancamentosAdapter.ViewHolder> {

    private List<Lancamento> lancamentos;
    private LayoutInflater mInflater;

    public LancamentosAdapter(Context context, List<Lancamento> lancamentos) {
        this.mInflater = LayoutInflater.from(context);
        this.lancamentos = lancamentos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lancamento lancamento = lancamentos.get(position);
        // TODO Configurar o holder com a informação do lançamento
    }

    @Override
    public int getItemCount() {
        return lancamentos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDescricao;

        ViewHolder(View itemView) {
            super(itemView);
            textViewDescricao = itemView.findViewById(R.id.textViewDescricao);
        }
    }
}
