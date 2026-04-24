package br.ulbra.dao;

import br.ulbra.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            String senhaCriptografada = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
            stmt.setString(3, senhaCriptografada);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com segurança!");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> listar() {
        String sql = "SELECT * FROM usuarios ORDER BY nome";
        List<Usuario> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                lista.add(u);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar usuários: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    u.setSenha(rs.getString("senha"));
                    return u;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar usuário: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            String senhaCriptografada = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
            stmt.setString(3, senhaCriptografada);

            // CORREÇÃO IMPORTANTE (faltava isso)

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar: " + e.getMessage());
        }
    }

    @Override
    public void excluir(Long id) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário removido!");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir usuário: " + e.getMessage());
        }
    }

    // MÉTODO EXTRA (não está na interface, mas pode continuar)
    public Usuario logar(String email, String senhaDigitada) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String senhaBanco = rs.getString("senha");

                    if (BCrypt.checkpw(senhaDigitada, senhaBanco)) {
                        Usuario u = new Usuario();
                        u.setNome(rs.getString("nome"));
                        u.setEmail(rs.getString("email"));
                        return u;
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro no login: " + e.getMessage());
        }

        return null;
    }
}