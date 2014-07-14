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