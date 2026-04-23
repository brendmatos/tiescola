package br.ulbra.service;

import br.ulbra.dao.EquipamentoDao;
import br.ulbra.model.Equipamento;

import java.util.List;

public class EquipamentoService {

    private EquipamentoDao dao;

    public EquipamentoService(EquipamentoDao dao) {
        this.dao = dao;
    }

    public void salvar(Equipamento equipamento) {

        if (equipamento.getTag_patrimonio() == null || equipamento.getTag_patrimonio().isEmpty()) {
            throw new RuntimeException("Tag do patrimônio obrigatória");
        }

        if (equipamento.getSala() == null || equipamento.getSala().isEmpty()) {
            throw new RuntimeException("Sala obrigatória");
        }

        dao.salvar(equipamento);
    }

    public List<Equipamento> listar() {
        return dao.listar();
    }

    public void atualizar(Equipamento equipamento) {
        dao.atualizar(equipamento);
    }

    public void excluir(Long id) {
        dao.excluir(id);
    }

    public Equipamento buscar(Long id) {
        return dao.buscarPorId(id);
    }
}