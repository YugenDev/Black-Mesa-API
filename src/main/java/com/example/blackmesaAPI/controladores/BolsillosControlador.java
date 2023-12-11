package com.example.blackmesaAPI.controladores;

import com.example.blackmesaAPI.entidades.Bolsillos;
import com.example.blackmesaAPI.servicios.BolsillosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/black-mesa/bolsillos")
public class BolsillosControlador {

    private final BolsillosServicio bolsillosServicio;

    @Autowired
    public BolsillosControlador(BolsillosServicio bolsillosServicio) {
        this.bolsillosServicio = bolsillosServicio;
    }

    @PostMapping("/{idCuenta}")
    public ResponseEntity<Bolsillos> crearBolsillo(@RequestBody Bolsillos bolsillo, @PathVariable Integer idCuenta) {
        Bolsillos nuevoBolsillo = bolsillosServicio.crearBolsillo(bolsillo, idCuenta);
        return ResponseEntity.ok(nuevoBolsillo);
    }

    @GetMapping
    public ResponseEntity<List<Bolsillos>> obtenerTodosLosBolsillos() {
        List<Bolsillos> bolsillos = bolsillosServicio.obtenerTodosLosBolsillos();
        return ResponseEntity.ok(bolsillos);
    }

    @DeleteMapping("/{idBolsillo}")
    public ResponseEntity<Void> borrarBolsillo(@PathVariable Integer idBolsillo) {
        bolsillosServicio.borrarBolsillo(idBolsillo);
        return ResponseEntity.noContent().build();
    }


}
