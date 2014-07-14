/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ShapeI;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author ivan
 */
public class Ellipse2DI extends Ellipse2D.Double{
    
    
    Stroke st;
    Color colorBorde;
    Paint colorRelleno;
    
    public Ellipse2DI(Stroke st,Color color){
        super();
        this.colorBorde = color;
        this.st = st;
        this.colorRelleno = null;
    }
    public Ellipse2DI(Point p1, Point p2, Stroke st,Color color) {
        super(p1.x,p1.y,p2.x,p2.y);
        this.colorBorde = color;
        this.st = st;
        this.colorRelleno = null;
    }

    public void setStroke(Stroke st){
        this.st = st;
    }
    
    public Stroke getStroke(){
        return st;
    }
    
    public Paint getColor1(){
        if(colorRelleno != null)
            return colorRelleno;
        else return null;
    }
    
    public void setColorRelleno(Paint gr){
        if(gr instanceof GradientPaint){
            this.colorRelleno = (GradientPaint)gr;
        }else{
            this.colorRelleno = (Color)gr;
        }
    }
    public void setColorBorde(Color c){
        this.colorBorde = c;
    }
    
    public Color getColorBorde(){
        return this.colorBorde;
    }
    
    public Paint getColorRelleno(){
        return colorRelleno;
    } 
}
