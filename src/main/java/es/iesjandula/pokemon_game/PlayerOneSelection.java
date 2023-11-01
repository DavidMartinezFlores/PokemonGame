/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.iesjandula.pokemon_game;

import es.iesjandula.pokemon_game.models.Pokemon;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
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
import lombok.Data;

/**
 *
 * @author David Martinez Flores
 */
@Data
public class PlayerOneSelection extends javax.swing.JFrame implements Serializable
{
        private String playerOneName;
	private Clip mainTheme;
        private DefaultListModel<Pokemon> temporalListModel = new DefaultListModel<>();
	private DefaultListModel<Pokemon> listModel = new DefaultListModel<>();
	private DefaultListModel<Pokemon> listModel2 = new DefaultListModel<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SpriteSelectedPlayerOne;
    private javax.swing.ButtonGroup buttonGroupPlayerOneSprite;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<Pokemon> jList1;
    private javax.swing.JList<Pokemon> jList2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

	/**
	 * Creates new form MainJFrmae
	 */
	public PlayerOneSelection(Clip clip)
	{
		this.initComponents();
                this.SpriteSelectedPlayerOne.setIcon(new ImageIcon("./images/red.png"));
                this.playerOneName="Player One";
                this.jLabel10.setText(playerOneName);
		this.listModel.addAll(this.loadAllPokemons());
		this.jList1.setModel(listModel);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.mainTheme = clip;
		this.jumpPokemonAnimationThread();
	}

	private List<Pokemon> loadAllPokemons()
	{
		Application application = new Application();
		return application.getPokemonList();
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupPlayerOneSprite = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        SpriteSelectedPlayerOne = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setBackground(new java.awt.Color(200, 252, 255));
        jList1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setBackground(new java.awt.Color(51, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SELECT");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jList2.setForeground(new java.awt.Color(0, 163, 48));
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("         CHOOSE YOUR POKEMON!");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setBackground(new java.awt.Color(255, 153, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("REMOVE");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("REMOVE ALL");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 117, 0));
        jLabel2.setText("HEALTH");
        jLabel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("ATTACK");
        jLabel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("DEFENSE");
        jLabel4.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("SP-ATTACK");
        jLabel5.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("SP-DEFENSE");
        jLabel6.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(248, 0, 243));
        jLabel7.setText("SPEED");
        jLabel7.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jButton4.setBackground(new java.awt.Color(51, 204, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("SELECTION COMPLETE");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel8.setText("FILTER:");

        jButton5.setText("RESET FILTER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Player One Name:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("       ");

        buttonGroupPlayerOneSprite.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Red");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroupPlayerOneSprite.add(jRadioButton2);
        jRadioButton2.setText("Blue");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        SpriteSelectedPlayerOne.setText(" ");

        buttonGroupPlayerOneSprite.add(jRadioButton3);
        jRadioButton3.setText("Ranger");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroupPlayerOneSprite.add(jRadioButton4);
        jRadioButton4.setText("Female Ranger");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroupPlayerOneSprite.add(jRadioButton5);
        jRadioButton5.setText("Normal Female");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Load State");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(61, 61, 61)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SpriteSelectedPlayerOne, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jButton1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jButton2)
                        .addGap(57, 57, 57)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(jButton4)))
                        .addGap(166, 166, 166))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jButton5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addGap(37, 37, 37)
                                .addComponent(jRadioButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SpriteSelectedPlayerOne, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        System.out.println("Presiono Enter");
        this.temporalListModel = new DefaultListModel<>();

        for(int i = 0 ; i<listModel.size();i++)
        {
            if(listModel.get(i).getName().toLowerCase().contains(this.jTextField1.getText().toLowerCase()))
            {
                this.temporalListModel.add(0, listModel.get(i));
            }
        }

        this.jList1.setModel(temporalListModel);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.jList1.setModel(this.listModel);
        this.jTextField1.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        this.playerOneName=this.jTextField2.getText().trim();
        if(this.playerOneName.length()<=16&& !this.playerOneName.isEmpty())
        {
            this.jLabel10.setText(playerOneName);
        }else
        {
            JOptionPane.showMessageDialog(null, "The selected name is too big or empty (16 chars max)");
        }
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        this.SpriteSelectedPlayerOne.setIcon(new ImageIcon("./images/red.png"));
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        this.SpriteSelectedPlayerOne.setIcon(new ImageIcon("./images/blue.png"));
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        this.SpriteSelectedPlayerOne.setIcon(new ImageIcon("./images/ranger.png"));
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        this.SpriteSelectedPlayerOne.setIcon(new ImageIcon("./images/femaleRanger.png"));
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        this.SpriteSelectedPlayerOne.setIcon(new ImageIcon("./images/normalFemale.png"));
    }//GEN-LAST:event_jRadioButton5ActionPerformed

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jMenuItem1ActionPerformed
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
	}// GEN-LAST:event_jMenuItem1ActionPerformed

	private void jButton2MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButton2MouseClicked
		this.selectButtonSound();
		Pokemon selectedPokemon = this.jList2.getSelectedValue();

		if (this.listModel2.contains(selectedPokemon))
		{
			for (int i = 0; i < this.listModel2.size(); i++)
			{
				Pokemon temporalPokemon = this.listModel2.get(i);
				if (temporalPokemon.equals(selectedPokemon))
				{
					this.listModel2.remove(i);
				}
			}
		}
	}// GEN-LAST:event_jButton2MouseClicked

