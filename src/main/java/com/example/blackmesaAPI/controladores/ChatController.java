package com.example.blackmesaAPI.controladores;

import com.example.blackmesaAPI.entidades.MensajeGPT;
import com.example.blackmesaAPI.servicios.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatbotService chatbotService;

    @Autowired
    public ChatController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping("/mensaje")
    public String procesarMensaje(@RequestBody MensajeGPT mensaje) {
        try {
            String respuesta = chatbotService.generarRespuesta(mensaje.getContenido());
            // Puedes realizar cualquier procesamiento adicional aquí
            return respuesta;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al procesar el mensaje.";
        }
    }

    @GetMapping("/mensajes")
    public List<MensajeGPT> obtenerTodosLosMensajes() {
        return chatbotService.obtenerTodosLosMensajes();
    }
}
