/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cargarArchivo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.annotation.processing.FilerException;
import java.io.*;

/**
 *
 * @author COMPAQ
 */
public class OpenFile {
    
    public String CargarArchivo (File file){
        String textFile = "";
        try {
            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);
            
            while(scan.hasNextLine()){
                textFile = textFile + scan.nextLine() + "\n";
            }
            scan.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al Abrir el Archivo");
        }
        catch (IOException e){
            System.out.println("Error al Leer el Archivo");
        }
        return textFile;        
    }
}
