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
 *
 * @author ivan
 */
public class NegativoOp extends sm.image.BufferedImageOpAdapter{
    
    @Override
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
