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
import java.awt.geom.Rectangle2D;

/**
 *
 * @author ivan
 */
public class Rectangle2DI extends Rectangle2D.Double{
    Stroke st;
    Color color;
    GradientPaint gradiente;
    
    public Rectangle2DI(Stroke st,Color color) {
        super();
        this.color = color;
        this.st = st;
    }
    public Rectangle2DI(Point p1, Point p2, Stroke st,Color color) {
        super(p1.x,p1.y,p2.x,p2.y);
        this.color = color;
        this.st = st;
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
    public Color getColor(){
        return color;
    }
    public void setColor(Color color){
        this.color = color;
    }
}