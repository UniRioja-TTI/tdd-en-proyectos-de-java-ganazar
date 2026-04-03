package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase principal que gestiona la lógica de negocio del servicio de tareas.
 * Se encarga de procesar las peticiones del usuario, interactuar con el repositorio
 * y ejecutar las reglas automáticas, como el envío de correos si hay tareas atrasadas.
 */
public class Servicio {

    private Repositorio repositorio;
    private MailerStub mailer;
    private int idCounter = 1; 

    public Servicio(Repositorio repositorio, MailerStub mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }

    /**
     * Registra una nueva tarea en el sistema y verifica automáticamente si existen 
     * tareas atrasadas para disparar correos de alerta.
     * * @param nombre El texto descriptivo o título de la nueva tarea.
     * @param fechaLimite La fecha máxima acordada para finalizar la tarea.
     */
    public void crearToDo(String nombre, LocalDate fechaLimite) {
        ToDo nuevaTarea = new ToDo(idCounter++, nombre, "", fechaLimite);
        repositorio.guardarToDo(nuevaTarea);
        comprobarAtrasadosYAlertar();
    }

    /**
     * Añade una dirección a la agenda de contactos y comprueba el estado de las tareas.
     * * @param email La dirección de correo que recibirá futuras alertas.
     */
    public void agregarDireccionCorreo(String email) {
        repositorio.guardarEmail(email);
        comprobarAtrasadosYAlertar();
    }

    /**
     * Actualiza el estado de una tarea a completada mediante su ID.
     * Después, evalúa si es necesario enviar alertas por el resto de tareas pendientes.
     * * @param id El identificador único de la tarea que el usuario ha terminado.
     */
    public void marcarTareaComoFinalizada(Integer id) {
        repositorio.marcarCompletado(id);
        comprobarAtrasadosYAlertar();
    }

    /**
     * Devuelve todas las tareas que el usuario aún tiene pendientes por hacer,
     * comprobando antes si alguna de ellas ya ha superado su fecha límite.
     * * @return Una lista con las tareas no completadas.
     */
    public List<ToDo> consultarPendientes() {
        comprobarAtrasadosYAlertar();
        return repositorio.obtenerPendientes();
    }

    /**
     * Regla de negocio interna. Verifica si alguna de las tareas pendientes
     * ha excedido la fecha actual e imprime una alerta de correo.
     */
    private void comprobarAtrasadosYAlertar() {
        List<ToDo> pendientes = repositorio.obtenerPendientes();
        LocalDate hoy = LocalDate.now();

        boolean hayAtrasadas = pendientes.stream()
                .anyMatch(tarea -> tarea.getFechaLimite().isBefore(hoy));

        if (hayAtrasadas) {
            System.out.println("¡Alerta! Hay tareas atrasadas. Se enviarán correos...");
        }
    }

    public static void main(String[] args) {
        DBStub dbStub = new DBStub();
        Repositorio repo = new Repositorio(dbStub);
        MailerStub mailer = new MailerStub();
        Servicio servicioApp = new Servicio(repo, mailer);

        System.out.println("--- GESTOR DE TAREAS INICIADO ---");
    }
}