/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaintImage;

/**
 *
 * @author ivan
 */
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.*;

public class UmbralizacionOp extends sm.image.BufferedImageOpAdapter{
    private int umbral; 
 
    public UmbralizacionOp(int umbral) { 
        this.umbral = umbral; 
    } 

    public BufferedImage filter(BufferedImage src, BufferedImage dest){ 
 
        if (dest == null) { 
        dest = createCompatibleDestImage(src, null); 
        } 
        WritableRaster srcRaster = src.getRaster(); 
        WritableRaster destRaster = dest.getRaster(); 

        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) { 
            BufferedImagePixelIterator.PixelData pixel = it.next() ;
            for (int i = 0; i < 3; i++)
                if(pixel.sample[i] > this.umbral){
                    pixel.sample[i]= 255;
                }else
                    pixel.sample[i]=0;
            destRaster.setPixel(pixel.col, pixel.row, pixel.sample); 
        } 
        return dest; 
    } 

} 

