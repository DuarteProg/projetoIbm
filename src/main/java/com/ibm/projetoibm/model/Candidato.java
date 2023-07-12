package com.ibm.projetoibm.model;

import java.lang.Override;

public class Candidato {

    // #region Atributos
    private Integer id;

    private String nome;

    private String status;
    // #endregion

    // #region Contrutor
    public Candidato(Integer id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }
    // #endregion

    // #region Getters e Setters
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
    // #endregion

    @Override
    public String toString() {
        return "Id" + id + "Nome" + nome + "Status" + status;
    }

}