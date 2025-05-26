package com.vsibrasil.projeto.models;

import java.util.List;

public class AnagramaResponse {
    private List<String> anagramas;

    public AnagramaResponse(List<String> anagramas) {
        this.anagramas = anagramas;
    }

    public List<String> getAnagramas() { return anagramas; }
}