/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sitop.Controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author angelo
 */
public class Report {
    
    private String author;
    private Timestamp timestamp;
    private ArrayList<Indicators> indicators;
    
    
    public Report(){
        
    }
    
    public Report(String author, Timestamp timestamp, ArrayList<Indicators> indicators){
        this.author = author;
        this.timestamp = timestamp;
        this.indicators = indicators;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
   
    /**
     * @return the indicators
     */
    public ArrayList<Indicators> getIndicators() {
        return indicators;
    }

    /**
     * @param indicators the indicators to set
     */
    public void setIndicators(ArrayList<Indicators> indicators) {
        this.indicators = indicators;
    }

    /**
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    
    
    
}
