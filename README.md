# 🕹**️Pokemon Game**🕹️

# ![N|Solid](https://i.imgur.com/QhKlmsK.png) **Gotta Catch 'em All!** ![N|Solid](https://i.imgur.com/QhKlmsK.png)


# 💖  **What is PokeGame?** 💖
-------------------------
>PokeGame is a pokemon card game with nuances of the anime itself or turn-based fighting games.
In this game you can select more than 700 different Pokémon to fight in a 1 versus 1 against another player. 
This has a single battle window in which the selected Pokémon are displayed on Pokémon cards. In the Player versus Player window you can select what type of attack to use (Physical or Special), but be careful because the elements exist! and water will quickly put out the flames of any fire type pokemon.

>After each player selects the attack, the ready button will be pressed, which will evaluate which Pokémon will attack first according to the speed of each one.
Remember that you can also change the current Pokémon for any other on your team, but there is a change limit! , if you spend your changes you will not be able to change more times in that game.
If you have doubts about the statistics of any pokemon, simply leave your mouse over the image of the pokemon and you will obtain valuable information.

>At the end of the fight, the winner will be shown and it will be decided if we want to play another game or exit the game.
--------------------------------------
# 🚓  **RULES** 🚓
- >**Select your avatar and name.**
- >**Choose your pokemons (Max 5).**
![N|Solid](https://i.gyazo.com/6c57889916d815caac360a275ca50a9e.png)
- >**Wait to the other player selections.**
- >**💥Start the figth.💥**
![N|Solid](https://i.gyazo.com/d22c258b2536cb207a05119d4b4a2292.png)
- >**🏆Be the Winner!🏆**
![N|Solid](https://i.gyazo.com/d5d373a71d3601d2774a9760b2642faa.png)

# 💾 **REQUERIMENTS** 💾
- >☕ **Java necesary.**
- >☕ **Java Swing**
- >☕ **Java verseion 17 recommended (It may work with lower versions but causes problems).**
- >☕ **Necesary library (lombok).**

#  👨‍💻 **Tech** 👨‍💻
- > ☕ **Dependencies like Lombok.**
- > ☕ **Maven Project**
- > ☕ **Java Swing**
- > ☕ **IDE: Apache NetBeans and Eclipse.**

# 💻 **Development** 💻
>**PokemonGame is based on java swing, to achieve other animations Threads are used to obtain this effect**.
>**The game is basically made up of**:
- **Pokemon Class**
 >Stores all the information about each Pokémon and provides useful information about them, such as obtaining their images, names, etc.
- **Application Class**
>Stores much of the game's logic, such as preloading each Pokémon's data from a file.
- **Launcher class**
>Run and launch the application.
- **PokemonGameIntro class:**
>A java swing window (JPanel) that has a background and a button to start the game.
- **PlayerOneSelection class:**
>A very important class, this is in charge of selecting player one's name, sprite, pokemons and more.
- **PlayerTwoSelection class:**
>It basically does the same thing as PlayerOneSelection but in this case for player two.
- **PlayerVersusPlayer class:**
>This stores all the battle between players, such as the pokemons currently in battle, the changes, the display and much more. Additionally, this class is supported by two secondary classes to show the Pokémon that each player defeats.
- **PlayerOneKills class:**
>A class for a background that stores Pokémon defeated by player one.
- **PlayerTwoKills class:**
>A class for a background that stores pokemons defeated by player two.
- **EndOfParty class:**
>This class shows the winner of the fight and gives you the option to restart a game or exit the game.

# 🎁🎃 **EXTRA** 🎃 🎁
>There is the option to save the state of a game during a fight which can be loaded almost from any point in the application at any time.

# ✨ **LICENSE**✨    
>Project carried out by David Martinez Flores and Manuel Belmonte Oliva

🕵 [️David Martinez Flores](https://github.com/DavidMartinezFlores)
🕵️ [Manuel Belmonte Oliva](https://github.com/zanux02)
