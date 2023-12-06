package com.example.blackmesaAPI.repositorios;


import com.example.blackmesaAPI.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepositorio extends JpaRepository<Cuenta, Integer> {
}
