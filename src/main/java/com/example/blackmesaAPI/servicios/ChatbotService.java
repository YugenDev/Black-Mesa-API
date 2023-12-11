package com.example.blackmesaAPI.servicios;

import com.example.blackmesaAPI.entidades.MensajeGPT;
import com.example.blackmesaAPI.repositorios.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatbotService {

    private final MensajeRepository mensajeRepository;

    @Autowired
    public ChatbotService(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    public String generarRespuesta(String mensajeUsuario) throws Exception {
        // Lógica para generar la respuesta utilizando OpenAI
        // ...

        // Guardar el mensaje del usuario en la base de datos
        MensajeGPT mensaje = new MensajeGPT();
        mensaje.setContenido(mensajeUsuario);
        mensajeRepository.save(mensaje);

        // Devolver la respuesta generada
        return "Respuesta del chatbot";
    }

    public List<MensajeGPT> obtenerTodosLosMensajes() {
        return mensajeRepository.findAll();
    }
}
