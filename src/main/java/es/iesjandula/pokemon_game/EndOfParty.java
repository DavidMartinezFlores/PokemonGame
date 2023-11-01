/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.iesjandula.pokemon_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

/**
 *
 * @author USUARIO
 */
public class EndOfParty extends javax.swing.JFrame {

    private Clip mainTheme;
    /**
     * Creates new form EndOfParty
     */
    public EndOfParty(String winner) {
        initComponents();
        this.mainTheme = this.getMainTheme();
        if (this.mainTheme!=null)
        {
          this.mainTheme.start();
          this.mainTheme.loop(Clip.LOOP_CONTINUOUSLY);
        }

        this.jLabel2.setIcon(new ImageIcon("./images/pokeball.png"));
	this.jLabel3.setIcon(new ImageIcon("./images/pokeball.png"));
        this.jLabel1.setText(winner);
        this.rotatePokeballThreadOne();
        this.rotatePokeballThreadTwo();
        
        this.setResizable(false);
	this.setLocationRelativeTo(null);
        
        this.buttonsAnimation();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 188, 49));
        jLabel1.setText("jLabel1");

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("EXIT GAME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(7, 139, 220));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("RESTART GAME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("      ");

        jLabel3.setText("      ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PokemonGameIntro gameIntro = new PokemonGameIntro();
        gameIntro.setVisible(true);
        this.mainTheme.stop();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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

						jLabel2.setLocation(jLabel2.getX(), jLabel2.getY() + speed);
						try
						{
							Thread.sleep(35);
						}
						catch (InterruptedException ex)
						{
							Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					for (int i = 0; i < 30; i++)
					{

						jLabel2.setLocation(jLabel2.getX(), jLabel2.getY() + (speed * -1));
						try
						{
							Thread.sleep(35);
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

						jLabel3.setLocation(jLabel3.getX(), jLabel3.getY() + speed);
						try
						{
							Thread.sleep(35);
						}
						catch (InterruptedException ex)
						{
							Logger.getLogger(PlayerVersusPlayer.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					for (int i = 0; i < 30; i++)
					{

						jLabel3.setLocation(jLabel3.getX(), jLabel3.getY() + (speed * -1));
						try
						{
							Thread.sleep(35);
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
   
   private void buttonsAnimation()
   {
       Thread animation = new Thread(new Runnable(){
           @Override
           public void run() {
               while(true){
                int speed = 1;
                for(int i =0 ;i<10;i++)
                {
                    jButton2.setLocation(jButton2.getX(), jButton2.getY()+speed);
                    jButton1.setLocation(jButton1.getX(), jButton1.getY()+speed);
                    try {
                        Thread.sleep(120);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EndOfParty.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for(int i =0 ;i<10;i++)
                {
                    jButton2.setLocation(jButton2.getX(), jButton2.getY()+ (speed * -1));
                    jButton1.setLocation(jButton1.getX(), jButton1.getY()+ (speed * -1));
                    try {
                        Thread.sleep(120);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EndOfParty.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               }
           }
       }
       );
       animation.start();
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    private Clip getMainTheme() {
        Clip clip = null;
              
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./audio/victory.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EndOfParty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(EndOfParty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EndOfParty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(EndOfParty.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clip;
    }
}
