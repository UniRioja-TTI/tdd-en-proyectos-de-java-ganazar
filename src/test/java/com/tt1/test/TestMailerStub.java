package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMailerStub {

    private MailerStub mailer;

    @BeforeEach
    void setUp() {
        mailer = new MailerStub();
    }

    @Test
    void testEnviarCorreo() {
        boolean resultado = mailer.enviarCorreo("profesor@universidad.edu", "¡Tests completados!");
        
        assertTrue(resultado, "El envío de correo debe devolver true confirmando el éxito");
    }
}