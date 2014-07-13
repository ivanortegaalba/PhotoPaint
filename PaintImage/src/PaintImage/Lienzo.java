/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaintImage;

import ShapeI.*;
import ShapeI.Line2DI;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author ivan
 */
public class Lienzo extends javax.swing.JPanel {

    /**
     * Creates new form Lienzo
     */
    
    //CONSTANTES ASOCIADAS A LA FIGURA ELEGIDA
    static final int PUNTO = 0;
    static final int LINEA = 1;
    static final int RECTANGULO = 2;
    static final int ELIPSE = 3;
    
    
    private Color colorBorde; //Color en el que pìntará la forma;
    private Paint colorRelleno;
    private int figura; //Figura que vamos a dibujar.
    private boolean relleno; //Esta o no rellenada
    private boolean editar;//Esta o no editandose las figuras
    private Point pClick, pDrag; //Punto de click y punto de arrastre.
    private Stroke stroke; //strocke con el grosor de las figuras actualmente
    private ArrayList<Shape> vShape = new ArrayList(); //vector de figuras
    
    //Array de nuevas figuras.
    private ArrayList<Line2DI> vLine = new ArrayList(); //vector de figuras
    private ArrayList<Rectangle2DI> vRectangle = new ArrayList(); //vector de figuras
    private ArrayList<Ellipse2DI> vEllipse = new ArrayList(); //vector de figuras
    private ArrayList<QuadCurve2DI> vQuadCurve = new ArrayList(); //vector de figuras
    private ArrayList<CubicCurve2DI> vCubicCurve = new ArrayList();
    
    //Variables de formas para ayudarnos al paso entre objetos.
    private Shape s; 
    private Line2DI linea;
    private Rectangle2DI rectangulo;
    private Ellipse2D elipse;
    
    //Imagenes
    private BufferedImage imagen;
    
    
    public Lienzo() {
        initComponents();
        this.stroke = new BasicStroke();
        this.colorBorde = Color.BLACK;
        this.relleno = false;
        this.colorRelleno = Color.WHITE;
        this.figura = 0;
        //this.imagen = new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
        //this.imagen.setRGB(300, 300, 255);

    }
    
    public void paint(Graphics g){
        //Cuidado con no usar variables que esten a null dentro del metodo paint,
        //Ya que dejara de ejecutar el metodo y no pintará bien.
        if (pClick != null || pDrag != null){
            super.paint(g);
            Graphics2D g2d = (Graphics2D)g;
            
            
            if(imagen!=null) 
                g2d.drawImage(imagen,0,0,this);
            
            if(vLine.size() != 0 ){
               
                for(Line2DI s:vLine) {
                    g2d.setPaint(s.getColor());
                    g2d.setStroke(s.getStroke());
                    g2d.draw(s);
                    
                }
            }
            if(vRectangle.size() != 0 ){
                
                for(Rectangle2DI s:vRectangle) {
                    g2d.setStroke(s.getStroke());
                    if(s.getRelleno()){
                        g2d.setPaint(s.getColorRelleno());
                        g2d.fill(s);
                    }
                    g2d.setPaint(s.getColorBorde());
                    g2d.draw(s);           
                        
                }
            }/*
            if(vEllipse.size() != 0 ){
                g2d.setPaint(s.getColor);
                g2d.setStroke(s.getStroke());
                for(Shape s:vShape) {
                    g2d.draw(s);
                    if(relleno) 
                        g2d.fill(s);
                    
                }
            }
            if(vQuadCurve.size() != 0 ){
                g2d.setPaint(s.getColor);
                g2d.setStroke(s.getStroke());
                for(Shape s:vShape) {
                    g2d.draw(s);
                    if(relleno) 
                        g2d.fill(s);
                    
                }
            }
            if(vCubicCurve.size() != 0 ){
                g2d.setPaint(s.getColor);
                g2d.setStroke(s.getStroke());
                for(Shape s:vShape) {
                    g2d.draw(s);
                    if(relleno) 
                        g2d.fill(s);
                    
                }
            }*/
        }

    }
    /*public void paint(Graphics g){
        //Cuidado con no usar variables que esten a null dentro del metodo paint,
        //Ya que dejara de ejecutar el metodo y no pintará bien.
        if (pClick != null || pDrag != null){
            super.paint(g);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setPaint(s.getColor);
            g2d.setStroke(s.getStroke());
            
            if(imagen!=null) 
                g2d.drawImage(imagen,0,0,this);
            
            if(vShape.size() != 0 )
                for(Shape s:vShape) {
                    g2d.draw(s);
                    if(relleno) 
                        g2d.fill(s);
                    
                }
        }

    }*/
    /*Devuelve el punto de click*/
    public Point getClickPoint(){
        return this.pClick;
    }
    
    /*Devuelve el punto de arrastrado*/
    public Point getDragPoint(){
        return this.pDrag;
    }
    
    /*Devuelve el color seleccionado actualmente*/
    public Paint getColorBorde(){
        return this.colorBorde;
    }
    
    /*Cambia la forma que se va a dibujar*/
    public void setForma(int i){
        this.figura = i;
    }
    
    /*Devuelve la forma que se va a dibujar*/
    public int getForma(){
        return this.figura;
    }
    
