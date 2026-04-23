
  package br.ulbra.dao;

import br.ulbra.model.Usuario;
import java.util.List;

public interface UsuarioDao {

    void salvar(Usuario usuario);

    List<Usuario> listar();

    Usuario buscarPorId(Long id);

    void atualizar(Usuario usuario);

    void excluir(Long id);
}
