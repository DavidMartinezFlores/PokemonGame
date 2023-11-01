/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.iesjandula.pokemon_game;

import es.iesjandula.pokemon_game.models.Pokemon;
import java.awt.HeadlessException;
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
import javax.swing.Icon;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author David Martinez Flores
 */
public class PlayerVersusPlayer extends javax.swing.JFrame implements Serializable
{
	private Clip mainTheme;

        private String playerOneName;
        private String playerTwoName;
        
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

                this.SpriteSelectedPlayerOne.setIcon(playerTwoSelection.getPlayerOneSelection().getSpriteSelectedPlayerOne().getIcon());
                this.SpriteSelectedPlayerTwo.setIcon(playerTwoSelection.getSpriteSelectedPlayerTwo().getIcon());
                
                
                this.jLabelBackground.setIcon(new ImageIcon("./images/selectionBack.jpg"));
		this.jLabel3.setIcon(new ImageIcon("./images/versus.png"));

		this.playerOneSelection = playerTwoSelection.getPlayerOneSelection();
		this.playerTwoSelection = playerTwoSelection;
               
                this.playerOneName= playerOneSelection.getPlayerOneName();
                this.playerTwoName= playerTwoSelection.getPlayerTwoName();
                
                this.jLabel4.setText(playerOneName);
                this.jLabel5.setText(playerTwoName);
                
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

		this.jLabel6.setText(this.listPlayerOne.get(0).getName());
		this.jLabel9.setText(this.listPlayerTwo.get(0).getName());

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
                
                this.jLabel4.setText(playerOneName);
                this.jLabel5.setText(playerTwoName);
                
		this.jList1.setModel(listPlayerOne);
		this.jList2.setModel(listPlayerTwo);

		this.jLabel6.setText(this.currentPlayerOnePokemon.getName());
		this.jLabel9.setText(this.currentPlayerTwoPokemon.getName());

		this.jLabel1.setIcon(this.iconPlayer1);
		this.jLabel2.setIcon(this.iconPlayer2);

		this.jLabel4Player1Health.setText(currentPlayerOnePokemon.getHealth() + "");
		this.jLabel5Player2Health.setText(currentPlayerTwoPokemon.getHealth() + "");

		this.setLocationRelativeTo(null);

		this.jLabelPokeball.setIcon(new ImageIcon("./images/pokeball.png"));

		this.rotatePokeballThread();

		this.jumpPlayerOneAnimationThread();
		this.jumpPlayerTwoAnimationThread();
                
