# Employee CSV Data Migration Project

## General Requirements

All projects:

- Must be run as Scrum projects
- Should be groups or 5 or 6
- Must apply SOLID & OO principles
- Must use the MVC pattern where there is a user interface
- Should use well-known design patterns where appropriate
- Must include comprehensive ```JUnit``` testing or equivalent
- Should begin with the creation of tests, in line with a test-driven development approach
- Must use ```log4j2``` for appropriate runtime logging or equivalent
- Must implement appropriate exception handling
- Must be hosted on GitHub and thoroughly documented, through a README.md file

## Overall Goals

- To read data from a .csv file (provided), parse it, populate objects and add to a collection.
- To efficiently write the data from the objects to a relational database using JDBC.
- To demonstrate good programming practices in OOP, SOLID, design patterns, testing, logging, etc.

## Phase 1 - Initial Reading and Cleaning

Create a new project and write code to read data from an Employee CSV file. \
As it is read in, add each record read to a new object of a suitable class and then add those objects to a collection. \
Any corrupt or duplicated data should be added to a separate collection for further analysis.
Write tests to ensure data is being managed correctly. \
Consider which date class would be best to use for the date fields - there is one in java.util and another in java.sql. \
Provide a simple user interface to display the results of reading the file - how many unique, clean records there are, how many duplicates, how many records with missing fields, possibly display the questionable records. \
User the provided EmployeeRecords.csv for your testing and optionally create your own test files to help with your JUnit tests.

### Notes:

- Consider preparing your tests beforehand, in line with a TDD approach.
- Since the overall purpose of the project is data migration, we want to make sure that only clean data is transferred.
- Consider your code structure and design patterns used, since later in the project we will be increasing the size of the data and looking at the efficiency of the code.
- The choice of collection will be important as there is some duplication of the employee records.

## Phase 2 - Persist to Database

Write the SQL statements to create a table and to persist data to that table. \
If the table exists, it will need to be dropped first. \
Install the drivers for the database to be used (MySQL) and create a connection. \
Create a data access object (DAO pattern) to persist the data to the database. \
Persist employee records and write code to retrieve individual records from the database.


### Notes:

- Remember to use try-with-resources to ensure connections are closed as soon as they have been used, if appropriate.
- Care needs to be taken with transferring dates from Java to SQL; make sure Strings are not used for dates.
- It is easy to make this process very slow by creating a new connection for each record - consider how to ensure that you reuse connections.