package com.ibm.projetoibm.model.DTO;

public class CandidatoDTO {
    private Integer id;
    private String nome;
    private String status;

    // Construtor
    public CandidatoDTO(Integer id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

