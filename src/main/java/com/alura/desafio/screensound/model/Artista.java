package com.alura.desafio.screensound.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoDoArtista tipoDoArtista;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    public Artista(){}

    public Artista(String nome, String tipoDoArtista){
        this.nome = nome;
        this.tipoDoArtista = TipoDoArtista.fromString(tipoDoArtista);

    }


    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        musicas.forEach(m -> m.setArtista(this));
        this.musicas = musicas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDoArtista getTipoDoArtista() {
        return tipoDoArtista;
    }

    public void setTipoDoArtista(TipoDoArtista tipoDoArtista) {
        this.tipoDoArtista = tipoDoArtista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", tipoDoArtista=" + tipoDoArtista + '\'' +
                ", músicas= " + musicas;
    }
}
