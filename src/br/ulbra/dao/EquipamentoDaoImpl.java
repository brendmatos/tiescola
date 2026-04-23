package br.ulbra.dao;

import br.ulbra.model.Equipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EquipamentoDaoImpl implements EquipamentoDao {

    @Override
    public void salvar(Equipamento equipamento) {
        String sql = "INSERT INTO equipamentos (tag_patrimonio, sala) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getTag_patrimonio());
            stmt.setString(2, equipamento.getSala());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Equipamento> listar() {
        String sql = "SELECT * FROM equipamentos";
        List<Equipamento> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipamento e = new Equipamento(
                        rs.getInt("id_equipamento"),
                        rs.getString("tag_patrimonio"),
                        rs.getString("sala")
                );
                lista.add(e);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public Equipamento buscarPorId(Long id) {
        String sql = "SELECT * FROM equipamentos WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Equipamento(
                        rs.getInt("id_equipamento"),
                        rs.getString("tag_patrimonio"),
                        rs.getString("sala")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void atualizar(Equipamento equipamento) {
        String sql = "UPDATE equipamentos SET tag_patrimonio=?, sala=? WHERE id_equipamento=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getTag_patrimonio());
            stmt.setString(2, equipamento.getSala());
            stmt.setInt(3, equipamento.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(Long id) {
        String sql = "DELETE FROM equipamentos WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}