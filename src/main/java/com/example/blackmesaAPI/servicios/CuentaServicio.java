package com.example.blackmesaAPI.servicios;

import com.example.blackmesaAPI.entidades.Cuenta;
import com.example.blackmesaAPI.entidades.Gastos;
import com.example.blackmesaAPI.entidades.MensajeGPT;
import com.example.blackmesaAPI.repositorios.CuentaRepositorio;
import com.example.blackmesaAPI.repositorios.MensajeRepository;
import com.example.blackmesaAPI.servicios.utilities.Msj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CuentaServicio {

    @Autowired
    CuentaRepositorio cuentaRepositorio;

    @Autowired
    MensajeRepository mensajeRepository;

    public Cuenta registrarCuenta(Cuenta cuenta) throws Exception {
        try {
            // Genera un número de cuenta aleatorio
            String numeroCuenta = generarNumeroCuentaAleatorio();

            cuenta.setNumeroCuenta(numeroCuenta);

            // Guarda la cuenta en la base de datos
            Cuenta cuentaRegistrada = this.cuentaRepositorio.save(cuenta);

            // Asocia un mensaje de bienvenida a la nueva cuenta
            MensajeGPT mensajeBienvenida = new MensajeGPT();
            mensajeBienvenida.setContenido("¡Bienvenido a nuestra plataforma, " + cuenta.getNombre() + "!");
            mensajeBienvenida.setCuenta(cuentaRegistrada);
            this.mensajeRepository.save(mensajeBienvenida);

            return cuentaRegistrada;
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new Exception("Error de integridad de datos al registrar la cuenta. Detalles: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al registrar la cuenta. Detalles: " + e.getMessage());
        }
    }

    private String generarNumeroCuentaAleatorio() {

        int longitud = 10;
        StringBuilder numeroCuenta = new StringBuilder();
        
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            int digito = random.nextInt(10);
            numeroCuenta.append(digito);
        }

        return numeroCuenta.toString();
    }

    public Cuenta consultarCuenta (Integer id) throws Exception{
        try {
            Optional<Cuenta> cuentaBuscada = this.cuentaRepositorio.findById(id);
            if(cuentaBuscada.isPresent()){
                return cuentaBuscada.get();
            }else {
                throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
        }
    }

    public List<Cuenta> buscarTodosLasCuentas () throws Exception{
        try{
            List<Cuenta> listaConsultada = this.cuentaRepositorio.findAll();
            return listaConsultada;
        }catch (Exception error){
            throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
        }
    }

    public List<MensajeGPT> obtenerMensajesDeCuenta(Integer idCuenta) {
        // Obtén la cuenta
        Cuenta cuenta = cuentaRepositorio.findById(idCuenta).orElse(null);

        if (cuenta != null) {
            // Devuelve los mensajes asociados a la cuenta
            return cuenta.getMensajes();
        } else {
            // Manejo de error si la cuenta no existe
            throw new EntityNotFoundException("Cuenta no encontrada con ID: " + idCuenta);
        }
    }

    public Cuenta editarCuenta (Integer id, Cuenta cuenta) throws Exception{
        try {
            Optional<Cuenta> cuentaBuscada = this.cuentaRepositorio.findById(id);
            if (cuentaBuscada.isPresent()){
                //  Afiliado afiliadoEditado = this.afiliadoRepositorio.save(afiliado);
                //  return afiliadoEditado;  ESTO CAMBIA todito el afiliado


                //aqui guardas selectivamente lo que quieras de la entidad

                Cuenta cuentaExistente = cuentaBuscada.get();
               // afiliadoExistente.setCorreo(afiliado.getCorreo());  //puedes poner logica con condicionales para que si dejas un valor nulo lo deje como está
              //  afiliadoExistente.setNombre(afiliado.getNombre());
               // afiliadoExistente.setCiudad(afiliado.getCiudad());

                return this.cuentaRepositorio.save(cuentaExistente);

            }else{
                throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
            }
        }catch (Exception error){
            System.out.println(error.getMessage());
            throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
        }
    }

    public Boolean retirarCuenta (Integer id) throws Exception{
        try {
            Boolean cuentaEncontrada = this.cuentaRepositorio.existsById(id);
            if (cuentaEncontrada){
                this.cuentaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
        }
    }
}
