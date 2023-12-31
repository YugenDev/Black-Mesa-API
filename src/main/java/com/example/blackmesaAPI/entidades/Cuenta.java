package com.example.blackmesaAPI.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "tipoDoc", nullable = false)
    private String tipoDoc;

    @Column(name = "documento", nullable = false)
    private String documento;

    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(nullable = false, unique = true)
    private String numeroCuenta;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bolsillos> bolsillos;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MensajeGPT> mensajes;

    public Cuenta() {
    }

    public Cuenta(Integer id, String nombre, String apellido, String tipoDoc, String documento, Date fechaNacimiento, String correo, String numeroCuenta, List<Bolsillos> bolsillos, List<MensajeGPT> mensajes) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDoc = tipoDoc;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.numeroCuenta = numeroCuenta;
        this.bolsillos = bolsillos;
        this.mensajes = mensajes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public List<Bolsillos> getBolsillos() {
        return bolsillos;
    }

    public void setBolsillos(List<Bolsillos> bolsillos) {
        this.bolsillos = bolsillos;
    }

    public List<MensajeGPT> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<MensajeGPT> mensajes) {
        this.mensajes = mensajes;
    }
}
