package com.example.listamarcelo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPokemons
        extends RecyclerView.Adapter<AdaptadorPokemons.ViewHolder> {

    private final ArrayList<PokemonLegendario> pokemons;

    public AdaptadorPokemons(ArrayList<PokemonLegendario> pokemons) {
        this.pokemons = pokemons;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagen;
        TextView tvTitulo;
        TextView tvSubtitulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivImagen);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvSubtitulo = itemView.findViewById(R.id.tvSubtitulo);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View fila = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila_pokemon, parent, false);
        return new ViewHolder(fila);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PokemonLegendario pokemon = pokemons.get(position);
        holder.tvTitulo.setText(pokemon.getNombre());
        holder.tvSubtitulo.setText(pokemon.getTipo());
        holder.ivImagen.setImageResource(pokemon.getImagen());

        // Al tocar la fila, un Toast con su título
        holder.itemView.setOnClickListener(v ->
                Toast.makeText(v.getContext(),
                        pokemon.getNombre(),
                        Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}
