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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	public void saveState(List<Object> party)
	{
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try
		{

			fileOutputStream = new FileOutputStream("partyState.obj");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(party);

		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if (objectOutputStream != null)
			{
				try
				{
					objectOutputStream.close();
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
			if (fileOutputStream != null)
			{
				try
				{
					fileOutputStream.close();
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}

	public List<Object> loadState()
	{
		List<Object> partyList = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		try
		{
			fileInputStream = new FileInputStream("partyState.obj");
			objectInputStream = new ObjectInputStream(fileInputStream);
			partyList = (List<Object>) objectInputStream.readObject();

		}
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if (objectInputStream != null)
			{
				try
				{
					objectInputStream.close();
				}
				catch (IOException ex)
				{
					Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			if (fileInputStream != null)
			{
				try
				{
					fileInputStream.close();
				}
				catch (IOException ex)
				{
					Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}

		return partyList;
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
