/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.iesjandula.pokemon_game;

import javax.swing.GroupLayout;
import es.iesjandula.pokemon_game.models.Pokemon;
import java.awt.Point;
import java.io.File;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author David Martinez Flores
 */
public class PlayerVersusPlayer extends javax.swing.JFrame implements Serializable
{
	private Clip mainTheme;

	private PlayerOneSelection playerOneSelection;
	private PlayerTwoSelection playerTwoSelection;

	private DefaultListModel<Pokemon> listPlayerOne = new DefaultListModel<>();
	private DefaultListModel<Pokemon> listPlayerTwo = new DefaultListModel<>();

	private ImageIcon iconPlayer1;
	private ImageIcon iconPlayer2;

	private Pokemon currentPlayerOnePokemon;
	private Pokemon currentPlayerTwoPokemon;

	private int playerOneChanges;
	private int playerTwoChanges;

	/**
	 * Creates new form PlayerVersusPlayer
	 */
	public PlayerVersusPlayer(PlayerTwoSelection playerTwoSelection)
	{
		playerTwoSelection.dispose();
		initComponents();
		this.mainTheme = this.startBattleTheme();
		if (this.mainTheme != null)
		{
			this.mainTheme.start();
		}
		this.setResizable(false);

		this.playerOneChanges = 8;
		this.playerTwoChanges = 8;

		this.jLabel3.setIcon(new ImageIcon("./images/versus.png"));

		this.playerOneSelection = playerTwoSelection.getPlayerOneSelection();
		this.playerTwoSelection = playerTwoSelection;

		this.listPlayerOne = this.playerOneSelection.getListModel2();
		this.listPlayerTwo = this.playerTwoSelection.getListModel2();

		this.initDefaultGraphics();
	}

