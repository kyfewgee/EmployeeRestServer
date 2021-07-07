
package com.mycompany.employeerestserver.utils;

/**
 * util class to keep track of a unique human readable ID
 * @author KFueglein
 */
public class UniqueID {
    private static int idCounter = 0;
    
    public static synchronized int createID(){
        return idCounter++;
    }
}
