package com.planta.plantacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planta.plantacao.model.PlantaModel;
import com.planta.plantacao.repository.PlantaRepositor;

@Service
public class PlantaService {

    // A gente injeta o repositório aqui para poder fazer as operações no banco de dados
    @Autowired
    private PlantaRepositor plantaRepositor;

    // Método para salvar uma nova planta ou atualizar uma existente
    public PlantaModel salvar(PlantaModel planta) {
        // O método save do repositório cuida de salvar ou atualizar a planta no banco
        return plantaRepositor.save(planta);
    }

    // Método para listar todas as plantas do banco
    public List<PlantaModel> listarTodas() {
        // O método findAll do repositório vai pegar todas as plantas do banco
        return plantaRepositor.findAll();
    }

    // Método para buscar uma planta pelo ID
    public Optional<PlantaModel> buscarPorId(Long id) {
        // O método findById tenta encontrar a planta pelo ID, e retorna um Optional (pode ser vazio)
        return plantaRepositor.findById(id);
    }

    // Método para deletar uma planta pelo ID
    public void deletar(Long id) {
        // O método deleteById do repositório vai excluir a planta do banco
        plantaRepositor.deleteById(id);
    }
}
