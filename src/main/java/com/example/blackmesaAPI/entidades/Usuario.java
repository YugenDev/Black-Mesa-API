package com.example.blackmesaAPI.entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.Array;

import java.util.List;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido,", length = 69, nullable = false)
    private String apellido;

    @Column(name = "tipoDocumento", length = 50, nullable = false)
    private String tipoDocumento;

    @Column(name = "documento",length = 50, nullable = false)
    private String documento;

    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "correo", length = 80, nullable = false)
    private String correo;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroCuenta", nullable = false)
    private Integer numeroCuenta;


    @ElementCollection
    @Column(name = "bolsillo")
    private Array[] bolsillos;


    @ElementCollection
    @Column(name = "hiloGPT")
    private Array[] hiloGPT;


    public Usuario() {
    }

    public Usuario(String id, String nombre, String apellido, String tipoDocumento, String documento, LocalDate fechaNacimiento, String correo, Integer numeroCuenta, Array[] bolsillos, Array[] hiloGPT) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.numeroCuenta = numeroCuenta;
        this.bolsillos = bolsillos;
        this.hiloGPT = hiloGPT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Array[] getBolsillos() {
        return bolsillos;
    }

    public void setBolsillos(Array[] bolsillos) {
        this.bolsillos = bolsillos;
    }

    public Array[] getHiloGPT() {
        return hiloGPT;
    }

    public void setHiloGPT(Array[] hiloGPT) {
        this.hiloGPT = hiloGPT;
    }
}
