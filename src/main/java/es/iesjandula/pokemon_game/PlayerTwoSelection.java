/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.iesjandula.pokemon_game;

import es.iesjandula.pokemon_game.models.Pokemon;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lombok.Data;

/**
 *
 * @author David Martinez Flores
 */
@Data
public class PlayerTwoSelection extends javax.swing.JFrame
{
	private PlayerOneSelection playerOneSelection;
	private DefaultListModel<Pokemon> listModel = new DefaultListModel<>();
	private DefaultListModel<Pokemon> listModel2 = new DefaultListModel<>();

	/**
	 * Creates new form PlayerTwoSelection
	 */
	public PlayerTwoSelection(PlayerOneSelection playerOneSelection)
	{
		this.playerOneSelection = playerOneSelection;
		playerOneSelection.dispose();
		initComponents();
		this.setResizable(false);
		this.listModel = playerOneSelection.getListModel();
		this.jList1.setModel(listModel);
		this.jList2.setModel(listModel2);

		this.setLocationRelativeTo(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{

		jLabel1 = new javax.swing.JLabel();
		jButton4 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList<>();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel7 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jList2 = new javax.swing.JList<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabel1.setText("         CHOOSE YOUR POKEMON!");
		jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jButton4.setText("SELECTION COMPLETE");
		jButton4.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jButton4MouseClicked(evt);
			}
		});
		jButton4.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton4ActionPerformed(evt);
			}
		});

		jButton2.setBackground(new java.awt.Color(255, 153, 102));
		jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		jButton2.setForeground(new java.awt.Color(255, 255, 255));
		jButton2.setText("REMOVE");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jButton2MouseClicked(evt);
			}
		});

		jButton3.setBackground(new java.awt.Color(255, 0, 51));
		jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		jButton3.setForeground(new java.awt.Color(255, 255, 255));
		jButton3.setText("REMOVE ALL");
		jButton3.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
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

		jList1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jList1.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jList1MouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(jList1);

		jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 102, 0));
		jLabel5.setText("SP-ATTACK");
		jLabel5.setBorder(javax.swing.BorderFactory.createCompoundBorder());

		jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(0, 204, 204));
		jLabel6.setText("SP-DEFENSE");
		jLabel6.setBorder(javax.swing.BorderFactory.createCompoundBorder());

		jButton1.setBackground(new java.awt.Color(51, 153, 0));
		jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		jButton1.setForeground(new java.awt.Color(255, 255, 255));
		jButton1.setText("SELECT");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jButton1MouseClicked(evt);
			}
		});

		jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel7.setForeground(new java.awt.Color(248, 0, 243));
		jLabel7.setText("SPEED");
		jLabel7.setBorder(javax.swing.BorderFactory.createCompoundBorder());

		jList2.setForeground(new java.awt.Color(0, 192, 88));
		jList2.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jList2MouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(jList2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(226, 226, 226).addComponent(jLabel1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 363,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(169, 169, 169).addComponent(jButton1)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(jButton2).addGap(57, 57, 57)
										.addComponent(jButton3))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57,
										Short.MAX_VALUE)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap())
				.addGroup(layout.createSequentialGroup().addGap(367, 367, 367).addComponent(jButton4)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(38, 38, 38)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jButton2).addComponent(jButton3).addComponent(jButton1))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel2)
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
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57,
										Short.MAX_VALUE)
								.addComponent(jButton4).addGap(16, 16, 16)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButton4ActionPerformed
		if (this.listModel2.size() > 0)
		{
			PlayerVersusPlayer playerVersusPlayer = new PlayerVersusPlayer(this);
			playerVersusPlayer.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "!OH , YOU NEED CHOOSE MINIMUM 1 POKEMON!");
		}
	}// GEN-LAST:event_jButton4ActionPerformed

	private void jButton2MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButton2MouseClicked
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
		this.listModel2.removeAllElements();
	}// GEN-LAST:event_jButton3MouseClicked

	private void jList1MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jList1MouseClicked
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

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButton1MouseClicked
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

	private void jList2MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jList2MouseClicked
		Pokemon selectedPokemon = this.jList2.getSelectedValue();
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

	private void jButton4MouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButton4MouseClicked
		// VENTANA DE PELEA
	}// GEN-LAST:event_jButton4MouseClicked

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JList<Pokemon> jList1;
	private javax.swing.JList<Pokemon> jList2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	// End of variables declaration//GEN-END:variables
}
