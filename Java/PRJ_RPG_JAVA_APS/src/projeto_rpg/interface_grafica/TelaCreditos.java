package projeto_rpg.interface_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCreditos extends JFrame {

    public TelaCreditos() {

        setTitle("Créditos");

        setSize(700, 600);

        setLocationRelativeTo(null);

        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel() {

            Image imagem = new ImageIcon(
                    getClass().getResource(
                    "/resources/image/background_credito_edit.png"))
                    .getImage();

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                g.drawImage(imagem, 0, 0,
                        getWidth(), getHeight(), this);

                g.setColor(new Color(0, 0, 0, 170));

                g.fillRect(0, 0, getWidth(), getHeight());

                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                // Sombra
                g2.setFont(new Font("Serif", Font.BOLD, 42));

                g2.setColor(Color.BLACK);

                g2.drawString("CRÉDITOS", 203, 83);

                // Título
                g2.setColor(new Color(220, 200, 150));

                g2.drawString("CRÉDITOS", 200, 80);
            }
        };

        painel.setLayout(null);

        // Texto créditos
        JTextArea texto = new JTextArea();

        texto.setText(
                "RPG EM JAVA\n\n" +

                "Desenvolvido por:\n" +
                "- Matheus Araujo\n" +
                "- Ryan Mondini\n\n" +

                "Projeto desenvolvido utilizando Java\n" +
                "e Java Swing.\n\n" +

                "Recursos utilizados:\n" +
                "- Java 21\n" +
                "- Eclipse IDE\n" +
                "- Java Swing\n\n" +

                "Obrigado por jogar!"
        );

        texto.setBounds(120, 95, 450, 400);

        texto.setFont(new Font("Serif", Font.PLAIN, 18));

        texto.setForeground(new Color(230, 220, 190));

        texto.setEditable(false);

        texto.setOpaque(false);

        painel.add(texto);

        // Opção voltar
        JLabel voltar = criarOpcao("VOLTAR", 280, 500);

        voltar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                dispose();
            }
        });

        painel.add(voltar);

        add(painel);

        setVisible(true);
    }

    // Criar opção
    private JLabel criarOpcao(String texto, int x, int y) {

        JLabel label = new JLabel(texto);

        label.setBounds(x, y, 300, 50);

        label.setFont(new Font("Serif", Font.PLAIN, 30));

        label.setForeground(
                new Color(210, 190, 140));

        label.setCursor(
                new Cursor(Cursor.HAND_CURSOR));

        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                label.setText("► " + texto);

                label.setForeground(
                        new Color(255, 220, 120));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                label.setText(texto);

                label.setForeground(
                        new Color(210, 190, 140));
            }
        });

        return label;
    }
}