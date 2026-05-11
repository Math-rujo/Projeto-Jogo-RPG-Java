package projeto_rpg.interface_grafica;
import projeto_rpg.personagens.jogador.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCriarPersonagem extends JFrame{
	
	private Jogador jogadorCriado;
	
	public TelaCriarPersonagem() {
		
		// Configuração da janela
		setTitle("Criar Personagem");
		
		setSize(900, 600);
		
		setLocationRelativeTo(null);
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Painel Principal
		JPanel painel = new JPanel() {
		
			Image imagem = new ImageIcon("src/resources/image/background_Criar_Perso_edit.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				
				// Desenhar fundo
				g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
				
	            // camada escura
	            g.setColor(new Color(0, 0, 0, 150));
	
	            g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		
		painel.setLayout(null);
		
		// Título
        JLabel titulo = new JLabel("CRIAR PERSONAGEM");

        titulo.setBounds(240, 40, 500, 50);

        titulo.setFont(new Font("Serif", Font.BOLD, 42));

        titulo.setForeground(
                new Color(220, 200, 150));

        painel.add(titulo);
        
        // Texto nome
        JLabel textoNome = new JLabel("Nome:");

        textoNome.setBounds(30, 100, 200, 40);

        textoNome.setFont(new Font("Serif", Font.PLAIN, 24));

        textoNome.setForeground(Color.WHITE);

        painel.add(textoNome);
        
        // Campo nome
        JTextField campoNome = new JTextField();

        campoNome.setBounds(120, 110, 220, 38);

        campoNome.setFont(new Font("Serif", Font.PLAIN, 20));

        campoNome.setForeground(new Color(255, 245, 210));

        // fundo amarelo claro medieval
        campoNome.setBackground(new Color(70, 60, 35));

        // cursor
        campoNome.setCaretColor(Color.WHITE);

        // borda arredondada
        campoNome.setBorder(new RoundedBorder(20));

        painel.add(campoNome);
        
        // Texto classe
        JLabel textoClasse = new JLabel("Classe:");

        textoClasse.setBounds(30, 160, 200, 40);

        textoClasse.setFont(new Font("Serif", Font.PLAIN, 24));

        textoClasse.setForeground(Color.WHITE);

        painel.add(textoClasse);

        // Lista de classes
     // Lista de classes
        String[] classes = {
                "Guerreiro",
                "Mago",
                "Arqueiro"
        };

        JComboBox<String> escolhaClasse =
                new JComboBox<>(classes);

        escolhaClasse.setBounds(120, 170, 220, 38);

        escolhaClasse.setFont(
                new Font("Serif", Font.PLAIN, 18));

        escolhaClasse.setForeground(
                new Color(255, 245, 210));

        escolhaClasse.setBackground(
                new Color(70, 60, 35));

        escolhaClasse.setBorder(
                new RoundedBorder(20));

        painel.add(escolhaClasse);
        
     // HP
        JLabel lblHP = new JLabel("HP: 120");

        lblHP.setBounds(50, 300, 200, 30);

        lblHP.setFont(new Font("Arial", Font.BOLD, 22));

        lblHP.setForeground(Color.WHITE);

        painel.add(lblHP);

        // ATK
        JLabel lblAtk = new JLabel("ATK: 18");

        lblAtk.setBounds(50, 340, 200, 30);

        lblAtk.setFont(new Font("Arial", Font.BOLD, 22));

        lblAtk.setForeground(Color.WHITE);

        painel.add(lblAtk);

        // DEF
        JLabel lblDef = new JLabel("DEF: 12");

        lblDef.setBounds(50, 380, 200, 30);

        lblDef.setFont(new Font("Arial", Font.BOLD, 22));

        lblDef.setForeground(Color.WHITE);

        painel.add(lblDef);

     // Área descrição
        JTextArea descricao = new JTextArea();

        descricao.setBounds(50, 420, 350, 120);

        descricao.setFont(new Font("Serif", Font.PLAIN, 20));

        descricao.setForeground(Color.WHITE);

        descricao.setOpaque(false);

        descricao.setEditable(false);

        descricao.setLineWrap(true);

        descricao.setWrapStyleWord(true);

        descricao.setText("Classe balanceada focada em combate.");

        painel.add(descricao);
        
     // Imagem classe
        JLabel imagemClasse = new JLabel();

        imagemClasse.setBounds(500, 170, 220, 300);

        // imagem inicial
        ImageIcon icone = new ImageIcon(getClass().getResource("/resources/image/jogador.png"));

        Image img = icone.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);

        imagemClasse.setIcon(new ImageIcon(img));

        painel.add(imagemClasse);
        
        escolhaClasse.addActionListener(e -> {

            String classeSelecionada =
                    (String) escolhaClasse.getSelectedItem();

            if(classeSelecionada.equals("Guerreiro")) {

                lblHP.setText("HP: 120");
                lblAtk.setText("ATK: 20");
                lblDef.setText("DEF: 15");
                descricao.setText("Especialista em combate corpo a corpo.");
                imagemClasse.setIcon(carregarImagem("/resources/image/guerreiro.png"));
            }

            else if(classeSelecionada.equals("Mago")) {
            	
                lblHP.setText("HP: 70");
                lblAtk.setText("ATK: 40");
                lblDef.setText("DEF: 8");
                descricao.setText("Usuário de magia poderosa.");
                imagemClasse.setIcon(carregarImagem("/resources/image/mago.png"));
            }

            else if(classeSelecionada.equals("Arqueiro")) {

                lblHP.setText("HP: 100");
                lblAtk.setText("ATK: 25");
                lblDef.setText("DEF: 18");
                descricao.setText("Especialista em ataques à distância.");
                imagemClasse.setIcon(carregarImagem("/resources/image/arqueiro.png"));
            }
        });
        
     // Opção criar
        JLabel criar = criarOpcao("CRIAR", 620, 500);

        criar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                String nome = campoNome.getText();

                String classeSelecionada =
                        (String) escolhaClasse.getSelectedItem();

                // validação nome
                if(nome.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite um nome válido!");
                    return;
                }

                // criar personagem
                if(classeSelecionada.equals("Guerreiro")) {
                    jogadorCriado = new Guerreiro(nome);
                }
                else if(classeSelecionada.equals("Mago")) {
                    jogadorCriado = new Mago(nome);
                }

                else if(classeSelecionada.equals("Arqueiro")) {
                    jogadorCriado = new Arqueiro(nome);
                }
                
                JOptionPane.showMessageDialog(null, "Personagem criado com sucesso!");

                // Abrir mapa
                new TelaMapa(jogadorCriado);

                dispose();
            }
        });

        painel.add(criar);
        
     // Opção voltar
        
        JLabel voltar = criarOpcao("VOLTAR", 40, 500);
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
	
	private ImageIcon carregarImagem(String caminho) {
	    ImageIcon icone = new ImageIcon(getClass().getResource(caminho));
	    Image img = icone.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);

	    return new ImageIcon(img);
	}
	
	private class RoundedBorder implements javax.swing.border.Border {

	    private int radius;

	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }

	    @Override
	    public Insets getBorderInsets(Component c) {
	        return new Insets(8, 12, 8, 12);
	    }

	    @Override
	    public boolean isBorderOpaque() {
	        return false;
	    }

	    @Override
	    public void paintBorder(Component c, Graphics g,int x, int y, int width, int height) {
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setColor(new Color(220, 190, 120));
	        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
	    }
	}
	
	private JLabel criarOpcao(String texto, int x, int y) {

	    JLabel label = new JLabel(texto);

	    label.setBounds(x, y, 350, 60);
	    label.setVerticalAlignment(SwingConstants.CENTER);
	    label.setFont(new Font("Serif", Font.PLAIN, 30));
	    label.setForeground(new Color(210, 190, 140));
	    
	    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    label.addMouseListener(new MouseAdapter() {

	        @Override
	        public void mouseEntered(MouseEvent e) {
	            label.setText("► " + texto);
	            label.setForeground(new Color(255, 220, 120));
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            label.setText(texto);
	            label.setForeground( new Color(210, 190, 140));
	        }
	    });

	    return label;
	}
	
}
