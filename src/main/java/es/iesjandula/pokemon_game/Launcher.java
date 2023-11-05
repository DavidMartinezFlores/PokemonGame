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
		// ---CREATE A NEW LAUNCHER OBJECT----
		Launcher launcher = new Launcher();

		// ---LAUNCH THE RUN METHOD----
		launcher.run(args);
	}

	/**
	 * Method run
	 *
	 * @param args
	 */
	private void run(String[] args)
	{
		// ---CREATE AND SET VISIBLE THE GAME INTRO----
		PokemonGameIntro gameIntro = new PokemonGameIntro();
		gameIntro.setVisible(true);
	}
}
