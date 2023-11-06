package es.iesjandula.pokemon_game;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

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
		//---USING NIMBUS LOOK FOR JAVA SWING---
		try
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (Exception exception)
		{
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}
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
