/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.iesjandula.pokemon_game;

import es.iesjandula.pokemon_game.models.Pokemon;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author David Martinez Flores
 */
public class PlayerVersusPlayer extends javax.swing.JFrame
{
	private PlayerOneSelection playerOneSelection;
	private PlayerTwoSelection playerTwoSelection;

	private DefaultListModel<Pokemon> listPlayerOne = new DefaultListModel<>();
	private DefaultListModel<Pokemon> listPlayerTwo = new DefaultListModel<>();

	private ImageIcon iconPlayer1;
	private ImageIcon iconPlayer2;

	private Pokemon currentPlayerOnePokemon;
	private Pokemon currentPlayerTwoPokemon;

	/**
	 * Creates new form PlayerVersusPlayer
	 */
	public PlayerVersusPlayer(PlayerTwoSelection playerTwoSelection)
	{
		playerTwoSelection.dispose();
		initComponents();
		this.startBattleTheme();
               
		this.jLabel3.setIcon(new ImageIcon("./images/versus.png"));

		this.playerOneSelection = playerTwoSelection.getPlayerOneSelection();
		this.playerTwoSelection = playerTwoSelection;

		this.listPlayerOne = this.playerOneSelection.getListModel2();
		this.listPlayerTwo = this.playerTwoSelection.getListModel2();

		this.jList1.setModel(listPlayerOne);
		this.jList2.setModel(listPlayerTwo);

		this.iconPlayer1 = new ImageIcon(this.listPlayerOne.get(0).getPokeImage());
		this.iconPlayer2 = new ImageIcon(this.listPlayerTwo.get(0).getPokeImage());

		this.jLabel1.setText(this.listPlayerOne.get(0).getName());
		this.jLabel2.setText(this.listPlayerTwo.get(0).getName());

		this.jLabel1.setIcon(this.iconPlayer1);
		this.jLabel2.setIcon(this.iconPlayer2);

		this.currentPlayerOnePokemon = this.listPlayerOne.get(0);
		this.currentPlayerTwoPokemon = this.listPlayerTwo.get(0);

		this.jLabel4Player1Health.setText(currentPlayerOnePokemon.getHealth() + "");
		this.jLabel5Player2Health.setText(currentPlayerTwoPokemon.getHealth() + "");

		this.setLocationRelativeTo(null);
		
                this.jLabelPokeball.setIcon(new ImageIcon("./images/pokeball.png"));
                this.rotatePokeballThread();
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupPlayer1 = new javax.swing.ButtonGroup();
        buttonGroupPlayer2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4Player1Health = new javax.swing.JLabel();
        jLabel5Player2Health = new javax.swing.JLabel();
        jButtonREADY = new javax.swing.JButton();
        jRadioButtonPlayerOnePhysicalAttack = new javax.swing.JRadioButton();
        jRadioButtonPlayerOneSpecialAttack = new javax.swing.JRadioButton();
        jRadioButtonPlayerTwoPhysicalAttack = new javax.swing.JRadioButton();
        jRadioButtonPlayerTwoSpecialAttack = new javax.swing.JRadioButton();
        jButtonChangePokemonPlayerOne = new javax.swing.JButton();
        jButtonChangePokemonPlayerTwo = new javax.swing.JButton();
        jLabelPokeball = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setViewportView(jList2);

        jLabel1.setText("jLabel1");
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("jLabel2");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("                ");

        jLabel4Player1Health.setText("jLabel4");

        jLabel5Player2Health.setText("jLabel4");

        jButtonREADY.setBackground(new java.awt.Color(0, 204, 51));
        jButtonREADY.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonREADY.setForeground(new java.awt.Color(255, 255, 255));
        jButtonREADY.setText("READY");
        jButtonREADY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonREADYMouseClicked(evt);
            }
        });
        jButtonREADY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonREADYActionPerformed(evt);
            }
        });

        buttonGroupPlayer1.add(jRadioButtonPlayerOnePhysicalAttack);
        jRadioButtonPlayerOnePhysicalAttack.setText("PHYSICAK ATTACK");

        buttonGroupPlayer1.add(jRadioButtonPlayerOneSpecialAttack);
        jRadioButtonPlayerOneSpecialAttack.setText("SPECIAL ATTACK");
        jRadioButtonPlayerOneSpecialAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPlayerOneSpecialAttackActionPerformed(evt);
            }
        });

        buttonGroupPlayer2.add(jRadioButtonPlayerTwoPhysicalAttack);
        jRadioButtonPlayerTwoPhysicalAttack.setText("PHYSICAL ATTACK");

        buttonGroupPlayer2.add(jRadioButtonPlayerTwoSpecialAttack);
        jRadioButtonPlayerTwoSpecialAttack.setText("SPECIAL ATTACK");

        jButtonChangePokemonPlayerOne.setText("CHANGE SELECTED POKEMON");
        jButtonChangePokemonPlayerOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonChangePokemonPlayerOneMouseClicked(evt);
            }
        });
        jButtonChangePokemonPlayerOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangePokemonPlayerOneActionPerformed(evt);
            }
        });

        jButtonChangePokemonPlayerTwo.setText("CHANGE SELECTED POKEMON");
        jButtonChangePokemonPlayerTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonChangePokemonPlayerTwoMouseClicked(evt);
            }
        });

        jLabelPokeball.setText("         ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonPlayerOneSpecialAttack)
                            .addComponent(jRadioButtonPlayerOnePhysicalAttack)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonREADY, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPokeball, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonPlayerTwoSpecialAttack)
                                    .addComponent(jRadioButtonPlayerTwoPhysicalAttack))
                                .addGap(92, 92, 92))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel4Player1Health)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5Player2Health)
                .addGap(178, 178, 178))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jButtonChangePokemonPlayerOne, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonChangePokemonPlayerTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4Player1Health)
                            .addComponent(jLabel5Player2Health))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonPlayerOnePhysicalAttack)
                            .addComponent(jRadioButtonPlayerTwoPhysicalAttack))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonPlayerOneSpecialAttack)
                            .addComponent(jRadioButtonPlayerTwoSpecialAttack)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelPokeball, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButtonREADY, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonChangePokemonPlayerOne, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonChangePokemonPlayerTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * Method playerOneAttack
	 */
	private void playerOneAttackPhysical()
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

		// Caculate the health
		this.currentPlayerTwoPokemon
				.setHealth(this.currentPlayerTwoPokemon.getHealth() + ((this.currentPlayerOnePokemon.getAttack() * -0.4)
						+ this.currentPlayerTwoPokemon.getDefense() * 0.1));
		// Setting the current poke with new values
		this.listPlayerTwo.set(position, this.currentPlayerTwoPokemon);

		// If the poke die, get automaticaly the last poke
		if (this.currentPlayerTwoPokemon.getHealth() <= 0
				&& (this.listPlayerTwo.size() > 0 && this.listPlayerOne.size() > 0))
		{
			this.listPlayerTwo.remove(position);
			this.currentPlayerTwoPokemon = this.listPlayerTwo.get(this.listPlayerTwo.size() - 1);
			this.jLabel2.setIcon(new ImageIcon(this.currentPlayerTwoPokemon.getPokeImage()));
		}
		// Update the health text and repaint the PlayerVersusPlayer
		this.jLabel2.setText(this.currentPlayerTwoPokemon.getName());

		this.jLabel5Player2Health.setText(currentPlayerTwoPokemon.getHealth() + "");
		this.repaint();
	}

	private void playerOneAttackSpecial()
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

		// Caculate the health
		this.currentPlayerTwoPokemon.setHealth(
				this.currentPlayerTwoPokemon.getHealth() + ((this.currentPlayerOnePokemon.getSpAttack() * -0.4)
						+ this.currentPlayerTwoPokemon.getSpDefense() * 0.1));
		// Setting the current poke with new values
		this.listPlayerTwo.set(position, this.currentPlayerTwoPokemon);

		// If the poke die, get automaticaly the last poke
		if (this.currentPlayerTwoPokemon.getHealth() <= 0
				&& (this.listPlayerTwo.size() > 0 && this.listPlayerOne.size() > 0))
		{
			this.listPlayerTwo.remove(position);
			this.currentPlayerTwoPokemon = this.listPlayerTwo.get(this.listPlayerTwo.size() - 1);
			this.jLabel2.setIcon(new ImageIcon(this.currentPlayerTwoPokemon.getPokeImage()));
		}
		// Update the health text and repaint the PlayerVersusPlayer
		this.jLabel2.setText(this.currentPlayerTwoPokemon.getName());

		this.jLabel5Player2Health.setText(currentPlayerTwoPokemon.getHealth() + "");
		this.repaint();
	}

	private void jButtonREADYActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButtonREADYActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButtonREADYActionPerformed

	private void jRadioButtonPlayerOneSpecialAttackActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jRadioButtonPlayerOneSpecialAttackActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jRadioButtonPlayerOneSpecialAttackActionPerformed

	private void jButtonREADYMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButtonREADYMouseClicked

		int randomNumber = (int) (Math.random() * 10 + 1);
		
		// this.launchPokemonPlayerOneAnimation();

		// this.launchPokemonPlayerTwoAnimation();
                
                this.selectButtonSound();

		if (this.currentPlayerOnePokemon.getSpeed() == this.currentPlayerTwoPokemon.getSpeed())
		{
			if (randomNumber < 5)
			{
				this.launchPokemonPlayerOneAnimation();
				System.out.println("ATACA EL JUGADOR 1 PRIMERO");

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
				System.out.println("ATACA EL JUGADOR 2 SEGUNDO");

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
			}
			else
			{
				this.launchPokemonPlayerTwoAnimation();
				System.out.println("ATACA EL JUGADOR 2 PRIMERO");

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
				System.out.println("ATACA EL JUGADOR 1 SEGUNDO");

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
			}
			this.repaint();
		}
		else if (this.currentPlayerOnePokemon.getSpeed() > this.currentPlayerTwoPokemon.getSpeed())
		{
			this.launchPokemonPlayerOneAnimation();
			System.out.println("ATACA EL JUGADOR 1 PRIMERO");

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
			System.out.println("ATACA EL JUGADOR 2 SEGUNDO");

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
		}
		else
		{
			this.launchPokemonPlayerTwoAnimation();
			System.out.println("ATACA EL JUGADOR 2 PRIMERO");

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
			System.out.println("ATACA EL JUGADOR 1 SEGUNDO");

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
		}

	}// GEN-LAST:event_jButtonREADYMouseClicked

	private void startBattleTheme() 
	{
			try
			{
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./audio/battle.wav"));                
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (LineUnavailableException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (UnsupportedAudioFileException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * Method launchPokemonPlayerTwoAnimation
	 */
	private void launchPokemonPlayerTwoAnimation()
	{
		Thread animationTwo = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				Point readyButtonLocation = jButtonREADY.getLocation();

				String initialText = jLabel2.getText();
				jLabel2.setText("");
				int startPosition = jLabel2.getX();
				int speed = -1;
				for (int i = 0; i < 300; i++)
				{
					jButtonREADY.setLocation(1000000000, 1000000000);
					jLabel2.setLocation(jLabel2.getX() + speed, jLabel2.getY());
					try
					{
						Thread.sleep(2);
					}
					catch (InterruptedException ex)
					{
						//Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException ex)
				{
					Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
				}
				jLabel2.setLocation(startPosition, jLabel2.getY());
				jLabel2.setText(initialText);

				jButtonREADY.setLocation(readyButtonLocation);
			}
		});
		animationTwo.start();
		animationTwo.interrupt();
	}

	/**
	 * Method launchPokemonPlayerOneAnimation
	 */
	private void launchPokemonPlayerOneAnimation()
	{
		Thread animation = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				Point readyButtonLocation = jButtonREADY.getLocation();

				String initialText = jLabel1.getText();
				jLabel1.setText("");
				int startPosition = jLabel1.getX();
				int speed = 1;
				for (int i = 0; i < 300; i++)
				{
					jButtonREADY.setLocation(1000000000, 1000000000);
					jLabel1.setLocation(jLabel1.getX() + speed, jLabel1.getY());
					try
					{
						Thread.sleep(2);
					}
					catch (InterruptedException ex)
					{
						//Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException ex)
				{
					Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
				}
				jLabel1.setLocation(startPosition, jLabel1.getY());
				jLabel1.setText(initialText);

				jButtonREADY.setLocation(readyButtonLocation);
			}
		});
		animation.start();
		animation.interrupt();
	}

	private void jButtonChangePokemonPlayerOneActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButtonChangePokemonPlayerOneActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButtonChangePokemonPlayerOneActionPerformed

	private void jButtonChangePokemonPlayerOneMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButtonChangePokemonPlayerOneMouseClicked
                this.selectButtonSound();
		this.changeSelectedCurrentPlayerOnePokemon();
	}// GEN-LAST:event_jButtonChangePokemonPlayerOneMouseClicked

	/**
	 * Method changeSelectedCurrentPlayerOnePokemon
	 */
	private void changeSelectedCurrentPlayerOnePokemon()
	{
		Pokemon selectedPokemon = this.jList1.getSelectedValue();
		if (selectedPokemon != null)
		{
			this.currentPlayerOnePokemon = selectedPokemon;
			this.iconPlayer1 = new ImageIcon(this.currentPlayerOnePokemon.getPokeImage());
			this.jLabel1.setText(this.currentPlayerOnePokemon.getName());
			this.jLabel1.setIcon(this.iconPlayer1);
			this.jLabel4Player1Health.setText(this.currentPlayerOnePokemon.getHealth() + "");

		}
		this.repaint();
	}

	private void jButtonChangePokemonPlayerTwoMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButtonChangePokemonPlayerTwoMouseClicked
                this.selectButtonSound();
		this.changeSelectedCurrentPlayerTwoPokemon();
	}// GEN-LAST:event_jButtonChangePokemonPlayerTwoMouseClicked

	/**
	 * Method changeSelectedCurrentPlayerTwoPokemon
	 */
	private void changeSelectedCurrentPlayerTwoPokemon()
	{
		Pokemon selectedPokemon = this.jList2.getSelectedValue();
		if (selectedPokemon != null)
		{
			this.currentPlayerTwoPokemon = selectedPokemon;
			this.iconPlayer2 = new ImageIcon(this.currentPlayerTwoPokemon.getPokeImage());
			this.jLabel2.setText(this.currentPlayerTwoPokemon.getName());
			this.jLabel2.setIcon(this.iconPlayer2);
			this.jLabel5Player2Health.setText(this.currentPlayerTwoPokemon.getHealth() + "");

		}
		this.repaint();
	}

	/**
	 * Method playerTwoAttack
	 */
	private void playerTwoAttackSpecial()
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

		this.currentPlayerOnePokemon.setHealth(
				this.currentPlayerOnePokemon.getHealth() + ((this.currentPlayerTwoPokemon.getSpAttack() * -0.4)
						+ this.currentPlayerOnePokemon.getSpDefense() * 0.1));
		this.listPlayerOne.set(position, this.currentPlayerOnePokemon);

		if (this.currentPlayerOnePokemon.getHealth() <= 0
				&& (this.listPlayerTwo.size() > 0 && this.listPlayerOne.size() > 0))
		{
			this.listPlayerOne.remove(position);
			this.currentPlayerOnePokemon = this.listPlayerOne.get(this.listPlayerOne.size() - 1);
			this.jLabel1.setIcon(new ImageIcon(this.currentPlayerOnePokemon.getPokeImage()));
		}
		this.jLabel1.setText(this.currentPlayerOnePokemon.getName());
		this.jLabel4Player1Health.setText(currentPlayerOnePokemon.getHealth() + "");
		this.repaint();
	}

	private void playerTwoAttackPhysical()
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

		this.currentPlayerOnePokemon
				.setHealth(this.currentPlayerOnePokemon.getHealth() + ((this.currentPlayerTwoPokemon.getAttack() * -0.4)
						+ this.currentPlayerOnePokemon.getDefense() * 0.1));
		this.listPlayerOne.set(position, this.currentPlayerOnePokemon);

		if (this.currentPlayerOnePokemon.getHealth() <= 0
				&& (this.listPlayerTwo.size() > 0 && this.listPlayerOne.size() > 0))
		{
			this.listPlayerOne.remove(position);
			this.currentPlayerOnePokemon = this.listPlayerOne.get(this.listPlayerOne.size() - 1);
			this.jLabel1.setIcon(new ImageIcon(this.currentPlayerOnePokemon.getPokeImage()));
		}
		this.jLabel1.setText(this.currentPlayerOnePokemon.getName());
		this.jLabel4Player1Health.setText(currentPlayerOnePokemon.getHealth() + "");
		this.repaint();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupPlayer1;
    private javax.swing.ButtonGroup buttonGroupPlayer2;
    private javax.swing.JButton jButtonChangePokemonPlayerOne;
    private javax.swing.JButton jButtonChangePokemonPlayerTwo;
    private javax.swing.JButton jButtonREADY;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4Player1Health;
    private javax.swing.JLabel jLabel5Player2Health;
    private javax.swing.JLabel jLabelPokeball;
    private javax.swing.JList<Pokemon> jList1;
    private javax.swing.JList<Pokemon> jList2;
    private javax.swing.JRadioButton jRadioButtonPlayerOnePhysicalAttack;
    private javax.swing.JRadioButton jRadioButtonPlayerOneSpecialAttack;
    private javax.swing.JRadioButton jRadioButtonPlayerTwoPhysicalAttack;
    private javax.swing.JRadioButton jRadioButtonPlayerTwoSpecialAttack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void rotatePokeballThread() {
        Thread rotatePokebal = new Thread(new Runnable(){
            @Override
            public void run() {
                int speed = 1;
                while(true){
                for(int i = 0;i<40;i++){
                
                    jLabelPokeball.setLocation(jLabelPokeball.getX(), jLabelPokeball.getY()+speed);
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for(int i = 0;i<40;i++){
                
                    jLabelPokeball.setLocation(jLabelPokeball.getX(), jLabelPokeball.getY()+(speed*-1));
                try {
                        Thread.sleep(15);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                }
            }
        });
        rotatePokebal.start();
    }

    private void selectButtonSound() {
        
        AudioInputStream audioInputStream = null;
            try {
                
                audioInputStream = AudioSystem.getAudioInputStream(new File("./audio/butonSelect.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                
                
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    audioInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
}
