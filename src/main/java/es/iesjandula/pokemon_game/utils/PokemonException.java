package es.iesjandula.pokemon_game.utils;

public class PokemonException extends Exception
{
	public PokemonException(String error, Exception exception) 
	{
		super(error,exception);
	}
}
