# Group 2 // CSV Data Migration Project

This repository contains the work created by group 2 of the Sparta Global Tech 207 & Tech 208 unit on the .csv Data Migration Project.

We've built an application that enables a user to input a csv file containing a large set of employee records, sanitise/validate the records and then save it to a database. We utilised JDBC, DAO & DTO design patterns plus OOP and SOLID principles with functional programming where sensible to do so.

## Learning Objectives

* Create a DAO and a DTO
* Used the singleton pattern
* Use a factory design pattern for Employees
* Utilised Java 8+ functional programming features
* Using try-with-resources to ensure connections are closed

## User Stories

```md

"As a USER, I WANT to read a CSV file,
 SO THAT the data can be collected." 

"As a USER, I WANT to collect clean data,
SO THAT I can store AND see how many clean records there are" 

"As a USER, I WANT un-clean data to be collected,
SO THAT I can store AND see how many un-clean records there are" 

" AS a USER, I WANT to be able to view the data,
SO THAT I can verify the data has been imported correctly." 

"AS a USER, I WANT to be able to input commands,
SO THAT I can perform actions AND I can view the records."

```

## Sample Acceptance Criteria (Gherkin Script)

```md


### Scenario: Reading a CSV file so Data can be collected.

GIVEN, I have a CSV file contains employee data
WHEN, I run the application
THEN, the employee data should be read

GIVEN, I am reading the CSV file
WHEN, It is being parsed
THEN, the data should be separated according to the rules of CSV 

GIVEN, I have parsed the data
WHEN, I store the data
THEN, the data should be stored in the correct object AND fields

### Scenario:  Collecting Un-Clean Data

GIVEN, a CSV data file is being used
WHEN, I collect the data
THEN, the data should be filtered by unclean-conditions AND stored

GIVEN, the data has been parsed AND is ready to be stored
WHEN, I filter it by the un-clean conditions
THEN, I should be able to store the un-clean data in a separate collection

GIVEN, I am using the interface
WHEN, I want to receive data that has been stored
THEN, I should be able to receive un-clean data


```

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Run `Main.java` to start the application.
4. Follow instructions laid out by command-line-interface.

## Our Process

This project was completed over 3 - 5 days. We were given general requirements  which we used to create user stories. From the user stories, we used a Jira board to plot our product backlog items. We then used TDD and pair programming to continually develop features. During the sprint, we met in the afternoon to discuss current progress and then we would collectively assign programming-pairs to their backlog tickets. We ended our sessions with retros to talk about any blockers, update the Kanban board and to delegate tasks for the next day.

The project aims to apply SOLID and OOP principles, use the MVC pattern where appropriate, and well-known design patterns. We developed the application in a TDD approach(JUnit). We used log4j2 for appropriate runtime logging and applied exception handling where applicable.

## Future Ideas

When picking a single employee record through the CLI. We should throw an error if the employee record picked belongs to the unclean data.

## Program Notes

### Useful Methods

**Getters and setters:**
- (get/set)EmpNo;
- (get/set)BirthDate;
- (get/set)FirstName;
- (get/set)LastName;
- (get/set)Gender;
- (get/set)HireDate;

<!-- 
**Convert Employee Object to a String:**
- `employeeObject.toString()`

### Creating Employee data from a String and storing it manually.
1. Start storage:
    - `EmployeeStorageStarter.start();`
2. Get a reference to the storage instance through the interface:
    - `EmployeeStorageInterface employeeStorage = EmployeeStorage.getEmployeeStorage();`
3. Setup data <-> String format required: 
   - ` Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary`
   - *Example String*: `111111,Mr.,John,J,Doe,M,john.doe@johndoe.com,1/31/1981,01/01/2001,111111`
4. Pass the string to the converter to return an employee object:
    - `Employee newEmployee = EmployeeConverter.createEmployeeFromData(*Example String*);`
5. Use reference setup in step 2 to add employee:
   - `employeeStorage.addEmployeeToList(newEmployee);`
6. *Optional* Use reference setup in step 2 to access storage methods:
    - `employeeStorage.getEmployeeList();` - Returns a list of employee objects
    - `employeeStorage.getEmployeeFromList(n);` - Returns a single employee object

### Reading in Employee data automatically from a CSV file.
1. Start storage:
    - `EmployeeStorageStarter.start();`
2. Get a reference to the storage instance through the interface: 
   - `EmployeeStorageInterface employeeStorage = EmployeeStorage.getEmployeeStorage();`
3. Specify amount of data to read & store from CSV: (n = quantity to read in)
    - `EmployeeCsvService.employeeCSVGetterAndStore(n);`
4. Use reference setup in step 2 to access storage methods:
   - `employeeStorage.getEmployeeList();` - Returns a list of employee objects
   - `employeeStorage.getEmployeeFromList(n);` - Returns a single employee object -->

## Contributors

* @Name-taken23 // Scrum Master
* @ells101
* @Reg-Howard // Github Lead
* @HamzaKazi
* @MarcinJakobik
* @bakar212
* @usmanrizwan1

### EMployee Objects Useful Methods

**Getters and setters:**

* (get/set)Id;
* (get/set)Prefix;
* (get/set)FirstName;
* (get/set)LastName;
* (get/set)Mail;
* (get/set)DOB;

## License

This project is licensed under the MIT License - see the `LICENSE` file for details.

getPrefix() {
        return prefix;
    }
