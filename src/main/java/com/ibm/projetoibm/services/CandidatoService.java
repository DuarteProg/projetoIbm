package com.ibm.projetoibm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.projetoibm.repository.CandidatoRepository;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public int iniciarProcesso(String nome) {
        return candidatoRepository.iniciarProcesso(nome);
    }

    public void marcarEntrevista(int codCandidato) {
        candidatoRepository.marcarEntrevista(codCandidato);
    }

    public void desqualificarCandidato(int codCandidato) {
        candidatoRepository.desqualificarCandidato(codCandidato);
    }

    public String verificarStatusCandidato(int codCandidato) {
        return candidatoRepository.verificarStatusCandidato(codCandidato);
    }

    public void aprovarCandidato(int codCandidato) {
        candidatoRepository.aprovarCandidato(codCandidato);
    }

    public List<String> obterAprovados() {
        return candidatoRepository.obterAprovados();
    }
}
