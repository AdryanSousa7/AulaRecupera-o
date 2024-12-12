package com.planta.plantacao.repository;

import com.planta.plantacao.model.PlantaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantaRepositor extends JpaRepository<PlantaModel, Long> {
    // O JpaRepository já faz a maior parte do trabalho para a gente,
    // então não precisamos escrever código para as operações básicas no banco (como salvar, buscar, deletar, etc).
    // Ele vai lidar com tudo isso automaticamente para a nossa classe PlantaModel, usando o tipo Long como ID.
}
