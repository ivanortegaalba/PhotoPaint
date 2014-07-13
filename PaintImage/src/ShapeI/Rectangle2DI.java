/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ShapeI;

import java.awt.Color;
import java.awt.Paint;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author ivan
 */
public class Rectangle2DI extends Rectangle2D.Double{
    Stroke st;
    Color color;
    GradientPaint gradiente;
    boolean relleno = false;
    
    public Rectangle2DI(Stroke st,Color color) {
        super();
        this.color = color;
        this.st = st;
        this.gradiente = null;
    }
    public Rectangle2DI(Point p1, Point p2, Stroke st,Color color) {
        super(p1.x,p1.y,p2.x,p2.y);
        this.color = color;
        this.st = st;
        this.gradiente = null;
    }
    public Rectangle2DI(Point p1, Point p2, Stroke st,GradientPaint gradiente) {
        super(p1.x,p1.y,p2.x,p2.y);
        this.gradiente = gradiente;
        this.st = st;
    }
    public Rectangle2DI(Stroke st,GradientPaint gradiente) {
        super();
        this.gradiente = gradiente;
        this.st = st;
    }
    public void setStroke(Stroke st){
        this.st = st;
    }
    
    public Stroke getStroke(){
        return st;
    }
    
    public Paint getPaint(){
        if(gradiente != null)
            return gradiente;
        else 
            return color;
    }
   
    
    public boolean getRelleno(){
        return relleno;
    }
    
    public void setPaint(Paint gr){
        if(gr instanceof GradientPaint){
            this.gradiente = (GradientPaint)gr;
        }else{
            this.color = (Color)gr;
            this.gradiente = null;
        }
    }
}