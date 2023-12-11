package com.example.blackmesaAPI.servicios;

import com.example.blackmesaAPI.entidades.Bolsillos;
import com.example.blackmesaAPI.entidades.Cuenta;
import com.example.blackmesaAPI.repositorios.BolsillosRepositorio;
import com.example.blackmesaAPI.repositorios.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BolsillosServicio {

    private final BolsillosRepositorio bolsillosRepositorio;

    private final CuentaRepositorio cuentaRepositorio;

    @Autowired
    public BolsillosServicio(BolsillosRepositorio bolsillosRepositorio, CuentaRepositorio cuentaRepositorio) {
        this.bolsillosRepositorio = bolsillosRepositorio;
        this.cuentaRepositorio = cuentaRepositorio;
    }

    public Bolsillos crearBolsillo(Bolsillos bolsillo, Integer idCuenta) {
        // Verifica si la cuenta existe
        Cuenta cuenta = cuentaRepositorio.findById(idCuenta)
                .orElseThrow(() -> new IllegalArgumentException("La cuenta con ID " + idCuenta + " no existe"));

        // Asigna el bolsillo a la cuenta
        bolsillo.setCuenta(cuenta);


        // Guarda el bolsillo en el repositorio
        return bolsillosRepositorio.save(bolsillo);
    }

    public List<Bolsillos> obtenerTodosLosBolsillos() {
        return bolsillosRepositorio.findAll();
    }

    public void borrarBolsillo(Integer idBolsillo) {
        // Verifica si el bolsillo existe
        Bolsillos bolsillo = bolsillosRepositorio.findById(idBolsillo)
                .orElseThrow(() -> new IllegalArgumentException("El bolsillo con ID " + idBolsillo + " no existe"));

        // Realiza cualquier lógica adicional antes de borrar (si es necesario)

        // Borra el bolsillo
        bolsillosRepositorio.delete(bolsillo);
    }
}
