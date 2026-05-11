package projeto_rpg.interface_grafica;

import javax.swing.*;
import projeto_rpg.personagens.jogador.Jogador;
import projeto_rpg.personagens.inimigo.Inimigo;

public class TelaBatalha extends JFrame {

    private Jogador jogador;
    private Inimigo inimigo;

    public TelaBatalha(Jogador jogador, Inimigo inimigo) {

        this.jogador = jogador;
        this.inimigo = inimigo;

        setTitle("Batalha");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
    }
}