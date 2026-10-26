package com.example.listamarcelo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
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

        ArrayList<PokemonLegendario> pokemons = new ArrayList<>();
        pokemons.add(new PokemonLegendario("Dialga", "Acero/Dragón - Sinnoh", R.drawable.dialga));
        pokemons.add(new PokemonLegendario("Palkia", "Agua/Dragón - Sinnoh", R.drawable.palkia));
        pokemons.add(new PokemonLegendario("Rayquaza", "Dragón/Volador - Hoenn", R.drawable.raiquaza));
        pokemons.add(new PokemonLegendario("Reshiram", "Dragón/Fuego - Teselia", R.drawable.reshiram));
        pokemons.add(new PokemonLegendario("Zekrom", "Dragón/Eléctrico - Teselia", R.drawable.zekrom));
        pokemons.add(new PokemonLegendario("Giratina", "Dragón/Fantasma - Sinnoh", R.drawable.giratina));
        pokemons.add(new PokemonLegendario("Lugia", "Volador/Psiquico - Johto", R.drawable.lugia));
        pokemons.add(new PokemonLegendario("Ho-oh", "Volador/Fuego - Johto", R.drawable.hooh));

        RecyclerView rvLista = findViewById(R.id.rvLista);
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        rvLista.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvLista.setAdapter(new AdaptadorPokemons(pokemons));
    }
}
