/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import cargarArchivo.ExtentFile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import lexico_sintactico.AnalizadorSintactico;
import lexico_sintactico.DibujaFiguras;
import lexico_sintactico.Lexico;
/**
 *
 * @author GRAFITEX
 */
public class Frame extends javax.swing.JFrame{

    /**
     * Creates new form Frame
     */
    PintaStringNumber obj = new PintaStringNumber();
    private final Highlighter.HighlightPainter pintaVerde;
    
    public Frame() {
        initComponents();
                        
        pintaVerde = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
        obj.pane.setHighlighter(new LineHighlighter());
        obj.pane.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                setHighlight(e);
            }
        });
        
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(obj, BorderLayout.WEST);
        jPanel1.add(obj.scrollPane, BorderLayout.CENTER);
        
        pack();
        Font fuente = new Font("Calisto MT", Font.PLAIN, 15);
        obj.pane.setBackground(new Color(204, 255, 255));
        obj.pane.setFont(fuente);
        //obj.pane.addCaretListener(new pintaLinea.PintaLineaActual());
        
        
    }
    
    public void setHighlight(CaretEvent e) {
        obj.pane.getHighlighter().removeAllHighlights();
        int concurrenciaLine = getLineFromOffset(obj.pane, e.getDot());
        int inicioPos = getLineStartOffsetForLine(obj.pane, concurrenciaLine);
        int finOffset = getLineEndOffsetForLine(obj.pane, concurrenciaLine);

        try {
            obj.pane.getHighlighter().addHighlight(inicioPos, finOffset, pintaVerde);           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        obj.pane.repaint();
    }
    
    public int getLineFromOffset(JTextComponent component, int offset) {
        return component.getDocument().getDefaultRootElement().getElementIndex(offset);
    }

    public int getLineStartOffsetForLine(JTextComponent component, int line) {
        return component.getDocument().getDefaultRootElement().getElement(line).getStartOffset();
    }

    public int getLineEndOffsetForLine(JTextComponent component, int line) {
        return component.getDocument().getDefaultRootElement().getElement(line).getEndOffset();
    }

    public class LineHighlighter extends DefaultHighlighter {
        private JTextComponent component;

        @Override
        public final void install(final JTextComponent c) {
            super.install(c);
            this.component = c;
        }

        @Override
        public final void deinstall(final JTextComponent c) {
            super.deinstall(c);
            this.component = null;
        }

        @Override
        public final void paint(final Graphics g) {
            final Highlighter.Highlight[] highlights = getHighlights();
            final int len = highlights.length;
            for (int i = 0; i < len; i++) {
                Highlighter.Highlight info = highlights[i];
                if (info.getClass().getName().indexOf("LayeredHighlightInfo") > -1) {
                    // Avoid allocing unless we need it.
                    final Rectangle a = this.component.getBounds();
                    final Insets insets = this.component.getInsets();
                    a.x = insets.left;
                    a.y = insets.top;
                    a.height -= insets.top + insets.bottom;
                    final Highlighter.HighlightPainter p = info.getPainter();
                    p.paint(g, info.getStartOffset(), info.getEndOffset(), a, this.component);
                }
            }
        }

        @Override
        public void removeAllHighlights() {
            obj.pane.repaint(0, 0, obj.pane.getWidth(), obj.pane.getHeight());
            super.removeAllHighlights();
        }
    }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jFileChooser1 = new javax.swing.JFileChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador - AJRA IDE 1.0");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 305));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Ejemplo1");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("project");
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("COMPILADO");

        jTextPane2.setEditable(false);
        jTextPane2.setBackground(new java.awt.Color(241, 237, 179));
        jScrollPane2.setViewportView(jTextPane2);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 545, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 255));
        jLabel3.setText("CODIGO :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 255));
        jLabel4.setText("Project");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("mrfastermen@gmail.com");

        jMenu1.setBackground(new java.awt.Color(153, 255, 153));
        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(153, 255, 153));
        jMenu2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setText("Ejecutar");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem2.setText("Correr");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setText("Limpiar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(153, 255, 153));
        jMenu3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu3.setText("Ayuda");

        jMenuItem5.setText("Palabras Reservadas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Ejemplo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Creditos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addGap(11, 11, 11)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jFileChooser1 = new JFileChooser();  
        jFileChooser1.setAcceptAllFileFilterUsed(true);
        ExtentFile ef = new ExtentFile();
        jFileChooser1.setFileFilter(ef);
        jFileChooser1.setDialogType(JFileChooser.OPEN_DIALOG);
        jFileChooser1.setDialogTitle("Abrir");
        jFileChooser1.showOpenDialog(this);
        File fi = jFileChooser1.getSelectedFile();
        cargarArchivo.OpenFile openfi = new cargarArchivo.OpenFile();
        obj.pane.setText(openfi.CargarArchivo(fi));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try{         
            escribir("project.ara");
            Lexico lex = new Lexico(new FileReader("project.ara"));
            AnalizadorSintactico parser = new AnalizadorSintactico(lex);
            jLabel2.setText(obj.moslin);
            try{
                parser.parse();
                JFrame marco = new JFrame("Figuras");
                marco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                DibujaFiguras panelDibujo = new DibujaFiguras(parser.getInstrucciones());
                panelDibujo.setBackground( Color.WHITE );
                marco.add(panelDibujo); 
                marco.setSize(600,600); 
                marco.setVisible(true); 
                marco.setLocationRelativeTo(null);
                jTextPane2.setText("COMPILACION EXITOSA!!!\n");
            }
            catch (java.lang.Exception el){
                jTextPane2.setText("SYNTAX ERROR\n");
                
            }
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       this.jTextPane2.setText("");
       //this.jTextPane3.setText("");
       obj.pane.setText("");
       this.jLabel2.setText("");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JOptionPane.showMessageDialog(null, "inicio : INICIO\n( : Parentesis A\n): Parentesis C\n{ : Llave A\n"
                + "} : Llave C\n; : Termina Cadena\n, : Separador\n< : Simbolo Men\n\"> : Simbolo May\n= : Enlazador\n"
                + "fin : FIN\nfinsi : FINSI\nfinsino : FINSINO\nfinciclo : FINCICLO\nentero : Palabra Reservada\n"
                + "caracter : Palabra Reservada\nmientras : Palabra Reservada\npara : Palabra Reservada\n"
                + "si : Palabra Reservada\nsino : Palabra Reservada\nfuncion : FUNCION");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        cargaArchivo1();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JFrame creditos = new JFrame();
        JPanel panel = new JPanel();
        JLabel l1 = null, l2 = null, l3 = null, l4= null;
        
        creditos.setTitle("CREDITOS");
        creditos.setVisible(true);
        creditos.setLocationRelativeTo(null);
        creditos.setResizable(false);
        creditos.setSize(190, 120);
        l1 = new JLabel();
        l1.setText("IDE - ALBERTO V3.05");
        l2 = new JLabel();
        l2.setText("Creado por:");
        l3 = new JLabel();
        l3.setText("ALBERTO RODRIGUEZ ALVAREZ");
        l4 = new JLabel();
        l4.setText("Profesor: Daniel Ricardo");
        
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        
        creditos.add(panel);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = jTree1.getSelectionPath();
        parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
        if(parentNode.isLeaf()){
            cargaArchivo1();
        }
    }//GEN-LAST:event_jTree1MouseClicked

    public void escribir(String direccion){
        //metodo que guarda lo que esta escrito en un archivo de texto
	try{	
            FileWriter writer = new FileWriter(direccion);
            PrintWriter print = new PrintWriter(writer);
            print.print(obj.pane.getText());
            writer.close();
	}
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void cargaArchivo1(){
        String imp = "";
        try{
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream("Ejemplo\\tren.ara");
            DataInputStream entrada = new DataInputStream(fstream);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            while ((strLinea = buffer.readLine()) != null)   {
                imp += strLinea+"\n";
            }
            entrada.close();
        }catch (Exception e){ 
            obj.pane.setText("Ocurrio un error: " + e.getMessage());
        }
        obj.pane.setText(imp);
    }
     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame();                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