    /*Devuelve si está seleccionado el relleno*/
    public boolean getRelleno(){
        return this.relleno;
    }
    
    public BufferedImage getImage(){
        return this.imagen;
    }
    /*Cambia el punto de click*/
    public void setClickPoint(Point p){
        this.pClick = p;
    }
    
    /*Cambia el punto arrastrado*/
    public void setDragPoint(Point p){
        this.pDrag = p;
    }
    
    /*Cambia el color seleccionado actualmente*/
    public void setColorBorde(Color color){
        this.colorBorde=color;
    }
    
    /*Cambia el color de relleno seleccionado actualmente*/
    public void setColorRelleno(Color color){
        this.colorRelleno=color;
    }
    
    /*Cambia a figura con o sin relleno*/
    public void setRelleno(boolean b){
        this.relleno = b;
    }
    
    public Paint getColorRelleno(){
        return this.colorRelleno;
    }
    public void setColorRelleno(Paint p){
        this.colorRelleno = p;
    }
            
    public void setEditar(boolean b){
        this.editar = b;
    }
    
    /*Cambia el grosor de la figura a i puntos*/
    public void setGrosor(int i){
        this.stroke=new BasicStroke(i);
    }
    
    public void setImage(BufferedImage i){
        this.imagen = i;
        this.setPreferredSize(new Dimension(imagen.getWidth(),imagen.getHeight()));
    }
    
    /*Crea un Shape segun la figura seleccionada y lo devuelve*/
    public void createShape(Point p1, Point p2){
        switch (figura){
            case PUNTO:
                linea = new Line2DI(p1,p1,this.stroke,this.colorBorde);
                this.vLine.add(linea);
                break;
            case LINEA:
                linea = new Line2DI(p1,p2,this.stroke,this.colorBorde);
                this.vLine.add(linea);
                break;
            case RECTANGULO:
                rectangulo = new Rectangle2DI(this.stroke,this.colorBorde);
                rectangulo.setFrameFromDiagonal(p1,p2);
                if(relleno)
                    if(colorRelleno != null)
                        if(colorRelleno instanceof GradientPaint)
                            rectangulo.setColorRelleno(colorRelleno);
                this.vRectangle.add(rectangulo);
                break;
            /*case ELIPSE:
                elipse = new Ellipse2D.Double();
                elipse.setFrameFromDiagonal(p1,p2);
                this.vShape.add(elipse);
                break;*/
        }
        
    }
    
    /*Actualiza los puntos del Shape en creación o edición*/
    public void updateShape(Point p1,Point p2){
        switch (figura){
            case LINEA:
                linea.setLine(p1,p2);
                break;
            case RECTANGULO:
                rectangulo.setFrameFromDiagonal(p1,p2);
                break;
/*            case ELIPSE:
                elipse.setFrameFromDiagonal(p1,p2);
                break;*/
        }
        
    }
    /*Establece p como el x e y de origen del shape*/
    public void setLocation(Shape s, Point2D p){
        if(s instanceof Line2DI){
            linea = (Line2DI)s;
            Point2D p2 = new Point2D.Double(linea.getX2() + p.getX() - linea.getX1(), linea.getY2() + p.getY() - linea.getY1());
            linea.setLine(p,p2);
        }
        if(s instanceof Rectangle2DI){
            rectangulo = (Rectangle2DI)s;
            this.rectangulo.setRect(p.getX(), p.getY(), rectangulo.getWidth(), rectangulo.getHeight());
        }
        if(s instanceof Ellipse2D){
            elipse = (Ellipse2D)s;

            this.elipse.setFrame(p.getX(), p.getY(), elipse.getWidth(), elipse.getHeight());
        }
    }
    
    /*Devuelve el shape que esta siendo seleccionado si p esta contenido o cerca de el */
    public Shape getSelectedShape(Point p1){
        if(this.editar){
            if( vShape.size() != 0 ){
                    for(int i = vShape.size()-1; i >=0; i--) {
                        if(vShape.get(i) instanceof Line2D)
                            if(isNear((Line2D)vShape.get(i),p1))
                                return vShape.get(i);
                        if(vShape.get(i).contains(p1))
                            return vShape.get(i);
                    }
                    
            }
        }
        return null;
    }
    
    /*Devuelve si un punto esta cerca de una linea lo suficiente*/
    private boolean isNear(Line2D linea2, Point2D p){
        double x = p.getX() - 1;
        double y = p.getY() - 1;
        double w = 2;
        double h = 2;
        return linea2.intersects(x, y, w, h);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.setClickPoint(evt.getPoint());
    }//GEN-LAST:event_formMouseClicked
        
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        this.setClickPoint(evt.getPoint());
        this.createShape(this.getClickPoint(), this.getClickPoint());
        if(this.editar){
            s = this.getSelectedShape(this.getClickPoint());
        }
        repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.setDragPoint(evt.getPoint());
        if(this.editar){
                this.setLocation(s,this.getDragPoint());
        }
        else{
            this.updateShape(this.getClickPoint(), this.getDragPoint());
        }
        repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setDragPoint(evt.getPoint());
        if(this.editar){
                this.setLocation(s,this.getDragPoint());   
        }
        else
            this.updateShape(this.getClickPoint(), this.getDragPoint());
        repaint();
    }//GEN-LAST:event_formMouseDragged
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
