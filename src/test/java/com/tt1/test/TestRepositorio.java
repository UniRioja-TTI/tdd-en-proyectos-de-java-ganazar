package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class TestRepositorio {

    private Repositorio repositorio;
    private DBStub dbStub;

    @BeforeEach
    void setUp() {
        dbStub = new DBStub();
        repositorio = new Repositorio(dbStub);
    }

    @Test
    void testGuardarYEncontrarToDo() {
        ToDo tarea = new ToDo(2, "Test Repositorio", "Probando la capa de datos", LocalDate.now());

        repositorio.guardarToDo(tarea);

        ToDo encontrada = repositorio.encontrarToDo(2);
        assertNotNull(encontrada, "El repositorio debería devolver la tarea guardada");
        assertEquals("Test Repositorio", encontrada.getNombre());
    }

    @Test
    void testMarcarCompletado() {
        ToDo tarea = new ToDo(3, "Tarea a completar", "Descripción", LocalDate.now());
        repositorio.guardarToDo(tarea);

        repositorio.marcarCompletado(3);

        ToDo encontrada = repositorio.encontrarToDo(3);
        assertTrue(encontrada.isCompletado(), "La tarea debería estar marcada como completada");
    }
}