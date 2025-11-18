package petmanager.view;
import javax.swing.*;

public class MainFrame extends JFrame{
    public MainFrame() {
        setTitle("Pet Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centraliza na tela

        initComponents();
    }

    private void initComponents(){
        JLabel label = new JLabel("Testeee");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
