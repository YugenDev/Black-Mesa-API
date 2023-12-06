package com.example.blackmesaAPI.controladores;

import com.example.blackmesaAPI.entidades.Gastos;
import com.example.blackmesaAPI.servicios.GastosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/black-mesa/gastos")
public class GastosControlador {

    @Autowired
    GastosServicio gastosServicio;

    @PostMapping
    public ResponseEntity<?> agregarGasto(@RequestBody Gastos gastos){
        try {
            Gastos respuestaGastos = this.gastosServicio.registrarGasto(gastos);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuestaGastos);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarGasto(@PathVariable Integer id){
        try {
            Gastos respuestaGastos = this.gastosServicio.consultargasto(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(respuestaGastos);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<Gastos>> consultargasto () throws Exception{
        try{
            List<Gastos> listaConsultada = this.gastosServicio.buscarTodosLosGastos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(listaConsultada);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }



}
