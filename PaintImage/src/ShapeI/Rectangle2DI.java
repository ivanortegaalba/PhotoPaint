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
    Color colorBorde;
    Paint colorRelleno;
    boolean relleno = false;
    
    public Rectangle2DI(Stroke st,Color color){
        super();
        this.colorBorde = color;
        this.st = st;
        this.colorRelleno = null;
    }
    public Rectangle2DI(Point p1, Point p2, Stroke st,Color color) {
        super(p1.x,p1.y,p2.x,p2.y);
        this.colorBorde = color;
        this.st = st;
        this.colorRelleno = null;
    }
    public Rectangle2DI(Point p1, Point p2, Stroke st,Paint colorRelleno) {
        super(p1.x,p1.y,p2.x,p2.y);
        this.colorRelleno = colorRelleno;
        this.st = st;
        this.relleno = true;
    }
    public Rectangle2DI(Stroke st,Paint colorRelleno) {
        super();
        this.relleno = true;
        this.colorRelleno = colorRelleno;
        this.st = st;
    }
    public void setStroke(Stroke st){
        this.st = st;
    }
    
    public Stroke getStroke(){
        return st;
    }
    
    public Paint getColorRelleno(){
        if(colorRelleno != null)
            return colorRelleno;
        else return null;
    }
    
    public void setColorRelleno(Paint gr){
        this.relleno = true;
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
    
    public boolean getRelleno(){
        return relleno;
    }
    
    public void setRelleno(boolean r){
        this.relleno = r;
    }
    
    
}