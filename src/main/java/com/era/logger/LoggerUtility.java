/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author PC
 */
public class LoggerUtility {
    
    private static LoggerUtility LoggerManager;
    
    
    private LoggerUtility(){
        
    }
    
    final public static LoggerUtility getSingleton(){
        if(LoggerManager==null){
            LoggerManager = new LoggerUtility();
        }
        return LoggerManager;
    }

    final public void logInfo(final Class class_, final String log){
        
        Logger logger = Logger.getLogger("Log");
        FileHandler fh;

        try {  

            //This block configure the logger with handler and formatter
            fh = new FileHandler("log.log",true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);
            
            final String logg = "Logger: " + log;
        
            System.out.println(logg);

            logger.info(logg);                

            fh.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    final public void logError(final Class class_,final Exception e){
        
        Logger logger = Logger.getLogger("ErrorLog");
        FileHandler fh;

        try {  

            //This block configure the logger with handler and formatter
            fh = new FileHandler("error.log",true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);
            
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            final String errorMessage = "Error: " + sw.toString();

            logger.info(errorMessage);

            System.out.println(errorMessage);

            fh.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
