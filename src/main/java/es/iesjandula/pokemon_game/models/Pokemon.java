package es.iesjandula.pokemon_game.models;

import java.awt.Image;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author David Martinez
 *
 */
@Data
@AllArgsConstructor
public class Pokemon implements Serializable
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

	private double maxHeatlh;

	/** Attribute weaknessTypes */
	private List<String> weaknessTypes;

	/** Attribute resistantTypes */
	private List<String> resistantTypes;

	/** Attribute typeAdvantages */
	private Map<String, List<List<String>>> typeAdvantages;

	/**
	 * Constructor for create new Pokemon
	 * @param pokedexNumber
	 * @param name
	 * @param type
	 * @param typeTwo
	 * @param total
	 * @param health
	 * @param attack
	 * @param defense
	 * @param spAttack
	 * @param spDefense
	 * @param speed
	 * @param generation
	 * @param legendary
	 */
	public Pokemon(int pokedexNumber, String name, String type, String typeTwo, double total, double health,
			double attack, double defense, double spAttack, double spDefense, double speed, int generation,
			boolean legendary)
	{
		this.pokedexNumber = pokedexNumber;
		this.name = name;
		this.type = type;
		this.typeTwo = typeTwo;
		this.total = total;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		this.generation = generation;
		this.legendary = legendary;
		this.maxHeatlh = this.health;
		this.typeAdvantages = this.getTypesAdvantagesProcess();
		this.weaknessTypes = this.getWeaknessTypesProcess();
		this.resistantTypes = this.getResistantTypesProcess();
	}

	/**
	 * Method getTypesAdvantagesProcess
	 * @return
	 */
	private Map<String, List<List<String>>> getTypesAdvantagesProcess()
	{
		Map<String, List<List<String>>> typeAdvantages = new HashMap<>();

		// The HashMap with type advantages (weakness list ,resistances list)
		typeAdvantages.put("Normal", List.of(List.of("Fighting"), List.of()));
		typeAdvantages.put("Fighting",
				List.of(List.of("Flying", "Psychic", "Fairy"), List.of("Normal", "Rock", "Steel", "Ice", "Dark")));
		typeAdvantages.put("Flying", List.of(List.of("Electric", "Ice", "Rock"), List.of("Fighting", "Bug", "Grass")));
		typeAdvantages.put("Poison", List.of(List.of("Ground", "Psychic"), List.of("Grass", "Fairy")));
		typeAdvantages.put("Ground",
				List.of(List.of("Water", "Ice", "Grass"), List.of("Poison", "Rock", "Fire", "Electric", "Steel")));
		typeAdvantages.put("Rock", List.of(List.of("Water", "Grass", "Fighting", "Ground", "Steel"),
				List.of("Flying", "Bug", "Fire", "Ice")));
		typeAdvantages.put("Bug", List.of(List.of("Fire", "Flying", "Rock"), List.of("Grass", "Psychic", "Dark")));
		typeAdvantages.put("Ghost", List.of(List.of("Ghost", "Psychic"), List.of()));
		typeAdvantages.put("Steel", List.of(List.of("Fire", "Fighting", "Ground"), List.of("Rock", "Ice", "Fairy")));
		typeAdvantages.put("Fire",
				List.of(List.of("Water", "Rock", "Ground"), List.of("Bug", "Steel", "Grass", "Ice")));
		typeAdvantages.put("Water", List.of(List.of("Electric", "Grass"), List.of("Fire", "Ground", "Rock")));
		typeAdvantages.put("Grass",
				List.of(List.of("Fire", "Ice", "Poison", "Flying", "Bug"), List.of("Water", "Ground", "Rock")));
		typeAdvantages.put("Electric", List.of(List.of("Ground"), List.of("Water", "Flying")));
		typeAdvantages.put("Psychic", List.of(List.of("Bug", "Ghost", "Dark"), List.of("Fighting", "Poison")));
		typeAdvantages.put("Ice",
				List.of(List.of("Fighting", "Rock", "Steel", "Fire"), List.of("Flying", "Ground", "Grass", "Dragon")));
		typeAdvantages.put("Dragon", List.of(List.of("Ice", "Dragon", "Fairy"), List.of("Dragon")));
		typeAdvantages.put("Dark", List.of(List.of("Fighting", "Bug", "Fairy"), List.of("Ghost", "Psychic")));
		typeAdvantages.put("Fairy", List.of(List.of("Steel", "Poison"), List.of("Fighting", "Dragon", "Dark")));
		return typeAdvantages;
	}

	/**
	 * Method getResistantTypesProcess
	 * 
	 * @return
	 */
	private List<String> getResistantTypesProcess()
	{
		List<String> resistancesList = new ArrayList<String>();

		resistancesList.addAll(this.typeAdvantages.get(this.type).get(1));

		return resistancesList;
	}

	/**
	 * Method getWeaknessTypesProcess
	 * 
	 * @return
	 */
	private List<String> getWeaknessTypesProcess()
	{
		List<String> weaknessList = new ArrayList<String>();

		weaknessList.addAll(this.typeAdvantages.get(this.type).get(0));

		return weaknessList;
	}

	/**
	 * Method getPokeImage
	 * @return
	 */
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

	/**
	 * Method toString
	 * @return
	 */
	@Override
	public String toString()
	{
		return " Pokedex Nº: " + this.getPokedexNumber() + " " + this.getName() + " - " + this.getType() + " "
				+ this.getTypeTwo() + " - ";
	}
}