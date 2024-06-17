package com.alura.desafio.screensound.model;

public enum TipoDoArtista {

    SOLO("Solo"),
    DUPLA("Dupla"),
    BANDA("Banda");

    private String tipo;

    TipoDoArtista(String tipo){
        this.tipo = tipo;
    }

    public static TipoDoArtista fromString(String text){
        for(TipoDoArtista tipoDoArtista : TipoDoArtista.values()){
            if(tipoDoArtista.tipo.equalsIgnoreCase(text)){
                return tipoDoArtista;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo foi encontrado para a string fornecida: " + text);
    }
}
