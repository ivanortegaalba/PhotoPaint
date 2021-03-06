package sm.sound;

import java.io.File;
import javax.sound.sampled.*;

/**
 * Grabador de audio basado en la clase 'TargetDataLine' de la Java Sound API
 * @author Jesus Chamorro
 */
public class SMSoundRecorder implements SMRecorder {
    // Constantes para el grabador
    private static final AudioFormat.Encoding _DEFAULT_CODING = AudioFormat.Encoding.PCM_SIGNED;
    private static final float _DEFAULT_SAMPLE_RATE = 44100.0f;
    private static final int _DEFAULT_SAMPLE_SIZE = 16;
    private static final int _DEFAULT_NUMCHANELS = 2;
    private static final int _DEFAULT_FRAME_SIZE = ((_DEFAULT_SAMPLE_SIZE/8)*_DEFAULT_NUMCHANELS);
    private static final float _DEFAULT_FRAME_RATE = _DEFAULT_SAMPLE_RATE; 
    private static final boolean _DEFAULT_BIGENDIAN = false;
    private static final AudioFileFormat.Type _DEFAULT_FILE_FORMAT = AudioFileFormat.Type.WAVE;
    // Variables
    private DataLine line;
    private LineListener lineListener = null;
    private File soundFile;
     
    /**
     *  Constructor 
     */
    public SMSoundRecorder(File f){
      soundFile = f;  
    }
    
    /**
     *  Lanza el proceso de grabación creando una hebra 
     */
    @Override
    public void record(){
        // Creamos la hebra sobrecargando el método run()
        Thread thread = new Thread(){
            public void run() { 
                startRecord();
            }
        };
        thread.start(); // Lanzamos la hebra
    }
    
    /**
     *  Detiene el proceso de grabación 
     */
    @Override
    public void stop(){
        if(line!=null){
            line.stop();
            line.close();
        }
        /* La hebra se cierra automáticamente: al cerrar la línea, el método 
        *  run() finaliza (al finalizar las llamadas 'write') y, con ello,
        *  la hebra */
    }
    
    /**
     *  Lleva a cabo la grabación sobre el fichero 'soundFile' usando los valores
     *  por defecto (veánse constantes).
     * 
     *  IMPORTANTE: Este método debe llamarse dentro de una hebra (de lo contrario,
     *              entraría en una grabación constante que nunca terminaría). 
     */
    private void startRecord(){
        // Definimos el formato de audio usando los valores por defecto (veánse constantes)
	AudioFormat audioFormat = new AudioFormat(_DEFAULT_CODING, _DEFAULT_SAMPLE_RATE, _DEFAULT_SAMPLE_SIZE,_DEFAULT_NUMCHANELS, _DEFAULT_FRAME_SIZE, _DEFAULT_FRAME_RATE, _DEFAULT_BIGENDIAN);
        // Creamos (y abrimos) la línea que usaremos para leer el audio.       
        DataLine.Info	info = new DataLine.Info(TargetDataLine.class, audioFormat);
        TargetDataLine targetDataLine = null;
        try{
            line = targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
            line.addLineListener(lineListener);
            targetDataLine.open(audioFormat);
        }
        catch (Exception e) {
            System.err.println("SMSoundRecorder: "+e);
        }
        // Definimos el formato de fichero usando los valores por defecto (veánse constantes)	
	AudioFileFormat.Type targetType = _DEFAULT_FILE_FORMAT;
        // Creamos el stream de entrada asociado a la línea
        AudioInputStream audioInputStream = new AudioInputStream(targetDataLine);
        // Comienza la grabación
        targetDataLine.start();
        try {
            AudioSystem.write(audioInputStream,targetType,soundFile);
        }
        catch (Exception e){
            System.err.println("SMSoundRecorder: "+e);
        }
        // WARNING: La grabación debe detenerse desde fuera de este método llamando a 'stop'
    }
  
    /**
     *  Activa el manejador de eventos 
     */
    public void setLineListener(LineListener l){
        lineListener = l;
    }
    
}
