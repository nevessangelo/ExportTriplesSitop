/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sitop.Main;

import br.edu.sitop.Controller.Report;
import br.edu.sitop.ReadJson.Json;
import br.edu.sitop.ReadOntology.Ontology;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jena.ontology.OntModel;

/**
 *
 * @author angelo
 */
public class Main {
    
    public static void main(String[] args) {
        File folder = new File("/home/angelo/Codigo/ExportTriplesSitop/jsons/");
        File[] listOfFiles = folder.listFiles();
        OntModel ontologySitop = Ontology.ReadOntology("/home/angelo/Projeto/Test_ontology2.owl");
        int id = 1;
        for (File file : listOfFiles) {
            try {
                Report report = Json.ReadJson(file.toString());
                Ontology.InsertTriples(ontologySitop, report, id);
                id++;
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



        
        
    }
    
}
