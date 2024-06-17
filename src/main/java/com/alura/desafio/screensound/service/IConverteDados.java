package com.alura.desafio.screensound.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
