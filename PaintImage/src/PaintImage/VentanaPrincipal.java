
package PaintImage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import sm.image.KernelProducer;
import sm.image.ThresholdOp;

/**
 *
 * @author ivan
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    /**
    * PaintPhoto: VentanaPrincipal. 
    * Esta clase será la encargada de controlar todos las ventanas internas de distintos tipos
    * los botones, y menus que se usaran para operar.
    * Es la clase donde se unirán todos los elementos para interactuar.
    * 
    * @autor Ivan Ortega Alba
    * @version 15.07.2014
    */
    /** Imagen temporal para no acumular las modificaciones de brillo y umbral*/ 
    private BufferedImage srcImg; 
    public static final int MODO_IMAGEN = 0;
    public static final int MODO_AUDIO = 1;
    public static final int MODO_VIDEO = 2;
    /**Constructor por defecto*/
    public VentanaPrincipal() {
        initComponents();
    }
    
    /** 
     * Cambia el espacio de color de una imagen.
     * 
     * @param img: imagen a la que vamos a cambiar el espacio.
     * @param type: tipo de espacio al que vamos a cambiarlo. Será una constante definida en la 
     * clase BufferedImage.
     * @return Imagen ya transformada.
     */
    BufferedImage convertImageType(BufferedImage img, int type){ 
        if(img==null) return null; 
        BufferedImage imgOut = new BufferedImage(img.getWidth(), 
        img.getHeight(), type); 
        Graphics2D g2d = imgOut.createGraphics(); 
        g2d.drawImage(img,0,0,null); 
        
        return imgOut; 
    } 
    public void setApariencia(int ap){
        switch (ap){
            case MODO_IMAGEN:
                this.ImagenMenu.setVisible(true);
                this.panelImagen.setVisible(true);
                this.panelColor.setVisible(true);
                
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        herramientasGrupo = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        barraInferior = new javax.swing.JPanel();
        barraEstado = new javax.swing.JLabel();
        panelColor = new javax.swing.JPanel();
        colorRellenoPanel = new javax.swing.JPanel();
        colorPrimarioPanel = new javax.swing.JPanel();
        rellenoTipoBox = new javax.swing.JComboBox();
        panelImagen = new javax.swing.JPanel();
        trazoPanel = new javax.swing.JPanel();
        grosorPanel = new javax.swing.JPanel();
        grosorSpin = new javax.swing.JSpinner();
        discontinuidadPanel = new javax.swing.JPanel();
        discontinuidadBox = new javax.swing.JComboBox();
        editarPanel = new javax.swing.JPanel();
        editarButton = new javax.swing.JToggleButton();
        umbralizacionPanel = new javax.swing.JPanel();
        umbralSlider = new javax.swing.JSlider();
        jPanel2 = new javax.swing.JPanel();
        colorUmbralBox = new javax.swing.JComboBox();
        tipoUmbralBox = new javax.swing.JComboBox();
        brilloPanel = new javax.swing.JPanel();
        brilloSlider = new javax.swing.JSlider();
        filtroPanel = new javax.swing.JPanel();
        filtroBoxPanel = new javax.swing.JPanel();
        convolveBox = new javax.swing.JComboBox();
        contrastePanel = new javax.swing.JPanel();
        contrasteButton = new javax.swing.JButton();
        iluminacionButton = new javax.swing.JButton();
        oscuridadButton = new javax.swing.JButton();
        rotacionPanel = new javax.swing.JPanel();
        rotacionSlider = new javax.swing.JSlider();
        novButton = new javax.swing.JButton();
        cientButton = new javax.swing.JButton();
        doscientButton = new javax.swing.JButton();
        escaladoPanel = new javax.swing.JPanel();
        aumentarButton = new javax.swing.JButton();
        disminuirButton = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        lapizButton = new javax.swing.JToggleButton();
        lineaButton = new javax.swing.JToggleButton();
        rectanguloButton = new javax.swing.JToggleButton();
        ovaloButton = new javax.swing.JToggleButton();
        curvaQuadButton = new javax.swing.JToggleButton();
        desktop = new javax.swing.JDesktopPane();
        barraMenu = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        nuevoMenu = new javax.swing.JMenuItem();
        abrirMenu = new javax.swing.JMenuItem();
        guardarMenu = new javax.swing.JMenuItem();
        grabarAudioMenu = new javax.swing.JMenuItem();
        hacerCapturaMenu = new javax.swing.JMenuItem();
        CamaraMenu = new javax.swing.JMenuItem();
        edicionMenu = new javax.swing.JMenu();
        verMenu = new javax.swing.JCheckBoxMenuItem();
        ImagenMenu = new javax.swing.JMenu();
        duplicarMenu = new javax.swing.JMenuItem();
        NegativoMenu = new javax.swing.JMenuItem();
        ColorConvertOpMenu = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barraInferior.setLayout(new java.awt.BorderLayout());

        barraEstado.setText("Punto");
        barraEstado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        barraInferior.add(barraEstado, java.awt.BorderLayout.PAGE_END);

        panelColor.setBorder(javax.swing.BorderFactory.createTitledBorder("color/relleno"));

        colorRellenoPanel.setBackground(new java.awt.Color(254, 254, 254));
        colorRellenoPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        colorRellenoPanel.setToolTipText("Color fondo");
        colorRellenoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colorRellenoPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout colorRellenoPanelLayout = new javax.swing.GroupLayout(colorRellenoPanel);
        colorRellenoPanel.setLayout(colorRellenoPanelLayout);
        colorRellenoPanelLayout.setHorizontalGroup(
            colorRellenoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        colorRellenoPanelLayout.setVerticalGroup(
            colorRellenoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        colorPrimarioPanel.setBackground(new java.awt.Color(1, 1, 1));
        colorPrimarioPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        colorPrimarioPanel.setToolTipText("Color primario\n");
        colorPrimarioPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colorPrimarioPanelMouseClicked(evt);
            }
        });
        colorPrimarioPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rellenoTipoBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sin relleno", "Liso", "Horizontal", "Vertical", " " }));
        rellenoTipoBox.setBorder(null);
        rellenoTipoBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rellenoTipoBoxItemStateChanged(evt);
            }
        });
        rellenoTipoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rellenoTipoBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelColorLayout = new javax.swing.GroupLayout(panelColor);
        panelColor.setLayout(panelColorLayout);
        panelColorLayout.setHorizontalGroup(
            panelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColorLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rellenoTipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorRellenoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorPrimarioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelColorLayout.setVerticalGroup(
            panelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColorLayout.createSequentialGroup()
                .addComponent(colorPrimarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rellenoTipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorRellenoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        barraInferior.add(panelColor, java.awt.BorderLayout.WEST);

        panelImagen.setLayout(new javax.swing.BoxLayout(panelImagen, javax.swing.BoxLayout.LINE_AXIS));

        trazoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Trazo"));
        trazoPanel.setLayout(new java.awt.GridBagLayout());

        grosorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Grosor"));
        grosorPanel.setLayout(new java.awt.BorderLayout());

        grosorSpin.setModel(new javax.swing.SpinnerNumberModel());
        grosorSpin.setToolTipText("");
        grosorSpin.setMaximumSize(new java.awt.Dimension(37, 30));
        grosorSpin.setName(""); // NOI18N
        grosorSpin.setPreferredSize(new java.awt.Dimension(20, 30));
        grosorSpin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                grosorSpinStateChanged(evt);
            }
        });
        grosorPanel.add(grosorSpin, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.ipadx = 30;
        trazoPanel.add(grosorPanel, gridBagConstraints);

        discontinuidadPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Estilo"));
        discontinuidadPanel.setLayout(new java.awt.BorderLayout());

        discontinuidadBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "________", "_ _ _ _ _ ", " - · - · - ·" }));
        discontinuidadBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        discontinuidadBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                discontinuidadBoxItemStateChanged(evt);
            }
        });
        discontinuidadPanel.add(discontinuidadBox, java.awt.BorderLayout.PAGE_END);

        trazoPanel.add(discontinuidadPanel, new java.awt.GridBagConstraints());

        panelImagen.add(trazoPanel);

        editarPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar"));
        editarPanel.setLayout(new java.awt.BorderLayout());

        editarButton.setText("Modo Edición");
        editarButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editarButtonStateChanged(evt);
            }
        });
        editarPanel.add(editarButton, java.awt.BorderLayout.PAGE_START);

        panelImagen.add(editarPanel);

        umbralizacionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Umbralización"));
        umbralizacionPanel.setLayout(new java.awt.BorderLayout());

        umbralSlider.setMinorTickSpacing(25);
        umbralSlider.setPaintTicks(true);
        umbralSlider.setSnapToTicks(true);
        umbralSlider.setToolTipText("Umbral");
        umbralSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        umbralSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                umbralSliderStateChanged(evt);
            }
        });
        umbralSlider.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                umbralSliderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                umbralSliderFocusLost(evt);
            }
        });
        umbralizacionPanel.add(umbralSlider, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        colorUmbralBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rojo", "Verde", "Azul", " " }));
        colorUmbralBox.setEnabled(false);
        colorUmbralBox.setFocusable(false);
        colorUmbralBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorUmbralBoxActionPerformed(evt);
            }
        });
        jPanel2.add(colorUmbralBox, new java.awt.GridBagConstraints());

        tipoUmbralBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Grises", "Color", " " }));
        tipoUmbralBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoUmbralBoxItemStateChanged(evt);
            }
        });
        jPanel2.add(tipoUmbralBox, new java.awt.GridBagConstraints());

        umbralizacionPanel.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        panelImagen.add(umbralizacionPanel);

        brilloPanel.setLayout(new java.awt.BorderLayout());

        brilloSlider.setMinorTickSpacing(25);
        brilloSlider.setPaintTicks(true);
        brilloSlider.setBorder(javax.swing.BorderFactory.createTitledBorder("Brillo"));
        brilloSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                brilloSliderStateChanged(evt);
            }
        });
        brilloSlider.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brilloSliderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brilloSliderFocusLost(evt);
            }
        });
        brilloPanel.add(brilloSlider, java.awt.BorderLayout.LINE_START);

        panelImagen.add(brilloPanel);

        filtroPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));
        filtroPanel.setLayout(new java.awt.BorderLayout());

        filtroBoxPanel.setLayout(new java.awt.GridBagLayout());

        convolveBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Media", "Binomial", "Enfoque", "Relieve", "Laplaciano" }));
        convolveBox.setAlignmentX(100.0F);
        convolveBox.setAlignmentY(100.0F);
        convolveBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                convolveBoxItemStateChanged(evt);
            }
        });
        convolveBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convolveBoxActionPerformed(evt);
            }
        });
        filtroBoxPanel.add(convolveBox, new java.awt.GridBagConstraints());
        convolveBox.getAccessibleContext().setAccessibleDescription("");

        filtroPanel.add(filtroBoxPanel, java.awt.BorderLayout.CENTER);

        panelImagen.add(filtroPanel);

        contrastePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraste"));
        contrastePanel.setLayout(new java.awt.GridBagLayout());

        contrasteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/contraste.png"))); // NOI18N
        contrasteButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/aumentar.png"))); // NOI18N
        contrasteButton.setMargin(new java.awt.Insets(0, 10, 0, 10));
        contrasteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasteButtonActionPerformed(evt);
            }
        });
        contrastePanel.add(contrasteButton, new java.awt.GridBagConstraints());

        iluminacionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/iluminar.png"))); // NOI18N
        iluminacionButton.setMargin(new java.awt.Insets(0, 10, 0, 10));
        iluminacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iluminacionButtonActionPerformed(evt);
            }
        });
        contrastePanel.add(iluminacionButton, new java.awt.GridBagConstraints());

        oscuridadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/oscurecer.png"))); // NOI18N
        oscuridadButton.setMargin(new java.awt.Insets(0, 10, 0, 10));
        oscuridadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oscuridadButtonActionPerformed(evt);
            }
        });
        contrastePanel.add(oscuridadButton, new java.awt.GridBagConstraints());

        panelImagen.add(contrastePanel);

        rotacionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Rotación"));
        rotacionPanel.setLayout(new javax.swing.BoxLayout(rotacionPanel, javax.swing.BoxLayout.LINE_AXIS));

        rotacionSlider.setMajorTickSpacing(90);
        rotacionSlider.setMaximum(360);
        rotacionSlider.setPaintTicks(true);
        rotacionSlider.setValue(0);
        rotacionSlider.setBorder(null);
        rotacionSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rotacionSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rotacionSliderStateChanged(evt);
            }
        });
        rotacionSlider.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rotacionSliderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rotacionSliderFocusLost(evt);
            }
        });
        rotacionPanel.add(rotacionSlider);

        novButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/rotacion90.png"))); // NOI18N
        novButton.setMargin(new java.awt.Insets(0, 10, 0, 10));
        novButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novButtonActionPerformed(evt);
            }
        });
        rotacionPanel.add(novButton);

        cientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/rotacion180.png"))); // NOI18N
        cientButton.setMargin(new java.awt.Insets(0, 10, 0, 10));
        cientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cientButtonActionPerformed(evt);
            }
        });
        rotacionPanel.add(cientButton);

        doscientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/rotacion270.png"))); // NOI18N
        doscientButton.setAlignmentX(0.5F);
        doscientButton.setMargin(new java.awt.Insets(0, 10, 0, 10));
        doscientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doscientButtonActionPerformed(evt);
            }
        });
        rotacionPanel.add(doscientButton);

        panelImagen.add(rotacionPanel);

        escaladoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Escalar"));
        escaladoPanel.setLayout(new java.awt.GridBagLayout());

        aumentarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/aumentar.png"))); // NOI18N
        aumentarButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aumentarButton.setMargin(new java.awt.Insets(0, 10, 0, 10));
        aumentarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aumentarButtonActionPerformed(evt);
            }
        });
        escaladoPanel.add(aumentarButton, new java.awt.GridBagConstraints());

        disminuirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/disminuir.png"))); // NOI18N
        disminuirButton.setMargin(new java.awt.Insets(0, 10, 0, 10));
        disminuirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disminuirButtonActionPerformed(evt);
            }
        });
        escaladoPanel.add(disminuirButton, new java.awt.GridBagConstraints());

        panelImagen.add(escaladoPanel);

        barraInferior.add(panelImagen, java.awt.BorderLayout.CENTER);

        getContentPane().add(barraInferior, java.awt.BorderLayout.PAGE_END);

        jToolBar1.setRollover(true);

        herramientasGrupo.add(lapizButton);
        lapizButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Lapiz.gif"))); // NOI18N
        lapizButton.setFocusable(false);
        lapizButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lapizButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lapizButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lapizButtonStateChanged(evt);
            }
        });
        jToolBar1.add(lapizButton);

        herramientasGrupo.add(lineaButton);
        lineaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Linea.gif"))); // NOI18N
        lineaButton.setFocusable(false);
        lineaButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lineaButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lineaButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lineaButtonStateChanged(evt);
            }
        });
        lineaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineaButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(lineaButton);

        herramientasGrupo.add(rectanguloButton);
        rectanguloButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Rectangulo.gif"))); // NOI18N
        rectanguloButton.setFocusable(false);
        rectanguloButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rectanguloButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rectanguloButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rectanguloButtonStateChanged(evt);
            }
        });
        jToolBar1.add(rectanguloButton);

        herramientasGrupo.add(ovaloButton);
        ovaloButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Ovalo.gif"))); // NOI18N
        ovaloButton.setFocusable(false);
        ovaloButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ovaloButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ovaloButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ovaloButtonStateChanged(evt);
            }
        });
        ovaloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovaloButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(ovaloButton);

        herramientasGrupo.add(curvaQuadButton);
        curvaQuadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/curva.png"))); // NOI18N
        curvaQuadButton.setFocusable(false);
        curvaQuadButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        curvaQuadButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        curvaQuadButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                curvaQuadButtonItemStateChanged(evt);
            }
        });
        jToolBar1.add(curvaQuadButton);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        desktop.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                desktopComponentAdded(evt);
            }
        });
        getContentPane().add(desktop, java.awt.BorderLayout.CENTER);

        archivoMenu.setText("Archivo");

        nuevoMenu.setText("Nuevo");
        nuevoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoMenuActionPerformed(evt);
            }
        });
        archivoMenu.add(nuevoMenu);

        abrirMenu.setText("Abrir");
        abrirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirMenuActionPerformed(evt);
            }
        });
        archivoMenu.add(abrirMenu);

        guardarMenu.setText("Guardar");
        guardarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMenuActionPerformed(evt);
            }
        });
        archivoMenu.add(guardarMenu);

        grabarAudioMenu.setText("Grabar audio");
        grabarAudioMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarAudioMenuActionPerformed(evt);
            }
        });
        archivoMenu.add(grabarAudioMenu);

        hacerCapturaMenu.setText("Realizar Captura");
        hacerCapturaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacerCapturaMenuActionPerformed(evt);
            }
        });
        archivoMenu.add(hacerCapturaMenu);

        CamaraMenu.setText("Camara");
        CamaraMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CamaraMenuActionPerformed(evt);
            }
        });
        archivoMenu.add(CamaraMenu);

        barraMenu.add(archivoMenu);

        edicionMenu.setText("Ver");

        verMenu.setSelected(true);
        verMenu.setText("Ver barra estado");
        verMenu.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                verMenuStateChanged(evt);
            }
        });
        verMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verMenuActionPerformed(evt);
            }
        });
        edicionMenu.add(verMenu);

        barraMenu.add(edicionMenu);

        ImagenMenu.setText("Imagen");

        duplicarMenu.setText("Duplicar");
        duplicarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duplicarMenuActionPerformed(evt);
            }
        });
        ImagenMenu.add(duplicarMenu);

        NegativoMenu.setText("Negativo");
        NegativoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NegativoMenuActionPerformed(evt);
            }
        });
        ImagenMenu.add(NegativoMenu);

        ColorConvertOpMenu.setText("Escala de grises");
        ColorConvertOpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorConvertOpMenuActionPerformed(evt);
            }
        });
        ImagenMenu.add(ColorConvertOpMenu);

        jMenuItem2.setText("RGB desplazado");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        ImagenMenu.add(jMenuItem2);

        barraMenu.add(ImagenMenu);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Cuando el lapiz es elegido, cambia la forma a dibujar y la barra de estado
    * del lienzo correspondiente a la ventana seleccionada.
    * 
    * @param evt información del evento.
    */
    private void lapizButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lapizButtonStateChanged
        VentanaInternaImage vi = (VentanaInternaImage)desktop.getSelectedFrame();
        if(vi!=null && vi instanceof VentanaInternaImage){
            if(this.lineaButton.isSelected()){
                this.barraEstado.setText("Punto");
                 vi.getLienzo().setForma(Lienzo.PUNTO);
            }
        }
    }//GEN-LAST:event_lapizButtonStateChanged

    /**
    * Cuando la linea es elegida, cambia la forma a dibujar y la barra de estado
    * del lienzo correspondiente a la ventana seleccionada.
    * 
    * @param evt información del evento.
    */
    private void lineaButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lineaButtonStateChanged
        VentanaInternaImage vi = (VentanaInternaImage)desktop.getSelectedFrame();
        if(vi!=null && vi instanceof VentanaInternaImage){
            if(this.lineaButton.isSelected()){
                this.barraEstado.setText("Linea");
                 vi.getLienzo().setForma(Lienzo.LINEA);
            }
        }
    }//GEN-LAST:event_lineaButtonStateChanged

    /**
    * Cuando el rectangulo es elegido, cambia la forma a dibujar y la barra de estado
    * del lienzo correspondiente a la ventana seleccionada.
    * 
    * @param evt información del evento.
    */
    private void rectanguloButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rectanguloButtonStateChanged
        VentanaInternaImage vi;
        vi = (VentanaInternaImage) desktop.getSelectedFrame();
        if(vi!=null && vi instanceof VentanaInternaImage){
            if(this.rectanguloButton.isSelected()){
                this.barraEstado.setText("Rectangulo");
                 vi.getLienzo().setForma(Lienzo.RECTANGULO);
            }
        }
    }//GEN-LAST:event_rectanguloButtonStateChanged
    /**
    * Cuando el ovalo es elegido, cambia la forma a dibujar y la barra de estado
    * del lienzo correspondiente a la ventana seleccionada.
    * 
    * @param evt información del evento.
    */
    private void ovaloButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ovaloButtonStateChanged
        VentanaInternaImage vi = (VentanaInternaImage)desktop.getSelectedFrame();
        if(vi!=null && vi instanceof VentanaInternaImage){
            if(this.ovaloButton.isSelected())
                this.barraEstado.setText("Circulo");
                 vi.getLienzo().setForma(Lienzo.ELIPSE);
        }
    }//GEN-LAST:event_ovaloButtonStateChanged

    private void verMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verMenuActionPerformed
    
    /**
     * Cuando la casilla está activada, muestra la barra de estado de la herramienta
     * seleccionada en ese mismo momento.
     * 
     * @param evt información del evento.
     */
    private void verMenuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_verMenuStateChanged
        if(this.verMenu.isSelected())
            this.barraEstado.setVisible(true);
        else
            this.barraEstado.setVisible(false);
    }//GEN-LAST:event_verMenuStateChanged
    
    /**
    * Abrirá cualquier tipo de archivo, y según su extensión, lo asociará 
    * a la ventana interna correspondiente, ya sea imagen, sonido, o video.
    * 
    * @param evt información del evento.
    */
    @SuppressWarnings("null")
    private void abrirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirMenuActionPerformed

        String ext = null,  //Extensión del archivo
                path;       //Ruta del archivo
        
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        
        if( resp == JFileChooser.APPROVE_OPTION) {
            try{
                File f = dlg.getSelectedFile();
                
                //Extraemos la extensión del archivo elegido.
                path = f.getAbsolutePath().toLowerCase();
                int i = path.lastIndexOf('.');
                if (i > 0) {
                    ext = path.substring(i+1);
                }
                
                switch (ext) {
                    //Imagen
                    case "jpg":
                    case "gif":
                    case "png":
                    case "tiff":
                        BufferedImage img = ImageIO.read(f);
                        VentanaInternaImage vi = new VentanaInternaImage();
                        vi.getLienzo().setImage(img);
                        vi.setTitle(f.getAbsolutePath());
                        this.desktop.add(vi);
                        vi.setVisible(true);
                        vi.getLienzo().repaint();
                        break;
                    //Sonido
                    case "aiif":
                    case "mp3":
                    case "wma":
                    case "wav":
                        VentanaInternaPlayer vip = VentanaInternaPlayer.getInstance(f);
                        if(vip == null)
                            System.err.println("devuelve null");
                        this.desktop.add(vip);
                        vip.setVisible(true);
                        vip.setTitle(f.getAbsolutePath());
                        vip.play();
                        break;
                    //Video
                    case "mpeg":
                    case "avi":
                    case "mp4":
                        VentanaInternaVideoPlayer viJMF = VentanaInternaVideoPlayer.getInstance(f);
                        if(viJMF ==null)
                            System.err.println("devuelve null");
                        this.desktop.add(viJMF);
                        viJMF.setVisible(true);
                        viJMF.setTitle(f.getAbsolutePath());
                        viJMF.setSize(250,250);
                        viJMF.play();
                        break;
                }

            }
            catch(IOException ex){
                System.err.println("Error al leer el archivo");
            }
        }

    }//GEN-LAST:event_abrirMenuActionPerformed
    /**
    * Crea un nuevo lienzo en una nueva {@link VentanaInternaImage}.
    * 
    * @param evt información del evento.
    */
    private void nuevoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoMenuActionPerformed
        VentanaInternaImage vi = new VentanaInternaImage();
        vi.setTitle("Imagen sin guardar");
        this.desktop.add(vi);
        vi.setVisible(true);

    }//GEN-LAST:event_nuevoMenuActionPerformed
    /**
     * Guarda el contenido del lienzo, tanto las imagenes como los gráficos que hay en él
     * en formato jpg, en la ruta elegida.
     * 
     * @param evt información del evento.
     */
    private void guardarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarMenuActionPerformed
          // TODO add your handling code here:
        VentanaInternaImage vi = (VentanaInternaImage)desktop.getSelectedFrame();
        BufferedImage img = vi.getLienzo().getImage();
        //Graphics2D g2d = vi.getLienzo().getImage().createGraphics();
        Graphics2D g2d = img.createGraphics(); 
        //g2d.drawLine(10,10,200,200);
        vi.getLienzo().paint(g2d);
        JFileChooser dlg = new JFileChooser(); 
        int resp = dlg.showSaveDialog(this); 
        if( resp == JFileChooser.APPROVE_OPTION) { 
            try{ 
            File f = dlg.getSelectedFile();
            ImageIO.write(img,"jpg",f);
            vi.setTitle(f.getAbsolutePath());
            }catch(IOException ex){ 
                System.err.println("Error al guardar la imagen"); 
        } 
}
    }//GEN-LAST:event_guardarMenuActionPerformed

    private void lineaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lineaButtonActionPerformed
    /**
    * Cambia el stroke asociado al lienzo con el nuevo grosor para la figura.
    * 
    * @param evt información del evento.
    */
    private void grosorSpinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_grosorSpinStateChanged
        VentanaInternaImage vi = (VentanaInternaImage)desktop.getSelectedFrame();
        if(vi!=null) {
            vi.getLienzo().setEstiloLinea((int) this.grosorSpin.getValue(),this.discontinuidadBox.getSelectedIndex());
        }
        this.repaint();
    }//GEN-LAST:event_grosorSpinStateChanged

   /**
     * Antes de empezar a modificar el brillo, guardamos una copia de la 
     * imagen a modificar.
     * 
     * @param evt información del evento.
     */
    private void brilloSliderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brilloSliderFocusGained
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame());
        if (vi != null) {
            this.srcImg = vi.getLienzo().getImage();
        }
    }//GEN-LAST:event_brilloSliderFocusGained
