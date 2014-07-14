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
 *Aplica e filtro negativo a una imagen.
 * Pixel a pixel, asigna el valor de cada banda del pixel a:
 * p(r,g,b)=q(255-r,255-g,255-b)
 * 
 * @author Ivan Ortega Alba
 * @version 15.07.2014
 */
public class NegativoOp extends sm.image.BufferedImageOpAdapter{
    
    @Override
    /**
     * Aplica el negativo a una imagen y la transforma dando lugar a la misma con
     * dicho filtro aplicado.
     * 
     * @param src imagen a la que aplicar el filtro
     * @param dest imagen a la que asignar el resultado de aplicar el filtro. Puede
     * ser null, y recoger la imagen devuelta.
     * 
     * @return imagen con el filtro ya aplicado.
     */
    public BufferedImage filter(BufferedImage src, BufferedImage dest){ 
 
        if (dest == null) { 
        dest = createCompatibleDestImage(src, null); 
        } 
        WritableRaster srcRaster = src.getRaster(); 
        WritableRaster destRaster = dest.getRaster(); 

        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) { 
            BufferedImagePixelIterator.PixelData pixel = it.next() ;
            for (int i = 0; i < 3; i++)
                    pixel.sample[i]= 255 - pixel.sample[i];
            destRaster.setPixel(pixel.col, pixel.row, pixel.sample); 
        } 
        return dest; 
    }
}
