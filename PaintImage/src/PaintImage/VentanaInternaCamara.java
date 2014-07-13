/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaintImage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.media.Buffer;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.format.YUVFormat;
import javax.media.util.BufferToImage;
import org.netbeans.lib.awtextra.AbsoluteLayout;


/**
 *
 * @author ivan
 */
public class VentanaInternaCamara extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaInternaCamara
     */
    Player p;
    
    public VentanaInternaCamara() {
        initComponents();
        try { 
            CaptureDeviceInfo deviceInfo; 
            List<CaptureDeviceInfo> deviceList = CaptureDeviceManager.getDeviceList(new YUVFormat()); 
            deviceInfo = deviceList.get(0); 
            MediaLocator ml = deviceInfo.getLocator(); 
            this.p = Manager.createRealizedPlayer(ml); 
            Component areaVisual = p.getVisualComponent(); 
            
            if(areaVisual!=null) this.add(areaVisual,BorderLayout.CENTER); 
                Component panelControl = p.getControlPanelComponent(); 
            if(panelControl!=null) 
                this.add(panelControl,BorderLayout.SOUTH); 
            
            } catch(Exception e) {} 
    }
    
    static public VentanaInternaCamara getInstance(){
        VentanaInternaCamara vic = new VentanaInternaCamara();
        return vic!=null?vic:null;
        
    }
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
