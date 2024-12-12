package com.planta.plantacao.controller;

import com.planta.plantacao.model.PlantaModel;
import com.planta.plantacao.service.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plantas")
public class PlantaController {

    // Aqui a gente injeta o serviço que vai lidar com as plantas
    @Autowired
    private PlantaService plantaService;

    // Criando uma nova planta
    @PostMapping
    public ResponseEntity<PlantaModel> criarPlanta(@RequestBody PlantaModel planta) {
        // Verifica se a planta está ok (se o nome não está vazio)
        if (planta == null || planta.getNome() == null || planta.getNome().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Se não tiver nome, manda 400
        }

        // Salva a planta no banco
        PlantaModel novaPlanta = plantaService.salvar(planta);

        // Retorna a planta salva com o status 201 e um cabeçalho "Location" com o link para o novo recurso
        return ResponseEntity.status(HttpStatus.CREATED)
                             .header("Location", "/plantas/" + novaPlanta.getId())
                             .body(novaPlanta);
    }

    // Listando todas as plantas
    @GetMapping
    public ResponseEntity<List<PlantaModel>> listarPlantas() {
        // Pega todas as plantas que tem no banco
        List<PlantaModel> plantas = plantaService.listarTodas();

        // Se não tiver planta nenhuma, retorna 204 (sem conteúdo)
        if (plantas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Se tiver plantas, manda elas de volta com status 200
        return ResponseEntity.ok(plantas);
    }

    // Buscando uma planta pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<PlantaModel> buscarPlanta(@PathVariable Long id) {
        // Tenta encontrar a planta pelo ID
        Optional<PlantaModel> planta = plantaService.buscarPorId(id);
        
        // Se a planta existir, retorna ela com status 200
        if (planta.isPresent()) {
            return ResponseEntity.ok(planta.get()); // Retorna a planta encontrada
        } else {
            // Se não achar a planta, manda 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Atualizando uma planta que já existe
    @PutMapping("/{id}")
    public ResponseEntity<PlantaModel> atualizarPlanta(@PathVariable Long id, @RequestBody PlantaModel planta) {
        // Verifica se a planta tem um nome válido
        if (planta == null || planta.getNome() == null || planta.getNome().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Se o nome for inválido, manda 400
        }

        // Procura a planta no banco usando o ID
        Optional<PlantaModel> plantaExistente = plantaService.buscarPorId(id);
        if (plantaExistente.isPresent()) {
            // Se encontrar a planta, atualiza o ID dela e salva de novo
            planta.setId(id); // Atualiza o ID da planta
            PlantaModel plantaAtualizada = plantaService.salvar(planta);
            return ResponseEntity.ok(plantaAtualizada); // Retorna a planta atualizada
        }

        // Se não achar a planta, manda 404
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Deletando uma planta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPlanta(@PathVariable Long id) {
        // Verifica se a planta com o ID existe
        Optional<PlantaModel> plantaExistente = plantaService.buscarPorId(id);
        if (plantaExistente.isPresent()) {
            // Se existir, deleta ela e retorna 204 (sem conteúdo)
            plantaService.deletar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        // Se não encontrar, manda 404
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