	/**
	 * Method initGraphics
	 */
	private void initDefaultGraphics()
	{
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

		this.jumpPlayerOneAnimationThread();
		this.jumpPlayerTwoAnimationThread();

		this.jLabelPlayerOneChanges.setText("Changes: " + this.playerOneChanges);
		this.jLabelPlayerTwoChanges.setText("Changes: " + this.playerTwoChanges);

		this.jProgressBar1.setValue(
				(int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
		this.jProgressBar2.setValue(
				(int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
	}

	public PlayerVersusPlayer(List<Object> partyList)
	{
		initComponents();
		this.mainTheme = this.startBattleTheme();
		if (this.mainTheme != null)
		{
			this.mainTheme.start();
		}

		this.setResizable(false);
		this.listPlayerOne = (DefaultListModel<Pokemon>) partyList.get(0);
		this.listPlayerTwo = (DefaultListModel<Pokemon>) partyList.get(1);

		this.jLabel3.setIcon(new ImageIcon("./images/versus.png"));

		this.currentPlayerOnePokemon = (Pokemon) partyList.get(2);
		this.currentPlayerTwoPokemon = (Pokemon) partyList.get(3);

		this.iconPlayer1 = new ImageIcon(this.currentPlayerOnePokemon.getPokeImage());
		this.iconPlayer2 = new ImageIcon(this.currentPlayerTwoPokemon.getPokeImage());

		this.playerOneChanges = (int) partyList.get(4);
		this.playerTwoChanges = (int) partyList.get(5);

		this.jList1.setModel(listPlayerOne);
		this.jList2.setModel(listPlayerTwo);

		this.jLabel1.setText(this.currentPlayerOnePokemon.getName());
		this.jLabel2.setText(this.currentPlayerTwoPokemon.getName());

		this.jLabel1.setIcon(this.iconPlayer1);
		this.jLabel2.setIcon(this.iconPlayer2);

		this.jLabel4Player1Health.setText(currentPlayerOnePokemon.getHealth() + "");
		this.jLabel5Player2Health.setText(currentPlayerTwoPokemon.getHealth() + "");

		this.setLocationRelativeTo(null);

		this.jLabelPokeball.setIcon(new ImageIcon("./images/pokeball.png"));

		this.rotatePokeballThread();

		this.jumpPlayerOneAnimationThread();
		this.jumpPlayerTwoAnimationThread();

		this.jLabelPlayerOneChanges.setText("Changes: " + this.playerOneChanges);
		this.jLabelPlayerTwoChanges.setText("Changes: " + this.playerTwoChanges);

		this.jProgressBar1.setValue(
				(int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
		this.jProgressBar2.setValue(
				(int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
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
        jLabelPlayerOneChanges = new javax.swing.JLabel();
        jLabelPlayerTwoChanges = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel1.setText("jLabel1");
        jLabel1.setToolTipText("heyyy");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });

        jLabel2.setText("jLabel2");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });

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
        jRadioButtonPlayerOnePhysicalAttack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPlayerOnePhysicalAttackMouseClicked(evt);
            }
        });

        buttonGroupPlayer1.add(jRadioButtonPlayerOneSpecialAttack);
        jRadioButtonPlayerOneSpecialAttack.setText("SPECIAL ATTACK");
        jRadioButtonPlayerOneSpecialAttack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPlayerOneSpecialAttackMouseClicked(evt);
            }
        });
        jRadioButtonPlayerOneSpecialAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPlayerOneSpecialAttackActionPerformed(evt);
            }
        });

        buttonGroupPlayer2.add(jRadioButtonPlayerTwoPhysicalAttack);
        jRadioButtonPlayerTwoPhysicalAttack.setText("PHYSICAL ATTACK");
        jRadioButtonPlayerTwoPhysicalAttack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPlayerTwoPhysicalAttackMouseClicked(evt);
            }
        });

        buttonGroupPlayer2.add(jRadioButtonPlayerTwoSpecialAttack);
        jRadioButtonPlayerTwoSpecialAttack.setText("SPECIAL ATTACK");
        jRadioButtonPlayerTwoSpecialAttack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPlayerTwoSpecialAttackMouseClicked(evt);
            }
        });

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

        jLabelPlayerOneChanges.setText("Changes:");

        jLabelPlayerTwoChanges.setText("Changes:");

        jProgressBar1.setForeground(new java.awt.Color(0, 204, 0));

        jProgressBar2.setForeground(new java.awt.Color(51, 204, 0));

        jMenu1.setText("File");

        jMenuItem1.setText("Save State");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Load State");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabelPlayerOneChanges)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonPlayerOneSpecialAttack)
                                    .addComponent(jRadioButtonPlayerOnePhysicalAttack)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButtonChangePokemonPlayerOne, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4Player1Health)
                                .addGap(18, 18, 18)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPokeball, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonREADY, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonChangePokemonPlayerTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButtonPlayerTwoPhysicalAttack)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jRadioButtonPlayerTwoSpecialAttack)
                                                .addGap(10, 10, 10)))
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabelPlayerTwoChanges)))
                                .addGap(53, 53, 53))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5Player2Health))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
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
                        .addGap(40, 40, 40)
                        .addComponent(jLabelPokeball, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonREADY, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5Player2Health)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4Player1Health))
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButtonPlayerOnePhysicalAttack)
                                    .addComponent(jLabelPlayerOneChanges))
                                .addGap(8, 8, 8)
                                .addComponent(jRadioButtonPlayerOneSpecialAttack))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButtonPlayerTwoPhysicalAttack)
                                    .addComponent(jLabelPlayerTwoChanges))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonPlayerTwoSpecialAttack)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonChangePokemonPlayerTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonChangePokemonPlayerOne, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(64, 64, 64))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       // GEN-FIRST:event_jMenuItem1ActionPerformed
		/*
		 * this.listPlayerOne=(DefaultListModel<Pokemon>) partyList.get(0);
		 * this.listPlayerTwo=(DefaultListModel<Pokemon>) partyList.get(1);
		 * 
		 * this.currentPlayerOnePokemon = (Pokemon) partyList.get(4);
		 * this.currentPlayerTwoPokemon = (Pokemon) partyList.get(5);
		 * 
		 * this.iconPlayer1= new ImageIcon(this.listPlayerOne.get(0).getPokeImage());
		 * this.iconPlayer2= new ImageIcon(this.listPlayerTwo.get(0).getPokeImage());
		 * 
		 * this.playerOneChanges = (int) partyList.get(6); this.playerTwoChanges = (int)
		 * partyList.get(6);
		 */
		System.out.println("GUARDAR ESTADO");
		JOptionPane.showMessageDialog(null, "SAVING STATE!");
		Application application = new Application();

		List<Object> partyList = new ArrayList<Object>();

		partyList.add(listPlayerOne);
		partyList.add(listPlayerTwo);

		partyList.add(currentPlayerOnePokemon);
		partyList.add(currentPlayerTwoPokemon);

		partyList.add(playerOneChanges);
		partyList.add(playerTwoChanges);
		System.out.println(partyList);
		application.saveState(partyList);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        
    }//GEN-LAST:event_jMenuItem1MouseClicked
    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {                                        
    } 
	private void jList1MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jList1MouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jList1MouseClicked

	private void jList2MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jList2MouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jList2MouseClicked

	private void jRadioButtonPlayerOnePhysicalAttackMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jRadioButtonPlayerOnePhysicalAttackMouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jRadioButtonPlayerOnePhysicalAttackMouseClicked

	private void jRadioButtonPlayerOneSpecialAttackMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jRadioButtonPlayerOneSpecialAttackMouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jRadioButtonPlayerOneSpecialAttackMouseClicked

	private void jRadioButtonPlayerTwoPhysicalAttackMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jRadioButtonPlayerTwoPhysicalAttackMouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jRadioButtonPlayerTwoPhysicalAttackMouseClicked

	private void jRadioButtonPlayerTwoSpecialAttackMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jRadioButtonPlayerTwoSpecialAttackMouseClicked
		this.selectButtonSound();
	}// GEN-LAST:event_jRadioButtonPlayerTwoSpecialAttackMouseClicked

	private void jLabel1MouseEntered(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jLabel1MouseEntered
		this.jLabel1.setToolTipText("Attack: " + this.currentPlayerOnePokemon.getAttack() + " \n" + "SpAttack: "
				+ this.currentPlayerOnePokemon.getSpAttack() + " \n" + "Defense: "
				+ this.currentPlayerOnePokemon.getDefense() + " \n" + "SpDefense: "
				+ this.currentPlayerOnePokemon.getSpDefense() + " \n");
	}// GEN-LAST:event_jLabel1MouseEntered

	private void jLabel2MouseEntered(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jLabel2MouseEntered
		this.jLabel2.setToolTipText("Attack: " + this.currentPlayerTwoPokemon.getAttack() + " \n" + "SpAttack: "
				+ this.currentPlayerTwoPokemon.getSpAttack() + " \n" + "Defense: "
				+ this.currentPlayerTwoPokemon.getDefense() + " \n" + "SpDefense: "
				+ this.currentPlayerTwoPokemon.getSpDefense() + " \n");
	}// GEN-LAST:event_jLabel2MouseEntered

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jMenuItem2ActionPerformed
		
		System.out.println("CARGAR ESTADO");
		Application application = new Application();

		List<Object> partyList = application.loadState();

		if (partyList != null)
		{
			this.mainTheme.stop();
			PlayerVersusPlayer loadedPlayerVersusPlayer = new PlayerVersusPlayer(partyList);
			loadedPlayerVersusPlayer.setVisible(true);
			System.out.println(partyList);
			this.dispose();
			JOptionPane.showMessageDialog(null, "STATE DATA LOADED!");

		}
		else
		{
			JOptionPane.showMessageDialog(null, "THE STATE IS CORRUPTED OR DONT EXISTS ANY STATE!");
		}

	}// GEN-LAST:event_jMenuItem2ActionPerformed
        
	/**
	 * Method playerOneAttack
	 */
	private void playerOneAttackPhysical()
	{
            if(this.listPlayerTwo.size()>0 && this.listPlayerOne.size()>0){
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
		double health = (this.currentPlayerTwoPokemon.getHealth() + ((this.currentPlayerOnePokemon.getAttack() * -0.4)
						+ this.currentPlayerTwoPokemon.getDefense() * 0.1));
                health = health<=0 ? 0:health;
		this.currentPlayerTwoPokemon.setHealth(health);
		// Setting the current poke with new values
		this.listPlayerTwo.set(position, this.currentPlayerTwoPokemon);

		// If the poke die, get automaticaly the last poke
		if (this.currentPlayerTwoPokemon.getHealth() <= 0
				&& (this.listPlayerTwo.size() > 0 && this.listPlayerOne.size() > 0))
		{
			this.listPlayerTwo.remove(position);
                        if(this.listPlayerTwo.size()>0){
			this.currentPlayerTwoPokemon = this.listPlayerTwo.get(this.listPlayerTwo.size() - 1);
			this.jLabel2.setIcon(new ImageIcon(this.currentPlayerTwoPokemon.getPokeImage()));
                        }
		}
		// Update the health text and repaint the PlayerVersusPlayer
		this.jLabel2.setText(this.currentPlayerTwoPokemon.getName());

		this.jLabel5Player2Health.setText(String.format("%.2f", currentPlayerTwoPokemon.getHealth()));
		this.repaint();
            }
            if(this.listPlayerOne.size()<=0)
            {
                this.jProgressBar1.setValue(
                            (int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
            this.jProgressBar2.setValue(
                            (int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
                JOptionPane.showMessageDialog(null, "The player Two Wins!");
            }
            if(this.listPlayerTwo.size()<=0)
            {
                this.jProgressBar1.setValue(
                            (int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
            this.jProgressBar2.setValue(
                            (int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
                JOptionPane.showMessageDialog(null, "The player One Wins!");
            }
	}

	private void playerOneAttackSpecial()
	{
            if(this.listPlayerTwo.size()>0 && this.listPlayerOne.size()>0){
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
                double health =this.currentPlayerTwoPokemon.getHealth() + ((this.currentPlayerOnePokemon.getSpAttack() * -0.4)
						+ this.currentPlayerTwoPokemon.getSpDefense() * 0.1);
                health = health<=0 ? 0:health;
		this.currentPlayerTwoPokemon.setHealth(health);
		// Setting the current poke with new values
		this.listPlayerTwo.set(position, this.currentPlayerTwoPokemon);

		// If the poke die, get automaticaly the last poke
		if (this.currentPlayerTwoPokemon.getHealth() <= 0
				&& (this.listPlayerTwo.size() > 0 && this.listPlayerOne.size() > 0))
		{
			this.listPlayerTwo.remove(position);
                        if(this.listPlayerTwo.size()>0)
                        {
                            this.currentPlayerTwoPokemon = this.listPlayerTwo.get(this.listPlayerTwo.size() - 1);
                        
                            this.jLabel2.setIcon(new ImageIcon(this.currentPlayerTwoPokemon.getPokeImage()));
                        }
		}
		// Update the health text and repaint the PlayerVersusPlayer
		this.jLabel2.setText(this.currentPlayerTwoPokemon.getName());

		this.jLabel5Player2Health.setText(String.format("%.2f", currentPlayerTwoPokemon.getHealth()));
		this.repaint();
            }
            if(this.listPlayerOne.size()<=0)
            {
                this.jProgressBar1.setValue(
                            (int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
            this.jProgressBar2.setValue(
                            (int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
                JOptionPane.showMessageDialog(null, "The player Two Wins!");
            }
            if(this.listPlayerTwo.size()<=0)
            {
                this.jProgressBar1.setValue(
                            (int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
            this.jProgressBar2.setValue(
                            (int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
                JOptionPane.showMessageDialog(null, "The player One Wins!");
            }
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
		this.jProgressBar1.setValue(
				(int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
		this.jProgressBar2.setValue(
				(int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
                
                if(this.listPlayerOne.size()<=0||this.listPlayerTwo.size()<=0)
                {
                    this.readyButtonEndPosition();
                }
                
	}// GEN-LAST:event_jButtonREADYMouseClicked

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
		return clip;
	}
        
        private void readyButtonEndPosition()
        {
            Thread buttonReadyEndPosition = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                    jButtonREADY.setLocation(-1000000000, -1000000000);
                    }
                }
            });
            buttonReadyEndPosition.start();
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
					jLabel3.setVisible(false);
					jLabel2.setLocation(jLabel2.getX() + speed, jLabel2.getY());
					try
					{
						Thread.sleep(2);
					}
					catch (InterruptedException ex)
					{
						// Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null,
						// ex);
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
				jLabel3.setVisible(true);
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
					jLabel3.setVisible(false);
					jLabel1.setLocation(jLabel1.getX() + speed, jLabel1.getY());
					try
					{
						Thread.sleep(2);
					}
					catch (InterruptedException ex)
					{
						// Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null,
						// ex);
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
				jLabel3.setVisible(true);
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
		this.jProgressBar1.setValue(
				(int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
	}// GEN-LAST:event_jButtonChangePokemonPlayerOneMouseClicked

	/**
	 * Method changeSelectedCurrentPlayerOnePokemon
	 */
	private void changeSelectedCurrentPlayerOnePokemon()
	{
		Pokemon selectedPokemon = this.jList1.getSelectedValue();
		if (this.playerOneChanges > 0)
		{
			this.playerOneChanges -= 1;
			this.jLabelPlayerOneChanges.setText("Changes: " + this.playerOneChanges);
			if (selectedPokemon != null)
			{
				this.currentPlayerOnePokemon = selectedPokemon;
				this.iconPlayer1 = new ImageIcon(this.currentPlayerOnePokemon.getPokeImage());
				this.jLabel1.setText(this.currentPlayerOnePokemon.getName());
				this.jLabel1.setIcon(this.iconPlayer1);
				this.jLabel4Player1Health.setText(this.currentPlayerOnePokemon.getHealth() + "");

			}
		}
		this.repaint();

	}

	private void jButtonChangePokemonPlayerTwoMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButtonChangePokemonPlayerTwoMouseClicked
		this.selectButtonSound();
		this.changeSelectedCurrentPlayerTwoPokemon();
		this.jProgressBar2.setValue(
				(int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
	}// GEN-LAST:event_jButtonChangePokemonPlayerTwoMouseClicked

	/**
	 * Method changeSelectedCurrentPlayerTwoPokemon
	 */
	private void changeSelectedCurrentPlayerTwoPokemon()
	{

		Pokemon selectedPokemon = this.jList2.getSelectedValue();
		if (this.playerTwoChanges > 0)
		{
			this.playerTwoChanges -= 1;
			this.jLabelPlayerTwoChanges.setText("Changes: " + this.playerTwoChanges);
			if (selectedPokemon != null)
			{
				this.currentPlayerTwoPokemon = selectedPokemon;
				this.iconPlayer2 = new ImageIcon(this.currentPlayerTwoPokemon.getPokeImage());
				this.jLabel2.setText(this.currentPlayerTwoPokemon.getName());
				this.jLabel2.setIcon(this.iconPlayer2);
				this.jLabel5Player2Health.setText(this.currentPlayerTwoPokemon.getHealth() + "");

			}
		}
		this.repaint();
	}

	/**
	 * Method playerTwoAttack
	 */
	private void playerTwoAttackSpecial()
	{       if(this.listPlayerTwo.size()>0 && this.listPlayerOne.size()>0){
                    int position = 0;
                    for (int i = 0; i < this.listPlayerOne.size(); i++)
                    {
                            if (this.currentPlayerOnePokemon.equals(this.listPlayerOne.get(i)))
                            {
                                    position = i;
                                    break;
                            }
                    }

                    double health =(this.currentPlayerOnePokemon.getHealth() + ((this.currentPlayerTwoPokemon.getSpAttack() * -0.4)
                                                    + this.currentPlayerOnePokemon.getSpDefense() * 0.1));
                    health = health<=0 ? 0:health;
                    this.currentPlayerOnePokemon.setHealth(health);
                    this.listPlayerOne.set(position, this.currentPlayerOnePokemon);

                    if (this.currentPlayerOnePokemon.getHealth() <= 0
                                    && (this.listPlayerTwo.size() > 0 && this.listPlayerOne.size() > 0))
                    {
                            this.listPlayerOne.remove(position);
                            if(this.listPlayerOne.size()>0){
                            this.currentPlayerOnePokemon = this.listPlayerOne.get(this.listPlayerOne.size() - 1);
                            this.jLabel1.setIcon(new ImageIcon(this.currentPlayerOnePokemon.getPokeImage()));
                            }
                    }
                    this.jLabel1.setText(this.currentPlayerOnePokemon.getName());
                    this.jLabel4Player1Health.setText(String.format("%.2f", currentPlayerOnePokemon.getHealth()));
                    this.repaint();
                }
                if(this.listPlayerOne.size()<=0)
                {
                    this.jProgressBar1.setValue(
                                (int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
                this.jProgressBar2.setValue(
                                (int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
                    JOptionPane.showMessageDialog(null, "The player Two Wins!");
                }
                if(this.listPlayerTwo.size()<=0)
                {
                    this.jProgressBar1.setValue(
                                (int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
                this.jProgressBar2.setValue(
                                (int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
                    JOptionPane.showMessageDialog(null, "The player One Wins!");
                }
	}

	private void playerTwoAttackPhysical()
	{
                if(this.listPlayerTwo.size()>0 && this.listPlayerOne.size()>0){
                    int position = 0;
                    for (int i = 0; i < this.listPlayerOne.size(); i++)
                    {
                            if (this.currentPlayerOnePokemon.equals(this.listPlayerOne.get(i)))
                            {
                                    position = i;
                                    break;
                            }
                    }

                   double health =(this.currentPlayerOnePokemon.getHealth() + ((this.currentPlayerTwoPokemon.getAttack() * -0.4)
                                                    + this.currentPlayerOnePokemon.getDefense() * 0.1));
                    
                    health = health<=0 ? 0:health;
                    this.currentPlayerOnePokemon.setHealth(health);
                    this.listPlayerOne.set(position, this.currentPlayerOnePokemon);

                    if (this.currentPlayerOnePokemon.getHealth() <= 0
                                    && (this.listPlayerTwo.size() > 0 && this.listPlayerOne.size() > 0))
                    {
                            this.listPlayerOne.remove(position);
                            if(this.listPlayerOne.size()>0){
                            this.currentPlayerOnePokemon = this.listPlayerOne.get(this.listPlayerOne.size() - 1);
                            this.jLabel1.setIcon(new ImageIcon(this.currentPlayerOnePokemon.getPokeImage()));
                            }
                    }
                    this.jLabel1.setText(this.currentPlayerOnePokemon.getName());
                    this.jLabel4Player1Health.setText(String.format("%.2f", currentPlayerOnePokemon.getHealth()));
                    this.repaint();
                }
                if(this.listPlayerOne.size()<=0)
                {
                    this.jProgressBar1.setValue(
                                (int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
                this.jProgressBar2.setValue(
                                (int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
                    JOptionPane.showMessageDialog(null, "The player Two Wins!");
                }
                if(this.listPlayerTwo.size()<=0)
                {
                    this.jProgressBar1.setValue(
                                (int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
                this.jProgressBar2.setValue(
                                (int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
                    JOptionPane.showMessageDialog(null, "The player One Wins!");
                }
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
    private javax.swing.JLabel jLabelPlayerOneChanges;
    private javax.swing.JLabel jLabelPlayerTwoChanges;
    private javax.swing.JLabel jLabelPokeball;
    private javax.swing.JList<Pokemon> jList1;
    private javax.swing.JList<Pokemon> jList2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JRadioButton jRadioButtonPlayerOnePhysicalAttack;
    private javax.swing.JRadioButton jRadioButtonPlayerOneSpecialAttack;
    private javax.swing.JRadioButton jRadioButtonPlayerTwoPhysicalAttack;
    private javax.swing.JRadioButton jRadioButtonPlayerTwoSpecialAttack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

	private void rotatePokeballThread()
	{
		Thread rotatePokebal = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				int speed = 1;
				while (true)
				{
					for (int i = 0; i < 40; i++)
					{

						jLabelPokeball.setLocation(jLabelPokeball.getX(), jLabelPokeball.getY() + speed);
						try
						{
							Thread.sleep(15);
						}
						catch (InterruptedException ex)
						{
							Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					for (int i = 0; i < 40; i++)
					{

						jLabelPokeball.setLocation(jLabelPokeball.getX(), jLabelPokeball.getY() + (speed * -1));
						try
						{
							Thread.sleep(15);
						}
						catch (InterruptedException ex)
						{
							Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
				}
			}
		});
		rotatePokebal.start();
	}

	private void jumpPlayerOneAnimationThread()
	{
		Thread jumpThread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				int speed = 1;
				while (true)
				{
					for (int i = 0; i < 10; i++)
					{

						jLabel1.setLocation(jLabel1.getX(), jLabel1.getY() + speed);
						try
						{
							Thread.sleep(100);
						}
						catch (InterruptedException ex)
						{
							Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					for (int i = 0; i < 10; i++)
					{

						jLabel1.setLocation(jLabel1.getX(), jLabel1.getY() + (speed * -1));
						try
						{
							Thread.sleep(100);
						}
						catch (InterruptedException ex)
						{
							Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
				}
			}
		});
		jumpThread.start();
	}

	private void jumpPlayerTwoAnimationThread()
	{
		Thread jumpThread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				int speed = 1;
				while (true)
				{
					for (int i = 0; i < 10; i++)
					{

						jLabel2.setLocation(jLabel2.getX(), jLabel2.getY() + speed);
						try
						{
							Thread.sleep(100);
						}
						catch (InterruptedException ex)
						{
							Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					for (int i = 0; i < 10; i++)
					{

						jLabel2.setLocation(jLabel2.getX(), jLabel2.getY() + (speed * -1));
						try
						{
							Thread.sleep(100);
						}
						catch (InterruptedException ex)
						{
							Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
				}
			}
		});
		jumpThread.start();
	}

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
		catch (UnsupportedAudioFileException ex)
		{
			Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
		}
		catch (LineUnavailableException ex)
		{
			Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
		}
		finally
		{
			try
			{
				audioInputStream.close();
			}
			catch (IOException ex)
			{
				Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
