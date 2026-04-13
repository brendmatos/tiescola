
    package br.ulbra.controller;

import br.ulbra.model.Chamado;
import br.ulbra.service.ChamadoService;

import java.sql.Timestamp;
import java.util.List;

public class ChamadoController {

    private final ChamadoService service;

    public ChamadoController(ChamadoService service) {
        this.service = service;
    }


    public void salvar(String solicitante, String sala, String equipamentoTag,
                       String problemaRelatado, String diagnosticoTecnico,
                       String prioridade, String status) {

        Chamado chamado = new Chamado();

        chamado.setSolicitante(solicitante);
        chamado.setSala(sala);
        chamado.setEquipamentoTag(equipamentoTag);
        chamado.setProblemaRelatado(problemaRelatado);
        chamado.setDiagnosticoTecnico(diagnosticoTecnico);
        chamado.setPrioridade(prioridade);
        chamado.setStatus(status);

        
        chamado.setDataAbertura(new Timestamp(System.currentTimeMillis()));

        service.salvar(chamado);
    }

   
    public List<Chamado> listar() {
        return service.listar();
    }

   
    public void atualizar(Long id, String solicitante, String sala,
                          String equipamentoTag, String problemaRelatado,
                          String diagnosticoTecnico, String prioridade,
                          String status, Timestamp dataAbertura) {

        Chamado chamado = new Chamado(
                id,
                solicitante,
                sala,
                equipamentoTag,
                problemaRelatado,
                diagnosticoTecnico,
                prioridade,
                status,
                dataAbertura
        );

        service.atualizar(chamado);
    }

   
    public void excluir(Long id) {
        service.excluir(id);
    }

 
    public Chamado buscar(Long id) {
        return service.buscar(id);
    }
}

