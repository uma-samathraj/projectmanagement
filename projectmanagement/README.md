# projectmanagement
This project is developed for my college miniproject 

Project helps for students and staff for seeing their mini project information 

Technologies
...........

Front end
........

HTML (VERSION 5+)

BOOTSTRAP (VERSION 4+)

ANGULARJS (VERSION 1.7+)

Backend
.......

Spring Boot (VERSION 2+)

Database
.......

PostgresSql (VERSION 9+)



Install any Eclipse or Intellij IDE for code development

1) Install Git in your local machine (reference - https://www.edureka.co/blog/install-git/)

2) Install Maven in your local machine (https://www.mkyong.com/maven/how-to-install-maven-in-windows/)

3) Install Postgresql in your local machine (https://www.postgresql.org/download/)

4) Download Postman 

5) Install any database workbench(my prefernce is DBeaver)

3) Once above steps complete -- Open command prompt and download my project by using 
   command git clone https://github.com/uma-samathraj/projectmanagement.git
   
4) once download and extract it go to that particular folder and use mvn -e clean install command

5) Open eclipse and go to your own workspace

6) go to file -> import --> Import projects from folder and archeive and import project starting folder 

Project Description
...................

Project Mainly divides into two modules 

1) Student Module 

2) Staff Module


1) Student Module
   ..............
   
   1) User should register with basic information like userName,password,Year of College , Staff Name , College Name
   
   2) By default user have user_role - who can view only the details(cant edit any other information apart from project info)
   
   Student Responsibilities
   ........................
   
    Once staff assign the teams, student should able to see his team members .
    
    Student should add project details for approval , once approved student can't able to change 
    the details or project
    
    Once project implemention done , student can see their Marks for this project
   
    
2)  Staff Module
    ............   
   
    1) Staff should register with their basic information
    
    2) By default staff will get admin_role
    
    
    Staff Responsibilities
    ......................
    
     Staff will do a Team creation and assign a Team leader
    
     Staff having another screen where he will get list of projects information for approval
    
     Once student complete their project , Staff will review it and will assign marks
     
    
    
Code Description
................

Models / Pojos
..............

1) User     
 
2) UserType

3) College 

4) Project

5) Project Status
    
6) ProjectStudent Info   
   
APIS
....

Project controller , UserController are main apis for create project and user information



Database Queries
...............
create user uma with password 'uma@123';

grant all privileges on database miniproject to uma;

ALTER ROLE uma SUPERUSER NOCREATEDB NOCREATEROLE INHERIT LOGIN;


