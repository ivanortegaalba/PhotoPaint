/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaintImage;
import java.io.File;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import sm.sound.SMSoundRecorder;
/**
 * Ventana que muestra el capturador de audio, que guardará la grabación
 * en un archivo previamente asignado a dicha ventana mediante el constructor.
 * 
 * @author Ivan Ortega Alba
 */
public class VentanaInternaRecorder extends javax.swing.JInternalFrame {

    SMSoundRecorder recorder;
    
    /**
     * Crea una ventana interna asociada a un archivo, donde se guardará
     * todo lo que se grabe.
     * 
     * @param f Archivo donde va a guardarse la grabación.
     */
    public VentanaInternaRecorder(File f) {
        initComponents();
        recorder = new SMSoundRecorder(f);
        recorder.setLineListener(this.lineListener);
    }

    
    /**
     * Manejador de eventos, que capturará cuando comienza o para de grabar, para 
     * cambiar los iconos de forma automática.
     */
    LineListener lineListener = new LineListener(){
        @Override
        public void update(LineEvent event) {
            if(event.getType()==LineEvent.Type.START) {
                recordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosAudio/RecordDisabled_48x48.png")));
                stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosAudio/StopNormalRed_48x48.png")));
                recordButton.setSelected(true);
            }
            if(event.getType()==LineEvent.Type.STOP) {
                stopButton.setSelected(true);
                recordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosAudio/RecordPressed_48x48.png")));
                stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosAudio/StopDisabled_48x48.png")));
            
            }
        }
    };
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        recordButton = new javax.swing.JToggleButton();
        stopButton = new javax.swing.JToggleButton();

        getContentPane().setLayout(new java.awt.GridLayout());

        buttonGroup.add(recordButton);
        recordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosAudio/RecordPressed_48x48.png"))); // NOI18N
        recordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordButtonActionPerformed(evt);
            }
        });
        getContentPane().add(recordButton);

        buttonGroup.add(stopButton);
        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosAudio/StopDisabled_48x48.png"))); // NOI18N
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stopButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Comienza a grabar
     */
    private void recordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordButtonActionPerformed
        recorder.record();
    }//GEN-LAST:event_recordButtonActionPerformed
    /**
     * Para la grabación
     */
    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        recorder.stop();
    }//GEN-LAST:event_stopButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JToggleButton recordButton;
    private javax.swing.JToggleButton stopButton;
    // End of variables declaration//GEN-END:variables
}
