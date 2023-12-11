package com.example.blackmesaAPI.repositorios;

import com.example.blackmesaAPI.entidades.Bolsillos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolsillosRepositorio extends JpaRepository<Bolsillos, Integer> {
}
