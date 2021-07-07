package com.mycompany.employeerestserver;

/*
    Error Handling When employee not found
    Prints the actual message response
    @Author KFueglein
*/
class EmployeeNotFoundException extends RuntimeException{
    EmployeeNotFoundException(int id){
        super("Could not find employee :" + id);
    }
}