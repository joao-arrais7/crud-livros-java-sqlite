package crud;

import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LivroDAO dao = new LivroDAO();
        dao.criarTabelaSeNaoExistir();

        int opcao = -1;

        while (opcao != 5) {

            String menu = """
                    === CRUD de Livros ===
                    1 - Cadastrar
                    2 - Listar
                    3 - Atualizar
                    4 - Excluir
                    5 - Sair
                    """;

            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opção inválida.");
                continue;
            }

            switch (opcao) {

                case 1 -> {
                    String titulo = JOptionPane.showInputDialog("Título:");
                    String autor = JOptionPane.showInputDialog("Autor:");
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));

                    Livro l = new Livro(titulo, autor, ano, preco);
                    dao.inserir(l);
                }

                case 2 -> {
                    List<Livro> lista = dao.listar();

                    if (lista.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado.");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (Livro l : lista) {
                            sb.append(l).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                }

                case 3 -> {
                    int id = Integer.parseInt(
                            JOptionPane.showInputDialog("ID do livro a atualizar:")
                    );

                    String novoTitulo = JOptionPane.showInputDialog("Novo título:");
                    String novoAutor = JOptionPane.showInputDialog("Novo autor:");
                    int novoAno = Integer.parseInt(JOptionPane.showInputDialog("Novo ano:"));
                    double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Novo preço:"));

                    Livro l = new Livro(novoTitulo, novoAutor, novoAno, novoPreco);
                    l.setId(id);

                    dao.atualizar(l);
                }

                case 4 -> {
                    int id = Integer.parseInt(
                            JOptionPane.showInputDialog("ID do livro a excluir:")
                    );
                    dao.deletar(id);
                }

                case 5 -> {
                    JOptionPane.showMessageDialog(null, "Saindo...");
                }

                default -> {
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            }
        }
    }
}
