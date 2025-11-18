package petmanager.view;

import petmanager.model.Animal;
import petmanager.model.Cachorro;
import petmanager.model.Gato;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListaFrame extends JFrame {

    private List<Animal> listaAnimais;
    private DefaultTableModel model;

    public ListaFrame(List<Animal> listaAnimais) {

        this.listaAnimais = listaAnimais;

        setTitle("Lista de Animais Cadastrados");
        setSize(950, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] colunas = {
                "Nome", "Idade", "Tipo",
                "Raça", "Cor/Pelo",
                "Vacinado", "Castrado",
                "Observações"
        };

        model = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);

        add(scrollPane, BorderLayout.CENTER);

        // ---------------- BOTÃO ATUALIZAR ----------------
        JButton btnAtualizar = new JButton("Atualizar Lista");
        btnAtualizar.addActionListener(e -> atualizarTabela());

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnAtualizar);

        add(painelBotoes, BorderLayout.SOUTH);

        atualizarTabela(); // carrega ao abrir
    }

    // ---------------- MÉTODO PARA RECARREGAR TABELA ----------------
    private void atualizarTabela() {

        model.setRowCount(0); // limpa tabela

        for (Animal animal : listaAnimais) {

            String tipo = animal instanceof Cachorro ? "Cachorro" : "Gato";

            String raca = "-";
            String corPelo = "-";
            String vacinado = "-";
            String castrado = "-";
            String observacoes = animal.getObservacoes();

            if (animal instanceof Cachorro c) {
                raca = c.getRaca();
                vacinado = c.isVacinado() ? "Sim" : "Não";
            }

            if (animal instanceof Gato g) {
                corPelo = g.getCorPelo();
                castrado = g.isCastrado() ? "Sim" : "Não";
            }

            model.addRow(new Object[]{
                    animal.getNome(),
                    animal.getIdade(),
                    tipo,
                    raca,
                    corPelo,
                    vacinado,
                    castrado,
                    observacoes
            });
        }
    }
}
