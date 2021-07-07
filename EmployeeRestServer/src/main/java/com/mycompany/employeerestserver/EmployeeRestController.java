/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeerestserver;

import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *Controller class to set up the paths 
 * @author KFueglein
 */
@RestController
@RequestMapping(path = "/employees")
public class EmployeeRestController {
    
    @Autowired
    private EmployeeData employeeData;
    
    //creates path http://localhost:8080/employees which will return 
    //all employees in the repository
     @GetMapping(path="", produces = "application/json")
    public ArrayList<Employee> getEmployees() 
    {
        return employeeData.getAllEmployees();
    }
    /*creates path http://localhost:8080/employees/{id} there needs to be
    an int value for {id} and this will return the employee with the specified ID
    */
    @GetMapping(path ="/{id}", produces = "application/json")
    public Employee getOne(@PathVariable int id) {
        Employee e = employeeData.getEmployeeByID(id);
        if(e != null){
            return e;
        }else{
         throw new EmployeeNotFoundException(id);
        }
    }
    /*creates path http://localhost:8080/employees/addEmployee where there needs to be a body
    //that includes a JSON with an input of the employee.
    //example of this is: 
      {"firstName":"Garry","middleInitial":"K","lastName":"Squarepants","dateOfBirth":"03/19/2000","dateOfEmployment":"04/12/2478","status":"ACTIVE"}
    
    this will add in an employee to the employee list
    */
    @PostMapping(path= "/addEmployee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) 
    {       
        employeeData.addEmployee(employee);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getID())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
    /*
        creates path http://localhost:8080/employees/update/{id} where there needs to be a body
        that includes a JSON with an input of the employee you want to be updated as well as an int 
        value in the URL for {id}
        example employee JSON: 
	{"firstName":"Garry","middleInitial":"K","lastName":"Squarepants","dateOfBirth":"03/19/2000","dateOfEmployment":"04/12/2478","status":"ACTIVE"}
    */
    @PutMapping(path = "/update/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable int id) {
    
    boolean val = employeeData.updateEmployeeByID(id, newEmployee);
    //if an employee was not updated then throw employee not found exception
     if(val){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(id)
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }else{
        throw new EmployeeNotFoundException(id);
    }
  }
    /*
    creates path http://localhost:8080/employees/delete/{id} where there needs to be
    an int value in URL for {id} and this will delete the employee with the given id
    from the Employee list
    */
  @DeleteMapping(path = "/delete/{id}")
  void deleteEmployee(@PathVariable int id) {
    boolean val = employeeData.deleteEmployeeByID(id);
    
    //if an employee was not deleted throw employee not found exception
    if(!val){
        throw new EmployeeNotFoundException(id);
    }
  }
    
}