/**
 * Destruimos la imagen guardada.
 * 
 * @param evt información del evento.
 */
    private void brilloSliderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brilloSliderFocusLost
        srcImg =null;
    }//GEN-LAST:event_brilloSliderFocusLost
/**
 * Aplicamos el rescaleOp a la imagen, modificando así el brillo a la imagen
 * actualmente en el lienzo.
 * 
 * @param evt información del evento.
 */
    private void brilloSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_brilloSliderStateChanged
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame());
            if (vi != null) {
                
                if(this.srcImg != null){
                    try{
                        if(srcImg.getType() != BufferedImage.TYPE_INT_RGB)
                            srcImg = this.convertImageType(srcImg, BufferedImage.TYPE_INT_RGB);
                        RescaleOp rop = new RescaleOp(1.0F, brilloSlider.getValue(), null);
                        BufferedImage imgdest = rop.filter(this.srcImg, null);
                        vi.getLienzo().setImage(imgdest);
                        vi.getLienzo().repaint();
                    } catch(IllegalArgumentException e){
                        System.err.println(e.getLocalizedMessage());
                    }
                }
            }

    }//GEN-LAST:event_brilloSliderStateChanged

    private void convolveBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convolveBoxActionPerformed
        
    }//GEN-LAST:event_convolveBoxActionPerformed
