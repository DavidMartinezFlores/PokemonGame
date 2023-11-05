/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.iesjandula.pokemon_game;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.iesjandula.pokemon_game.models.Pokemon;
import es.iesjandula.pokemon_game.utils.PokemonException;

/**
 *
 * @author David Martinez Flores
 */
public class PlayerVersusPlayer extends javax.swing.JFrame implements Serializable
{
	/** Attribute screenSize */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	/** Attribute logger */
	private static final Logger logger = LogManager.getLogger();

	/** Attribute playerOneKillsList */
	private List<Pokemon> playerOneKillsList;
	/** Attribute playerOneKills */
	private PlayerOneKills playerOneKills;

	private List<Pokemon> playerTwoKillsList;
	private PlayerTwoKills playerTwoKills;

	/** Attribute mainTheme */
	private Clip mainTheme;

	/** Attribute playerOneName */
	private String playerOneName;
	/** Attribute playerTwoName */
	private String playerTwoName;

	/** Attribute playerOneSelection */
	private PlayerOneSelection playerOneSelection;
	/** Attribute playerTwoSelection */
	private PlayerTwoSelection playerTwoSelection;

	/** Attribute listPlayerOne */
	private DefaultListModel<Pokemon> listPlayerOne = new DefaultListModel<>();
	/** Attribute listPlayerTwo */
	private DefaultListModel<Pokemon> listPlayerTwo = new DefaultListModel<>();

	/** Attribute iconPlayer1 */
	private ImageIcon iconPlayer1;
	/** Attribute iconPlayer2 */
	private ImageIcon iconPlayer2;

	/** Attribute currentPlayerOnePokemon */
	private Pokemon currentPlayerOnePokemon;
	/** Attribute currentPlayerTwoPokemon */
	private Pokemon currentPlayerTwoPokemon;

	/** Attribute playerOneChanges */
	private int playerOneChanges;
	/** Attribute playerTwoChanges */
	private int playerTwoChanges;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel SpriteSelectedPlayerOne;
	private javax.swing.JLabel SpriteSelectedPlayerTwo;
	private javax.swing.ButtonGroup buttonGroupPlayer1;
	private javax.swing.ButtonGroup buttonGroupPlayer2;
	private javax.swing.JButton jButtonChangePokemonPlayerOne;
	private javax.swing.JButton jButtonChangePokemonPlayerTwo;
	private javax.swing.JButton jButtonReady;
	private javax.swing.JLabel jLabelBackground;
	private javax.swing.JLabel jLabelCurrentPlayerOnePokemonName;
	private javax.swing.JLabel jLabelGameVersion;
	private javax.swing.JLabel jLabelPlayerOneCardImage;
	private javax.swing.JLabel jLabelPlayerOneChanges;
	private javax.swing.JLabel jLabelPlayerOneHealth;
	private javax.swing.JLabel jLabelPlayerOneName;
	private javax.swing.JLabel jLabelPlayerTwoCardImage;
	private javax.swing.JLabel jLabelPlayerTwoChanges;
	private javax.swing.JLabel jLabelPlayerTwoHealth;
	private javax.swing.JLabel jLabelPlayerTwoName;
	private javax.swing.JLabel jLabelPokeball;
	private javax.swing.JLabel jLabelPokemonPlayerOne;
	private javax.swing.JLabel jLabelPokemonPlayerTwo;
	private javax.swing.JLabel jLabelVersus;
	private javax.swing.JLabel jLabeljLabelCurrentPlayerTwoPokemonName;
	private javax.swing.JList<Pokemon> jListPlayerOne;
	private javax.swing.JList<Pokemon> jListPlayerTwo;
	private javax.swing.JMenu jMenu;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItemLoadState;
	private javax.swing.JMenuItem jMenuItemSaveState;
	private javax.swing.JProgressBar jProgressBarPlayerOne;
	private javax.swing.JProgressBar jProgressBarPlayerTwo;
	private javax.swing.JRadioButton jRadioButtonPlayerOnePhysicalAttack;
	private javax.swing.JRadioButton jRadioButtonPlayerOneSpecialAttack;
	private javax.swing.JRadioButton jRadioButtonPlayerTwoPhysicalAttack;
	private javax.swing.JRadioButton jRadioButtonPlayerTwoSpecialAttack;
	private javax.swing.JScrollPane jScrollPaneOne;
	private javax.swing.JScrollPane jScrollPaneTwo;
	// End of variables declaration//GEN-END:variables

	/**
	 * Creates new form PlayerVersusPlayer
	 *
	 * @param playerTwoSelection
	 */
	public PlayerVersusPlayer(PlayerTwoSelection playerTwoSelection)
	{
		// ---THE ORDER ITS IMPORTANT----
		this.initComponents();
		this.setTitle("Player Versus Player");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./images/pokeball.png"));

		this.playerOneKillsList = new ArrayList<>();
		this.playerOneKills = new PlayerOneKills(this.playerOneKillsList, 0, 0);

		this.playerTwoKillsList = new ArrayList<>();
		this.playerTwoKills = new PlayerTwoKills(this.playerTwoKillsList, this.screenSize.width - 350, 0);

		this.playerOneKills.setVisible(true);
		this.playerTwoKills.setVisible(true);

		this.mainTheme = this.startBattleTheme();
		// --START THE THEME ONLY IF IS NOT NULL--
		if (this.mainTheme != null)
		{
			this.mainTheme.start();
		}
		this.setResizable(false);

		this.playerOneChanges = 8;
		this.playerTwoChanges = 8;

		this.SpriteSelectedPlayerOne
				.setIcon(playerTwoSelection.getPlayerOneSelection().getSpriteSelectedPlayerOne().getIcon());
		this.SpriteSelectedPlayerTwo.setIcon(playerTwoSelection.getSpriteSelectedPlayerTwo().getIcon());

		this.jLabelBackground.setIcon(new ImageIcon("./images/selectionBack.jpg"));
		this.jLabelVersus.setIcon(new ImageIcon("./images/versus.png"));

		this.playerOneSelection = playerTwoSelection.getPlayerOneSelection();
		this.playerTwoSelection = playerTwoSelection;

		this.playerOneName = this.playerOneSelection.getPlayerOneName();
		this.playerTwoName = playerTwoSelection.getPlayerTwoName();

		this.jLabelPlayerOneName.setText(this.playerOneName);
		this.jLabelPlayerTwoName.setText(this.playerTwoName);

		this.listPlayerOne = this.playerOneSelection.getListModel2();
		this.listPlayerTwo = this.playerTwoSelection.getListModel2();

		this.initDefaultGraphics();
	}

	/**
	 * Method initGraphics
	 */
	private void initDefaultGraphics()
	{
		// ---DEFAULT THINGS---
		this.jListPlayerOne.setModel(this.listPlayerOne);
		this.jListPlayerTwo.setModel(this.listPlayerTwo);

		this.iconPlayer1 = new ImageIcon(this.listPlayerOne.get(0).getPokeImage());
		this.iconPlayer2 = new ImageIcon(this.listPlayerTwo.get(0).getPokeImage());

		this.jLabelCurrentPlayerOnePokemonName.setText(this.listPlayerOne.get(0).getName());
		this.jLabeljLabelCurrentPlayerTwoPokemonName.setText(this.listPlayerTwo.get(0).getName());

		this.jLabelPokemonPlayerOne.setIcon(this.iconPlayer1);
		this.jLabelPokemonPlayerTwo.setIcon(this.iconPlayer2);

		this.currentPlayerOnePokemon = this.listPlayerOne.get(0);
		this.currentPlayerTwoPokemon = this.listPlayerTwo.get(0);

		this.jLabelPlayerOneHealth.setText(this.currentPlayerOnePokemon.getHealth() + "");
		this.jLabelPlayerTwoHealth.setText(this.currentPlayerTwoPokemon.getHealth() + "");

		this.setLocationRelativeTo(null);

		this.jLabelPokeball.setIcon(new ImageIcon("./images/pokeball.png"));

		this.rotatePokeballThread();

		this.jumpPlayerOneAnimationThread();
		this.jumpPlayerTwoAnimationThread();

		this.jLabelPlayerOneChanges.setText("Changes: " + this.playerOneChanges);
		this.jLabelPlayerTwoChanges.setText("Changes: " + this.playerTwoChanges);

		this.updateProgressBars();
	}

