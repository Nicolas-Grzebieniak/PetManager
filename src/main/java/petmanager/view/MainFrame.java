package petmanager.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import service.ArquivoService;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Pet Manager");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centraliza
        setLayout(new BorderLayout());

        // ---------- TÍTULO ----------
        JLabel titulo = new JLabel("Pet Manager", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        // Painel para os botões com layout vertical
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // ---------- BOTÕES ----------
        JButton btnCadastro = new JButton("Cadastrar Animal");
        JButton btnListar = new JButton("Listar Animais");
        JButton btnSalvar = new JButton("Salvar Dados");
        JButton btnCarregar = new JButton("Carregar Dados");

        // Ajustar tamanho dos botões
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

        // ---------- AÇÕES DOS BOTÕES ----------
        btnCadastro.addActionListener(e -> new petmanager.ui.CadastroFrame().setVisible(true));
        btnListar.addActionListener(e -> new ListaFrame().setVisible(true));

        btnSalvar.addActionListener(e -> {
            try {
                ArquivoService.salvar();
                JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
            }
        });

        btnCarregar.addActionListener(e -> {
            try {
                ArquivoService.carregar();
                JOptionPane.showMessageDialog(this, "Dados carregados!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar: " + ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}

