package com.example.blackmesaAPI.controladores;

import com.example.blackmesaAPI.entidades.Cuenta;
import com.example.blackmesaAPI.servicios.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/black-mesa/cuenta")
public class CuentaControlador {

    @Autowired
    CuentaServicio cuentaServicio;

    @PostMapping
    public ResponseEntity<?> agregarCuenta(@RequestBody Cuenta cuenta){
        try {
            Cuenta respuestaCuenta = this.cuentaServicio.registrarCuenta(cuenta);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuestaCuenta);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCuenta(@PathVariable Integer id){
        try {
            Cuenta respuestaCuenta = this.cuentaServicio.consultarCuenta(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(respuestaCuenta);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<Cuenta>> consultarExamenes() throws Exception{
        try{
            List<Cuenta> listaConsultada = this.cuentaServicio.buscarTodosLasCuentas();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(listaConsultada);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> editarCuenta(Integer id, @RequestBody Cuenta cuenta) throws Exception {
        try{
            Cuenta cuentaRespuesta =  this.cuentaServicio.editarCuenta(id, cuenta);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(cuentaRespuesta);
        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCuenta (@PathVariable Integer id) throws Exception{
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.cuentaServicio.retirarCuenta(id));
        }catch (Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
