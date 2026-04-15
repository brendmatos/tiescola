
    package br.ulbra.controller;

import br.ulbra.dao.ChamadoDaoImpl;
import br.ulbra.model.Chamado;
import br.ulbra.service.ChamadoService;

import java.sql.Timestamp;
import java.util.List;

public class ChamadoController {

     private ChamadoService service;

    public ChamadoController() {
        this.service = new ChamadoService(new ChamadoDaoImpl());
    }

    public String salvar(String solicitante, String sala,
                   String equipamentoTag, String problemaRelatado,
                   String diagnosticoTecnico, String prioridade,
                   String status, String dataAbertura) {
        try {
            Chamado chamado = new Chamado();
            chamado.setSolicitante(solicitante);
            chamado.setSala(sala);
            chamado.setEquipamentoTag(equipamentoTag);
            chamado.setProblemaRelatado(problemaRelatado);
            chamado.setDiagnosticoTecnico(diagnosticoTecnico);
            chamado.setPrioridade(prioridade);
            chamado.setStatus(status);
            chamado.setDataAbertura(dataAbertura);

            service.salvar(chamado);
            return "Usuário cadastrado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Chamado> listar() {
        return service.listar();
    }

    public String atualizar(Long id, String solicitante, String sala,
                   String equipamentoTag, String problemaRelatado,
                   String diagnosticoTecnico, String prioridade,
                   String status, String dataAbertura) {
        try {
            Chamado chamado = new Chamado(id, solicitante,  sala,
                    equipamentoTag,  problemaRelatado,
                   diagnosticoTecnico,  prioridade,
                   status, dataAbertura );
            service.atualizar(chamado);
            return "Atualizado com sucesso";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public String excluir(Long id) {
        try {
            service.excluir(id);
            return "Deletado com sucesso";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

}

