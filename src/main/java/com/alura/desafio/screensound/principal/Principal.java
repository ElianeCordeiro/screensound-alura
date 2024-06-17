package com.alura.desafio.screensound.principal;

import com.alura.desafio.screensound.model.Artista;
import com.alura.desafio.screensound.model.Musica;
import com.alura.desafio.screensound.repository.ArtistaRepositorio;
import com.alura.desafio.screensound.service.ConsultaChatGPT;
import com.alura.desafio.screensound.service.ConverteDados;

import java.util.*;

import java.util.Scanner;

public class Principal{

    private Scanner leitura = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();
    Optional<Artista> artista;

    private ArtistaRepositorio repositorio;


    public Principal(ArtistaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public void exibeMenu(){
        var opcao = -1;
        while(opcao != 0){
            var menu = """
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Listar músicas
                    4 - Buscar músicas por artistas
                    5 - Pesquisar dados sobre um artista
                    
                    0 - Sair
                    
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusicaPorArtista();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    pesquisarArtista();
                    break;
            }
        }
    }

    private void pesquisarArtista() {
        System.out.println("Digite o nome do artista para busca. ");
        var nomeArtista = leitura.nextLine();
        var dadosArtista = ConsultaChatGPT.obterArtirsta(nomeArtista);
        System.out.println("Dados do artista: " + dadosArtista);

    }

    private void cadastrarArtista() {
        System.out.println("Qual nome do artista? ");
        var nomeArtista = leitura.nextLine();
        System.out.println("Digite o tipo do artista: (solo, dupla ou banda.");
        var tipoDoArtista = leitura.nextLine();
        Artista artista = new Artista(nomeArtista, tipoDoArtista);
        repositorio.save(artista);
    }

    private void cadastrarMusicaPorArtista() {
        System.out.println("Informe o nome do artista. ");
        var nomeArtista = leitura.nextLine();
        Optional<Artista> buscaArtista = repositorio.findByNomeContainingIgnoreCase(nomeArtista);

        if(buscaArtista.isPresent()){
            var artistaEncontrado = buscaArtista.get();
            List<Musica> musicas = new ArrayList<>();
            Musica musica = salvarMusica();
            musicas.add(musica);

            artistaEncontrado.setMusicas(musicas);
            repositorio.save(artistaEncontrado);
        }else{
            System.out.println("Artista não encontrado. ");
        }
    }

    private Musica salvarMusica() {
        System.out.println("Qual o nome da musica? ");
        var nomeMusica = leitura.nextLine();
        System.out.println("Qual o nome do albúm da música? ");
        var nomeAlbum = leitura.nextLine();

        Musica musica = new Musica(nomeMusica, nomeAlbum);
        return musica;
    }

    private void listarMusicas() {
        listarArtistas();

        if(artista.isPresent()){
            var artistaEncontrada = artista.get().getNome();
            List<Musica> musicasEncontradas = repositorio.listarMusicas(artistaEncontrada);
            musicasEncontradas.forEach( m->
                    System.out.println("Música: " + m.getTitulo()));

        }

    }

    private void listarArtistas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a ->
                System.out.println(a.getNome()));

        System.out.println("Qual o nome do artista?");
        var nomeArtista = leitura.nextLine();

        artista = repositorio.findByNomeContainingIgnoreCase(nomeArtista);

        if (artista.isPresent()) {
            artista.toString();
        } else {
            System.out.println("Artista não encontrado");
        }
    }

    private void buscarMusicaPorArtista() {
        listarMusicas();

        if(artista.isPresent()){
            var nomeArtista = artista.get().getNome();
            System.out.println("Qual o nome da música? ");
            var nomeMusica = leitura.nextLine();

            Musica musica = repositorio.buscarMusicaPorArtista(nomeArtista, nomeMusica);
            System.out.println(musica.toString());
        }

    }

}
