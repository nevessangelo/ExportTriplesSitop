/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sitop.Main;

import br.edu.sitop.ReadJson.Json;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angelo
 */
public class Main {
    
    public static void main(String[] args) {
        File folder = new File("/home/angelo/Codigo/ExportTriplesSitop/jsons/");
        File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            try {
                Json.ReadJson(file.toString());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



        
        
    }
    
}
