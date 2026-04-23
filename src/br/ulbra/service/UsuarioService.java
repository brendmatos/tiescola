package br.ulbra.service;

import br.ulbra.dao.UsuarioDao;
import br.ulbra.model.Usuario;

import java.util.List;

public class UsuarioService {

    private UsuarioDao dao;

    public UsuarioService(UsuarioDao dao) {
        this.dao = dao;
    }

    public void salvar(Usuario usuario) {

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new RuntimeException("Nome obrigatório");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new RuntimeException("Email obrigatório");
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new RuntimeException("Senha obrigatória");
        }

        dao.salvar(usuario);
    }

    public List<Usuario> listar() {
        return dao.listar();
    }

    public void atualizar(Usuario usuario) {
        dao.atualizar(usuario);
    }

    public void excluir(Long id) {
        dao.excluir(id);
    }

    public Usuario buscar(Long id) {
        return dao.buscarPorId(id);
    }
}
