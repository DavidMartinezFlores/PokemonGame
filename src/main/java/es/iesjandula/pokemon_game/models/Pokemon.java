package es.iesjandula.pokemon_game.models;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author David Martinez
 *
 */
@Data
@AllArgsConstructor
public class Pokemon
{
	/** Attribute pokedexNumber */
	private int pokedexNumber;

	/** Attribute name */
	private String name;

	/** Attribute type */
	private String type;

	/** Attribute typeTwo */
	private String typeTwo;

	/** Attribute total */
	private double total;

	/** Attribute health */
	private double health;

	/** Attribute attack */
	private double attack;

	/** Attribute defense */
	private double defense;

	/** Attribute spAttack */
	private double spAttack;

	/** Attribute spDefense */
	private double spDefense;

	/** Attribute speed */
	private double speed;

	/** Attribute generation */
	private int generation;

	/** Attribute legendary */
	private boolean legendary;

	public Image getPokeImage()
	{
		File imageResource = new File("./images/");
		String path = "";
		Image image = new ImageIcon("./images/0.png").getImage();

		for (File imageTmp : imageResource.listFiles())
		{
			if (imageTmp.getName().startsWith(String.valueOf(this.pokedexNumber)))
			{
				image = new ImageIcon(imageTmp.getAbsolutePath()).getImage();
				break;
			}
		}
		return image;
		// image = new ImageIcon("./images/generic.png").getImage();
	}

	@Override
	public String toString()
	{
		return " Pokedex Nº: " + this.getPokedexNumber() + " " + this.getName() + " - " + this.getType() + " "
				+ this.getTypeTwo() + " - ";
	}
}
