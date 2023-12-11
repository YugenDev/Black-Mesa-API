package com.example.blackmesaAPI.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Bolsillos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer metaMonetaria;
    @Column(nullable = false)
    private Integer saldo;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    @JsonIgnore
    private Cuenta cuenta;


    public Bolsillos() {
    }

    public Bolsillos(Long id, String nombre, Integer metaMonetaria, Integer saldo, Cuenta cuenta) {
        this.id = id;
        this.nombre = nombre;
        this.metaMonetaria = metaMonetaria;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMetaMonetaria() {
        return metaMonetaria;
    }

    public void setMetaMonetaria(Integer metaMonetaria) {
        this.metaMonetaria = metaMonetaria;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
