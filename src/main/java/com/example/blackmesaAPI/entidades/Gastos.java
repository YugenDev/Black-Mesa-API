package com.example.blackmesaAPI.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "gastos")
public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "categoria", nullable = false)
    private Integer categoria;
    @Column(name = "valor", nullable = false)
    private Integer valor;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "cuentaDestino", nullable = false)
    private Integer cuentaDestino;

    @Column(name = "cuentaOrigen", nullable = false)
    private Integer cuentaOrigen;

    public Gastos() {
    }

    public Gastos(String id, Integer categoria, Integer valor, LocalDate fecha, Integer cuentaDestino, Integer cuentaOrigen) {
        this.id = id;
        this.categoria = categoria;
        this.valor = valor;
        this.fecha = fecha;
        this.cuentaDestino = cuentaDestino;
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Integer cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Integer getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Integer cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }
}
