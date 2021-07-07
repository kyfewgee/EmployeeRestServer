/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeerestserver;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
/**
 *This class is meant to take the list and find the values needed
    It obviously also allows modification to employees in the list or 
    adding/removing employees to the list
    This is essentially our repository
 * @author KFueglein
 */
@Repository
public class EmployeeData {

    private static EmployeeList list = EmployeeList.EmployeeList();
    
    //returns the list of only active employees
    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> ActiveEmployees = new ArrayList<Employee>();
        for(Employee e : list.getEmployeeArrayList()){
            if (e.getStatus().equals("ACTIVE")){
                ActiveEmployees.add(e);
            }
        } 
    return ActiveEmployees;
    }
    //will add in a value
    public void addEmployee(Employee employee){
     list.getEmployeeArrayList().add(employee);
    }
    //this uses a basic for loop to find the employee by ID
    //Since the data set is small the search time is not too slow
    public Employee getEmployeeByID(int id){
        Employee employee = null;
        for(Employee e : list.getEmployeeArrayList()){
            if(e.getID() == id){
                if(e.getStatus().equals("INACTIVE")){
                //this will throw employee not found error in controller
                employee = null;
                }else{
                employee = e;
                }
            break;
            }
        }
        return employee;
    }
    //again looks up our employee and sets their status as "INACTIVE"
    public boolean deleteEmployeeByID(int id){
        for(Employee e : list.getEmployeeArrayList()){
            if(e.getID() == id){
                e.setStatus("INACTIVE");
                return true; 
            }
        }
        return false;
    }
    //finds the employee by ID then will update all of the employee information
    //with the new information from our new Employee, it will not change the ID
    public boolean updateEmployeeByID(int id, Employee employee){
        for (Employee e : list.getEmployeeArrayList()){
            if(e.getID() == id){
                e.updateEmployeeInfo(employee);
                return true;
            }
        }
        return false;
    }

}
