package br.ulbra.service;

import br.ulbra.dao.ChamadoDao;
import br.ulbra.model.Chamado;

import java.util.List;

public class ChamadoService {

    private ChamadoDao dao;

    public ChamadoService(ChamadoDao dao) {
        this.dao = dao;
    }

    public void salvar(Chamado chamado) {

   
        if (chamado.getSolicitante() == null || chamado.getSolicitante().isEmpty()) {
            throw new RuntimeException("Solicitante obrigatório");
        }

        if (chamado.getProblemaRelatado() == null || chamado.getProblemaRelatado().isEmpty()) {
            throw new RuntimeException("Problema relatado obrigatório");
        }

        if (chamado.getPrioridade() == null || chamado.getPrioridade().isEmpty()) {
            throw new RuntimeException("Prioridade obrigatória");
        }

        if (chamado.getStatus() == null || chamado.getStatus().isEmpty()) {
            throw new RuntimeException("Status obrigatório");
        }

        dao.salvar(chamado);
    }

    public List<Chamado> listar() {
        return dao.listar();
    }

    public void atualizar(Chamado chamado) {
        dao.atualizar(chamado);
    }

    public void excluir(Long id) {
        dao.excluir(id);
    }

    public Chamado buscar(Long id) {
        return dao.buscarPorId(id);
    }
}