package projeto_rpg.personagens.jogador;

public class Arqueiro extends Jogador{
	
	public Arqueiro(String nome)
	{
		super(nome, "Arqueiro");
		
		setAtaque(25);
		setDefesa(18);
		setVidaMaxima(100);
		setPontosVida(100);
	}
}
