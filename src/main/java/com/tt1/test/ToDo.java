package com.tt1.test;

import java.time.LocalDate;

/**
 * Representa una tarea pendiente dentro del sistema.
 * Es un JavaBean que almacena la información fundamental de la tarea,
 * como su nombre, descripción, fecha límite y su estado actual (completada o no).
 */
public class ToDo {
    private Integer id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    public ToDo() {
    }

    /**
     * Constructor para inicializar una nueva tarea.
     * Por defecto, la tarea se inicializa como no completada.
     * * @param id El número de identificación único de la tarea.
     * @param nombre El título o resumen descriptivo de la tarea.
     * @param descripcion Los detalles extendidos de lo que se debe hacer.
     * @param fechaLimite La fecha máxima en la que la tarea debe estar finalizada.
     */
    public ToDo(Integer id, String nombre, String descripcion, LocalDate fechaLimite) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completado = false;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFechaLimite() { return fechaLimite; }
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }
    public boolean isCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }
}