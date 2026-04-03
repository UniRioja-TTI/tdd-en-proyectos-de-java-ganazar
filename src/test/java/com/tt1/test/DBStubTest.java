package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class DBStubTest {

    private DBStub db;

    @BeforeEach
    void setUp() {
        db = new DBStub();
    }

    @Test
    void testCreateAndReadToDo() {
        ToDo tarea = new ToDo(1, "Estudiar TDD", "Hacer la práctica", LocalDate.now().plusDays(1));

        db.createToDo(tarea);
        
        ToDo guardada = db.readToDo(1);
        assertNotNull(guardada, "La tarea debería haberse guardado");
        assertEquals("Estudiar TDD", guardada.getNombre());
    }
}