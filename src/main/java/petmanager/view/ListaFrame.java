package petmanager.view;

import petmanager.model.Animal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListaFrame extends JFrame {

    private JTextArea txtLista;
    private ArrayList<Animal> animais;

    public ListaFrame() {
        this.animais = animais;

        setTitle("Lista de Animais");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        txtLista = new JTextArea();
        txtLista.setEditable(false);
        txtLista.setFont(new Font("Arial", Font.PLAIN, 14));
        add(new JScrollPane(txtLista), BorderLayout.CENTER);

        JButton btnAtualizar = new JButton("Atualizar Lista");
        btnAtualizar.addActionListener(e -> atualizarLista());

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnFechar);

        add(painelBotoes, BorderLayout.SOUTH);

        atualizarLista(); // carregar lista ao abrir
    }

    private void atualizarLista() {
        txtLista.setText("");

        if (animais.isEmpty()) {
            txtLista.setText("Nenhum animal cadastrado.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Animal a : animais) {
            sb.append(a.toString()).append("\n");
        }

        txtLista.setText(sb.toString());
    }
}

