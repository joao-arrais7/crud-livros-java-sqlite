package crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    // Cria tabela se não existir
    public void criarTabelaSeNaoExistir() {
        String sql = """
            CREATE TABLE IF NOT EXISTS livros (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo TEXT,
                autor TEXT,
                ano INTEGER,
                preco REAL
            );
        """;

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    // Inserir livro
    public void inserir(Livro l) {
        String sql = "INSERT INTO livros (titulo, autor, ano, preco) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setInt(3, l.getAno());
            ps.setDouble(4, l.getPreco());
            ps.executeUpdate();

            System.out.println("Livro cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir livro: " + e.getMessage());
        }
    }

    // Listar livros
    public List<Livro> listar() {
        List<Livro> lista = new ArrayList<>();
        String sql = "SELECT id, titulo, autor, ano, preco FROM livros";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Livro l = new Livro();
                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setAno(rs.getInt("ano"));
                l.setPreco(rs.getDouble("preco"));
                lista.add(l);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }

        return lista;
    }

    // Atualizar livro
    public void atualizar(Livro l) {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, ano = ?, preco = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setInt(3, l.getAno());
            ps.setDouble(4, l.getPreco());
            ps.setInt(5, l.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Livro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum livro encontrado com esse ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar livro: " + e.getMessage());
        }
    }

    // Deletar livro
    public void deletar(int id) {
        String sql = "DELETE FROM livros WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Livro excluído com sucesso!");
            } else {
                System.out.println("Nenhum livro encontrado com esse ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir livro: " + e.getMessage());
        }
    }
}
