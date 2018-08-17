/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sitop.ReadOntology;

import br.edu.sitop.Controller.Report;
import java.io.InputStream;
import java.util.HashMap;;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.util.FileManager;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;


/**
 *
 * @author angelo
 */
public class Ontology {
    
    public static Boolean ChecksTriples(Model model, String author) {
        String qr = "prefix sitop: <http://www.sitop.com/ontologies/sitop.owl#>\n"
                + "\n"
                + "SELECT ?subject\n"
                + "WHERE {\n"
                + " 	?subject sitop:hasCode '"+author+"'.\n"
                + "}";
        Query query = QueryFactory.create(qr);
        QueryExecution qExe = QueryExecutionFactory.create(query, model);
        ResultSet resultsRes = qExe.execSelect();
        while (resultsRes.hasNext()) {    
             QuerySolution soln = resultsRes.nextSolution();
             //String author = soln.get("?subject");
             return true;
        }

        
        return false;

    }
    
    public static OntModel ReadOntology(String path){
        OntDocumentManager mgr = new OntDocumentManager();
        OntModelSpec s = new OntModelSpec(OntModelSpec.RDFS_MEM);
        s.setDocumentManager(mgr);
        OntModel m = ModelFactory.createOntologyModel(s, null);
        InputStream in = FileManager.get().open(path);
        m.read(in, "RDF/XML");
        return m;

    }
    
 
    public static Model InsertTriples(OntModel sitopOntology, Report report, int id, Model finalModel, 
            HashMap<String, Integer> HmidAuthor){
        
        String SitopNS = "http://www.sitop.com/ontologies/sitop.owl#";
        
        OntClass sitop_class = sitopOntology.getOntClass(SitopNS + "SITOPReport");
        OntClass author_class = sitopOntology.getOntClass(SitopNS + "Author");
        
        //get propretys
        OntProperty hasAuthor = sitopOntology.getObjectProperty(SitopNS + "hasAuthor");
        DatatypeProperty hasCode = sitopOntology.getDatatypeProperty(SitopNS + "hasCode");
        DatatypeProperty hasTimeStamp = sitopOntology.getDatatypeProperty(SitopNS + "hasTimeStamp");
        
 
        String reportURIID = sitop_class.toString() + "/"+id;
        
        Integer idAuthor = HmidAuthor.get(report.getAuthor());
        String authorURIID = author_class.toString() + "/"+ idAuthor;
     
        
        OntModel inf = ModelFactory.createOntologyModel(new OntModelSpec(OntModelSpec.RDFS_MEM), null);
        Individual reportIndividual = inf.createIndividual(reportURIID, sitop_class);
        
       
        if(ChecksTriples(finalModel, report.getAuthor())){
            reportIndividual.addProperty(hasAuthor, authorURIID);
        }else{
            Individual authorIndividual = inf.createIndividual(authorURIID, author_class);
            reportIndividual.addProperty(hasAuthor, authorIndividual);
            Node codeNode = NodeFactory.createLiteralByValue(report.getAuthor(), XSDDatatype.XSDstring);
            RDFNode RDFcodeNode = inf.asRDFNode(codeNode);
            authorIndividual.addProperty(hasCode, RDFcodeNode);
        }
        
        
        Node timestampnode = NodeFactory.createLiteralByValue(report.getTimestamp(), XSDDatatype.XSDdateTimeStamp);
        RDFNode RDFtimestampNode = inf.asRDFNode(timestampnode);
        
        
        reportIndividual.addProperty(hasTimeStamp, RDFtimestampNode);
        
        //indicadores
        
        Model union = ModelFactory.createUnion(inf, finalModel);
        
        return union;
        
    }
    
}