/**
     * Cuando cambiamos el tipo de filtro a aplicar, aplicamos el nuevo
     * filtro seleccionado a la imagen de la ventana seleccionada.
     * 
     * @param evt información del evento.
     */
    private void convolveBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_convolveBoxItemStateChanged
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame());
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImage();
            if(imgSource!=null){
                try{
                    Kernel k = null;
                    String s = (String) convolveBox.getSelectedItem();
                    switch (s) {
                        case "Media":
                            k = new Kernel(3,3,KernelProducer.MASCARA_MEDIA_3x3);
                            break;
                        case "Binomial":
                            k = new Kernel(3,3,KernelProducer.MASCARA_BINOMIAL_3x3);
                            break;
                        case "Enfoque":
                            k = new Kernel(3,3,KernelProducer.MASCARA_ENFOQUE_3x3);
                            break;
                        case "Laplaciano":
                            k = new Kernel(3,3,KernelProducer.MASCARA_LAPLACIANA_3x3);
                            break;
                        case "Relieve":
                            k = new Kernel(3,3,KernelProducer.MASCARA_RELIEVE_3x3);
                            break;
                    }

                    
                    ConvolveOp cop = new ConvolveOp(k); 
                    BufferedImage imgOut = cop.filter(imgSource,null); 
                    vi.getLienzo().setImage(imgOut);
                    vi.getLienzo().repaint();
                } catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
        
    }//GEN-LAST:event_convolveBoxItemStateChanged
    /**
     * Cambiamos el espacio de color de la imagen seleccionada.
     * 
     * @param evt información del evento.
     */
    private void ColorConvertOpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorConvertOpMenuActionPerformed
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
         if (vi != null) { 
            BufferedImage imgSource = vi.getLienzo().getImage(); 
         if(imgSource!=null){ 
            try{ 
                ICC_Profile ip;
                ip = ICC_Profile.getInstance(ColorSpace.CS_GRAY); 
                ColorSpace cs = new ICC_ColorSpace(ip); 
                ColorConvertOp ccop = new ColorConvertOp(cs,null); 
                BufferedImage imgdest = ccop.filter(imgSource,null); 
                vi.getLienzo().setImage(imgdest);
                vi.getLienzo().repaint();
                }catch(Exception e){ 
                System.err.println("Error"); 
            }
         } 
         }
        
        
    }//GEN-LAST:event_ColorConvertOpMenuActionPerformed
    /**
     * Aplicamos la mejora de contraste a la imagen seleccionada
     * 
     * @param evt información del evento.
     */
    private void contrasteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasteButtonActionPerformed
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
        if (vi != null) { 
            BufferedImage imgSource = vi.getLienzo().getImage(); 
            /*Es necesario convertir la imagen a INT_RGB para quitar el canal alfa,
            ya que, ni LookupOP, ni Rescaleop
            */
            if(imgSource!=null){ 
               try{ 
                   if(imgSource.getType() != BufferedImage.TYPE_INT_RGB)
                        imgSource = this.convertImageType(imgSource, BufferedImage.TYPE_INT_RGB);
                   
                    LookupTable lt = LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_SFUNCION);
                    //LookupTable lt; 
                    //lt=LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_NEGATIVE);
                    LookupOp lop = new LookupOp(lt, null); 
                    BufferedImage imgdest = lop.filter(imgSource,null); 
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                    }catch(Exception e){ 
                    System.err.println("Error"); 
               }
            } 
        }
    }//GEN-LAST:event_contrasteButtonActionPerformed
