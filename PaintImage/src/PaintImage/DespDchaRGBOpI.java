/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaintImage;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.*;
/**
 *Filtro para procesar una imagen pixel a pixel.
 * Este filtro desplazará hacia la derecha el array RGB.
 * Tal que sí tenemos el array [R,G,B]-> [G,B,R]. 
 * Esto se aplicará pixel a pixel.
 * Por tanto obtendremos una imagen con las bandas cambiadas, lo que puede ser un efecto
 * interesante para retocar o colorear una imagen y darle un aspecto distinto.
 * 
 * @author Ivan Ortega Alba
 * @version 15.07.2014
 */
public class DespDchaRGBOpI extends sm.image.BufferedImageOpAdapter{

    /**
     * Método encargado de aplicar el desplazamiento de bandas sobre los pixeles
     * de la imagen.
     * 
     * @param src Imagen original a la que se va a aplicar el efecto
     * @param dest Imagen a la que asignar la imagen ya filtrada. Si es null, el 
     * programa podrá devolver un {@link BufferedImage} con la imagen resultate.
     * @return Resultado de aplicar el filtro a la imagen original.
     * 
     */
    public BufferedImage filter(BufferedImage src, BufferedImage dest) { 
 
        if (dest == null) { 
        dest = createCompatibleDestImage(src, null); 
        } 
        WritableRaster srcRaster = src.getRaster(); 
        WritableRaster destRaster = dest.getRaster(); 

        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) { 
            BufferedImagePixelIterator.PixelData pixel = it.next() ;
            int temp = pixel.sample[0];
            for (int i = 0; i < 2; i++){
                    pixel.sample[i] = pixel.sample[i+1];
            }
            pixel.sample[2]= temp;
            destRaster.setPixel(pixel.col, pixel.row, pixel.sample); 
            
        } 
        return dest; 
    }
}

