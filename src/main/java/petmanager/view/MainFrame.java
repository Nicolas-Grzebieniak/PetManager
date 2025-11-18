package petmanager.view;

import petmanager.model.Animal;
import petmanager.service.ArquivoService;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    // Lista global de animais
    public static ArrayList<Animal> listaAnimais = new ArrayList<>();

    public MainFrame() {
        setTitle("Pet Manager");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ---------- TÍTULO ----------
        JLabel titulo = new JLabel("Pet Manager", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JButton btnCadastro = new JButton("Cadastrar Animal");
        JButton btnListar = new JButton("Listar Animais");
        JButton btnSalvar = new JButton("Salvar Dados");
        JButton btnCarregar = new JButton("Carregar Dados");

        Dimension btnSize = new Dimension(200, 40);
        btnCadastro.setPreferredSize(btnSize);
        btnListar.setPreferredSize(btnSize);
        btnSalvar.setPreferredSize(btnSize);
        btnCarregar.setPreferredSize(btnSize);

        painelBotoes.add(btnCadastro);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(btnListar);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(btnSalvar);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(btnCarregar);

        add(painelBotoes, BorderLayout.CENTER);

        // ---------- AÇÕES ----------

        btnCadastro.addActionListener(e ->
                new CadastroFrame(listaAnimais).setVisible(true)
        );

        btnListar.addActionListener(e ->
                new petmanager.view.ListaFrame(listaAnimais).setVisible(true)
        );

        btnSalvar.addActionListener(e -> {
            try {
                ArquivoService.salvarAnimais(listaAnimais);
                JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
            }
        });

        btnCarregar.addActionListener(e -> {
            try {
                ArrayList<Animal> carregados = ArquivoService.carregarAnimais();

                listaAnimais.clear();
                listaAnimais.addAll(carregados);

                JOptionPane.showMessageDialog(this, "Dados carregados com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar: " + ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
