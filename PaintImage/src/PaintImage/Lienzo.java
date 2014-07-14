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
    static final int CURVA_UN_PUNTO = 4;
    
    static final int SIN_RELLENO = 0;
    static final int RELLENO_LISO = 1;
    static final int RELLENO_GRADIENTE_H = 2;
    static final int RELLENO_GRADIENTE_V = 3;
    
    static final int LINEA_CONTINUA = 0;
    static final int LINEA_DISCONTINUA = 1;
    static final int LINEA_PUNTEADA = 2;
    
    private Color color1; //Color en el que pìntará la forma;
    private Color color2;
    private GradientPaint gradiente;
    private int tipoRelleno;
    private int figura; //Figura que vamos a dibujar.
    private boolean editar;//Esta o no editandose las figuras
    private boolean buscaPunto; //Indica si se esta buscando un punto de control de la curva
    private Point pClick, pDrag, pCurve; //Punto de click y punto de arrastre.
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
    private Ellipse2DI elipse;
    private QuadCurve2DI curva;
    
    //Imagenes
    private BufferedImage imagen;
    
    /**
     * Constructor por defecto
     */
    public Lienzo() {
        initComponents();
        this.stroke = new BasicStroke();
        this.color1 = Color.BLACK;
        this.tipoRelleno = SIN_RELLENO;
        this.color2 = Color.WHITE;
        this.figura = 0;
        this.pCurve = new Point(0,0);
        this.buscaPunto = false;
        //this.imagen = new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
        //this.imagen.setRGB(300, 300, 255);

    }
    /**
     * Se encarga de pintar todo el lienzo, con las figuras y 
     * las imagenes que se incluyen en ellas.
     * @param g grafico que va a pintar
     */
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
                    if(s.getColorRelleno()!=null){
                        g2d.setPaint(s.getColorRelleno());
                        g2d.fill(s);
                    }
                    g2d.setPaint(s.getColorBorde());
                    g2d.draw(s);                                
                }
            }
            if(vEllipse.size() != 0 ){
                for(Ellipse2DI s:vEllipse) {
                    g2d.setStroke(s.getStroke());
                    if(s.getColorRelleno()!=null){
                        g2d.setPaint(s.getColorRelleno());
                        g2d.fill(s);
                    }
                    g2d.setPaint(s.getColorBorde());
                    g2d.draw(s);                                
                }
            }
            if(vQuadCurve.size() != 0 ){
                for(QuadCurve2DI s:vQuadCurve) {
                    g2d.setPaint(s.getColor());
                    g2d.setStroke(s.getStroke());
                    g2d.draw(s);
                    
                }
            }
            
        }

    }
    /**
     * Devuelve el punto de click
     */
    public Point getClickPoint(){
        return this.pClick;
    }
    
    /**
     * Devuelve el punto de arrastrado
     */
    public Point getDragPoint(){
        return this.pDrag;
    }
    
    /**
     * Devuelve el color seleccionado actualmente
    */
    public Paint getColor1(){
        return this.color1;
    }
    
    /**
     * Cambia la forma que se va a dibujar
     */
    public void setForma(int i){
        this.figura = i;
    }
    
    /**
     * Devuelve la forma que se va a dibujar
     */
    public int getForma(){
        return this.figura;
    }
    
    /**
     * Devuelve el tipo de relleno
     */
    public int getTipoRelleno(){
        return this.tipoRelleno;
    }
    /**
     * Devuelve la imagen contenida en el lienzo
     */
    public BufferedImage getImage(){
        return this.imagen;
    }
    /**
     * Cambia la imagen contenida en el lienzo
     * 
     * @param i nueva imagen que sustituirá a la anterior
     */
    public void setImage(BufferedImage i){
        this.imagen = i;
        this.setPreferredSize(new Dimension(imagen.getWidth(),imagen.getHeight()));
    }
    /**
     * Cambia el punto de click
     */
    public void setClickPoint(Point p){
        this.pClick = p;
    }
    
    /**
     * Cambia el punto arrastrado
     */
    public void setDragPoint(Point p){
        this.pDrag = p;
    }
    
    /**
     * Cambia el color seleccionado actualmente
     */
    public void setColor1(Color color){
        this.color1=color;
    }
    
    /**
     * Cambia el color de relleno seleccionado actualmente
     */
    public void setColor2(Color color){
        this.color2=color;
    }
    
    /**
     * Cambia a figura con o sin relleno
     * @param b entero, que indica el tipo, puede hacerse mediante las constantes
     * definidas en la clase Lienzo.
     */
    public void setTipoRelleno(int b){
        this.tipoRelleno = b;
    }
    /**
     * Obtiene el color secundario
     */
    public Color getColor2(){
        return this.color2;
    }     
    /**
     * Activa o desactiva la opcion editar
     * 
     * @param b booleano que indica si esta activo o no.
     */
    public void setEditar(boolean b){
        this.editar = b;
    }
    
    /**
     * Cambia el grosor de la figura a i puntos o el estilo de linea segun las 
     * constantes definidas en la clase Lienzo
     * 
     * <li>LINEA_CONTINUA = 0;</li>
     * <li>LINEA_DISCONTINUA = 1;</li>
     * <li>LINEA_PUNTEADA = 2;</li>
     * 
     * @param g entero con el grosor de la linea.
     * @param  estiloLinea alguna de las constantes anteriores.
     */
    public void setEstiloLinea(int g, int estiloLinea){
        float grosor = (int) g;
        switch (estiloLinea){
            case LINEA_CONTINUA:
                stroke = new BasicStroke(grosor);
                break;
            case LINEA_DISCONTINUA:
                float[] discontinua = {10.0f,4.0f};
                stroke = new BasicStroke(grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,discontinua, 5.0f);
                break;
            case LINEA_PUNTEADA:
                float [] punteo = {10.0f,4.0f,2.0f};
                stroke = new BasicStroke(grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,punteo, 5.0f);
                break;
        }
        
    }
    
    
    
