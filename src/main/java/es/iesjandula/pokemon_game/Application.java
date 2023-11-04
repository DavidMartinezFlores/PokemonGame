package es.iesjandula.pokemon_game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.iesjandula.pokemon_game.models.Pokemon;
import es.iesjandula.pokemon_game.utils.Constants;
import es.iesjandula.pokemon_game.utils.PokemonException;
import lombok.Data;

/**
 * @author David Martinez
 *
 */
@Data
public class Application
{
	/** Attribute logger*/
	private static final Logger logger = LogManager.getLogger();
	
	/** Attribute player1PokemonList */
	private List<Pokemon> PokemonList;

	/**
	 * Constructor for create new Application
	 * @throws PokemonException 
	 */
	public Application()
	{
		try
		{
			this.PokemonList = this.loadPokemonData();
		}
		catch (PokemonException exception)
		{
			String error = "An Error Ocurred on the application loading data";
			logger.error(error,exception);
		}
	}

	/**
	 * Method saveState
	 * 
	 * @param party
	 */
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
		catch (IOException exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			this.saveStateCloseAll(fileOutputStream, objectOutputStream);
		}
	}

	/**
	 * Method saveStateCloseAll
	 *
	 * @param fileOutputStream
	 * @param objectOutputStream
	 */
	private void saveStateCloseAll(FileOutputStream fileOutputStream, ObjectOutputStream objectOutputStream)
	{
		if (objectOutputStream != null)
		{
			try
			{
				objectOutputStream.close();
			}
			catch (IOException exception)
			{
				exception.printStackTrace();
			}
		}
		if (fileOutputStream != null)
		{
			try
			{
				fileOutputStream.close();
			}
			catch (IOException exception)
			{
				exception.printStackTrace();
			}
		}
	}

	/**
	 * Method loadState
	 *
	 * @return
	 * @throws PokemonException 
	 */
	public List<Object> loadState() throws PokemonException
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
		catch (FileNotFoundException exception)
		{
			exception.printStackTrace();
		}
		catch (IOException exception)
		{
			exception.printStackTrace();
		}
		catch (ClassNotFoundException exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			this.loadStateCloseAll(fileInputStream, objectInputStream);
		}

		return partyList;
	}

	/**
	 * Method loadStateCloseAll
	 *
	 * @param fileInputStream
	 * @param objectInputStream
	 * @throws PokemonException 
	 */
	private void loadStateCloseAll(FileInputStream fileInputStream, ObjectInputStream objectInputStream) throws PokemonException
	{
		if (objectInputStream != null)
		{
			try
			{
				objectInputStream.close();
			}
			catch (IOException exception)
			{
				String error = "In Out Exception";
				logger.error(error,exception);
				throw new PokemonException(error, exception);
			}
		}
		if (fileInputStream != null)
		{
			try
			{
				fileInputStream.close();
			}
			catch (IOException exception)
			{
				String error = "In Out Exception";
				logger.error(error,exception);
				throw new PokemonException(error, exception);
			}
		}
	}

	/**
	 * Method loadPokemonData
	 * 
	 * @return
	 * @throws PokemonException 
	 */
	private List<Pokemon> loadPokemonData() throws PokemonException
	{
		List<Pokemon> pokemonLoadedList = new ArrayList<>();
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
				
				subString = bufferedReader.readLine();
			}

		}
		catch (FileNotFoundException exception)
		{
			String error = "File not found";
			logger.error(error,exception);
			throw new PokemonException(error, exception);
		}
		catch (IOException exception)
		{
			String error = "In Out Exception";
			logger.error(error,exception);
			throw new PokemonException(error, exception);
		}
		finally 
		{
			this.loadDataCloseAll(fileReader, bufferedReader);
		}

		return pokemonLoadedList;
	}

	/**
	 * Method loadDataCloseAll
	 * @param fileReader
	 * @param bufferedReader
	 * @throws PokemonException
	 */
	private void loadDataCloseAll(FileReader fileReader, BufferedReader bufferedReader) throws PokemonException
	{
		if(bufferedReader!=null) 
		{
			try
			{
				bufferedReader.close();
			}
			catch (IOException exception)
			{
				String error = "In Out Exception";
				logger.error(error,exception);
				throw new PokemonException(error, exception);
			}
		}
		if(fileReader!=null) 
		{
			try
			{
				fileReader.close();
			}
			catch (IOException exception)
			{
				String error = "In Out Exception";
				logger.error(error,exception);
				throw new PokemonException(error, exception);
			}
		}
	}
}