	private void jButton3MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButton3MouseClicked
		this.selectButtonSound();
		this.listModel2.removeAllElements();
	}// GEN-LAST:event_jButton3MouseClicked

	private void jList1MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jList1MouseClicked
		this.selectButtonSound();
		Pokemon selectedPokemon = this.jList1.getSelectedValue();
		ImageIcon icon = new ImageIcon(selectedPokemon.getPokeImage());
		this.jLabel1.setIcon(icon);
		this.jLabel1.setText(selectedPokemon.getName());

		this.jLabel2.setText("Health: " + selectedPokemon.getHealth());
		this.jLabel3.setText("Attack: " + selectedPokemon.getAttack());
		this.jLabel4.setText("SP-Attack: " + selectedPokemon.getSpAttack());
		this.jLabel5.setText("Defense: " + selectedPokemon.getDefense());
		this.jLabel6.setText("SP-Defense: " + selectedPokemon.getSpDefense());
		this.jLabel7.setText("Speed: " + selectedPokemon.getSpeed());
		this.repaint();

	}// GEN-LAST:event_jList1MouseClicked

	private void jList2MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jList2MouseClicked
		Pokemon selectedPokemon = this.jList2.getSelectedValue();
		this.selectButtonSound();
		if (selectedPokemon != null)
		{
			ImageIcon icon = new ImageIcon(selectedPokemon.getPokeImage());
			this.jLabel1.setIcon(icon);
			this.jLabel1.setText(selectedPokemon.getName());

			this.jLabel2.setText("Health: " + selectedPokemon.getHealth());
			this.jLabel3.setText("Attack: " + selectedPokemon.getAttack());
			this.jLabel4.setText("SP-Attack: " + selectedPokemon.getSpAttack());
			this.jLabel5.setText("Defense: " + selectedPokemon.getDefense());
			this.jLabel6.setText("SP-Defense: " + selectedPokemon.getSpDefense());
			this.jLabel7.setText("Speed: " + selectedPokemon.getSpeed());
			this.repaint();
		}
	}// GEN-LAST:event_jList2MouseClicked

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButton4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton4ActionPerformed

	private void jButton4MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButton4MouseClicked
		this.selectButtonSound();
		if (this.listModel2.size() > 0)
		{
			PlayerTwoSelection playerTwoSelection = new PlayerTwoSelection(this);
			playerTwoSelection.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "!OH , YOU NEED CHOOSE MINIMUM 1 POKEMON!");
                        this.jLabel10.setText("Player One");
		}
	}// GEN-LAST:event_jButton4MouseClicked

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButton1MouseClicked
		this.selectButtonSound();
		Pokemon selectedPokemon = this.jList1.getSelectedValue();

		if (listModel2.contains(selectedPokemon))
		{
			JOptionPane.showMessageDialog(this, "You alrready select " + selectedPokemon.getName());
		}
		else if (this.listModel2.size() < 5)
		{
			this.listModel2.add(0, selectedPokemon);
			this.jList2.setModel(listModel2);
			System.out.println(listModel2);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "You have 5 Pokemons selected!");
		}

	}// GEN-LAST:event_jButton1MouseClicked

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

	private void jumpPokemonAnimationThread()
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
}
