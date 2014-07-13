/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaintImage;

import java.awt.Component;
import java.awt.Graphics;
import java.io.File;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import sm.sound.SMSoundPlayer;

/**
 * Ventana donde se podrá reproducir audio de distintos formatos,
 * asistido por una barra de reproducción.
 * 
 * @version 15.07.2015
 * @author Ivan Ortega Alba
 */


public class VentanaInternaPlayer extends javax.swing.JInternalFrame {

    
    Player p;
    
    /**
     * Constructor para crear una ventana asociada al fichero de audio que se está
     * reproduciendo.
     * 
     * @param f fichero de audio a reproducir.
     */
    private VentanaInternaPlayer(File f) {
        initComponents();
        try { 
            MediaLocator ml = new MediaLocator("file:"+ f.getAbsolutePath()); 
            this.p = Manager.createRealizedPlayer(ml); 
            this.setSize(250,55);
            this.setTitle(f.getAbsolutePath());
            Component panelControl = this.p.getControlPanelComponent(); 
            if(panelControl!=null)  {
                this.add(panelControl,java.awt.BorderLayout.SOUTH);
            }
            } catch(Exception e) {} 
         
    }

    /**
     * Crea una instancia a partir del constructor, asociando el archivo abierto.
     * 
     * @param f archivo que va a abrirse
     * @return ventana interna de tipo VentanaInternaVideoPlayer
     */
    public static VentanaInternaPlayer getInstance(File f){
            VentanaInternaPlayer vip = new VentanaInternaPlayer(f);
            if (vip!=null)
                return vip;
            else{
                return null;    
            }
   
    }
    
    /**
     * Comienza a reproducir el audio.
     */
    public void play(){
        this.p.start();
    }
    
    /**
     * Para la reproduccion del video.
     */
    public void stop(){
        p.stop();
    }
    
    /**
     * Cierra el archivo a reproducir, y libera los recursos.
     */
    public void close(){
        p.close();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(250, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    // End of variables declaration//GEN-END:variables
}
