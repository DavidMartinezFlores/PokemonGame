/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.iesjandula.pokemon_game;

import java.io.File;
import java.io.IOException;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author 2DAM
 */
public class PokemonGameIntro extends javax.swing.JFrame
{
	/** Attribute logger*/
	private static final Logger logger = LogManager.getLogger();
	
	/** Attribute mainTheme */
	private Clip mainTheme;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButtonStrarGame;
	private javax.swing.JLabel jLabelBackground;
	private javax.swing.JLabel jLabelPokeballOne;
	private javax.swing.JLabel jLabelPokeballTwo;

	// End of variables declaration//GEN-END:variables
	/**
	 * Creates new form PokemonGameIntro
	 */
	public PokemonGameIntro()
	{
		this.initComponents();
		this.jumpStartButtonAnimationThread();
		this.mainTheme = this.openingThemePlay();
		this.jLabelBackground.setIcon(new ImageIcon("./images/presentation.png"));
		this.jLabelPokeballOne.setIcon(new ImageIcon("./images/pokeball.png"));
		this.jLabelPokeballTwo.setIcon(new ImageIcon("./images/pokeball.png"));

		this.rotatePokeballThreadOne();
		this.rotatePokeballThreadTwo();

		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Method openingThemePlay
	 * 
	 * @return
	 */
	private Clip openingThemePlay()
	{
		Clip clip = null;
		try
		{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./audio/opening.wav"));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch (UnsupportedAudioFileException exception)
		{
			String error = "UnsupportedAudioFileException";
			logger.error(error,exception);
		}
		catch (IOException exception)
		{
			String error = "IOException";
			logger.error(error,exception);
		}
		catch (LineUnavailableException exception)
		{
			String error = "LineUnavailableException";
			logger.error(error,exception);
		}

		return clip;

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
	// Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{

		this.jButtonStrarGame = new javax.swing.JButton();
		this.jLabelPokeballOne = new javax.swing.JLabel();
		this.jLabelPokeballTwo = new javax.swing.JLabel();
		this.jLabelBackground = new javax.swing.JLabel();

		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		this.jButtonStrarGame.setBackground(new java.awt.Color(1, 163, 28));
		this.jButtonStrarGame.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
		this.jButtonStrarGame.setForeground(new java.awt.Color(255, 255, 255));
		this.jButtonStrarGame.setText("START GAME");
		this.jButtonStrarGame.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		this.jButtonStrarGame.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				PokemonGameIntro.this.jButtonStrarGameMouseClicked(evt);
			}
		});
		this.jButtonStrarGame.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				PokemonGameIntro.this.jButtonStrarGameActionPerformed(evt);
			}
		});
		this.getContentPane().add(this.jButtonStrarGame,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 370, 60));

		this.jLabelPokeballOne.setText("   ");
		this.getContentPane().add(this.jLabelPokeballOne,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 146, 114));

		this.jLabelPokeballTwo.setText("   ");
		this.getContentPane().add(this.jLabelPokeballTwo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 165, 104));

		this.jLabelBackground.setText("    ");
		this.getContentPane().add(this.jLabelBackground,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1156, 521));

		this.pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Method jButtonStrarGameActionPerformed
	 * 
	 * @param evt
	 */
	private void jButtonStrarGameActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton1ActionPerformed

	/**
	 * Method jButtonStrarGameMouseClicked
	 * 
	 * @param evt
	 */
	private void jButtonStrarGameMouseClicked(java.awt.event.MouseEvent evt)
	{// GEN-FIRST:event_jButton1MouseClicked
		this.selectButtonSound();
		PlayerOneSelection playerOneSelection = new PlayerOneSelection(this.mainTheme);
		playerOneSelection.setVisible(true);
		this.dispose();
	}// GEN-LAST:event_jButton1MouseClicked

	/**
	 * Method rotatePokeballThreadOne
	 */
	private void rotatePokeballThreadOne()
	{
		Thread rotatePokebal = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				int speed = 1;
				while (true)
				{
					for (int i = 0; i < 30; i++)
					{

						PokemonGameIntro.this.jLabelPokeballOne.setLocation(
								PokemonGameIntro.this.jLabelPokeballOne.getX(),
								PokemonGameIntro.this.jLabelPokeballOne.getY() + speed);
						try
						{
							Thread.sleep(15);
						}
						catch (InterruptedException exception)
						{
							String error = "UnsupportedAudioFileException";
							logger.error(error,exception);
						}
					}
					for (int i = 0; i < 30; i++)
					{

						PokemonGameIntro.this.jLabelPokeballOne.setLocation(
								PokemonGameIntro.this.jLabelPokeballOne.getX(),
								PokemonGameIntro.this.jLabelPokeballOne.getY() + (speed * -1));
						try
						{
							Thread.sleep(15);
						}
						catch (InterruptedException exception)
						{
							String error = "InterruptedException";
							logger.error(error,exception);
						}
					}
				}
			}
		});
		rotatePokebal.start();
	}

	/**
	 * Method rotatePokeballThreadTwo
	 */
	private void rotatePokeballThreadTwo()
	{
		Thread rotatePokebal = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				int speed = 1;
				while (true)
				{
					for (int i = 0; i < 30; i++)
					{

						PokemonGameIntro.this.jLabelPokeballTwo.setLocation(
								PokemonGameIntro.this.jLabelPokeballTwo.getX(),
								PokemonGameIntro.this.jLabelPokeballTwo.getY() + speed);
						try
						{
							Thread.sleep(15);
						}
						catch (InterruptedException exception)
						{
							String error = "InterruptedException";
							logger.error(error,exception);
						}
					}
					for (int i = 0; i < 30; i++)
					{

						PokemonGameIntro.this.jLabelPokeballTwo.setLocation(
								PokemonGameIntro.this.jLabelPokeballTwo.getX(),
								PokemonGameIntro.this.jLabelPokeballTwo.getY() + (speed * -1));
						try
						{
							Thread.sleep(15);
						}
						catch (InterruptedException exception)
						{
							String error = "InterruptedException";
							logger.error(error,exception);
						}
					}
				}
			}
		});
		rotatePokebal.start();
	}

	/**
	 * Method selectButtonSound
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
			logger.error(error,exception);
		}
		catch (IOException exception)
		{
			String error = "IOException";
			logger.error(error,exception);
		}
		catch (LineUnavailableException exception)
		{
			String error = "LineUnavailableException";
			logger.error(error,exception);
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
				logger.error(error,exception);
			}
		}
	}

	/**
	 * Method jumpStartButtonAnimationThread
	 */
	private void jumpStartButtonAnimationThread()
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

						PokemonGameIntro.this.jButtonStrarGame.setLocation(
								PokemonGameIntro.this.jButtonStrarGame.getX(),
								PokemonGameIntro.this.jButtonStrarGame.getY() + speed);
						try
						{
							Thread.sleep(100);
						}
						catch (InterruptedException exception)
						{
							String error = "InterruptedException";
							logger.error(error,exception);
						}
					}
					for (int i = 0; i < 10; i++)
					{

						PokemonGameIntro.this.jButtonStrarGame.setLocation(
								PokemonGameIntro.this.jButtonStrarGame.getX(),
								PokemonGameIntro.this.jButtonStrarGame.getY() + (speed * -1));
						try
						{
							Thread.sleep(100);
						}
						catch (InterruptedException exception)
						{
							String error = "InterruptedException";
							logger.error(error,exception);
						}
					}
				}
			}
		});
		jumpThread.start();
	}
}
