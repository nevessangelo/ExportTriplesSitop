/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sitop.Main;

import br.edu.sitop.Controller.GenerateHash;
import br.edu.sitop.Controller.Report;
import br.edu.sitop.ReadJson.Json;
import br.edu.sitop.ReadOntology.Ontology;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

/**
 *
 * @author angelo
 */
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File("/home/angelo/Codigo/ExportTriplesSitop/jsons/");
        File[] listOfFiles = folder.listFiles();
        OntModel ontologySitop = Ontology.ReadOntology("/home/angelo/Projeto/Test_ontology2.owl");
        Model finalModel = ModelFactory.createDefaultModel();
        HashMap<String, Integer> idAuthor = GenerateHash.createHashAuthor();
        
        int id = 1;
        for (File file : listOfFiles) {
            try {
                Report report = Json.ReadJson(file.toString());
                Model model_aux = Ontology.InsertTriples(ontologySitop, report, id, finalModel, idAuthor);
                finalModel = model_aux;
                id++;
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        finalModel.write(System.out, "N-Triples");
        FileOutputStream out = new FileOutputStream("/home/angelo/Test.rdf",false);
        finalModel.write(out, "RDF/XML");
        finalModel.close();
    }
    
}