/**
     * Giramos 270º la imagen seleccionada.
     * 
     * @param evt información del evento.
     */
    private void doscientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doscientButtonActionPerformed
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
         if (vi != null) { 
            BufferedImage imgSource = vi.getLienzo().getImage(); 
         if(imgSource!=null){ 
                AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(270.0), 
                        imgSource.getWidth()/2,imgSource.getHeight()/2); 
                try{ 
                    AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR); 
                    BufferedImage imgdest = atop.filter( imgSource, null); 
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }catch(IllegalArgumentException e){ 
                System.err.println(e.getLocalizedMessage());
                } 

            }  
        }
    }//GEN-LAST:event_doscientButtonActionPerformed

    private void iluminacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iluminacionButtonActionPerformed
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
        if (vi != null) { 
            BufferedImage imgSource = vi.getLienzo().getImage(); 
            /*Es necesario convertir la imagen a INT_RGB para quitar el canal alfa,
            ya que, ni LookupOP, ni Rescaleop
            */
            if(imgSource!=null){ 
               try{ 
                   if(imgSource.getType() != BufferedImage.TYPE_INT_RGB)
                        imgSource = this.convertImageType(imgSource, BufferedImage.TYPE_INT_RGB);
                   
                    LookupTable lt = LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_LOGARITHM);
                    LookupOp lop = new LookupOp(lt, null); 
                    BufferedImage imgdest = lop.filter(imgSource,null); 
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                    }catch(Exception e){ 
                    System.err.println("Error"); 
               }
            } 
        }
    }//GEN-LAST:event_iluminacionButtonActionPerformed

    private void oscuridadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oscuridadButtonActionPerformed
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
        if (vi != null) { 
            BufferedImage imgSource = vi.getLienzo().getImage(); 
            /*Es necesario convertir la imagen a INT_RGB para quitar el canal alfa,
            ya que, ni LookupOP, ni Rescaleop
            */
            if(imgSource!=null){ 
               try{ 
                   if(imgSource.getType() != BufferedImage.TYPE_INT_RGB)
                        imgSource = this.convertImageType(imgSource, BufferedImage.TYPE_INT_RGB);
                   
                    LookupTable lt = LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_GAMMA_CORRECTION);
                    LookupOp lop = new LookupOp(lt, null); 
                    BufferedImage imgdest = lop.filter(imgSource,null); 
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                    }catch(Exception e){ 
                    System.err.println("Error"); 
               }
            } 
        }
    }//GEN-LAST:event_oscuridadButtonActionPerformed

    private void novButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novButtonActionPerformed
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
         if (vi != null) { 
            BufferedImage imgSource = vi.getLienzo().getImage(); 
         if(imgSource!=null){ 
                AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(90.0), 
                        imgSource.getWidth()/2,imgSource.getHeight()/2); 
                try{ 
                    AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR); 
                    BufferedImage imgdest = atop.filter( imgSource, null); 
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }catch(IllegalArgumentException e){ 
                System.err.println(e.getLocalizedMessage());
                } 

            }  
        } 
    }//GEN-LAST:event_novButtonActionPerformed

    private void cientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cientButtonActionPerformed
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
         if (vi != null) { 
            BufferedImage imgSource = vi.getLienzo().getImage(); 
         if(imgSource!=null){ 
                AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(180.0), 
                        imgSource.getWidth()/2,imgSource.getHeight()/2); 
                try{ 
                    AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR); 
                    BufferedImage imgdest = atop.filter( imgSource, null); 
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }catch(IllegalArgumentException e){ 
                System.err.println(e.getLocalizedMessage());
                } 

            }  
        }
    }//GEN-LAST:event_cientButtonActionPerformed

    private void rotacionSliderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rotacionSliderFocusGained
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame());
        if (vi != null) {
            this.srcImg = vi.getLienzo().getImage();
        }
    }//GEN-LAST:event_rotacionSliderFocusGained

    private void rotacionSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rotacionSliderStateChanged
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame());
        if (vi != null) {

            if(this.srcImg != null){
                try{
                    if(srcImg.getType() != BufferedImage.TYPE_INT_RGB)
                        srcImg = this.convertImageType(srcImg, BufferedImage.TYPE_INT_RGB);
                    AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(this.rotacionSlider.getValue()), 
                    srcImg.getWidth()/2,srcImg.getHeight()/2);
                    AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR); 
                    BufferedImage imgdest = atop.filter( srcImg, null); 
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                } catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
        
    }//GEN-LAST:event_rotacionSliderStateChanged

    private void rotacionSliderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rotacionSliderFocusLost
        srcImg =null;

    }//GEN-LAST:event_rotacionSliderFocusLost

    private void aumentarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aumentarButtonActionPerformed
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
         if (vi != null) { 
            BufferedImage imgSource = vi.getLienzo().getImage(); 
         if(imgSource!=null){ 
            try{ 
                AffineTransform at = AffineTransform.getScaleInstance(1.25,1.25);
                
                try{ 
                 AffineTransformOp atop = new AffineTransformOp(at, 
                AffineTransformOp.TYPE_BILINEAR); 
                 BufferedImage imgdest = atop.filter( imgSource, null); 
                 vi.getLienzo().setImage(imgdest);
                 vi.getLienzo().repaint();
                 }catch(Exception e){ 
                 System.err.println("Error al aplicar Affine"); 
                 } 

            } catch(IllegalArgumentException e){ 
                System.err.println(e.getLocalizedMessage()); 
            } 
         } 
         }
    }//GEN-LAST:event_aumentarButtonActionPerformed

    private void disminuirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disminuirButtonActionPerformed
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
         if (vi != null) { 
            BufferedImage imgSource = vi.getLienzo().getImage(); 
         if(imgSource!=null){ 
            try{ 
                AffineTransform at = AffineTransform.getScaleInstance(0.75,0.75);
                
                try{ 
                 AffineTransformOp atop = new AffineTransformOp(at, 
                AffineTransformOp.TYPE_BILINEAR); 
                 BufferedImage imgdest = atop.filter( imgSource, null); 
                 vi.getLienzo().setImage(imgdest);
                 vi.getLienzo().repaint();
                 }catch(Exception e){ 
                 System.err.println("Error al aplicar Affine"); 
                 } 

            } catch(IllegalArgumentException e){ 
                System.err.println(e.getLocalizedMessage()); 
            } 
         } 
         }
    }//GEN-LAST:event_disminuirButtonActionPerformed

    private void grabarAudioMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarAudioMenuActionPerformed
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showSaveDialog(this);
        
        if( resp == JFileChooser.APPROVE_OPTION) {
            try{
                File f = dlg.getSelectedFile();
                VentanaInternaRecorder vir= new VentanaInternaRecorder(f);
                this.desktop.add(vir);
                vir.setTitle(f.getAbsolutePath());
                vir.setVisible(true);
            }
            catch(Exception ex){
                System.err.println("Error al grabar el audio");
            }
        }
    }//GEN-LAST:event_grabarAudioMenuActionPerformed

    private void CamaraMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CamaraMenuActionPerformed
        try{
                VentanaInternaCamara vic = VentanaInternaCamara.getInstance();
                vic.setTitle("Webcam");
                this.desktop.add(vic);
                vic.setVisible(true);
            }
            catch(Exception ex){
                System.err.println("Error al abrir el video"+ ex.getMessage());
            }
    }//GEN-LAST:event_CamaraMenuActionPerformed

    private void NegativoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NegativoMenuActionPerformed
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
         if (vi != null) { 
            BufferedImage imgSource = vi.getLienzo().getImage(); 
            if(imgSource!=null){ 
                try{ 
                    NegativoOp neg = new NegativoOp();
                    BufferedImage imgdest = neg.filter(imgSource, null); 
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }catch(Exception e){ 
                    System.err.println("Error al aplicar Affine"); 
                } 
            }
        }
    }//GEN-LAST:event_NegativoMenuActionPerformed

    private void colorPrimarioPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorPrimarioPanelMouseClicked
         VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
         
            Color c = JColorChooser.showDialog(this, "Seleccion color" , this.colorPrimarioPanel.getBackground()); 
            if(c != null) {
                this.colorPrimarioPanel.setBackground(c);
                if (vi != null) { 
                vi.getLienzo().setColor1(c);
            }
        }
        
    }//GEN-LAST:event_colorPrimarioPanelMouseClicked

    private void colorRellenoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorRellenoPanelMouseClicked
         VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
         
            Color c = JColorChooser.showDialog(this, "Seleccion color" , this.colorRellenoPanel.getBackground()); 
            if(c != null) {
                this.colorRellenoPanel.setBackground(c);
                if (vi != null) { 
                vi.getLienzo().setColor2(c);
            }
        }
    }//GEN-LAST:event_colorRellenoPanelMouseClicked

    private void rellenoTipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rellenoTipoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rellenoTipoBoxActionPerformed

    private void rellenoTipoBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rellenoTipoBoxItemStateChanged

            VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 

            vi.getLienzo().setColor1(this.colorPrimarioPanel.getBackground());
            vi.getLienzo().setColor2(this.colorRellenoPanel.getBackground());
            
                switch(this.rellenoTipoBox.getSelectedIndex()){
                    case 0: //Sin relleno
                        vi.getLienzo().setTipoRelleno(Lienzo.SIN_RELLENO);
                        break;
                    case 1: //Con relleno liso
                        vi.getLienzo().setTipoRelleno(Lienzo.RELLENO_LISO);
                        break;
                    case 2: //Degradado vertical
                        vi.getLienzo().setTipoRelleno(Lienzo.RELLENO_GRADIENTE_V);
                        break;
                    case 3: //Degradado horizontal
                        vi.getLienzo().setTipoRelleno(Lienzo.RELLENO_GRADIENTE_H);
                        break;
                }

    }//GEN-LAST:event_rellenoTipoBoxItemStateChanged

    private void duplicarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplicarMenuActionPerformed

        
        try{
                VentanaInternaImage vi = (VentanaInternaImage)desktop.getSelectedFrame();
                BufferedImage img = vi.getLienzo().getImage();
                
                VentanaInternaImage vin = new VentanaInternaImage();
                vin.getLienzo().setImage(img);
                vin.setTitle(vi.getTitle()+" (1)");
                this.desktop.add(vin);
                vin.setVisible(true);
                vin.getLienzo().repaint();
            }
            catch(Exception ex){
                System.err.println("Error al duplicar la imagen");
            }
    }//GEN-LAST:event_duplicarMenuActionPerformed

    private void colorUmbralBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorUmbralBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colorUmbralBoxActionPerformed

    private void tipoUmbralBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoUmbralBoxItemStateChanged
        if(tipoUmbralBox.getSelectedIndex()==1)
            colorUmbralBox.setEnabled(true);
        else
            colorUmbralBox.setEnabled(false);
    }//GEN-LAST:event_tipoUmbralBoxItemStateChanged

    private void umbralSliderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_umbralSliderFocusGained
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame());
        if (vi != null) {
            this.srcImg = vi.getLienzo().getImage();
        }    }//GEN-LAST:event_umbralSliderFocusGained

    private void umbralSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_umbralSliderStateChanged
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame());
            if (vi != null) {
                if(this.srcImg != null){
                    try{
                        if(srcImg.getType() != BufferedImage.TYPE_INT_RGB)
                            srcImg = this.convertImageType(srcImg, BufferedImage.TYPE_INT_RGB);
                        ThresholdOp top = new ThresholdOp(this.umbralSlider.getValue());
                        BufferedImage imgdest;
                        if(this.tipoUmbralBox.getSelectedIndex() == 0){
                            top.setType(ThresholdOp.TYPE_GREY_LEVEL);
                            
                        }else{
                            
                            switch(this.colorUmbralBox.getSelectedItem().toString()){
                                case "Rojo":
                                    top = new ThresholdOp(Color.RED,this.umbralSlider.getValue());
                                    break;
                                case "Verde":
                                    top = new ThresholdOp(Color.GREEN,this.umbralSlider.getValue());
                                    break;
                                case "Azul":
                                    top = new ThresholdOp(Color.BLUE,this.umbralSlider.getValue());
                                    break;
                            }
                            top.setType(ThresholdOp.TYPE_COLOR);
                        }
                        imgdest = top.filter(this.srcImg, null);
                        vi.getLienzo().setImage(imgdest);
                        vi.getLienzo().repaint();
                    } catch(IllegalArgumentException e){
                        System.err.println(e.getLocalizedMessage());
                    }
                }
            }
    }//GEN-LAST:event_umbralSliderStateChanged

    private void umbralSliderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_umbralSliderFocusLost
        srcImg =null;
    }//GEN-LAST:event_umbralSliderFocusLost

    private void hacerCapturaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hacerCapturaMenuActionPerformed
        JInternalFrame vi = desktop.getSelectedFrame(); 
        if (vi != null) { 
            VentanaInternaImage vii = new VentanaInternaImage();
            VentanaInternaVideoPlayer vip = (VentanaInternaVideoPlayer) vi;
            BufferedImage imgdest = vip.getFrame();
            if(imgdest !=null){ 
                try{ 
                    this.desktop.add(vii);
                    vii.setVisible(true);
                    vii.getLienzo().setImage(imgdest);
                    vii.setTitle("Captura sin guardar");
                    vii.getLienzo().repaint();
                }catch(Exception e){ 
                    System.err.println("Error al aplicar Affine"); 
                } 
            }
        }
    }//GEN-LAST:event_hacerCapturaMenuActionPerformed

    private void desktopComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_desktopComponentAdded
        JInternalFrame vi = (JInternalFrame) evt.getChild();
        VentanaInternaImage vii;
        if(evt.getChild() instanceof VentanaInternaImage){
            vii = (VentanaInternaImage) vi;            
            vii.getLienzo().setColor1(this.colorPrimarioPanel.getBackground());
            if (this.rellenoTipoBox.getSelectedIndex() > 0){
                vii.getLienzo().setTipoRelleno(rellenoTipoBox.getSelectedIndex());
                if(this.rellenoTipoBox.getSelectedIndex() > 0)
                    vii.getLienzo().setColor2(this.colorRellenoPanel.getBackground());
                    
            }
        }
    }//GEN-LAST:event_desktopComponentAdded

    private void discontinuidadBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_discontinuidadBoxItemStateChanged
        VentanaInternaImage vi = (VentanaInternaImage) desktop.getSelectedFrame();
        if(vi!=null) {
        vi.getLienzo().setEstiloLinea((int) this.grosorSpin.getValue(),this.discontinuidadBox.getSelectedIndex());
        }
    }//GEN-LAST:event_discontinuidadBoxItemStateChanged

    private void ovaloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovaloButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ovaloButtonActionPerformed

    private void curvaQuadButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_curvaQuadButtonItemStateChanged
        VentanaInternaImage vi = (VentanaInternaImage)desktop.getSelectedFrame();
        if(vi!=null && vi instanceof VentanaInternaImage){
            if(this.curvaQuadButton.isSelected())
                this.barraEstado.setText("Curva de 1 punto");
                 vi.getLienzo().setForma(Lienzo.CURVA_UN_PUNTO);
        }
    }//GEN-LAST:event_curvaQuadButtonItemStateChanged

    private void editarButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editarButtonStateChanged
        VentanaInternaImage vi = (VentanaInternaImage)desktop.getSelectedFrame();
        if(vi!=null){
            if(this.editarButton.isSelected())
                 vi.getLienzo().setEditar(true);
             else
                 vi.getLienzo().setEditar(false);
         }
        repaint();
    }//GEN-LAST:event_editarButtonStateChanged

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        VentanaInternaImage vi = (VentanaInternaImage) (desktop.getSelectedFrame()); 
         if (vi != null) { 
            BufferedImage imgSource = vi.getLienzo().getImage(); 
            if(imgSource!=null){ 
                try{ 
                    DespDchaRGBOpI neg = new DespDchaRGBOpI();
                    BufferedImage imgdest = neg.filter(imgSource, null); 
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }catch(Exception e){ 
                    System.err.println("Error al aplicar Affine"); 
                } 
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CamaraMenu;
    private javax.swing.JMenuItem ColorConvertOpMenu;
    private javax.swing.JMenu ImagenMenu;
    private javax.swing.JMenuItem NegativoMenu;
    private javax.swing.JMenuItem abrirMenu;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JButton aumentarButton;
    private javax.swing.JLabel barraEstado;
    private javax.swing.JPanel barraInferior;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JPanel brilloPanel;
    private javax.swing.JSlider brilloSlider;
    private javax.swing.JButton cientButton;
    private javax.swing.JPanel colorPrimarioPanel;
    private javax.swing.JPanel colorRellenoPanel;
    private javax.swing.JComboBox colorUmbralBox;
    private javax.swing.JButton contrasteButton;
    private javax.swing.JPanel contrastePanel;
    private javax.swing.JComboBox convolveBox;
    private javax.swing.JToggleButton curvaQuadButton;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JComboBox discontinuidadBox;
    private javax.swing.JPanel discontinuidadPanel;
    private javax.swing.JButton disminuirButton;
    private javax.swing.JButton doscientButton;
    private javax.swing.JMenuItem duplicarMenu;
    private javax.swing.JMenu edicionMenu;
    private javax.swing.JToggleButton editarButton;
    private javax.swing.JPanel editarPanel;
    private javax.swing.JPanel escaladoPanel;
    private javax.swing.JPanel filtroBoxPanel;
    private javax.swing.JPanel filtroPanel;
    private javax.swing.JMenuItem grabarAudioMenu;
    private javax.swing.JPanel grosorPanel;
    private javax.swing.JSpinner grosorSpin;
    private javax.swing.JMenuItem guardarMenu;
    private javax.swing.JMenuItem hacerCapturaMenu;
    private javax.swing.ButtonGroup herramientasGrupo;
    private javax.swing.JButton iluminacionButton;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToggleButton lapizButton;
    private javax.swing.JToggleButton lineaButton;
    private javax.swing.JButton novButton;
    private javax.swing.JMenuItem nuevoMenu;
    private javax.swing.JButton oscuridadButton;
    private javax.swing.JToggleButton ovaloButton;
    private javax.swing.JPanel panelColor;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JToggleButton rectanguloButton;
    private javax.swing.JComboBox rellenoTipoBox;
    private javax.swing.JPanel rotacionPanel;
    private javax.swing.JSlider rotacionSlider;
    private javax.swing.JComboBox tipoUmbralBox;
    private javax.swing.JPanel trazoPanel;
    private javax.swing.JSlider umbralSlider;
    private javax.swing.JPanel umbralizacionPanel;
    private javax.swing.JCheckBoxMenuItem verMenu;
    // End of variables declaration//GEN-END:variables
}
