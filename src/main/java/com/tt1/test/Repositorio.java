package com.tt1.test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Capa de enlace de datos (Data Access Layer).
 * Encapsula la lógica de comunicación con la base de datos (DBStub),
 * proporcionando métodos específicos y limpios para que sean consumidos por el Servicio.
 */
public class Repositorio {
    
    private DBStub db;

    public Repositorio(DBStub db) {
        this.db = db;
    }

    /**
     * Delega el guardado de una nueva tarea en la base de datos.
     * * @param todo El objeto tarea que se quiere persistir.
     */
    public void guardarToDo(ToDo todo) {
        db.createToDo(todo);
    }

    /**
     * Busca una tarea concreta en la base de datos a partir de su ID.
     * * @param id El identificador numérico de la tarea.
     * @return El objeto ToDo encontrado.
     */
    public ToDo encontrarToDo(Integer id) {
        return db.readToDo(id);
    }

    /**
     * Localiza una tarea por su ID y cambia su estado directamente a completado.
     * * @param id El identificador único de la tarea que se va a finalizar.
     */
    public void marcarCompletado(Integer id) {
        ToDo tarea = db.readToDo(id);
        if (tarea != null) {
            tarea.setCompletado(true);
            db.updateToDo(tarea);
        }
    }

    /**
     * Guarda una dirección de correo electrónico en la agenda de la base de datos.
     * * @param email La cadena de texto con la dirección de correo.
     */
    public void guardarEmail(String email) {
        db.addEmail(email);
    }

    /**
     * Obtiene el listado de tareas filtrando únicamente aquellas que aún no están terminadas.
     * * @return Una lista de tareas cuyo atributo 'completado' es falso.
     */
    public List<ToDo> obtenerPendientes() {
        return db.readAllToDos().stream()
                 .filter(tarea -> !tarea.isCompletado())
                 .collect(Collectors.toList());
    }
}