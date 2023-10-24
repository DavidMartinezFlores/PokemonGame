package es.iesjandula.pokemon_game;

/**
 * @author David Martinez
 *
 */
public class Launcher
{
	/**
	 * Method main
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Launcher launcher = new Launcher();
		launcher.run(args);
	}

	/**
	 * Method run
	 * 
	 * @param args
	 */
	private void run(String[] args)
	{
		// PlayerOneSelection playerOneSelection = new PlayerOneSelection();
		// playerOneSelection.setVisible(true);
		PokemonGameIntro gameIntro = new PokemonGameIntro();
		gameIntro.setVisible(true);
	}
}
