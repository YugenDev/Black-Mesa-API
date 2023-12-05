package com.example.blackmesaAPI.servicios;

import com.example.blackmesaAPI.entidades.Usuario;
import com.example.blackmesaAPI.repositorios.UsuarioRepositorio;
import com.example.blackmesaAPI.servicios.utilities.Msj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public Usuario registrarUsuario(Usuario usuario) throws Exception{

        try{
            return this.usuarioRepositorio.save(usuario);
        }catch(Exception error){
            throw new Exception(Msj.ERROR_REGISTRO.getMensaje());
        }

    }

    public Usuario consultarUsuario(Integer idUsuario) throws Exception{
        try {
            Optional<Usuario> usuarioBuscado = this.usuarioRepositorio.findById(idUsuario);
            if(usuarioBuscado.isPresent()){
                return usuarioBuscado.get();
            }else {
                throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
        }
    }

    public List<Usuario> buscarTodosLosUsuarios() throws Exception{
        try{
            List<Usuario> listaConsultada = this.usuarioRepositorio.findAll();
            return listaConsultada;
        }catch (Exception error){
            throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
        }
    }

    public Usuario editarUsuario (Integer id, Usuario usuario) throws Exception{
        try {
            Optional<Usuario> usuarioBuscado = this.usuarioRepositorio.findById(id);
            if (usuarioBuscado.isPresent()){
                //  Afiliado afiliadoEditado = this.afiliadoRepositorio.save(afiliado);
                //  return afiliadoEditado;  ESTO CAMBIA todito el afiliado


                //aqui guardas selectivamente lo que quieras de la entidad

                Usuario usuarioExistente = usuarioBuscado.get();
                usuarioExistente.setBolsillos(usuario.getBolsillos());  //puedes poner logica con condicionales para que si dejas un valor nulo lo deje como está

                return this.usuarioRepositorio.save(usuarioExistente);

            }else{
                throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
            }
        }catch (Exception error){
            System.out.println(error.getMessage());
            throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
        }
    }

    public Boolean retirarUsuario (Integer id) throws Exception{
        try {
            Boolean usuarioEncontrado = this.usuarioRepositorio.existsById(id);
            if (usuarioEncontrado){
                this.usuarioRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
        }
    }
}
