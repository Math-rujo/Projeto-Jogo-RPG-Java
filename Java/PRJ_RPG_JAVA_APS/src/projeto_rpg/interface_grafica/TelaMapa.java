package projeto_rpg.interface_grafica;

import projeto_rpg.personagens.jogador.Jogador;
import javax.swing.*;

public class TelaMapa extends JFrame {

    private Jogador jogador;

    public TelaMapa(Jogador jogador) {

        this.jogador = jogador;

        setTitle("Mapa RPG");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adiciona painel do jogo
        add(new PainelMapa(jogador));

        setVisible(true);
    }
}