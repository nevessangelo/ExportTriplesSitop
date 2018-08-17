/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sitop.ReadJson;

import br.edu.sitop.Controller.Indicators;
import br.edu.sitop.Controller.Report;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
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
            
            JSONObject indicators_object = (JSONObject) jsonObject.get("indicators");

            JSONObject oil_object = (JSONObject) indicators_object.get("oil");
            JSONObject gas_object = (JSONObject) indicators_object.get("gas");
            
            String aux_timesptamp = SITU_DT_REGISTRO + " " + SITU_HR_REGISTRO;
            
            DateFormat df = new SimpleDateFormat("dd/mm/yyyy hh:mm");
            Date parsedDate = df.parse(aux_timesptamp);
           
            Timestamp timeStampDate = new Timestamp(parsedDate.getTime());
            
            report.setAuthor(USUA_CD_USERNAME);
            report.setTimestamp(timeStampDate);
            
            Set keys = oil_object.keySet();
            Iterator<String> iterator = keys.iterator();
            ArrayList<Indicators> indicatorsList = new ArrayList<>();
            while (iterator.hasNext()) {
                String Indicator = (String) iterator.next();
                JSONObject parametrs = (JSONObject) oil_object.get(Indicator);
                if (parametrs.get("unit") != null && !parametrs.get("unit").equals("")) {
                    String s_value = (String) parametrs.get("value");
                    String s_unit = (String) parametrs.get("unit");
                    Double valueIndicator = Double.parseDouble(s_value);
                    Indicators indicators = new Indicators();
                    indicators.setName(Indicator);
                    indicators.setValue(valueIndicator);
                    indicators.setMedida(s_unit);
                    indicatorsList.add(indicators);
                }
            }
            
            Set keysGas = gas_object.keySet();
            Iterator<String> iteratorGas = keysGas.iterator();
            while (iteratorGas.hasNext()) {
                String Indicator = (String) iteratorGas.next();
                JSONObject parametrs = (JSONObject) gas_object.get(Indicator);
                if (parametrs.get("unit") != null && !parametrs.get("unit").equals("")) {
                    String s_value = (String) parametrs.get("value");
                    String s_unit = (String) parametrs.get("unit");
                    Double valueIndicator = Double.parseDouble(s_value);
                    Indicators indicators = new Indicators();
                    indicators.setName(Indicator);
                    indicators.setValue(valueIndicator);
                    indicators.setMedida(s_unit);
                    indicatorsList.add(indicators);
                }
                
            }
            
            report.setIndicators(indicatorsList);
            
            
            
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