                this.jLabel4Player1Health.setText(String.format("%.2f", Double.parseDouble(this.jLabel4Player1Health.getText())));
                this.jLabel5Player2Health.setText(String.format("%.2f",Double.parseDouble(this.jLabel5Player2Health.getText())));
                
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
        jButtonREADY = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4Player1Health = new javax.swing.JLabel();
        jLabel5Player2Health = new javax.swing.JLabel();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        SpriteSelectedPlayerOne = new javax.swing.JLabel();
        SpriteSelectedPlayerTwo = new javax.swing.JLabel();
        jLabelBackground = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonREADY.setBackground(new java.awt.Color(0, 204, 51));
        jButtonREADY.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonREADY.setForeground(new java.awt.Color(255, 255, 255));
        jButtonREADY.setText("READY");
        jButtonREADY.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        getContentPane().add(jButtonREADY, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, 105, 60));

        jList1.setBackground(new java.awt.Color(200, 252, 255));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 352, -1));

        jList2.setBackground(new java.awt.Color(255, 200, 200));
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 359, -1));

        jLabel1.setToolTipText("heyyy");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, 158));

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 150, 150));

        jLabel3.setText("                ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 98, 94));

        jLabel4Player1Health.setText("jLabel4");
        getContentPane().add(jLabel4Player1Health, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        jLabel5Player2Health.setText("jLabel5");
        getContentPane().add(jLabel5Player2Health, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, -1, -1));

        buttonGroupPlayer1.add(jRadioButtonPlayerOnePhysicalAttack);
        jRadioButtonPlayerOnePhysicalAttack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonPlayerOnePhysicalAttack.setText("PHYSICAK ATTACK");
        jRadioButtonPlayerOnePhysicalAttack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPlayerOnePhysicalAttackMouseClicked(evt);
            }
        });
        getContentPane().add(jRadioButtonPlayerOnePhysicalAttack, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, -1, -1));

        buttonGroupPlayer1.add(jRadioButtonPlayerOneSpecialAttack);
        jRadioButtonPlayerOneSpecialAttack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
        getContentPane().add(jRadioButtonPlayerOneSpecialAttack, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, -1, -1));

        buttonGroupPlayer2.add(jRadioButtonPlayerTwoPhysicalAttack);
        jRadioButtonPlayerTwoPhysicalAttack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonPlayerTwoPhysicalAttack.setText("PHYSICAL ATTACK");
        jRadioButtonPlayerTwoPhysicalAttack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPlayerTwoPhysicalAttackMouseClicked(evt);
            }
        });
        getContentPane().add(jRadioButtonPlayerTwoPhysicalAttack, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, -1, -1));

        buttonGroupPlayer2.add(jRadioButtonPlayerTwoSpecialAttack);
        jRadioButtonPlayerTwoSpecialAttack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonPlayerTwoSpecialAttack.setText("SPECIAL ATTACK");
        jRadioButtonPlayerTwoSpecialAttack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPlayerTwoSpecialAttackMouseClicked(evt);
            }
        });
        getContentPane().add(jRadioButtonPlayerTwoSpecialAttack, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, -1, -1));

        jButtonChangePokemonPlayerOne.setBackground(new java.awt.Color(255, 51, 0));
        jButtonChangePokemonPlayerOne.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonChangePokemonPlayerOne.setForeground(new java.awt.Color(255, 255, 255));
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
        getContentPane().add(jButtonChangePokemonPlayerOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 250, 29));

        jButtonChangePokemonPlayerTwo.setBackground(new java.awt.Color(255, 51, 0));
        jButtonChangePokemonPlayerTwo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonChangePokemonPlayerTwo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonChangePokemonPlayerTwo.setText("CHANGE SELECTED POKEMON");
        jButtonChangePokemonPlayerTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonChangePokemonPlayerTwoMouseClicked(evt);
            }
        });
        getContentPane().add(jButtonChangePokemonPlayerTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 650, 250, 29));

        jLabelPokeball.setText("         ");
        getContentPane().add(jLabelPokeball, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 105, 114));

        jLabelPlayerOneChanges.setBackground(new java.awt.Color(255, 153, 0));
        jLabelPlayerOneChanges.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPlayerOneChanges.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPlayerOneChanges.setText("Changes:");
        jLabelPlayerOneChanges.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelPlayerOneChanges.setOpaque(true);
        getContentPane().add(jLabelPlayerOneChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, -1));

        jLabelPlayerTwoChanges.setBackground(new java.awt.Color(255, 153, 0));
        jLabelPlayerTwoChanges.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPlayerTwoChanges.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPlayerTwoChanges.setText("Changes:");
        jLabelPlayerTwoChanges.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelPlayerTwoChanges.setOpaque(true);
        getContentPane().add(jLabelPlayerTwoChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 560, -1, -1));

        jProgressBar1.setForeground(new java.awt.Color(0, 204, 0));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 130, 16));

        jProgressBar2.setForeground(new java.awt.Color(51, 204, 0));
        getContentPane().add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 130, 16));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 162, 22));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 162, 22));

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/basicCard.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/basicCard.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("       v1.0.0");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 1020, 40));

        SpriteSelectedPlayerOne.setText(" ");
        getContentPane().add(SpriteSelectedPlayerOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 90, 160));

        SpriteSelectedPlayerTwo.setText(" ");
        getContentPane().add(SpriteSelectedPlayerTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 90, 160));

        jLabelBackground.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 740));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       // GEN-FIRST:event_jMenuItem1ActionPerformed
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
                
                partyList.add(playerOneName);
                partyList.add(playerTwoName);
                
                partyList.add(this.SpriteSelectedPlayerOne.getIcon());
                partyList.add(this.SpriteSelectedPlayerTwo.getIcon());
                
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
		this.jLabel9.setText(this.currentPlayerTwoPokemon.getName());

		this.jLabel5Player2Health.setText(String.format("%.2f", currentPlayerTwoPokemon.getHealth()));
		this.repaint();
            }
        this.checkEndOfParty();
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
		this.jLabel9.setText(this.currentPlayerTwoPokemon.getName());

		this.jLabel5Player2Health.setText(String.format("%.2f", currentPlayerTwoPokemon.getHealth()));
		this.repaint();
            }
        this.checkEndOfParty();
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
                
                Pokemon temporalAttackPlayerOnePoke = this.currentPlayerOnePokemon;
                Pokemon temporalAttackPlayerTwoPoke = this.currentPlayerTwoPokemon;
                
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
                                
				if (this.listPlayerTwo.size()>0 && this.currentPlayerTwoPokemon.getName().equals(temporalAttackPlayerTwoPoke.getName()))
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

				if (this.listPlayerOne.size()>0 && this.currentPlayerOnePokemon.getName().equals(temporalAttackPlayerOnePoke.getName()))
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
                        
			if (this.listPlayerTwo.size()>0 && this.currentPlayerTwoPokemon.getName().equals(temporalAttackPlayerTwoPoke.getName()))
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
		else if (this.currentPlayerOnePokemon.getSpeed() < this.currentPlayerTwoPokemon.getSpeed())
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

			if (this.listPlayerOne.size()>0 && this.currentPlayerOnePokemon.getName().equals(temporalAttackPlayerOnePoke.getName()))
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

				String initialText = jLabel9.getText();
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
				jLabel2.setText("");

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
				
				int startPosition = jLabel1.getX();
				int speed = 1;
				for (int i = 0; i < 300; i++)
				{
					
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
				this.jLabel6.setText(this.currentPlayerOnePokemon.getName());
				this.jLabel1.setIcon(this.iconPlayer1);
				this.jLabel4Player1Health.setText(String.format("%.2f", currentPlayerOnePokemon.getHealth()));

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
				this.jLabel9.setText(this.currentPlayerTwoPokemon.getName());
				this.jLabel2.setIcon(this.iconPlayer2);
				this.jLabel5Player2Health.setText(String.format("%.2f", currentPlayerTwoPokemon.getHealth()));

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
                    health = health<=0 ? 0 : health;
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
                    this.jLabel6.setText(this.currentPlayerOnePokemon.getName());
                    this.jLabel4Player1Health.setText(String.format("%.2f", currentPlayerOnePokemon.getHealth()));
                    this.repaint();
                }
        this.checkEndOfParty();
	}

    private void checkEndOfParty() throws HeadlessException {
        if(this.listPlayerOne.size()<=0)
        {
            this.jProgressBar1.setValue(
                    (int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
            this.jProgressBar2.setValue(
                    (int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
            JOptionPane.showMessageDialog(null, ""+this.playerTwoName+" is the Winner!");
            EndOfParty endOfParty = new EndOfParty(this.playerTwoName+" won the Game",this.SpriteSelectedPlayerTwo.getIcon());
            this.mainTheme.stop();
            endOfParty.setVisible(true);
            this.dispose();
        }
        else if(this.listPlayerTwo.size()<=0)
        {
            this.jProgressBar1.setValue(
                    (int) ((this.currentPlayerOnePokemon.getHealth() * 100) / this.currentPlayerOnePokemon.getMaxHeatlh()));
            this.jProgressBar2.setValue(
                    (int) ((this.currentPlayerTwoPokemon.getHealth() * 100) / this.currentPlayerTwoPokemon.getMaxHeatlh()));
            JOptionPane.showMessageDialog(null, ""+this.playerOneName+" is the Winner!");
            EndOfParty endOfParty = new EndOfParty(this.playerOneName+" won the Game",this.SpriteSelectedPlayerOne.getIcon());
            this.mainTheme.stop();
            endOfParty.setVisible(true);
            this.dispose();
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
                    this.jLabel6.setText(this.currentPlayerOnePokemon.getName());
                    this.jLabel4Player1Health.setText(String.format("%.2f", currentPlayerOnePokemon.getHealth()));
                    this.repaint();
                }
        this.checkEndOfParty();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SpriteSelectedPlayerOne;
    private javax.swing.JLabel SpriteSelectedPlayerTwo;
    private javax.swing.ButtonGroup buttonGroupPlayer1;
    private javax.swing.ButtonGroup buttonGroupPlayer2;
    private javax.swing.JButton jButtonChangePokemonPlayerOne;
    private javax.swing.JButton jButtonChangePokemonPlayerTwo;
    private javax.swing.JButton jButtonREADY;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel4Player1Health;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel5Player2Health;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBackground;
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
