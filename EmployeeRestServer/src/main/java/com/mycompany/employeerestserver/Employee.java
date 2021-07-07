
package com.mycompany.employeerestserver;
import  com.mycompany.employeerestserver.utils.UniqueID;

/**
 * Employee object to hold Employee artifacts
 * @author Cheddar
 */
public class Employee {
    int ID;
    String FirstName;
    String MiddleInitial;
    String LastName;
    String DateOfBirth;
    String DateOfEmployment;
    String Status;
    
    public Employee(String firstName, String middleInitial, String lastName, String dateOfBirth, String dateOfEmployment, String status ){
        ID = UniqueID.createID();
        FirstName = firstName;
        MiddleInitial = middleInitial;
        LastName = lastName;
        
        //check valid date
        if(checkDateFormat(dateOfBirth) == false){
           System.out.println("****Invalid birth date on Employee ID: " +ID + " Name: "+ FirstName + " "+ MiddleInitial + ". " + LastName+ "*******");
        }else{
            DateOfBirth = dateOfBirth;
        }
        //check valid date
        if(checkDateFormat(dateOfEmployment) == false){
           System.out.println("****Invalid employment date on Employee ID: " +ID + " Name: "+ FirstName + " "+ MiddleInitial + ". " + LastName+"*****");
        }else{
            DateOfEmployment = dateOfEmployment;
        }
        Status = status;
        
    }
    public Employee(){
        ID = UniqueID.createID();
    }
    public int getID(){
        return ID;
    }
    public void updateEmployeeInfo(Employee e){
        this.FirstName = e.getFirstName();
        this.MiddleInitial = e.getMiddleInitial();
        this.LastName = e.getLastName();
        this.DateOfBirth = e.getDateOfBirth();
        this.DateOfEmployment = e.getDateOfEmployment();
        this.Status = e.getStatus();
    }
    
    public void setFirstName(String firstName){
        FirstName = firstName;
    }
    public String getFirstName(){
        return FirstName;
    }
    public void setMiddleInitial(String middleInitial){
        MiddleInitial = middleInitial;
    }
    public String getMiddleInitial(){
        return MiddleInitial;
    }
    public void setLastName(String lastName){
        LastName = lastName;
    }
    public String getLastName(){
        return LastName;
    }
    public void setDateOfBirth(String dateOfBirth){
        //check valid date
        if(checkDateFormat(dateOfBirth) == false){
           System.out.println("****Invalid birth date on Employee ID: " +ID + " Name: "+ FirstName + " "+ MiddleInitial + ". " + LastName+ "*******");
        }else{
            DateOfBirth = dateOfBirth;
        }
    }
    public String getDateOfBirth(){
        return DateOfBirth;
    }
    public void setDateOfEmployment(String dateOfEmployment){
        //check valid date
        if(checkDateFormat(dateOfEmployment) == false){
           System.out.println("****Invalid employment date on Employee ID: " +ID + " Name: "+ FirstName + " "+ MiddleInitial + ". " + LastName+"*****");
        }else{
            DateOfEmployment = dateOfEmployment;
        }
    }
    public String getDateOfEmployment(){
        return DateOfEmployment;
    }
    public void setStatus(String status){
        //check to make sure string is a valid input
        if(status.equals("ACTIVE")|| status.equals("INACTIVE")){
            Status = status;
        }
        else{
            System.out.println("Invalid Status");
        }
    }
    public String getStatus(){
        return Status;
    }
    
    //Very basic check of MM/dd/yyyy format for the dates
    public boolean checkDateFormat(String date){
        if(date.matches("([0-1][0-9])/([0-3][0-9])/([0-9]{4})"))
            return true;
        else
            return false;
    }
    public String toString(){
        return "Employee ID = " + ID + "\n" +"First Name = " + FirstName + "\n" + "Middle Initial = " + MiddleInitial  + "\n"
                + "Last Name = " + LastName + "\n" + "Date Of Birth = " + DateOfBirth + "\n" + "Date of Employment = " 
                + DateOfEmployment + "\n"+ "Status = " + Status;
    }
    
}
