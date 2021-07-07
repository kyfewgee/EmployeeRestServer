/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeerestserver;

import com.mycompany.employeerestserver.utils.EmployeeFileReader;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 

/**
 *Main class to initialize the Spring application
 * @author KFueglein
 */
@SpringBootApplication
public class EmployeeRestServerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeeFileReader file = new EmployeeFileReader();
        EmployeeList EL = EmployeeList.EmployeeList();
        System.out.println(EL.getContent());
        SpringApplication.run(EmployeeRestServerMain.class, args);
        
    }
        
}
    

