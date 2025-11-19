package petmanager.view;

import petmanager.model.Animal;
import petmanager.model.Cachorro;
import petmanager.model.Gato;
import petmanager.service.CadastroService; // <-- Verifique se este é o pacote correto!
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

    private JTextArea txtObservacoes;

    private JPanel painelPrincipal;

    public CadastroFrame(List<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;

        setTitle("Cadastro de Animais");
        setSize(500, 550);
        setLocationRelativeTo(null);

        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(12, 2, 5, 5));

        JScrollPane scrollFrame = new JScrollPane(painelPrincipal);
        scrollFrame.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollFrame, BorderLayout.CENTER);

        // Campos básicos
        painelPrincipal.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelPrincipal.add(txtNome);

        painelPrincipal.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        painelPrincipal.add(txtIdade);

        painelPrincipal.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"Cachorro", "Gato"});
        painelPrincipal.add(comboTipo);

        // Campos de Raça e Cor/Pelo
        painelPrincipal.add(new JLabel("Raça:"));
        txtRaca = new JTextField();
        painelPrincipal.add(txtRaca);

        painelPrincipal.add(new JLabel("Cor do Pelo:"));
        txtCorPelo = new JTextField();
        painelPrincipal.add(txtCorPelo);

        // Checkboxes
        checkVacinado = new JCheckBox("Vacinado");
        painelPrincipal.add(checkVacinado);
        painelPrincipal.add(new JLabel(""));

        checkCastrado = new JCheckBox("Castrado");
        painelPrincipal.add(checkCastrado);
        painelPrincipal.add(new JLabel(""));

        // Campo Observações
        painelPrincipal.add(new JLabel("Observações:"));
        txtObservacoes = new JTextArea(3, 20);
        painelPrincipal.add(new JScrollPane(txtObservacoes));

        JButton btnCadastrar = new JButton("Cadastrar");
        painelPrincipal.add(btnCadastrar);

        JButton btnVoltar = new JButton("Voltar");
        painelPrincipal.add(btnVoltar);

        btnCadastrar.addActionListener(e -> cadastrarAnimal());
        btnVoltar.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void cadastrarAnimal() {
        try {
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            String tipo = (String) comboTipo.getSelectedItem();
            String observacoes = txtObservacoes.getText();

            String corPeloGeral = txtCorPelo.getText();
            boolean castradoGeral = checkCastrado.isSelected();
            boolean vacinadoGeral = checkVacinado.isSelected();

            if (tipo.equals("Cachorro")) {
                String raca = txtRaca.getText();

                // 7 Argumentos
                Cachorro cachorro = CadastroService.criarCachorro(
                        nome, idade, raca, vacinadoGeral, castradoGeral, corPeloGeral, observacoes
                );
                listaAnimais.add(cachorro);

                JOptionPane.showMessageDialog(this, "Cachorro cadastrado com sucesso!");

            } else { // Gato

                // 6 Argumentos
                Gato gato = CadastroService.criarGato(
                        nome, idade, corPeloGeral, castradoGeral, vacinadoGeral, observacoes
                );
                listaAnimais.add(gato);

                JOptionPane.showMessageDialog(this, "Gato cadastrado com sucesso!");
            }

            limparCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade precisa ser um número inteiro.");
        } catch (PetInvalidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro no cadastro. Verifique a sincronização de argumentos.", "Erro Fatal", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
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