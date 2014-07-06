/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ShapeI;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author ivan
 */
public class Ellipse2DI extends Ellipse2D.Double{
    Stroke st;
    Color color;
    GradientPaint gradiente;
    
    public Ellipse2DI(Stroke st,Color color) {
        super();
        this.color = color;
        this.st = st;
    }
    public Ellipse2DI(Stroke st,GradientPaint gradiente) {
        super();
        this.gradiente = gradiente;
        this.st = st;
    }
    
    public Ellipse2DI(Point p1, Point p2, Stroke st,GradientPaint gradiente) {
        super();
        this.gradiente = gradiente;
        this.st = st;
        this.setFrameFromDiagonal(p1, p2);

    }
    
    public void setStroke(Stroke st){
        this.st = st;
    }
    
    public Stroke getStroke(){
        return st;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
}
