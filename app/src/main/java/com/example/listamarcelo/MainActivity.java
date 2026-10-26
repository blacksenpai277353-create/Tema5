package com.example.listamarcelo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Los datos: al menos 8 elementos
        ArrayList<PokemonLegendario> pokemons = new ArrayList<>();
        pokemons.add(new PokemonLegendario("Mewtwo", "Psíquico - Kanto", R.drawable.mewtwo));
        pokemons.add(new PokemonLegendario("Lugia", "Psíquico/Volador - Johto", R.drawable.lugia));
        pokemons.add(new PokemonLegendario("Ho-Oh", "Fuego/Volador - Johto", R.drawable.hooh));
        pokemons.add(new PokemonLegendario("Rayquaza", "Dragón/Volador - Hoenn", R.drawable.rayquaza));
        pokemons.add(new PokemonLegendario("Kyogre", "Agua - Hoenn", R.drawable.kyogre));
        pokemons.add(new PokemonLegendario("Groudon", "Tierra - Hoenn", R.drawable.groudon));
        pokemons.add(new PokemonLegendario("Dialga", "Acero/Dragón - Sinnoh", R.drawable.dialga));
        pokemons.add(new PokemonLegendario("Arceus", "Normal - Sinnoh", R.drawable.arceus));

        // 2. La lista: cómo se colocan las filas y quién las pinta
        RecyclerView rvLista = findViewById(R.id.rvLista);
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        rvLista.setAdapter(new AdaptadorPokemons(pokemons));
    }
}
