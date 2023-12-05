package com.example.blackmesaAPI.controladores;

import com.example.blackmesaAPI.entidades.Usuario;
import com.example.blackmesaAPI.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/black-mesa/usuario")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    @PostMapping
    public ResponseEntity<?> agregarUsuario(@RequestBody Usuario usuario){
        try {
            Usuario respuestaServicio = this.usuarioServicio.registrarUsuario(usuario);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuario(@PathVariable Integer id){
        try {
            Usuario respuestaAfiliado = this.usuarioServicio.consultarUsuario(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(respuestaAfiliado);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> consultarUsuarios() throws Exception{
        try{
            List<Usuario> listaConsultada = this.usuarioServicio.buscarTodosLosUsuarios();
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
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) throws Exception {
        try{
            Usuario usuarioRespuesta =  this.usuarioServicio.editarUsuario(id, usuario);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioRespuesta);
        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario (@PathVariable Integer id) throws Exception{
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.retirarUsuario(id));
        }catch (Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
