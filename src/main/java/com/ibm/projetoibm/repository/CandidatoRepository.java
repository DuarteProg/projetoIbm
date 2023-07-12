package com.ibm.projetoibm.repository;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ibm.projetoibm.model.Candidato;
import com.ibm.projetoibm.model.exception.ResourceConflictException;
import com.ibm.projetoibm.model.exception.ResourceNotFoundException;

@Repository
public class CandidatoRepository {

    private List<Candidato> candidatos = new ArrayList<Candidato>();
    private Integer ultimoId = 0;

    public int iniciarProcesso(String nome) {
        boolean candidatoExistente = candidatos.stream()
                .anyMatch(candidato -> candidato.getNome().equals(nome));

        if (candidatoExistente) {
            throw new ResourceConflictException("Já existe um candidato com o mesmo nome");
        }

        int id = ++ultimoId;
        Candidato candidato = new Candidato(id, nome, "Recebido");
        candidatos.add(candidato);

        return id;
    }

    public void marcarEntrevista(int codCandidato) {
        Optional<Candidato> candidato = candidatos.stream()
                .filter(produto -> produto.getId() == codCandidato)
                .findFirst();

        if (!candidato.isPresent()) {
            throw new ResourceNotFoundException("Candidato não encontrado");
        }
        candidato.orElseThrow().setStatus("Qualificado");
    }

    public void desqualificarCandidato(int codCandidato) {
        Optional<Candidato> candidatoOptional = candidatos.stream()
                .filter(candidato -> candidato.getId() == codCandidato)
                .findFirst();

        if (!candidatoOptional.isPresent()) {
            throw new ResourceNotFoundException("Candidato não encontrado");
        }

        candidatos.removeIf(candidato -> candidato.getId() == codCandidato);
    }

    public String verificarStatusCandidato(int codCandidato) {

        Optional<Candidato> candidato = candidatos.stream()
                .filter(produto -> produto.getId() == codCandidato)
                .findFirst();

        return candidato.orElseThrow().getStatus();
    }

    public void aprovarCandidato(int codCandidato) {

        Optional<Candidato> candidato = candidatos.stream()
                .filter(produto -> produto.getId() == codCandidato)
                .findFirst();

        if (!candidato.isPresent()) {
            throw new ResourceNotFoundException("Candidato não encontrado");
        }

        candidato.orElseThrow().setStatus("Aprovado");
    }

    public List<Candidato> obterAprovados() {

        List<Candidato> candidatosAprovados = new ArrayList<>();
        for (Candidato candidato : candidatos) {
            if (candidato.getStatus().equals("Aprovado")) {
                candidatosAprovados.add(candidato);
            }
        }
        return candidatosAprovados;
    }
}