/**
 * Crea un la figura con los atributos de trazo, relleno y color que hay
 * en este instante seleccionados para la ventana donde estamos dibujando.
 * 
 * @param p1 punto con las coordenadas de la figura, para figuras como punto, o el comienzo
 * de algunas figuras que necesitan más de un punto.
 * @param p2 punto para las figuras de dos puntos, que sería el correspondiente donde
 * deja de arrastrarse con el ratón, es decir, donde termina la figura.
 * @param p3 Punto auxiliar para figuras como la curva con punto, donde este punto sería
 * el punto de control.
 */
    public void createShape(Point p1, Point p2, Point p3){
            switch (figura){
            case PUNTO:
                linea = new Line2DI(p1,p1,this.stroke,this.color1);
                this.vLine.add(linea);
                break;
            case LINEA:
                linea = new Line2DI(p1,p2,this.stroke,this.color1);
                this.vLine.add(linea);
                break;
            case RECTANGULO:
                rectangulo = new Rectangle2DI(this.stroke,this.color1);
                rectangulo.setFrameFromDiagonal(p1,p2);
                if(tipoRelleno > SIN_RELLENO){
                    rectangulo.setColorRelleno(color2);
                    if(tipoRelleno == RELLENO_GRADIENTE_H){
                        //p1.setLocation(rectangulo.getX(),rectangulo.getY());
                        //p2.setLocation(rectangulo.getX(),p1.getY());
                        gradiente = new GradientPaint(p1,color1,p2,color2);
                        
                    }else if(tipoRelleno == Lienzo.RELLENO_GRADIENTE_V){
                        gradiente = new GradientPaint(p1,color1,p2,color2);
                    }
                    if(gradiente != null )
                    rectangulo.setColorRelleno(gradiente);
                }
                this.vRectangle.add(rectangulo);
                break;
                
            case ELIPSE:
                elipse = new Ellipse2DI(this.stroke,this.color1);
                elipse.setFrameFromDiagonal(p1,p2);
                if(tipoRelleno > SIN_RELLENO){
                    elipse.setColorRelleno(color2);
                    if(tipoRelleno == RELLENO_GRADIENTE_H){
                        //p1.setLocation(elipse.getX(),elipse.getY());
                        //p2.setLocation(elipse.getX(),p1.getY());
                        gradiente = new GradientPaint(p1,color1,p2,color2);
                        
                    }else if(tipoRelleno == Lienzo.RELLENO_GRADIENTE_V){
                        gradiente = new GradientPaint(p1,color1,p2,color2);
                    }
                    if(gradiente != null )
                    elipse.setColorRelleno(gradiente);
                }
                this.vEllipse.add(elipse);
                break;
                
            case CURVA_UN_PUNTO:
                if(!buscaPunto){
                        curva = new QuadCurve2DI(p1,p2,p3,this.stroke,this.color1);
                this.vQuadCurve.add(curva);
                }
                break;
        }
        
    }
    
    /**
     * Actualiza la posición de las figuras, tanto cuando se estan creando y 
     * estableciendo el fin de la figura, como para cuando se están editando.
     * Tambien actualiza la posición del punto de control de las curvas.
     * 
     * @param p1 punto de comienzo de la figura
     * @param p2 punto de finalización de la figura
     * @param p3 punto auxiliar utilizado como punto de control.
     */
    public void updateShape(Point p1,Point p2, Point p3){
        switch (figura){
            case LINEA:
                linea.setLine(p1,p2);
                break;
            case RECTANGULO:
                rectangulo.setFrameFromDiagonal(p1,p2);
                break;
            case ELIPSE:
                elipse.setFrameFromDiagonal(p1,p2);
                break;
            case CURVA_UN_PUNTO:
                if(buscaPunto)
                curva.setCurve(curva.getP1(), p3, curva.getP2());
                else 
                    curva.setCurve(p1, p3, p2);
        }
        
    }
    /**
     * Establece p como el x e y de origen de la figura.
     * Por el mal diseño de clases, hemos tenido que sobrecargar el método, por cada posiblidad
     * de selección.
     */
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
        if(s instanceof Ellipse2DI){
            elipse = (Ellipse2DI)s;
            this.elipse.setFrame(p.getX(), p.getY(), elipse.getWidth(), elipse.getHeight());
        }
    }
    
    /*Devuelve el shape que esta siendo seleccionado si p esta contenido o cerca de el */
    public Shape getSelectedShape(Point p1){
        if(this.editar){
            if( vLine.size() != 0 ){
                    for(int i = vLine.size()-1; i >=0; i--) {
                            if(isNear((Line2DI)vLine.get(i),p1))
                                return vLine.get(i);
                    }
                    
            }
            if( vRectangle.size() != 0 ){
                    for(int i = vRectangle.size()-1; i >=0; i--) {
                            if( vRectangle.get(i).contains(p1))
                                return vLine.get(i);
                    }
                    
            }
        }
        return null;
    }
    
    /*Devuelve si un punto esta cerca de una linea lo suficiente*/
    private boolean isNear(Line2DI linea2, Point2D p){
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
        if(!buscaPunto){
            this.createShape(this.pClick, this.pClick,this.pClick);
            this.pCurve.setLocation(pClick);
        }
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
            this.updateShape(this.getClickPoint(), this.getDragPoint(),pCurve);
        }
        if(figura == CURVA_UN_PUNTO && !this.buscaPunto)
            buscaPunto = true;
        else if(figura == CURVA_UN_PUNTO && this.buscaPunto){
            buscaPunto = false;
        }
        repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setDragPoint(evt.getPoint());
        if(this.figura == CURVA_UN_PUNTO && buscaPunto)
            this.pCurve.setLocation(evt.getPoint()); 
        if(!buscaPunto)
            this.updateShape(this.pClick, this.pDrag, this.pDrag);
        if(this.editar){
                this.setLocation(s,this.getDragPoint());   
        }
        else
            this.updateShape(this.pClick, this.pDrag, this.pCurve);
        repaint();
    }//GEN-LAST:event_formMouseDragged
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
