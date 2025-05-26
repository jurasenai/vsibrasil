package com.vsibrasil.projeto.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AnagramaService {

 public List<String> gerarAnagramas(String letras) {
     if (letras == null || letras.isEmpty()) {
         throw new IllegalArgumentException("Erro: a entrada não pode ser vazia.");
     }

     if (!letras.matches("[a-zA-Z]+")) {
         throw new IllegalArgumentException("Erro: a entrada deve conter apenas letras.");
     }

     if (temLetrasRepetidas(letras)) {
         throw new IllegalArgumentException("Erro: as letras devem ser distintas, sem repetições.");
     }

     List<String> resultado = new ArrayList<>();
     permutar("", letras, resultado);
     return resultado;
 }

 private boolean temLetrasRepetidas(String letras) {
     Set<Character> conjunto = new HashSet<>();
     for (char c : letras.toCharArray()) {
         if (!conjunto.add(c)) {
             return true;
         }
     }
     return false;
 }

 private void permutar(String prefixo, String restante, List<String> resultado) {
     if (restante.isEmpty()) {
         resultado.add(prefixo);
     } else {
         for (int i = 0; i < restante.length(); i++) {
             String novoPrefixo = prefixo + restante.charAt(i);
             String novoRestante = restante.substring(0, i) + restante.substring(i + 1);
             permutar(novoPrefixo, novoRestante, resultado);
         }
     }
 }
}
