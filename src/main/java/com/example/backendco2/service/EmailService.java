package com.example.backendco2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendPasswordResetEmail(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Recuperación de contraseña");
        message.setText("Para restablecer tu contraseña, haz clic en el siguiente enlace:\n\n"
                + "http://localhost:8080/reset-password?token=" + token
                + "\n\nEste enlace expirará en 1 hora.");

        mailSender.send(message);
    }
}
