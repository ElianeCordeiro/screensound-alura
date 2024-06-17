package com.alura.desafio.screensound.repository;

import com.alura.desafio.screensound.model.Artista;
import com.alura.desafio.screensound.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ArtistaRepositorio extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArtista);

    //List<Musica> findMusicaBy();

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nomeArtista%")
    List<Musica> listarMusicas(String nomeArtista);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nomeArtista% AND m.titulo ILIKE %:tituloMusica%")
    Musica buscarMusicaPorArtista(String nomeArtista, String tituloMusica);
}
