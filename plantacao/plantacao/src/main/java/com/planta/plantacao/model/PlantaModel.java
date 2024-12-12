package com.planta.plantacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlantaModel {

    // Aqui usamos a anotação @Id para dizer que esse campo é o identificador único da planta
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O ID vai ser gerado automaticamente pelo banco
    private Long id; // ID da planta, que é único para cada uma

    private String nome;     // Nome da planta (ex: Rosa, Cacto, etc.)
    private String tipo;     // Tipo de planta (ex: flor, árvore, etc.)
    private String descricao; // Descrição da planta (detalhes sobre como ela é ou o que ela faz)

    // Getters e Setters: Esses métodos são usados para acessar e alterar os valores das variáveis acima

    public Long getId() {
        return id; // Retorna o ID da planta
    }

    public void setId(Long id) {
        this.id = id; // Altera o ID da planta
    }

    public String getNome() {
        return nome; // Retorna o nome da planta
    }

    public void setNome(String nome) {
        this.nome = nome; // Altera o nome da planta
    }

    public String getTipo() {
        return tipo; // Retorna o tipo da planta
    }

    public void setTipo(String tipo) {
        this.tipo = tipo; // Altera o tipo da planta
    }

    public String getDescricao() {
        return descricao; // Retorna a descrição da planta
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao; // Altera a descrição da planta
    }
}
