/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ShapeI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Line2D;

/**
 *
 * @author ivan
 */
public class Line2DI extends Line2D.Double{

    Stroke st;
    Color color;
    
    public Line2DI(Stroke st,Color color) {
        super();
        this.color = color;
        this.st = st;;
    }
    public Line2DI(Point p1, Point p2, Stroke st,Color color) {
        super(p1,p2);
        this.color = color;
        this.st = st;
    }
    public Line2DI(Point p1, Point p2) {
        super(p1,p2);
    }

    public void setStroke(Stroke st){
        this.st = st;
    }
    public Stroke getStroke(){
        return st;
    }
    public Paint getColor(){
        return color;
    }
    public void setColor(Color color){
        this.color = color;
    }

    
}

