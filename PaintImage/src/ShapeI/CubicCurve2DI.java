/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ShapeI;

import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.CubicCurve2D;

/**
 *
 * @author ivan
 */
public class CubicCurve2DI extends CubicCurve2D.Double{
    Stroke st;
    Color color;
    
    public CubicCurve2DI(Stroke st,Color color) {
        super();
        this.color = color;
        this.st = st;
    }
    public CubicCurve2DI(Point p1, Point p2,Point q1, Point q2, Stroke st,Color color) {
        super(p1.x,p1.y,p2.x,p2.y,q1.x,q1.y,q2.x,q2.y);
        this.color = color;
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
