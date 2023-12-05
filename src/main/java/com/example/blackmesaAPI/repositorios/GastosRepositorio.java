package com.example.blackmesaAPI.repositorios;

import com.example.blackmesaAPI.entidades.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastosRepositorio extends JpaRepository<Gastos, Integer> {
}
