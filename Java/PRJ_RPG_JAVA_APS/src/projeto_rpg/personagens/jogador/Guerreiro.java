package projeto_rpg.personagens.jogador;

public class Guerreiro extends Jogador{
		
	public Guerreiro(String nome)
	{
		super(nome, "Guerreiro");
		
		setAtaque(20);
		setDefesa(15);
		setVidaMaxima(120);
		setPontosVida(120);
	}
}
