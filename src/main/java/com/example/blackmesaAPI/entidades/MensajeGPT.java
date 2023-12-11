package com.example.blackmesaAPI.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class MensajeGPT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    @JsonIgnore
    private Cuenta cuenta;

    public MensajeGPT() {
    }

    public MensajeGPT(Long id, String contenido, Cuenta cuenta) {
        this.id = id;
        this.contenido = contenido;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
