/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sitop.ReadJson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    
    public static void ReadJson(String name) throws IOException{
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(name));
            JSONObject jsonObject = (JSONObject) obj;
            
            String USUA_CD_USERNAME = (String) jsonObject.get("USUA_CD_USERNAME");
            String SITU_HR_REGISTRO = (String) jsonObject.get("SITU_HR_REGISTRO");
            String SITU_DT_REGISTRO = (String) jsonObject.get("SITU_DT_REGISTRO");
            
            System.out.println(USUA_CD_USERNAME);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
