/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
/**
 *
 * @author GRAFITEX
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
 
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Document;
 
public class PintaStringNumber extends JPanel 
{
  JTextPane pane;
  JScrollPane scrollPane;
  String moslin = "";
  
  private int ultimoCaracter(String text, int indice){
        while(--indice >= 0){
            if(String.valueOf(text.charAt(indice)).matches("\\W")){
                break;
            }
        }
        return indice;
    }
    
    private int primerCaracter(String text, int indice){
        while(indice < text.length()){
            if(String.valueOf(text.charAt(indice)).matches("\\W")){
                break;
            }
            indice++;
        }
        return indice;
    }
 
  public PintaStringNumber (){
      super ();
      final StyleContext cont = StyleContext.getDefaultStyleContext();
      final AttributeSet cadAzul = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
      final AttributeSet cadNegra = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        
      DefaultStyledDocument doc = new DefaultStyledDocument(){
          public void insertString(int offset, String str, AttributeSet a) throws BadLocationException{
              super.insertString(offset, str, a);    
              
              String text = getText(0, getLength());
              int antes = ultimoCaracter(text, offset);
              if (antes < 0) antes = 0;
              int despues = primerCaracter(text, offset + str.length());
              int palabraL = antes;
              int palabraR = antes;
              
              while (palabraR <= despues) {
                  if (palabraR == despues || String.valueOf(text.charAt(palabraR)).matches("\\W")) {
                      if (text.substring(palabraL, palabraR).matches("(\\W)*(inicio|entero|fin|mientras|para|finciclo|si|finsi|sino|finsino|hacer|hasta|entonces|funcion|linea|rectangulo|circulo|color|elipse|retornar|true|false)"))
                          setCharacterAttributes(palabraL, palabraR - palabraL, cadAzul, false);
                      else
                          setCharacterAttributes(palabraL, palabraR - palabraL, cadNegra, false);
                      palabraL = palabraR;
                  }
                  palabraR++;
              }
          }
            
          public void remover (int offs, int len) throws BadLocationException {
              super.remove(offs, len);

              String text = getText(0, getLength());
              int antes = ultimoCaracter(text, offs);
              if (antes < 0) antes = 0;
              int despues = primerCaracter(text, offs);
 
              if (text.substring(antes, despues).matches("(\\W)*(inicio|entero|fin|mientras|para|finciclo|si|finsi|sino|finsino|hacer|hasta|entonces|funcion|linea|rectangulo|circulo|color|elipse|retornar|true|false)")) {
                  setCharacterAttributes(antes, despues - antes, cadAzul, false);
              } else {
                  setCharacterAttributes(antes, despues - antes, cadNegra, false);
              }
          }
      };
    
    setPreferredSize (new Dimension (30, 30));
    pane = new JTextPane (doc)
    {
      public void paint (Graphics g)
      {
	super.paint(g);
	PintaStringNumber.this.repaint ();
      }
    };
    pane.setPreferredSize(new Dimension(300, 300));
    
    scrollPane = new JScrollPane (pane);
  }
   
  public void paint (Graphics g)
  {
    super.paint (g);
    
    int start =
      pane.viewToModel (scrollPane.getViewport ().getViewPosition ());
    int end =
      pane.
      viewToModel (new
		   Point (scrollPane.getViewport ().getViewPosition ().x +
			  pane.getWidth (),
			  scrollPane.getViewport ().getViewPosition ().y +
			  pane.getHeight ()));
    Document doc = pane.getDocument ();
    int startline = doc.getDefaultRootElement ().getElementIndex (start);
    int endline = doc.getDefaultRootElement ().getElementIndex (end);
    int fontHeight = g.getFontMetrics (pane.getFont ()).getHeight ();	// font
    
    for (int line = startline, y = 0; line <= endline+1;
	 line++, y += fontHeight)
      {
	g.drawString (Integer.toString (line), 0, y);
      }
    moslin = "Numero de Lineas: " + (endline+1);
  }
}