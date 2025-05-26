package com.vsibrasil.projeto.services;


import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramaServiceTest {

    private final AnagramaService service = new AnagramaService();

    @Test
    void testAnagramas() {
        List<String> resultado = service.gerarAnagramas("abc");
        assertEquals(6, resultado.size());
    }

    @Test
    void testLetraUnica() {
        List<String> resultado = service.gerarAnagramas("x");
        assertEquals(List.of("x"), resultado);
    }

    @Test
    void testEntradaVazia() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.gerarAnagramas(""));
        assertTrue(ex.getMessage().contains("não pode ser vazia"));
    }

    @Test
    void testRepetidas() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.gerarAnagramas("aab"));
        assertTrue(ex.getMessage().contains("distintas"));
    }
}
