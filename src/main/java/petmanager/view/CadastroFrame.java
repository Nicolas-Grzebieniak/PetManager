package petmanager.view;

import petmanager.model.Animal;
import petmanager.model.Cachorro;
import petmanager.model.Gato;
import petmanager.Exception.CadastroService;
import petmanager.Exception.PetInvalidoException;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CadastroFrame extends JFrame {

    private List<Animal> listaAnimais;

    private JTextField txtNome;
    private JTextField txtIdade;
    private JComboBox<String> comboTipo;

    private JTextField txtRaca;
    private JCheckBox checkVacinado;

    private JTextField txtCorPelo;
    private JCheckBox checkCastrado;

    private JTextArea txtObservacoes; // NOVO CAMPO

    public CadastroFrame(List<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;  // RECEBE LISTA DO MAINFRAME

        setTitle("Cadastro de Animais");
        setSize(400, 450);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2, 5, 5));
        add(panel);

        // Campos básicos
        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        panel.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        panel.add(txtIdade);

        panel.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"Cachorro", "Gato"});
        panel.add(comboTipo);

        // Campos Cachorro
        panel.add(new JLabel("Raça:"));
        txtRaca = new JTextField();
        panel.add(txtRaca);

        checkVacinado = new JCheckBox("Vacinado");
        panel.add(checkVacinado);
        panel.add(new JLabel("")); // espaço

        // Campos Gato
        panel.add(new JLabel("Cor do Pelo:"));
        txtCorPelo = new JTextField();
        panel.add(txtCorPelo);

        checkCastrado = new JCheckBox("Castrado");
        panel.add(checkCastrado);
        panel.add(new JLabel("")); // espaço

        // Novo campo Observações
        panel.add(new JLabel("Observações:"));
        txtObservacoes = new JTextArea(3, 20);
        panel.add(new JScrollPane(txtObservacoes));

        JButton btnCadastrar = new JButton("Cadastrar");
        panel.add(btnCadastrar);

        JButton btnVoltar = new JButton("Voltar");
        panel.add(btnVoltar);

        btnCadastrar.addActionListener(e -> cadastrarAnimal());
        btnVoltar.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void cadastrarAnimal() {
        try {
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            String tipo = (String) comboTipo.getSelectedItem();
            String observacoes = txtObservacoes.getText(); // pega observações

            if (tipo.equals("Cachorro")) {
                String raca = txtRaca.getText();
                boolean vacinado = checkVacinado.isSelected();

                Cachorro cachorro = CadastroService.criarCachorro(nome, idade, raca, vacinado, observacoes);
                listaAnimais.add(cachorro);

                JOptionPane.showMessageDialog(this, "Cachorro cadastrado com sucesso!");

            } else {
                String corPelo = txtCorPelo.getText();
                boolean castrado = checkCastrado.isSelected();

                Gato gato = CadastroService.criarGato(nome, idade, corPelo, castrado, observacoes);
                listaAnimais.add(gato);

                JOptionPane.showMessageDialog(this, "Gato cadastrado com sucesso!");
            }

            limparCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade precisa ser um número inteiro.");
        } catch (PetInvalidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtIdade.setText("");
        txtRaca.setText("");
        txtCorPelo.setText("");
        checkVacinado.setSelected(false);
        checkCastrado.setSelected(false);
        txtObservacoes.setText("");
    }
}
