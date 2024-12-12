package com.planta.plantacao.dto;

public class PlantaDTO {
    
    // Aqui ficam as informações da planta, que são os dados que a gente vai transferir
    private Long id;        // ID da planta
    private String nome;    // Nome da planta
    private String tipo;    // Tipo da planta (ex: árvore, flor, etc.)
    private String descricao; // Descrição da planta (pode ser um detalhe ou informação adicional)

    // Getters e Setters: Esses métodos são usados para pegar ou alterar os valores das variáveis acima

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
