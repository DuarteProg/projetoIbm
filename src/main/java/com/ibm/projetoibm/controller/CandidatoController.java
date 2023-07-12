package com.ibm.projetoibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.projetoibm.model.Candidato;
import com.ibm.projetoibm.model.DTO.AprovadosDTO;
import com.ibm.projetoibm.services.CandidatoService;
import com.ibm.projetoibm.shared.CandidatoDTO;

@RestController
@RequestMapping("/api/v1/hiring")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping("/start")
    public int iniciarProcesso(@RequestBody AprovadosDTO nome) {
        return candidatoService.iniciarProcesso(nome.nome());
    }

    @PostMapping("/schedule")
    public void marcarEntrevista(@RequestBody CandidatoDTO codCandidatoDTO) {
        int codCandidato = codCandidatoDTO.getCodCandidato();
        candidatoService.marcarEntrevista(codCandidato);
    }

    @PostMapping("/disqualify")
    public void desqualificarCandidato(@RequestBody CandidatoDTO codCandidatoDTO) {
        int codCandidato = codCandidatoDTO.getCodCandidato();
        candidatoService.desqualificarCandidato(codCandidato);
    }

    @PostMapping("/approve")
    public void aprovarCandidato(@RequestBody CandidatoDTO codCandidatoDTO) {
        int codCandidato = codCandidatoDTO.getCodCandidato();
        candidatoService.aprovarCandidato(codCandidato);
    }

    @GetMapping("/status/candidate/{codCandidato}")
    public String verificarStatusCandidato(@PathVariable int codCandidato) {
        return candidatoService.verificarStatusCandidato(codCandidato);
    }

    @GetMapping("/approved")
    public List<Candidato> obterAprovados() {
        List<Candidato> listaAprovados = candidatoService.obterAprovados();
        return listaAprovados;
    }

}
