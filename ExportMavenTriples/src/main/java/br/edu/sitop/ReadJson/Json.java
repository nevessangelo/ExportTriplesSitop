/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sitop.ReadJson;

import br.edu.sitop.Controller.Report;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author angelo
 */
public class Json {
    
    public static Report ReadJson(String name) throws IOException{
        JSONParser parser = new JSONParser();
        Report report = new Report();
        try {
            Object obj = parser.parse(new FileReader(name));
            JSONObject jsonObject = (JSONObject) obj;
            
            String USUA_CD_USERNAME = (String) jsonObject.get("USUA_CD_USERNAME");
            String SITU_HR_REGISTRO = (String) jsonObject.get("SITU_HR_REGISTRO");
            String SITU_DT_REGISTRO = (String) jsonObject.get("SITU_DT_REGISTRO");
            
            String aux_timesptamp = SITU_DT_REGISTRO + " " + SITU_HR_REGISTRO;
            
            DateFormat df = new SimpleDateFormat("dd/mm/yyyy hh:mm");
            Date parsedDate = df.parse(aux_timesptamp);
           
            Timestamp timeStampDate = new Timestamp(parsedDate.getTime());
            
            report.setAuthor(USUA_CD_USERNAME);
            report.setTimestamp(timeStampDate);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        }
        return report;
    }
    
}
