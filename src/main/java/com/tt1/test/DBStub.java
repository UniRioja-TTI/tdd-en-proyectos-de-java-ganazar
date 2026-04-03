package com.tt1.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Emula el comportamiento de una base de datos en memoria.
 * Utiliza estructuras de datos de Java (Map y Set) para almacenar
 * temporalmente las tareas y la agenda de correos durante la ejecución.
 */
public class DBStub {
    
    private Map<Integer, ToDo> tareas;
    private Set<String> correos;

    public DBStub() {
        this.tareas = new HashMap<>();
        this.correos = new HashSet<>();
    }

    /**
     * Guarda una nueva tarea en la base de datos simulada.
     * * @param todo El objeto ToDo que se desea almacenar.
     */
    public void createToDo(ToDo todo) {
        tareas.put(todo.getId(), todo);
    }

    /**
     * Busca y recupera una tarea específica mediante su identificador.
     * * @param id El número de identificación único de la tarea a buscar.
     * @return El objeto ToDo correspondiente, o null si no existe.
     */
    public ToDo readToDo(Integer id) {
        return tareas.get(id);
    }

    /**
     * Recupera absolutamente todas las tareas almacenadas en el sistema.
     * * @return Una lista conteniendo todos los objetos ToDo guardados.
     */
    public List<ToDo> readAllToDos() {
        return new ArrayList<>(tareas.values());
    }

    /**
     * Actualiza la información de una tarea existente.
     * * @param todo El objeto ToDo con la información actualizada que sobrescribirá a la anterior.
     */
    public void updateToDo(ToDo todo) {
        tareas.put(todo.getId(), todo);
    }

    /**
     * Elimina permanentemente una tarea del almacenamiento.
     * * @param id El identificador único de la tarea que se desea borrar.
     */
    public void deleteToDo(Integer id) {
        tareas.remove(id);
    }

    /**
     * Añade una nueva dirección de correo a la agenda del sistema.
     * * @param email La dirección de correo electrónico a guardar.
     */
    public void addEmail(String email) {
        correos.add(email);
    }

    /**
     * Recupera la lista completa de correos electrónicos guardados.
     * * @return Un conjunto (Set) con todas las direcciones de correo sin duplicados.
     */
    public Set<String> getEmails() {
        return correos;
    }
}