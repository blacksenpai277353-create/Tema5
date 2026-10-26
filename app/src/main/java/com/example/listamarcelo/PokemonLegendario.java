package com.example.listamarcelo;

public class PokemonLegendario {

    private String nombre;
    private String tipo;
    private int imagen; // el recurso de la imagen: R.drawable.algo

    public PokemonLegendario(String nombre, String tipo, int imagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getImagen() {
        return imagen;
    }
}
