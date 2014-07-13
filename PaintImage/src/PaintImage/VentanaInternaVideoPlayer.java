/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaintImage;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.media.Buffer;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;


    /**
     * Crea una nueva ventana, con un reproductor de video
     * 
     * @author ivan
     * @version 15.07.2014
     */
public class VentanaInternaVideoPlayer extends javax.swing.JInternalFrame {

    
    Player p;
    /**
     * Crea una ventana interna, con la barra del reproductor, y reproducirá
     * el video correspondiente al fichero que se haya abierto.
     * 
     * @param f fichero de video que va a reproducirse.
     */
    private VentanaInternaVideoPlayer(File f) {
        initComponents();
        try { 
            MediaLocator ml = new MediaLocator("file:"+f.getAbsolutePath()); 
            this.p = Manager.createRealizedPlayer(ml); 
            
            Component areaVisual = this.p.getVisualComponent(); 
            if(areaVisual!=null) 
                this.panelContPanel.add(areaVisual,java.awt.BorderLayout.CENTER);
            Component panelControl = this.p.getControlPanelComponent(); 
            if(panelControl!=null)  
                this.panelContPanel.add(panelControl,java.awt.BorderLayout.SOUTH);
            
        } catch(Exception e) {
            System.err.println("Error al abrir la ventana " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Crea una instancia a partir del constructor, asociando el archivo abierto.
     * 
     * @param f archivo que va a abrirse
     * @return ventana interna de tipo VentanaInternaVideoPlayer
     */
    public static VentanaInternaVideoPlayer getInstance(File f){
            VentanaInternaVideoPlayer vijmf = new VentanaInternaVideoPlayer(f);
            if (vijmf!=null)
                return vijmf;
            else{
                return null;    
            }
   
    }
    
    /**
     * Comienza a reproducir el video.
     */
    public void play(){
        p.start();
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
    /**
     * Captura la imagen que hay ahora mismo en reproduccion.
     * 
     * @return un BufferedImage con la imagen que ha sido capturada. 
     */
    public BufferedImage getFrame(){ 
        FrameGrabbingControl fgc; 
        String claseCtr = "javax.media.control.FrameGrabbingControl "; 
        fgc = (FrameGrabbingControl)this.p.getControl(claseCtr); 
        Buffer bufferFrame = fgc.grabFrame(); 
        BufferToImage bti; 
        bti=new BufferToImage((VideoFormat)bufferFrame.getFormat()); 
        Image img = bti.createImage(bufferFrame); 
        return (BufferedImage)img; 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContPanel = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(200, 200));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        panelContPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        panelContPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelContPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelContPanel;
    // End of variables declaration//GEN-END:variables
}
