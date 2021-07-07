/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeerestserver;

import com.mycompany.employeerestserver.utils.EmployeeFileReader;
import java.util.ArrayList;

/**
 *Singleton Instance of Employee list
    To ensure that there will only ever be on employee list
 * @author KFueglein
 */
public final class EmployeeList {
    private static EmployeeList EmployeeListInstance = null;
    private ArrayList<Employee> Employees;
    
    private EmployeeList(){
        EmployeeFileReader file = new EmployeeFileReader();
        Employees = file.readInEmployees("EmployeeInfo.txt");
    }
    
    public static EmployeeList EmployeeList(){
        if (EmployeeListInstance == null){
            EmployeeListInstance = new EmployeeList();
        }
        return EmployeeListInstance;
    }
    public String getContent(){
        String content = "";
        for(Employee e : Employees){
            content = content+ e.toString()+ "\n" ;
        }
        
        return content;
    }
    public ArrayList<Employee> getEmployeeArrayList(){
        return this.Employees;
    }
}
