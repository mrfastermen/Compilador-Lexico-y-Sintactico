/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import java.io.File;

/**
 *
 * @author pc
 */
public class GeneradorFlex {
    public static void main(String[] args) {
        JFlex.Main.generate(new File(
                "src"+File.separator+"lexico_sintactico"
                + File.separator + "Lexico.flex"));
    }
}
