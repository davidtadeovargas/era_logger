import com.era.logger.LoggerUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PC
 */
@TestMethodOrder(OrderAnnotation.class)
public class LoggerUtilityJUnitTest  {
    
    @Test
    @Order(1)
    public void logInfoTest() {
        
        try{
            
            LoggerUtility.getSingleton().logInfo(LoggerUtilityJUnitTest.class, "Testing logInfo");
            
            Assertions.assertTrue(true);
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(LoggerUtilityJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
    
    @Test
    @Order(2)
    public void logErrorTest() {
        
        try{
            
            throw new Exception();
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(LoggerUtilityJUnitTest.class, e);
            
            Assertions.assertTrue(true);
        }
    }
}
