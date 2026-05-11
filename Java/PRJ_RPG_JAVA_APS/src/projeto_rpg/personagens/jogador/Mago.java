package projeto_rpg.personagens.jogador;

public class Mago extends Jogador{
	
	public Mago(String nome)
	{
		super(nome, "Mago");
		
		setAtaque(40);
		setDefesa(8);
		setVidaMaxima(70);
		setPontosVida(70);
	}
}
