/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cargarArchivo;

import java.io.File;

/**
 *
 * @author COMPAQ
 */
public class ExtentFile extends javax.swing.filechooser.FileFilter{

    @Override
    public boolean accept(File fi) {
        return fi.isDirectory() | fi.getName().toLowerCase().endsWith(".ara");
    }

    @Override
    public String getDescription() {
        return ".ara Lenguaje Alberto";
    }
    
}
