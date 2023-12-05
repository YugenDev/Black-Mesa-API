package com.example.blackmesaAPI.servicios.utilities;

public enum Msj {

    ERROR_REGISTRO("Error al registrarse"),

    ERROR_NO_ENCUENTRA("No se ha encontrado el elemento brindado")

    ;

    private String mensaje;

    Msj (String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
