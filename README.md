# Mohammed-Hendy
## Introduction
 This project automate the Notes APIs https://practice.expandtesting.com/notes/api/api-docs/#google_vignette main High level scenarios:
1.	Verify that the API is healthy
2.	Register a new user and verify it’s created
3.	Log in with a user and verify the profile information
4.	Update profile information and verify it’s updated successfully
5.	Change the password and verify it’s updated successfully
6.	Create a note and verify it’s added to the list of all notes
7.	Update a note and verify it’s updated successfully
8.	Delete a note and verify it’s deleted successfully
9.	
 , it's developed using RestAssured with TestNG.
### Pre-requists
 JDK version 20.0.2, IntelliJ IDEA.
#### about My Framework
![image](https://github.com/user-attachments/assets/bce076cc-9271-4461-a355-f3396b711e8b)

How to use the framewrok
  1- clone the project to a local repository.
  2- open it with IntelliJ IDEA.
  3- Set all needed project structures
  4- Using maven plugins start to compile and install all the needed dependencies in the pom.xml file
  5- choose to run individual scenarios from the features files or to run from the TestNG File.
  6- you can check for the test report after reach runs when "allure-results" folder created.

##### Test data implementation
Test data read from excel files located in resources folder, you can add any of the test data to the sheets there based on the readData pacjakge.
