# EmployeeRestServer

Requirements to run:

Maven version 3.6.3
Java version 1.8.0_291

you can possibly use other versions but they have not been tested 


To Build and Run Jar:

1. Open command prompt and navigate to the directory of the project /EmployeeRestServer

2. Through command prompt run: mvn package
	this will build your jar inside of the target directory 
	under the name EmployeeRestServer-1.0-SNAPSHOT.jar

3. In the projects main directory there is an example input file named "EmployeeInfo.txt". You can copy this file over into your target directory to use as your input.
OR
create your own txt file in the target directory named "EmployeeInfo.txt" with the similar format of every employee being separated by a new line (example:\n)and attributes being in order of:
First Name
Middle Initial
Last Name
Date of birth
Date of Employment
status
these attributes must all be separated by a ", " that is just how the string is being split. Of course you can always use the example file.

4. Navigate to the target directory of the project (/EmployeeRestServer/target) in the command prompt run the command: java -jar EmployeeRestServer-1.0-SNAPSHOT.jar
Now the jar is up and running.

To Test:
Postman is a free option to run some Rest calls that was used for testing.

To GET ALL employees: 
create a GET message that has the URL http://localhost:8080/employees  
no input or body needed it should return a JSON list of all employees that are "ACTIVE" in the system

To GET ONE employee:
create a GET message that has the URL
http://localhost:8080/employees/{id}
{id} is a variable you can input in a number for this value, if you are using the given sample information a working id is 1

To ADD an employee:
create a POST message that has the URL
http://localhost:8080/employees/addEmployee
this REQUIRES a body in JSON format
example employee and format:
{"firstName":"Larry","middleInitial":"K","lastName":"Charles","dateOfBirth":"03/19/2000","dateOfEmployment":"04/12/2478","status":"ACTIVE"}

To UPDATE an employee:
create a PUT message that has the URL
http://localhost:8080/employees/update/{id}
{id} is a variable you can input in a number for this value, if you are using the given sample information a working id is 1
this REQUIRES a body in JSON format
you can make an employee active again with the update and change the status to "ACTIVE" instead of "INACTIVE"
example employee and format:
{"firstName":"Garry","middleInitial":"K","lastName":"Squarepants","dateOfBirth":"03/19/2000","dateOfEmployment":"04/12/2478","status":"ACTIVE"}

To DELETE an employee:
create a DELETE message that has the URL
http://localhost:8080/employees/delete/{id}
{id} is a variable you can input in a number for this value, if you are using the given sample information a working id is 1
This requires "Basic Authentication" in postman you can select this under the authorization tab.
There is only one username and password user: admin1 password: password

To Exit Application:

in command prompt run: ctrl+C 
this will shut down the spring boot application
