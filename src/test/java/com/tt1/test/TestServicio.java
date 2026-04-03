package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

class TestServicio {

    private Servicio servicio;
    private Repositorio repositorio;
    private DBStub dbStub;
    private MailerStub mailerStub;

    @BeforeEach
    void setUp() {
        dbStub = new DBStub();
        repositorio = new Repositorio(dbStub);
        mailerStub = new MailerStub();
        
        servicio = new Servicio(repositorio, mailerStub);
    }

    @Test
    void testCrearToDo() {
        servicio.crearToDo("Estudiar TDD", LocalDate.now().plusDays(2));
        
        ToDo encontrada = repositorio.encontrarToDo(1); // Suponiendo que le asigna el ID 1
        assertNotNull(encontrada, "El servicio debería haber guardado la tarea en el repositorio");
        assertEquals("Estudiar TDD", encontrada.getNombre());
    }

    @Test
    void testConsultarPendientes() {
        repositorio.guardarToDo(new ToDo(1, "Completada", "Desc", LocalDate.now()));
        repositorio.marcarCompletado(1);
        repositorio.guardarToDo(new ToDo(2, "Pendiente", "Desc", LocalDate.now()));

        List<ToDo> pendientes = servicio.consultarPendientes();

        assertNotNull(pendientes);
        assertEquals(1, pendientes.size(), "Solo debería haber 1 tarea pendiente");
        assertEquals("Pendiente", pendientes.get(0).getNombre());
    }
}