	/**
	 * Constructor for create new PlayerVersusPlayer
	 *
	 * @param partyList
	 */
	public PlayerVersusPlayer(List<Object> partyList)
	{
		// --THE ORDER ITS IMPORTANT---
		// --THAT CONSTRUCTOR ITS ONLY FOR THE LOAD STATE OPTIONS WITH OBJECT LIST---
		this.initComponents();
		this.mainTheme = this.startBattleTheme();
		if (this.mainTheme != null)
		{
			this.mainTheme.start();
		}
		this.setTitle("Player Versus Player");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./images/pokeball.png"));

		this.setResizable(false);
		this.listPlayerOne = (DefaultListModel<Pokemon>) partyList.get(0);
		this.listPlayerTwo = (DefaultListModel<Pokemon>) partyList.get(1);

		this.jLabelVersus.setIcon(new ImageIcon("./images/versus.png"));
		this.jLabelBackground.setIcon(new ImageIcon("./images/selectionBack.jpg"));

		this.currentPlayerOnePokemon = (Pokemon) partyList.get(2);
		this.currentPlayerTwoPokemon = (Pokemon) partyList.get(3);

		this.iconPlayer1 = new ImageIcon(this.currentPlayerOnePokemon.getPokeImage());
		this.iconPlayer2 = new ImageIcon(this.currentPlayerTwoPokemon.getPokeImage());

		this.playerOneChanges = (int) partyList.get(4);
		this.playerTwoChanges = (int) partyList.get(5);

		this.playerOneName = (String) partyList.get(6);
		this.playerTwoName = (String) partyList.get(7);

		this.SpriteSelectedPlayerOne.setIcon((Icon) partyList.get(8));
		this.SpriteSelectedPlayerTwo.setIcon((Icon) partyList.get(9));

		this.playerOneKillsList = (List<Pokemon>) partyList.get(10);
		this.playerOneKills = new PlayerOneKills(this.playerOneKillsList, 0, 0);
		this.playerOneKills.setVisible(true);

		this.playerTwoKillsList = (List<Pokemon>) partyList.get(11);
		this.playerTwoKills = new PlayerTwoKills(this.playerTwoKillsList, this.screenSize.width - 350, 0);
		this.playerTwoKills.setVisible(true);

		this.jLabelPlayerOneName.setText(this.playerOneName);
		this.jLabelPlayerTwoName.setText(this.playerTwoName);

		this.jListPlayerOne.setModel(this.listPlayerOne);
		this.jListPlayerTwo.setModel(this.listPlayerTwo);

		this.jLabelCurrentPlayerOnePokemonName.setText(this.currentPlayerOnePokemon.getName());
		this.jLabeljLabelCurrentPlayerTwoPokemonName.setText(this.currentPlayerTwoPokemon.getName());

		this.jLabelPokemonPlayerOne.setIcon(this.iconPlayer1);
		this.jLabelPokemonPlayerTwo.setIcon(this.iconPlayer2);

		this.jLabelPlayerOneHealth.setText(this.currentPlayerOnePokemon.getHealth() + "");
		this.jLabelPlayerTwoHealth.setText(this.currentPlayerTwoPokemon.getHealth() + "");

		this.setLocationRelativeTo(null);

		this.jLabelPokeball.setIcon(new ImageIcon("./images/pokeball.png"));

		this.rotatePokeballThread();

		this.jumpPlayerOneAnimationThread();
		this.jumpPlayerTwoAnimationThread();

		this.jLabelPlayerOneHealth
				.setText(String.format("%.2f", Double.parseDouble(this.jLabelPlayerOneHealth.getText())));
		this.jLabelPlayerTwoHealth
				.setText(String.format("%.2f", Double.parseDouble(this.jLabelPlayerTwoHealth.getText())));

		this.jLabelPlayerOneChanges.setText("Changes: " + this.playerOneChanges);
		this.jLabelPlayerTwoChanges.setText("Changes: " + this.playerTwoChanges);

		this.updateProgressBars();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{

		this.buttonGroupPlayer1 = new javax.swing.ButtonGroup();
		this.buttonGroupPlayer2 = new javax.swing.ButtonGroup();
		this.jButtonReady = new javax.swing.JButton();
		this.jScrollPaneOne = new javax.swing.JScrollPane();
		this.jListPlayerOne = new javax.swing.JList<>();
		this.jScrollPaneTwo = new javax.swing.JScrollPane();
		this.jListPlayerTwo = new javax.swing.JList<>();
		this.jLabelPokemonPlayerOne = new javax.swing.JLabel();
		this.jLabelPokemonPlayerTwo = new javax.swing.JLabel();
		this.jLabelVersus = new javax.swing.JLabel();
		this.jLabelPlayerOneHealth = new javax.swing.JLabel();
		this.jLabelPlayerTwoHealth = new javax.swing.JLabel();
		this.jRadioButtonPlayerOnePhysicalAttack = new javax.swing.JRadioButton();
		this.jRadioButtonPlayerOneSpecialAttack = new javax.swing.JRadioButton();
		this.jRadioButtonPlayerTwoPhysicalAttack = new javax.swing.JRadioButton();
		this.jRadioButtonPlayerTwoSpecialAttack = new javax.swing.JRadioButton();
		this.jButtonChangePokemonPlayerOne = new javax.swing.JButton();
		this.jButtonChangePokemonPlayerTwo = new javax.swing.JButton();
		this.jLabelPokeball = new javax.swing.JLabel();
		this.jLabelPlayerOneChanges = new javax.swing.JLabel();
		this.jLabelPlayerTwoChanges = new javax.swing.JLabel();
		this.jProgressBarPlayerOne = new javax.swing.JProgressBar();
		this.jProgressBarPlayerTwo = new javax.swing.JProgressBar();
		this.jLabelPlayerOneName = new javax.swing.JLabel();
		this.jLabelPlayerTwoName = new javax.swing.JLabel();
		this.jLabelCurrentPlayerOnePokemonName = new javax.swing.JLabel();
		this.jLabeljLabelCurrentPlayerTwoPokemonName = new javax.swing.JLabel();
		this.jLabelPlayerTwoCardImage = new javax.swing.JLabel();
		this.jLabelPlayerOneCardImage = new javax.swing.JLabel();
		this.jLabelGameVersion = new javax.swing.JLabel();
		this.SpriteSelectedPlayerOne = new javax.swing.JLabel();
		this.SpriteSelectedPlayerTwo = new javax.swing.JLabel();
		this.jLabelBackground = new javax.swing.JLabel();
		this.jMenuBar1 = new javax.swing.JMenuBar();
		this.jMenu = new javax.swing.JMenu();
		this.jMenuItemSaveState = new javax.swing.JMenuItem();
		this.jMenuItemLoadState = new javax.swing.JMenuItem();

		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		this.jButtonReady.setBackground(new java.awt.Color(0, 204, 51));
		this.jButtonReady.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		this.jButtonReady.setForeground(new java.awt.Color(255, 255, 255));
		this.jButtonReady.setText("READY");
		this.jButtonReady.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		this.jButtonReady.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.jButtonReady.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				PlayerVersusPlayer.this.jButtonReadyMouseClicked(evt);
			}
		});
		this.getContentPane().add(this.jButtonReady, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, 105, 60));

		this.jListPlayerOne.setBackground(new java.awt.Color(200, 252, 255));
		this.jListPlayerOne.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.jListPlayerOne.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				PlayerVersusPlayer.this.jListPlayerOneMouseClicked(evt);
			}
		});
		this.jScrollPaneOne.setViewportView(this.jListPlayerOne);

		this.getContentPane().add(this.jScrollPaneOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 352, -1));

		this.jListPlayerTwo.setBackground(new java.awt.Color(255, 200, 200));
		this.jListPlayerTwo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.jListPlayerTwo.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				PlayerVersusPlayer.this.jListPlayerTwoMouseClicked(evt);
			}
		});
		this.jScrollPaneTwo.setViewportView(this.jListPlayerTwo);

		this.getContentPane().add(this.jScrollPaneTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 359, -1));

		this.jLabelPokemonPlayerOne.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
		this.jLabelPokemonPlayerOne.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				PlayerVersusPlayer.this.jLabelPokemonPlayerOneMouseEntered(evt);
			}
		});
		this.getContentPane().add(this.jLabelPokemonPlayerOne,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, 158));

		this.jLabelPokemonPlayerTwo.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
		this.jLabelPokemonPlayerTwo.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				PlayerVersusPlayer.this.jLabelPokemonPlayerTwoMouseEntered(evt);
			}
		});
		this.getContentPane().add(this.jLabelPokemonPlayerTwo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 150, 150));

		this.jLabelVersus.setText("                ");
		this.getContentPane().add(this.jLabelVersus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 98, 94));

		this.jLabelPlayerOneHealth.setText("jLabel4");
		this.jLabelPlayerOneHealth.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
		this.getContentPane().add(this.jLabelPlayerOneHealth,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

		this.jLabelPlayerTwoHealth.setText("jLabel5");
		this.jLabelPlayerTwoHealth.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
		this.getContentPane().add(this.jLabelPlayerTwoHealth,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, -1, -1));

		this.buttonGroupPlayer1.add(this.jRadioButtonPlayerOnePhysicalAttack);
		this.jRadioButtonPlayerOnePhysicalAttack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		this.jRadioButtonPlayerOnePhysicalAttack.setText("PHYSICAK ATTACK");
		this.jRadioButtonPlayerOnePhysicalAttack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.jRadioButtonPlayerOnePhysicalAttack.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				PlayerVersusPlayer.this.jRadioButtonPlayerOnePhysicalAttackMouseClicked(evt);
			}
		});
		this.getContentPane().add(this.jRadioButtonPlayerOnePhysicalAttack,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, -1, -1));

		this.buttonGroupPlayer1.add(this.jRadioButtonPlayerOneSpecialAttack);
		this.jRadioButtonPlayerOneSpecialAttack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		this.jRadioButtonPlayerOneSpecialAttack.setText("SPECIAL ATTACK");
		this.jRadioButtonPlayerOneSpecialAttack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.jRadioButtonPlayerOneSpecialAttack.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				PlayerVersusPlayer.this.jRadioButtonPlayerOneSpecialAttackMouseClicked(evt);
			}
		});
		this.getContentPane().add(this.jRadioButtonPlayerOneSpecialAttack,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, -1, -1));

		this.buttonGroupPlayer2.add(this.jRadioButtonPlayerTwoPhysicalAttack);
		this.jRadioButtonPlayerTwoPhysicalAttack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		this.jRadioButtonPlayerTwoPhysicalAttack.setText("PHYSICAL ATTACK");
		this.jRadioButtonPlayerTwoPhysicalAttack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.jRadioButtonPlayerTwoPhysicalAttack.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				PlayerVersusPlayer.this.jRadioButtonPlayerTwoPhysicalAttackMouseClicked(evt);
			}
		});
		this.getContentPane().add(this.jRadioButtonPlayerTwoPhysicalAttack,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, -1, -1));

		this.buttonGroupPlayer2.add(this.jRadioButtonPlayerTwoSpecialAttack);
		this.jRadioButtonPlayerTwoSpecialAttack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		this.jRadioButtonPlayerTwoSpecialAttack.setText("SPECIAL ATTACK");
		this.jRadioButtonPlayerTwoSpecialAttack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.jRadioButtonPlayerTwoSpecialAttack.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				PlayerVersusPlayer.this.jRadioButtonPlayerTwoSpecialAttackMouseClicked(evt);
			}
		});
		this.getContentPane().add(this.jRadioButtonPlayerTwoSpecialAttack,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, -1, -1));

		this.jButtonChangePokemonPlayerOne.setBackground(new java.awt.Color(255, 51, 0));
		this.jButtonChangePokemonPlayerOne.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonChangePokemonPlayerOne.setForeground(new java.awt.Color(255, 255, 255));
		this.jButtonChangePokemonPlayerOne.setText("CHANGE SELECTED POKEMON");
		this.jButtonChangePokemonPlayerOne.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.jButtonChangePokemonPlayerOne.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				PlayerVersusPlayer.this.jButtonChangePokemonPlayerOneMouseClicked(evt);
			}
		});
		this.getContentPane().add(this.jButtonChangePokemonPlayerOne,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 250, 29));

		this.jButtonChangePokemonPlayerTwo.setBackground(new java.awt.Color(255, 51, 0));
		this.jButtonChangePokemonPlayerTwo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jButtonChangePokemonPlayerTwo.setForeground(new java.awt.Color(255, 255, 255));
		this.jButtonChangePokemonPlayerTwo.setText("CHANGE SELECTED POKEMON");
		this.jButtonChangePokemonPlayerTwo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.jButtonChangePokemonPlayerTwo.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				PlayerVersusPlayer.this.jButtonChangePokemonPlayerTwoMouseClicked(evt);
			}
		});
		this.getContentPane().add(this.jButtonChangePokemonPlayerTwo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 650, 250, 29));

		this.jLabelPokeball.setText("         ");
		this.getContentPane().add(this.jLabelPokeball, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 105, 114));

		this.jLabelPlayerOneChanges.setBackground(new java.awt.Color(255, 153, 0));
		this.jLabelPlayerOneChanges.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelPlayerOneChanges.setForeground(new java.awt.Color(255, 255, 255));
		this.jLabelPlayerOneChanges.setText("Changes:");
		this.jLabelPlayerOneChanges.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		this.jLabelPlayerOneChanges.setOpaque(true);
		this.getContentPane().add(this.jLabelPlayerOneChanges,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, -1));

		this.jLabelPlayerTwoChanges.setBackground(new java.awt.Color(255, 153, 0));
		this.jLabelPlayerTwoChanges.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		this.jLabelPlayerTwoChanges.setForeground(new java.awt.Color(255, 255, 255));
		this.jLabelPlayerTwoChanges.setText("Changes:");
		this.jLabelPlayerTwoChanges.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		this.jLabelPlayerTwoChanges.setOpaque(true);
		this.getContentPane().add(this.jLabelPlayerTwoChanges,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 560, -1, -1));

		this.jProgressBarPlayerOne.setForeground(new java.awt.Color(0, 204, 0));
		this.jProgressBarPlayerOne.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
		this.getContentPane().add(this.jProgressBarPlayerOne,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 130, 16));

		this.jProgressBarPlayerTwo.setForeground(new java.awt.Color(51, 204, 0));
		this.jProgressBarPlayerTwo.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
		this.getContentPane().add(this.jProgressBarPlayerTwo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 130, 16));

		this.jLabelPlayerOneName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		this.jLabelPlayerOneName.setText("jLabel4");
		this.getContentPane().add(this.jLabelPlayerOneName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 162, 22));

		this.jLabelPlayerTwoName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		this.jLabelPlayerTwoName.setText("jLabel5");
		this.getContentPane().add(this.jLabelPlayerTwoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 162, 22));

		this.jLabelCurrentPlayerOnePokemonName.setText("jLabel6");
		this.jLabelCurrentPlayerOnePokemonName.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
		this.getContentPane().add(this.jLabelCurrentPlayerOnePokemonName,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

		this.jLabeljLabelCurrentPlayerTwoPokemonName.setText("jLabel9");
		this.jLabeljLabelCurrentPlayerTwoPokemonName.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
		this.getContentPane().add(this.jLabeljLabelCurrentPlayerTwoPokemonName,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, -1, -1));

		this.jLabelPlayerTwoCardImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/cards/basicCard.png"))); // NOI18N
		this.jLabelPlayerTwoCardImage.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
		this.getContentPane().add(this.jLabelPlayerTwoCardImage,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

		this.jLabelPlayerOneCardImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/cards/basicCard.png"))); // NOI18N
		this.jLabelPlayerOneCardImage.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
		this.getContentPane().add(this.jLabelPlayerOneCardImage,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

		this.jLabelGameVersion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		this.jLabelGameVersion.setText("       v1.0.0");
		this.getContentPane().add(this.jLabelGameVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 1020, 40));

		this.SpriteSelectedPlayerOne.setText(" ");
		this.getContentPane().add(this.SpriteSelectedPlayerOne,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 90, 160));

		this.SpriteSelectedPlayerTwo.setText(" ");
		this.getContentPane().add(this.SpriteSelectedPlayerTwo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 90, 160));

		this.jLabelBackground.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		this.getContentPane().add(this.jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 740));

		this.jMenu.setText("File");

		this.jMenuItemSaveState.setText("Save State");
		this.jMenuItemSaveState.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				PlayerVersusPlayer.this.jMenuItemSaveStateActionPerformed(evt);
			}
		});
		this.jMenu.add(this.jMenuItemSaveState);

		this.jMenuItemLoadState.setText("Load State");
		this.jMenuItemLoadState.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				PlayerVersusPlayer.this.jMenuItemLoadStateActionPerformed(evt);
			}
		});
		this.jMenu.add(this.jMenuItemLoadState);

		this.jMenuBar1.add(this.jMenu);

		this.setJMenuBar(this.jMenuBar1);

		this.pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Method jMenuItemSaveStateActionPerformed Used for save the party status
	 *
	 * @param evt
	 */
	private void jMenuItemSaveStateActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jMenuItem1ActionPerformed
		// GEN-FIRST:event_jMenuItem1ActionPerformed
		PlayerVersusPlayer.logger.info("GUARDAR ESTADO");
		JOptionPane.showMessageDialog(null, "SAVING STATE!");
		Application application = new Application();

		// ---USING OBJECT LIST TO STORE ALL THE OBJECTS---
		List<Object> partyList = new ArrayList<>();

		partyList.add(this.listPlayerOne);
		partyList.add(this.listPlayerTwo);

		partyList.add(this.currentPlayerOnePokemon);
		partyList.add(this.currentPlayerTwoPokemon);

		partyList.add(this.playerOneChanges);
		partyList.add(this.playerTwoChanges);

		partyList.add(this.playerOneName);
		partyList.add(this.playerTwoName);

		partyList.add(this.SpriteSelectedPlayerOne.getIcon());
		partyList.add(this.SpriteSelectedPlayerTwo.getIcon());

		partyList.add(this.playerOneKillsList);
		partyList.add(this.playerTwoKillsList);

		PlayerVersusPlayer.logger.info(partyList);

		// ---SAVING THE LIST---
		application.saveState(partyList);
	}// GEN-LAST:event_jMenuItem1ActionPerformed

	/**
	 * Method jListPlayerOneMouseClicked Used for the sound on click
	 *
	 * @param evt
	 */
	private void jListPlayerOneMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jList1MouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jList1MouseClicked

	/**
	 * Method jListPlayerTwoMouseClicked Used for the sound on click
	 *
	 * @param evt
	 */
	private void jListPlayerTwoMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jList2MouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jList2MouseClicked

	/**
	 * Method jRadioButtonPlayerOnePhysicalAttackMouseClicked Used for the sound on
	 * click
	 *
	 * @param evt
	 */
	private void jRadioButtonPlayerOnePhysicalAttackMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jRadioButtonPlayerOnePhysicalAttackMouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jRadioButtonPlayerOnePhysicalAttackMouseClicked

	/**
	 * Method jRadioButtonPlayerOneSpecialAttackMouseClicked Used for the sound on
	 * click
	 *
	 * @param evt
	 */
	private void jRadioButtonPlayerOneSpecialAttackMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jRadioButtonPlayerOneSpecialAttackMouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jRadioButtonPlayerOneSpecialAttackMouseClicked

	/**
	 * Method jRadioButtonPlayerTwoPhysicalAttackMouseClicked Used for the sound on
	 * click
	 *
	 * @param evt
	 */
	private void jRadioButtonPlayerTwoPhysicalAttackMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jRadioButtonPlayerTwoPhysicalAttackMouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jRadioButtonPlayerTwoPhysicalAttackMouseClicked

	/**
	 * Method jRadioButtonPlayerTwoSpecialAttackMouseClicked Used for the sound on
	 * click
	 *
	 * @param evt
	 */
	private void jRadioButtonPlayerTwoSpecialAttackMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jRadioButtonPlayerTwoSpecialAttackMouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jRadioButtonPlayerTwoSpecialAttackMouseClicked

	/**
	 * Method jLabelPokemonPlayerOneMouseEntered Used for show the pokemon stats on
	 * Mouse Entered (Player One)
	 *
	 * @param evt
	 */
	private void jLabelPokemonPlayerOneMouseEntered(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jLabel1MouseEntered
		this.jLabelPokemonPlayerOne.setToolTipText("Attack: " + this.currentPlayerOnePokemon.getAttack() + " \n"
				+ "SpAttack: " + this.currentPlayerOnePokemon.getSpAttack() + " \n" + "Defense: "
				+ this.currentPlayerOnePokemon.getDefense() + " \n" + "SpDefense: "
				+ this.currentPlayerOnePokemon.getSpDefense() + " \n");
	}// GEN-LAST:event_jLabel1MouseEntered

	/**
	 * Method jLabelPokemonPlayerTwoMouseEntered Used for show the pokemon stats on
	 * Mouse Entered (Player Two)
	 *
	 * @param evt
	 */
	private void jLabelPokemonPlayerTwoMouseEntered(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jLabel2MouseEntered
		this.jLabelPokemonPlayerTwo.setToolTipText("Attack: " + this.currentPlayerTwoPokemon.getAttack() + " \n"
				+ "SpAttack: " + this.currentPlayerTwoPokemon.getSpAttack() + " \n" + "Defense: "
				+ this.currentPlayerTwoPokemon.getDefense() + " \n" + "SpDefense: "
				+ this.currentPlayerTwoPokemon.getSpDefense() + " \n");
	}// GEN-LAST:event_jLabel2MouseEntered

	/**
	 * Method jMenuItemLoadStateActionPerformed Used for load the state
	 *
	 * @param evt
	 */
	private void jMenuItemLoadStateActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jMenuItem2ActionPerformed

		PlayerVersusPlayer.logger.info("CARGAR ESTADO");
		Application application = new Application();

		// --USING OBJECT LIST FOR STORE ALL THE OBJECTS---
		List<Object> partyList = null;
		try
		{
			partyList = application.loadState();
		}
		catch (PokemonException exception)
		{
			String error = "An error occurred loading state";
			PlayerVersusPlayer.logger.error(error, exception);
		}

		if (partyList != null)
		{
			// ---IF THE LOAD IS COMPLETED , LAUNCH PLAYE VERSUS PLAYER WITH THE LIST AND
			// DISPOSE ALL---
			this.mainTheme.stop();
			PlayerVersusPlayer loadedPlayerVersusPlayer = new PlayerVersusPlayer(partyList);
			loadedPlayerVersusPlayer.setVisible(true);
			PlayerVersusPlayer.logger.info(partyList);

			this.playerOneKills.dispose();
			this.playerTwoKills.dispose();
			this.dispose();

			JOptionPane.showMessageDialog(null, "STATE DATA LOADED!");

		}
		else
		{
			// --SHOW WARNING POP UP
			JOptionPane.showMessageDialog(null, "THE STATE IS CORRUPTED OR DONT EXISTS ANY STATE!");
		}

	}// GEN-LAST:event_jMenuItem2ActionPerformed

	/**
	 * Method playerOneAttack Used for the player one physical attack
	 */
	private void playerOneAttackPhysical()
	{
		// --IF THE PLAYERS HAV MORE THAN 0 POKEMON
		if ((this.listPlayerTwo.size() > 0) && (this.listPlayerOne.size() > 0))
		{
			int position = 0;
			for (int i = 0; i < this.listPlayerTwo.size(); i++)
			{
				if (this.currentPlayerTwoPokemon.equals(this.listPlayerTwo.get(i)))
				{
					position = i;
					break;
				}
			}

			// Possibility for fail the attack
			int randomFalliure = (int) ((Math.random() * 100) + 1);
			if (randomFalliure < 95)
			{
				// Caculate the health
				double health = (this.currentPlayerTwoPokemon.getHealth()
						+ ((this.currentPlayerOnePokemon.getAttack() * -0.4)
								+ (this.currentPlayerTwoPokemon.getDefense() * 0.1)));
				// Calculating the weakness and the resistances
				health = this.playerOneAttackElements(health);
				// Calculating the weakness and the resistances

				health = this.playerOneAttackCritical(health);
				health = health <= 0 ? 0 : health;

				this.currentPlayerTwoPokemon.setHealth(health);
				// Setting the current poke with new values
				this.listPlayerTwo.set(position, this.currentPlayerTwoPokemon);

				// If the poke die, get automaticaly the last poke
				this.playerOneAttackDieNextPokemon(position);
				// Update the health text and repaint the PlayerVersusPlayer
				this.jLabeljLabelCurrentPlayerTwoPokemonName.setText(this.currentPlayerTwoPokemon.getName());

				this.jLabelPlayerTwoHealth.setText(String.format("%.2f", this.currentPlayerTwoPokemon.getHealth()));
				this.repaint();
			}
			else
			{
				JOptionPane.showMessageDialog(null, this.currentPlayerOnePokemon.getName() + " attack FAIL!");
			}

		}
		// --CHECK IF IS END OF PARTY---
		this.checkEndOfParty();
	}

	/**
	 * Method playerOneAttackDieNextPokemon Used for automaticaly change the pokemon
	 * when the last poke die (Player One)
	 *
	 * @param position
	 */
	private void playerOneAttackDieNextPokemon(int position)
	{
		// --IF THE CURRENT POKEMON DIE----
		if ((this.currentPlayerTwoPokemon.getHealth() <= 0)
				&& ((this.listPlayerTwo.size() > 0) && (this.listPlayerOne.size() > 0)))
		{
			// --ADD TO THE PLAYER KILLS AND REMOVE IT---
			this.playerOneKillsList.add(this.currentPlayerTwoPokemon);
			this.listPlayerTwo.remove(position);
			int playerOneKillsX = this.playerOneKills.getX();
			int playerOneKillsY = this.playerOneKills.getY();
			this.playerOneKills.dispose();
			this.playerOneKills = new PlayerOneKills(this.playerOneKillsList, playerOneKillsX, playerOneKillsY);
			this.playerOneKills.setVisible(true);
			if (this.listPlayerTwo.size() > 0)
			{
				// --UPDATE THE CURRENT POKEMON ONLY IF THE PLAYER HAVE MORE THAN 0---
				this.currentPlayerTwoPokemon = this.listPlayerTwo.get(this.listPlayerTwo.size() - 1);
				this.jLabelPokemonPlayerTwo.setIcon(new ImageIcon(this.currentPlayerTwoPokemon.getPokeImage()));
			}
		}
	}

	/**
	 * Method playerOneAttackCritical Used for the player one critical hits
	 *
	 * @param health
	 * @return
	 */
	private double playerOneAttackCritical(double health)
	{
		int critical = (int) ((Math.random() * 100) + 1);
		if (critical >= 90)
		{
			health += (this.currentPlayerTwoPokemon.getMaxHeatlh() * -0.25);
			JOptionPane.showMessageDialog(null, this.currentPlayerOnePokemon.getName() + " Critical hit");
		}
		return health;
	}

	/**
	 * Method playerOneAttackElements Used for calculate the player one attack
	 * elements damage
	 *
	 * @param health
	 * @return
	 */
	private double playerOneAttackElements(double health)
	{
		// --USE A LIST OF WEAKNESS AND OTHER FOR RESISTANCES---
		List<String> playerOneWeakness = this.currentPlayerTwoPokemon.getWeaknessTypes();
		List<String> playerOneResistances = this.currentPlayerTwoPokemon.getResistantTypes();

		// --IF THE TYPE ONE OR TYPE TWO EXIST ON THE ENEMY WAEKNESS, DEALS MORE
		// DAMAGE--
		if (playerOneWeakness.contains(this.currentPlayerOnePokemon.getType()))
		{
			health += (this.currentPlayerTwoPokemon.getMaxHeatlh() * -0.40);
		}
		if (playerOneWeakness.contains(this.currentPlayerOnePokemon.getTypeTwo()))
		{
			health += (this.currentPlayerTwoPokemon.getMaxHeatlh() * -0.40);
		}

		// --IF THE TYPE ONE OR TYPE TWO EXIST ON THE ENEMY RESISTANCES, DEALS LESS
		// DAMAGE--
		if (playerOneResistances.contains(this.currentPlayerOnePokemon.getType()))
		{
			health += (this.currentPlayerTwoPokemon.getMaxHeatlh() * +0.05);
		}
		if (playerOneResistances.contains(this.currentPlayerOnePokemon.getTypeTwo()))
		{
			health += (this.currentPlayerTwoPokemon.getMaxHeatlh() * +0.05);
		}
		return health;
	}

	/**
	 * Method playerOneAttackSpecial Used for the player one special attack
	 */
	private void playerOneAttackSpecial()
	{
		// --IF THE PLAYERS HAV MORE THAN 0 POKEMONS---
		if ((this.listPlayerTwo.size() > 0) && (this.listPlayerOne.size() > 0))
		{
			int position = 0;
			for (int i = 0; i < this.listPlayerTwo.size(); i++)
			{
				if (this.currentPlayerTwoPokemon.equals(this.listPlayerTwo.get(i)))
				{
					position = i;
					break;
				}
			}

			// Possibility for fail the attack
			int randomFalliure = (int) ((Math.random() * 100) + 1);
			if (randomFalliure < 95)
			{
				// Caculate the health
				double health = this.currentPlayerTwoPokemon.getHealth()
						+ ((this.currentPlayerOnePokemon.getSpAttack() * -0.4)
								+ (this.currentPlayerTwoPokemon.getSpDefense() * 0.1));
				health = this.playerOneAttackElements(health);

				health = this.playerOneAttackCritical(health);
				health = health <= 0 ? 0 : health;

				this.currentPlayerTwoPokemon.setHealth(health);
				// Setting the current poke with new values
				this.listPlayerTwo.set(position, this.currentPlayerTwoPokemon);

				this.playerOneAttackDieNextPokemon(position);
				// Update the health text and repaint the PlayerVersusPlayer
				this.jLabeljLabelCurrentPlayerTwoPokemonName.setText(this.currentPlayerTwoPokemon.getName());

				this.jLabelPlayerTwoHealth.setText(String.format("%.2f", this.currentPlayerTwoPokemon.getHealth()));
				this.repaint();
			}
			else
			{
				JOptionPane.showMessageDialog(null, this.currentPlayerOnePokemon.getName() + " attack FAIL!");
			}
		}
		this.checkEndOfParty();
	}

	/**
	 * Method jButtonReadyMouseClicked Used for calculate wich pokemon is the first
	 * on attack
	 *
	 * @param evt
	 */
	private void jButtonReadyMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButtonREADYMouseClicked
		this.selectButtonSound();

		// --USE TWO TEMPORAL POKEMONS---
		Pokemon temporalAttackPlayerOnePoke = this.currentPlayerOnePokemon;
		Pokemon temporalAttackPlayerTwoPoke = this.currentPlayerTwoPokemon;

		// --OPTION FOR EQUAL SPEED---
		if (this.currentPlayerOnePokemon.getSpeed() == this.currentPlayerTwoPokemon.getSpeed())
		{
			this.equalSpeedAttackTurns(temporalAttackPlayerOnePoke, temporalAttackPlayerTwoPoke);
		}
		// --OPTION FOR MORE SPEED ON PLAYER ONE---
		else if (this.currentPlayerOnePokemon.getSpeed() > this.currentPlayerTwoPokemon.getSpeed())
		{
			this.playerOneMoreSpeedTurn(temporalAttackPlayerTwoPoke);
		}
		// --OPTION FOR MORE SPEED ON PLAYER TWO---
		else if (this.currentPlayerOnePokemon.getSpeed() < this.currentPlayerTwoPokemon.getSpeed())
		{
			this.playerTwoMoreSpeedTurn(temporalAttackPlayerOnePoke);
		}

		// --UPDATE THE BARS---
		this.updateProgressBars();

		// --USED FOR CHANGE THE BUTTON POSITION---
		if ((this.listPlayerOne.size() <= 0) || (this.listPlayerTwo.size() <= 0))
		{
			this.readyButtonEndPosition();
		}

	}// GEN-LAST:event_jButtonREADYMouseClicked

	/**
	 * Method updateProgressBars Update the progess bars status
	 */
	private void updateProgressBars()
	{
		this.jProgressBarPlayerOne.setValue(
				(int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
		this.jProgressBarPlayerTwo.setValue(
				(int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
	}

	/**
	 * Method playerTwoMoreSpeedTurn Used for the player two with more speed
	 *
	 * @param temporalAttackPlayerOnePoke
	 */
	private void playerTwoMoreSpeedTurn(Pokemon temporalAttackPlayerOnePoke)
	{
		this.launchPokemonPlayerTwoAnimation();
		PlayerVersusPlayer.logger.info("ATACA EL JUGADOR 2 PRIMERO");

		if (this.currentPlayerTwoPokemon.getHealth() > 0)
		{
			if (this.jRadioButtonPlayerTwoPhysicalAttack.isSelected())
			{
				this.playerTwoAttackPhysical();
			}
			else if (this.jRadioButtonPlayerTwoSpecialAttack.isSelected())
			{
				this.playerTwoAttackSpecial();
			}
		}

		this.launchPokemonPlayerOneAnimation();
		PlayerVersusPlayer.logger.info("ATACA EL JUGADOR 1 SEGUNDO");

		if ((this.listPlayerOne.size() > 0)
				&& this.currentPlayerOnePokemon.getName().equals(temporalAttackPlayerOnePoke.getName()))
		{
			if (this.jRadioButtonPlayerOnePhysicalAttack.isSelected())
			{
				this.playerOneAttackPhysical();
			}
			else if (this.jRadioButtonPlayerOneSpecialAttack.isSelected())
			{
				this.playerOneAttackSpecial();
			}
		}
	}

	/**
	 * Method playerOneMoreSpeedTurn Used for the player One more speed
	 *
	 * @param temporalAttackPlayerTwoPoke
	 */
	private void playerOneMoreSpeedTurn(Pokemon temporalAttackPlayerTwoPoke)
	{
		this.launchPokemonPlayerOneAnimation();
		PlayerVersusPlayer.logger.info("ATACA EL JUGADOR 1 PRIMERO");

		if (this.currentPlayerOnePokemon.getHealth() > 0)
		{
			if (this.jRadioButtonPlayerOnePhysicalAttack.isSelected())
			{
				this.playerOneAttackPhysical();
			}
			else if (this.jRadioButtonPlayerOneSpecialAttack.isSelected())
			{
				this.playerOneAttackSpecial();
			}
		}

		this.launchPokemonPlayerTwoAnimation();
		PlayerVersusPlayer.logger.info("ATACA EL JUGADOR 2 SEGUNDO");

		if ((this.listPlayerTwo.size() > 0)
				&& this.currentPlayerTwoPokemon.getName().equals(temporalAttackPlayerTwoPoke.getName()))
		{
			if (this.jRadioButtonPlayerTwoPhysicalAttack.isSelected())
			{
				this.playerTwoAttackPhysical();
			}
			else if (this.jRadioButtonPlayerTwoSpecialAttack.isSelected())
			{
				this.playerTwoAttackSpecial();
			}
		}
	}

	/**
	 * Method equalSpeedAttackTurns Used for equals speed
	 *
	 * @param temporalAttackPlayerOnePoke
	 * @param temporalAttackPlayerTwoPoke
	 */
	private void equalSpeedAttackTurns(Pokemon temporalAttackPlayerOnePoke, Pokemon temporalAttackPlayerTwoPoke)
	{
		// --USE RANDOM NUMBER FOR TURNS---
		int randomNumber = (int) ((Math.random() * 10) + 1);
		if (randomNumber < 5)
		{
			this.playerOneMoreSpeedTurn(temporalAttackPlayerTwoPoke);
		}
		else
		{
			this.playerTwoMoreSpeedTurn(temporalAttackPlayerOnePoke);
		}

		this.repaint();
	}

	/**
	 * Method startBattleTheme Start the battle theme
	 *
	 * @return
	 */
	private Clip startBattleTheme()
	{
		Clip clip = null;
		try
		{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./audio/battle.wav"));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		}
		catch (IOException exception)
		{
			String error = "IOException";
			PlayerVersusPlayer.logger.error(error, exception);
		}
		catch (LineUnavailableException exception)
		{
			String error = "LineUnavailableException";
			PlayerVersusPlayer.logger.error(error, exception);
		}
		catch (UnsupportedAudioFileException exception)
		{
			String error = "UnsupportedAudioFileException";
			PlayerVersusPlayer.logger.error(error, exception);
		}
		return clip;
	}

	/**
	 * Method readyButtonEndPosition Move the ready button to end position
	 */
	private void readyButtonEndPosition()
	{
		Thread buttonReadyEndPosition = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while (true)
				{
					PlayerVersusPlayer.this.jButtonReady.setLocation(-1000000000, -1000000000);
				}
			}
		});
		buttonReadyEndPosition.start();
	}

	/**
	 * Method launchPokemonPlayerTwoAnimation Used for the player two pokemon
	 * animation
	 */
	private void launchPokemonPlayerTwoAnimation()
	{
		Thread animationTwo = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				Point readyButtonLocation = PlayerVersusPlayer.this.jButtonReady.getLocation();

				String initialText = PlayerVersusPlayer.this.jLabeljLabelCurrentPlayerTwoPokemonName.getText();
				PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.setText("");
				int startPosition = PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.getX();

				// --THE SPEED---
				int speed = -1;

				// ---MOVE POKEMON---
				for (int i = 0; i < 300; i++)
				{
					PlayerVersusPlayer.this.jButtonReady.setLocation(1000000000, 1000000000);
					PlayerVersusPlayer.this.jLabelVersus.setVisible(false);
					PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.setLocation(
							PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.getX() + speed,
							PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.getY());
					try
					{
						Thread.sleep(2);
					}
					catch (InterruptedException exception)
					{
						String error = "InterruptedException";
						PlayerVersusPlayer.logger.error(error, exception);
					}
				}
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException exception)
				{
					String error = "InterruptedException";
					PlayerVersusPlayer.logger.error(error, exception);
				}
				// ---RESET LOCATIONS---
				PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.setLocation(startPosition,
						PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.getY());
				PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.setText("");

				PlayerVersusPlayer.this.jButtonReady.setLocation(readyButtonLocation);
				PlayerVersusPlayer.this.jLabelVersus.setVisible(true);
			}
		});
		animationTwo.start();
		animationTwo.interrupt();
	}

	/**
	 * Method launchPokemonPlayerOneAnimation Used for the player one pokemon
	 * animation
	 */
	private void launchPokemonPlayerOneAnimation()
	{
		Thread animation = new Thread(new Runnable()
		{
			@Override
			public void run()
			{

				int startPosition = PlayerVersusPlayer.this.jLabelPokemonPlayerOne.getX();

				// -THE SPEED
				int speed = 1;

				// --MOVE THE POKEMON--
				for (int i = 0; i < 300; i++)
				{

					PlayerVersusPlayer.this.jLabelVersus.setVisible(false);
					PlayerVersusPlayer.this.jLabelPokemonPlayerOne.setLocation(
							PlayerVersusPlayer.this.jLabelPokemonPlayerOne.getX() + speed,
							PlayerVersusPlayer.this.jLabelPokemonPlayerOne.getY());
					try
					{
						Thread.sleep(2);
					}
					catch (InterruptedException exception)
					{
						String error = "InterruptedException";
						PlayerVersusPlayer.logger.error(error, exception);
					}
				}
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException exception)
				{
					String error = "InterruptedException";
					PlayerVersusPlayer.logger.error(error, exception);
				}

				// --RESET POSITIONS---
				PlayerVersusPlayer.this.jLabelPokemonPlayerOne.setLocation(startPosition,
						PlayerVersusPlayer.this.jLabelPokemonPlayerOne.getY());

				PlayerVersusPlayer.this.jLabelVersus.setVisible(true);
			}
		});
		animation.start();
		animation.interrupt();
	}

	/**
	 * Method jButtonChangePokemonPlayerOneMouseClicked Used for change the player
	 * one pokemon
	 *
	 * @param evt
	 */
	private void jButtonChangePokemonPlayerOneMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButtonChangePokemonPlayerOneMouseClicked
		this.selectButtonSound();
		this.changeSelectedCurrentPlayerOnePokemon();
		this.jProgressBarPlayerOne.setValue(
				(int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
	}// GEN-LAST:event_jButtonChangePokemonPlayerOneMouseClicked

	/**
	 * Method changeSelectedCurrentPlayerOnePokemon Used for the process to change
	 * the player one pokemon
	 */
	private void changeSelectedCurrentPlayerOnePokemon()
	{
		Pokemon selectedPokemon = this.jListPlayerOne.getSelectedValue();
		if (this.playerOneChanges > 0)
		{
			this.playerOneChanges -= 1;
			this.jLabelPlayerOneChanges.setText("Changes: " + this.playerOneChanges);
			if (selectedPokemon != null)
			{
				this.currentPlayerOnePokemon = selectedPokemon;
				this.iconPlayer1 = new ImageIcon(this.currentPlayerOnePokemon.getPokeImage());
				this.jLabelCurrentPlayerOnePokemonName.setText(this.currentPlayerOnePokemon.getName());
				this.jLabelPokemonPlayerOne.setIcon(this.iconPlayer1);
				this.jLabelPlayerOneHealth.setText(String.format("%.2f", this.currentPlayerOnePokemon.getHealth()));

			}
		}
		this.repaint();

	}

	/**
	 * Method jButtonChangePokemonPlayerTwoMouseClicked Used for change the player
	 * two pokemon
	 *
	 * @param evt
	 */
	private void jButtonChangePokemonPlayerTwoMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButtonChangePokemonPlayerTwoMouseClicked
		this.selectButtonSound();
		this.changeSelectedCurrentPlayerTwoPokemon();
		this.jProgressBarPlayerTwo.setValue(
				(int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
	}// GEN-LAST:event_jButtonChangePokemonPlayerTwoMouseClicked

	/**
	 * Method changeSelectedCurrentPlayerTwoPokemon Used for the process to change
	 * the player one pokemon
	 */
	private void changeSelectedCurrentPlayerTwoPokemon()
	{

		Pokemon selectedPokemon = this.jListPlayerTwo.getSelectedValue();
		if (this.playerTwoChanges > 0)
		{
			this.playerTwoChanges -= 1;
			this.jLabelPlayerTwoChanges.setText("Changes: " + this.playerTwoChanges);
			if (selectedPokemon != null)
			{
				this.currentPlayerTwoPokemon = selectedPokemon;
				this.iconPlayer2 = new ImageIcon(this.currentPlayerTwoPokemon.getPokeImage());
				this.jLabeljLabelCurrentPlayerTwoPokemonName.setText(this.currentPlayerTwoPokemon.getName());
				this.jLabelPokemonPlayerTwo.setIcon(this.iconPlayer2);
				this.jLabelPlayerTwoHealth.setText(String.format("%.2f", this.currentPlayerTwoPokemon.getHealth()));

			}
		}
		this.repaint();
	}

	/**
	 * Method playerTwoAttack Used for the player two special attack
	 */
	private void playerTwoAttackSpecial()
	{
		// --IF THE PLAYERS HAVE MORE THAN 0 POKEMONS---
		if ((this.listPlayerTwo.size() > 0) && (this.listPlayerOne.size() > 0))
		{
			int position = 0;
			for (int i = 0; i < this.listPlayerOne.size(); i++)
			{
				if (this.currentPlayerOnePokemon.equals(this.listPlayerOne.get(i)))
				{
					position = i;
					break;
				}
			}

			// Possibility for fail the attack
			int randomFalliure = (int) ((Math.random() * 100) + 1);

			// Posibility to fail
			if (randomFalliure < 95)
			{
				// Update health
				double health = (this.currentPlayerOnePokemon.getHealth()
						+ ((this.currentPlayerTwoPokemon.getSpAttack() * -0.4)
								+ (this.currentPlayerOnePokemon.getSpDefense() * 0.1)));

				health = this.playerTwoAttackElements(health);

				health = this.playerTwoAttackCritial(health);
				health = health <= 0 ? 0 : health;
				this.currentPlayerOnePokemon.setHealth(health);
				this.listPlayerOne.set(position, this.currentPlayerOnePokemon);

				this.playerTwoAttackDieNextPokemon(position);
				this.jLabelCurrentPlayerOnePokemonName.setText(this.currentPlayerOnePokemon.getName());
				this.jLabelPlayerOneHealth.setText(String.format("%.2f", this.currentPlayerOnePokemon.getHealth()));
				this.repaint();
			}
			else
			{
				JOptionPane.showMessageDialog(null, this.currentPlayerTwoPokemon.getName() + " attack FAIL!");
			}
		}
		this.checkEndOfParty();
	}

	/**
	 * Method playerTwoAttackDieNextPokemon Used for change the player two pokemon
	 * when the pokemon die automaticaly
	 *
	 * @param position
	 */
	private void playerTwoAttackDieNextPokemon(int position)
	{
		// --IF THE PLAYER HAVE MORE THAN 0 POKEMONS---
		if ((this.currentPlayerOnePokemon.getHealth() <= 0)
				&& ((this.listPlayerTwo.size() > 0) && (this.listPlayerOne.size() > 0)))
		{
			// --ADD THE POKEMON THE THE KILLS, AND REMOVE---
			this.playerTwoKillsList.add(this.currentPlayerOnePokemon);
			this.listPlayerOne.remove(position);
			int playerTwoKillsX = this.playerTwoKills.getX();
			int playerTwoKillsY = this.playerTwoKills.getY();
			this.playerTwoKills.dispose();
			this.playerTwoKills = new PlayerTwoKills(this.playerTwoKillsList, playerTwoKillsX, playerTwoKillsY);
			this.playerTwoKills.setVisible(true);
			if (this.listPlayerOne.size() > 0)
			{
				// --IF THE PLAYER HAVE MORE THAN 0 POKEMONS UPDATE THE CURRENT POKEMON---
				this.currentPlayerOnePokemon = this.listPlayerOne.get(this.listPlayerOne.size() - 1);
				this.jLabelPokemonPlayerOne.setIcon(new ImageIcon(this.currentPlayerOnePokemon.getPokeImage()));
			}
		}
	}

	/**
	 * Method checkEndOfParty Used for check if is the end of the party and get the
	 * winner
	 *
	 * @throws HeadlessException
	 */
	private void checkEndOfParty() throws HeadlessException
	{
		if (this.listPlayerOne.size() <= 0)
		{
			// --PLAYER TWO IS THE WINNER---
			this.updateProgressBars();
			JOptionPane.showMessageDialog(null, "" + this.playerTwoName + " is the Winner!");
			EndOfParty endOfParty = new EndOfParty(this.playerTwoName + " won the Game",
					this.SpriteSelectedPlayerTwo.getIcon(), this.playerOneKills, this.playerTwoKills);
			this.mainTheme.stop();
			endOfParty.setVisible(true);
			this.dispose();
		}
		else if (this.listPlayerTwo.size() <= 0)
		{
			// --PLAYER ONE IS THE WINNER---
			this.updateProgressBars();
			JOptionPane.showMessageDialog(null, "" + this.playerOneName + " is the Winner!");
			EndOfParty endOfParty = new EndOfParty(this.playerOneName + " won the Game",
					this.SpriteSelectedPlayerOne.getIcon(), this.playerOneKills, this.playerTwoKills);
			this.mainTheme.stop();
			endOfParty.setVisible(true);
			this.dispose();
		}
	}

	/**
	 * Method playerTwoAttackPhysical Used for the player two physical attack
	 */
	private void playerTwoAttackPhysical()
	{
		// --IF THE PLAYERS HAVE MORE THAN 0 POKEMONS---
		if ((this.listPlayerTwo.size() > 0) && (this.listPlayerOne.size() > 0))
		{
			int position = 0;
			for (int i = 0; i < this.listPlayerOne.size(); i++)
			{
				if (this.currentPlayerOnePokemon.equals(this.listPlayerOne.get(i)))
				{
					position = i;
					break;
				}
			}

			// Possibility for fail the attack
			int randomFalliure = (int) ((Math.random() * 100) + 1);
			if (randomFalliure < 95)
			{
				double health = (this.currentPlayerOnePokemon.getHealth()
						+ ((this.currentPlayerTwoPokemon.getAttack() * -0.4)
								+ (this.currentPlayerOnePokemon.getDefense() * 0.1)));

				// Calculating the weakness and the resistances
				health = this.playerTwoAttackElements(health);
				// Calculating the weakness and the resistances

				health = this.playerTwoAttackCritial(health);

				health = health <= 0 ? 0 : health;

				this.currentPlayerOnePokemon.setHealth(health);
				this.listPlayerOne.set(position, this.currentPlayerOnePokemon);

				this.playerTwoAttackDieNextPokemon(position);
				this.jLabelCurrentPlayerOnePokemonName.setText(this.currentPlayerOnePokemon.getName());
				this.jLabelPlayerOneHealth.setText(String.format("%.2f", this.currentPlayerOnePokemon.getHealth()));
				this.repaint();
			}
			else
			{
				JOptionPane.showMessageDialog(null, this.currentPlayerTwoPokemon.getName() + " attack FAIL!");
			}
		}
		// --CHECK IF IS THE END OF PARTY---
		this.checkEndOfParty();
	}

	/**
	 * Method playerTwoAttackCritial Used for the player two critical
	 *
	 * @param health
	 * @return
	 */
	private double playerTwoAttackCritial(double health)
	{
		int critical = (int) ((Math.random() * 100) + 1);
		if (critical >= 90)
		{
			health += (this.currentPlayerOnePokemon.getMaxHeatlh() * -0.25);
			JOptionPane.showMessageDialog(null, this.currentPlayerTwoPokemon.getName() + " Critical hit");
		}
		return health;
	}

	/**
	 * Method playerTwoAttackElements Used for the elements for the player two
	 * attacks
	 *
	 * @param health
	 * @return
	 */
	private double playerTwoAttackElements(double health)
	{
		// --USE TWO LISTS FOR WEAKNESS AND RESISTANCES---
		List<String> playerOneWeakness = this.currentPlayerOnePokemon.getWeaknessTypes();
		List<String> playerOneResistances = this.currentPlayerOnePokemon.getResistantTypes();

		// --IF THE TYPE ONE OR TYPE TWO EXISTS ON THE ENEMY WEAKNESS , DEALS MORE
		// DAMAGE---
		if (playerOneWeakness.contains(this.currentPlayerTwoPokemon.getType()))
		{
			health += (this.currentPlayerOnePokemon.getMaxHeatlh() * -0.40);
		}
		if (playerOneWeakness.contains(this.currentPlayerTwoPokemon.getTypeTwo()))
		{
			health += (this.currentPlayerOnePokemon.getMaxHeatlh() * -0.40);
		}

		// --IF THE TYPE ONE OR TYPE TWO EXISTS ON THE ENEMY RESISTANCES , DEALS LESS
		// DAMAGE---
		if (playerOneResistances.contains(this.currentPlayerTwoPokemon.getType()))
		{
			health += (this.currentPlayerOnePokemon.getMaxHeatlh() * +0.05);
		}
		if (playerOneResistances.contains(this.currentPlayerTwoPokemon.getTypeTwo()))
		{
			health += (this.currentPlayerOnePokemon.getMaxHeatlh() * +0.05);
		}
		return health;
	}

	/**
	 * Method rotatePokeballThread Used for the pokeball animation
	 */
	private void rotatePokeballThread()
	{
		Thread rotatePokebal = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				// --SPEED--
				int speed = 1;

				// --INFINITE LOOP FOR INFINITE ANIMATION---
				while (true)
				{
					for (int i = 0; i < 40; i++)
					{

						PlayerVersusPlayer.this.jLabelPokeball.setLocation(
								PlayerVersusPlayer.this.jLabelPokeball.getX(),
								PlayerVersusPlayer.this.jLabelPokeball.getY() + speed);
						try
						{
							Thread.sleep(15);
						}
						catch (InterruptedException exception)
						{
							String error = "InterruptedException";
							PlayerVersusPlayer.logger.error(error, exception);
						}
					}
					for (int i = 0; i < 40; i++)
					{

						PlayerVersusPlayer.this.jLabelPokeball.setLocation(
								PlayerVersusPlayer.this.jLabelPokeball.getX(),
								PlayerVersusPlayer.this.jLabelPokeball.getY() + (speed * -1));
						try
						{
							Thread.sleep(15);
						}
						catch (InterruptedException exception)
						{
							String error = "InterruptedException";
							PlayerVersusPlayer.logger.error(error, exception);
						}
					}
				}
			}
		});
		rotatePokebal.start();
	}

	/**
	 * Method jumpPlayerOneAnimationThread Jump player one animation pokemon
	 */
	private void jumpPlayerOneAnimationThread()
	{
		Thread jumpThread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				// --SPEED---
				int speed = 1;
				// --INFINITE LOOP FOR INFINITE ANIMATION---
				while (true)
				{
					for (int i = 0; i < 10; i++)
					{

						PlayerVersusPlayer.this.jLabelPokemonPlayerOne.setLocation(
								PlayerVersusPlayer.this.jLabelPokemonPlayerOne.getX(),
								PlayerVersusPlayer.this.jLabelPokemonPlayerOne.getY() + speed);
						try
						{
							Thread.sleep(100);
						}
						catch (InterruptedException exception)
						{
							String error = "InterruptedException";
							PlayerVersusPlayer.logger.error(error, exception);
						}
					}
					for (int i = 0; i < 10; i++)
					{

						PlayerVersusPlayer.this.jLabelPokemonPlayerOne.setLocation(
								PlayerVersusPlayer.this.jLabelPokemonPlayerOne.getX(),
								PlayerVersusPlayer.this.jLabelPokemonPlayerOne.getY() + (speed * -1));
						try
						{
							Thread.sleep(100);
						}
						catch (InterruptedException exception)
						{
							String error = "InterruptedException";
							PlayerVersusPlayer.logger.error(error, exception);
						}
					}
				}
			}
		});
		jumpThread.start();
	}

	/**
	 * Method jumpPlayerTwoAnimationThread Used for the player two jump pokemon
	 * animation
	 */
	private void jumpPlayerTwoAnimationThread()
	{
		Thread jumpThread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				// --SPEED--
				int speed = 1;
				// --INFINITE LOOP FOR INFINITE ANIMATION---
				while (true)
				{
					for (int i = 0; i < 10; i++)
					{

						PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.setLocation(
								PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.getX(),
								PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.getY() + speed);
						try
						{
							Thread.sleep(100);
						}
						catch (InterruptedException exception)
						{
							String error = "InterruptedException";
							PlayerVersusPlayer.logger.error(error, exception);
						}
					}
					for (int i = 0; i < 10; i++)
					{

						PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.setLocation(
								PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.getX(),
								PlayerVersusPlayer.this.jLabelPokemonPlayerTwo.getY() + (speed * -1));
						try
						{
							Thread.sleep(100);
						}
						catch (InterruptedException exception)
						{
							String error = "InterruptedException";
							PlayerVersusPlayer.logger.error(error, exception);
						}
					}
				}
			}
		});
		jumpThread.start();
	}

	/**
	 * Method selectButtonSound Used for the buttons sound
	 */
	private void selectButtonSound()
	{

		AudioInputStream audioInputStream = null;
		try
		{
			audioInputStream = AudioSystem.getAudioInputStream(new File("./audio/butonSelect.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		}
		catch (UnsupportedAudioFileException exception)
		{
			String error = "UnsupportedAudioFileException";
			PlayerVersusPlayer.logger.error(error, exception);
		}
		catch (IOException exception)
		{
			String error = "IOException";
			PlayerVersusPlayer.logger.error(error, exception);
		}
		catch (LineUnavailableException exception)
		{
			String error = "LineUnavailableException";
			PlayerVersusPlayer.logger.error(error, exception);
		}
		finally
		{
			try
			{
				audioInputStream.close();
			}
			catch (IOException exception)
			{
				String error = "IOException";
				PlayerVersusPlayer.logger.error(error, exception);
			}
		}
	}
}
