package com.example.blackmesaAPI.repositorios;

import com.example.blackmesaAPI.entidades.MensajeGPT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<MensajeGPT, Long> {
    // Puedes agregar métodos de consulta personalizados si es necesario
}

