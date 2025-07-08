package com.planta.monitoramentoifmt.repository; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planta.monitoramentoifmt.model.Planta;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {
}