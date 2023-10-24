package es.iesjandula.pokemon_game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import es.iesjandula.pokemon_game.utils.Constants;
import lombok.Data;
import es.iesjandula.pokemon_game.models.Pokemon;

/**
 * @author David Martinez
 *
 */
@Data
public class Application
{
	/** Attribute player1PokemonList */
	private List<Pokemon> PokemonList;

	public Application()
	{
		this.PokemonList = this.loadPokemonData();
	}

	private List<Pokemon> loadPokemonData()
	{
		List<Pokemon> pokemonLoadedList = new ArrayList<Pokemon>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try
		{
			fileReader = new FileReader(Constants.DATA_LOAD_POKEMON);
			bufferedReader = new BufferedReader(fileReader);

			// READ 2 TIMES , FOR SKIP THE HEADERS
			String subString = subString = bufferedReader.readLine();
			subString = bufferedReader.readLine();

			while (subString != null)
			{
				String[] subStringArray = subString.split(",");
				Pokemon loadedPoke = new Pokemon(Integer.parseInt(subStringArray[0]), subStringArray[1],
						subStringArray[2], subStringArray[3], Double.parseDouble(subStringArray[4]),
						Double.parseDouble(subStringArray[5]), Double.parseDouble(subStringArray[6]),
						Double.parseDouble(subStringArray[7]), Double.parseDouble(subStringArray[8]),
						Double.parseDouble(subStringArray[9]), Double.parseDouble(subStringArray[10]),
						Integer.parseInt(subStringArray[11]), Boolean.parseBoolean(subStringArray[12]));
				pokemonLoadedList.add(loadedPoke);
				// System.out.println(loadedPoke);
				subString = bufferedReader.readLine();
			}

		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pokemonLoadedList;
	}
}
