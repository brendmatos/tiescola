
    
package br.ulbra.dao;

import br.ulbra.model.Chamado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;

public class ChamadoDaoImpl implements ChamadoDao {

    @Override
    public void salvar(Chamado chamado) {
        String sql = "INSERT INTO ti_escola (solicitante, sala, equipamento_tag, problema_relatado, diagnostico_tecnico, prioridade, status, data_abertura) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chamado.getSolicitante());
            stmt.setString(2, chamado.getSala());
            stmt.setString(3, chamado.getEquipamentoTag());
            stmt.setString(4, chamado.getProblemaRelatado());
            stmt.setString(5, chamado.getDiagnosticoTecnico());
            stmt.setString(6, chamado.getPrioridade());
            stmt.setString(7, chamado.getStatus());
            stmt.setString(8, chamado.getDataAbertura());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Chamado> listar() {
        String sql = "SELECT * FROM ti_escola";
        List<Chamado> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Chamado c = new Chamado(
                        rs.getLong("id"),
                        rs.getString("solicitante"),
                        rs.getString("sala"),
                        rs.getString("equipamento_tag"),
                        rs.getString("problema_relatado"),
                        rs.getString("diagnostico_tecnico"),
                        rs.getString("prioridade"),
                        rs.getString("status"),
                        rs.getString("data_abertura")
                );
                lista.add(c);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        }

        return lista;
    }

    @Override
    public Chamado buscarPorId(Long id) {
        String sql = "SELECT * FROM ti_escola WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Chamado(
                        rs.getLong("id"),
                        rs.getString("solicitante"),
                        rs.getString("sala"),
                        rs.getString("equipamento_tag"),
                        rs.getString("problema_relatado"),
                        rs.getString("diagnostico_tecnico"),
                        rs.getString("prioridade"),
                        rs.getString("status"),
                        rs.getString("data_abertura")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void atualizar(Chamado chamado) {
        String sql = "UPDATE ti_escola SET solicitante=?, sala=?, equipamento_tag=?, problema_relatado=?, diagnostico_tecnico=?, prioridade=?, status=?, data_abertura=? WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chamado.getSolicitante());
            stmt.setString(2, chamado.getSala());
            stmt.setString(3, chamado.getEquipamentoTag());
            stmt.setString(4, chamado.getProblemaRelatado());
            stmt.setString(5, chamado.getDiagnosticoTecnico());
            stmt.setString(6, chamado.getPrioridade());
            stmt.setString(7, chamado.getStatus());
            stmt.setString(8, chamado.getDataAbertura());
            stmt.setLong(9, chamado.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(Long id) {
        String sql = "DELETE FROM ti_escola WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}