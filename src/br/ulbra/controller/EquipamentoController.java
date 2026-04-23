package br.ulbra.controller;

import br.ulbra.dao.EquipamentoDaoImpl;
import br.ulbra.model.Equipamento;
import br.ulbra.service.EquipamentoService;

import java.util.List;

public class EquipamentoController {

    private EquipamentoService service;

    public EquipamentoController() {
        this.service = new EquipamentoService(new EquipamentoDaoImpl());
    }

    public String salvar( String tagPatrimonio, String sala) {
        try {
            Equipamento equipamento = new Equipamento();
            
            equipamento.setTag_patrimonio(tagPatrimonio);
            equipamento.setSala(sala);

            service.salvar(equipamento);
            return "Equipamento cadastrado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Equipamento> listar() {
        return service.listar();
    }

    public String atualizar(String tagPatrimonio, String sala) {
        try {
            Equipamento equipamento = new Equipamento();
           
            equipamento.setTag_patrimonio(tagPatrimonio);
            equipamento.setSala(sala);

            service.atualizar(equipamento);
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

    public Equipamento buscar(Long id) {
        return service.buscar(id);
    }
}