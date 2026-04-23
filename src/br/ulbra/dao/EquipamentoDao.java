package br.ulbra.dao;

import br.ulbra.model.Equipamento;
import java.util.List;

public interface EquipamentoDao {

    void salvar(Equipamento equipamento);

    List<Equipamento> listar();

    Equipamento buscarPorId(Long id);

    void atualizar(Equipamento equipamento);

    void excluir(Long id);
}