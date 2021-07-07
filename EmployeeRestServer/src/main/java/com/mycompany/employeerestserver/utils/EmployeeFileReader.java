/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeerestserver.utils;
import com.mycompany.employeerestserver.Employee;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;

/**
 *This is a helper method to read in the values from the External text file
 * @author KFueglein
 */
public class EmployeeFileReader {
    
    public static ArrayList<Employee> readInEmployees(String filename){
        int lineNumber = 1;
        ArrayList<Employee> Employees =  new ArrayList<Employee>();
        try{
            File file = new File(filename);
            Scanner sc = new Scanner(file);
        

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] values  = line.split(", ");
            if(values.length != 6){
                System.out.println("********Invalid input in input file on line: "+lineNumber+ " ***************");
                break;
            }else{
                Employees.add(new Employee(values[0],values[1],values[2],values[3],values[4],values[5]));
            }
            lineNumber++;
        }
        }   
        catch(FileNotFoundException e){
            System.out.println(e);
        } 
        return Employees;
    }
    

    
    
}
