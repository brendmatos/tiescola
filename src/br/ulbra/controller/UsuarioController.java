package br.ulbra.controller;

import br.ulbra.dao.UsuarioDaoImpl;
import br.ulbra.model.Usuario;
import br.ulbra.service.UsuarioService;

import java.util.List;

public class UsuarioController {

    private UsuarioService service;

    public UsuarioController() {
        this.service = new UsuarioService(new UsuarioDaoImpl());
    }

    public String salvar(String nome, String email, String senha) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            service.salvar(usuario);
            return "Usuário cadastrado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Usuario> listar() {
        return service.listar();
    }

    public String atualizar(Long id, String nome, String email, String senha) {
        try {
            Usuario usuario = new Usuario(id.intValue(), nome, email, senha);

            service.atualizar(usuario);
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

    public Usuario buscar(Long id) {
        return service.buscar(id);
    }
}