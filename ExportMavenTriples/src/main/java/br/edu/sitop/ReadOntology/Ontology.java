/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sitop.ReadOntology;

import br.edu.sitop.Controller.Indicators;
import br.edu.sitop.Controller.Report;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;import java.util.Iterator;
;
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
import org.apache.jena.vocabulary.RDFS;


/**
 *
 * @author angelo
 */
public class Ontology {
    
    public static Integer idIndicator = 1;
    public static Integer idPlatformArea = 1;
    public static Integer idscalarQuantity = 1;
    
    
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
    
 
    public static Model InsertTriples(OntModel sitopOntology, OntModel scalarQuantity, 
            Report report, int id, Model finalModel, 
            HashMap<String, Integer> HmidAuthor, HashMap<String, ArrayList<String>> indicatorsParametrs){
        
        sitopOntology.setStrictMode(false);
        String SitopNS = "http://www.sitop.com/ontologies/sitop.owl#";
        String ontoCapeNS = "file:/I:/OntoCape/OWL/scalar_quantity.owl#";
        
        OntClass sitop_class = sitopOntology.getOntClass(SitopNS + "SITOPReport");
        OntClass author_class = sitopOntology.getOntClass(SitopNS + "Author");
        OntClass IndicatorClass = sitopOntology.getOntClass(SitopNS + "Indicator");
        OntClass PlatformAreaClass = sitopOntology.getOntClass(SitopNS + "PlatformArea");
        
        OntClass RealScalarClass = scalarQuantity.getOntClass(ontoCapeNS + "ScalarQuantity");
        
        
        //get propretys
        OntProperty hasAuthor = sitopOntology.getObjectProperty(SitopNS + "hasAuthor");
        OntProperty hasPlatformArea = sitopOntology.getObjectProperty(SitopNS + "hasPlatformArea");
        OntProperty hasIndicator = sitopOntology.getObjectProperty(SitopNS + "hasIndicator");
        OntProperty hasValue = sitopOntology.getObjectProperty(SitopNS + "hasValue");
        
        DatatypeProperty hasCode = sitopOntology.getDatatypeProperty(SitopNS + "hasCode");
        DatatypeProperty hasTimeStamp = sitopOntology.getDatatypeProperty(SitopNS + "hasTimeStamp");
        DatatypeProperty hasName = sitopOntology.getDatatypeProperty(SitopNS + "hasName");
        
        DatatypeProperty hasNumericalValue = scalarQuantity.getDatatypeProperty(ontoCapeNS + "has_numerical_value");
        DatatypeProperty hasUnitofMeasurement = scalarQuantity.getDatatypeProperty(ontoCapeNS + "has_unit_of_measurement");
        
        
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
        ArrayList<Indicators> IndicatorsList = report.getIndicators();
        for(Indicators indicators: IndicatorsList){
            ArrayList<String> get_classes = indicatorsParametrs.get(indicators.getName());
            
            String IndicatorURIID = IndicatorClass.toString()+"/"+idIndicator;
            String PlatFormAreaURIID = PlatformAreaClass.toString()+"/"+idPlatformArea;
            String scalarQuantityURIID = RealScalarClass.toString() + "/"+idscalarQuantity;
            
            OntClass TypeAreaClass = sitopOntology.getOntClass(SitopNS + get_classes.get(1));
            OntClass TypeIndicadorClass = sitopOntology.getOntClass(SitopNS + get_classes.get(0));
            
    
            Individual indicatorIndividual = inf.createIndividual(IndicatorURIID, IndicatorClass);
            Individual platformAreaIndividual = inf.createIndividual(PlatFormAreaURIID, PlatformAreaClass);
            
            
            platformAreaIndividual.addProperty(RDFS.subClassOf, TypeAreaClass);
            indicatorIndividual.addProperty(hasPlatformArea, platformAreaIndividual);
            
            reportIndividual.addProperty(hasIndicator, indicatorIndividual);
            
            
            Individual scalarIndividual = inf.createIndividual(scalarQuantityURIID, RealScalarClass);
            
            
            
            indicatorIndividual.addProperty(hasValue, scalarIndividual);
            
            Node valuenode = NodeFactory.createLiteralByValue(indicators.getValue(), XSDDatatype.XSDdouble);
            RDFNode RDFvalueNode = inf.asRDFNode(valuenode);
            
            Node unitnode = NodeFactory.createLiteralByValue(indicators.getMedida(), XSDDatatype.XSDstring);
            RDFNode RDFUnitNode = inf.asRDFNode(unitnode);
            
            scalarIndividual.addProperty(hasNumericalValue, RDFvalueNode);
            scalarIndividual.addProperty(hasUnitofMeasurement, RDFUnitNode);
            
            
            indicatorIndividual.addProperty(RDFS.subClassOf, TypeIndicadorClass);
            
            
            
            
            
            idIndicator++;
            idPlatformArea++;
            idscalarQuantity++;
            
            
            
        }
        
        
        Model union = ModelFactory.createUnion(inf, finalModel);
        
        return union;
        
    }
    
}
