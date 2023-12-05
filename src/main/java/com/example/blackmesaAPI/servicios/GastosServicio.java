package com.example.blackmesaAPI.servicios;

import com.example.blackmesaAPI.entidades.Gastos;
import com.example.blackmesaAPI.repositorios.GastosRepositorio;
import com.example.blackmesaAPI.servicios.utilities.Msj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastosServicio {

    @Autowired
    GastosRepositorio gastosRepositorio;

    public Gastos registrarGasto(Gastos gastos) throws Exception{

        try{
            return this.gastosRepositorio.save(gastos);
        }catch(Exception error){
            throw new Exception(Msj.ERROR_REGISTRO.getMensaje());
        }

    }

    public Gastos consultargasto(Integer idgasto) throws Exception{
        try {
            Optional<Gastos> gastoBuscado = this.gastosRepositorio.findById(idgasto);
            if(gastoBuscado.isPresent()){
                return gastoBuscado.get();
            }else {
                throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
        }
    }

    public List<Gastos> buscarTodosLosGastos() throws Exception{
        try{
            List<Gastos> listaConsultada = this.gastosRepositorio.findAll();
            return listaConsultada;
        }catch (Exception error){
            throw new Exception(Msj.ERROR_NO_ENCUENTRA.getMensaje());
        }
    }


}
