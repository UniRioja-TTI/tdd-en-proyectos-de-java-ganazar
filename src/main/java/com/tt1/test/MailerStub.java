package com.tt1.test;

/**
 * Emula un servicio externo de envío de correos electrónicos.
 * En lugar de enviar correos reales, imprime los mensajes por la consola
 * para verificar que el flujo de notificaciones funciona correctamente.
 */
public class MailerStub {
    
    /**
     * Simula el envío de un correo de alerta a una dirección específica.
     * * @param direccion El correo electrónico del destinatario.
     * @param mensaje El cuerpo del correo que se desea enviar.
     * @return true si la simulación del envío ha sido exitosa.
     */
    public boolean enviarCorreo(String direccion, String mensaje) {
        System.out.println("SIMULACIÓN - Enviando correo a: " + direccion);
        System.out.println("SIMULACIÓN - Mensaje: " + mensaje);
        return true; 
    }
}