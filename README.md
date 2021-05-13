# Hobby Web Application(HWA)
Coverage 92.5%
# This project was to have CRUD functionality on a web application in this case a spending tracker. 
Inside you can add into fields of amount, spending type and additional 
infomation for whatever purchase that you made to keep a so called online diary. 
#JIRA LINK:https://kevinqa.atlassian.net/jira/software/projects/HOB/boards/4/backlog


### Prerequisites

Git Bash on local machine with a github account to access the repo.
MySQL
???VisualStudio???
Java and Eclipse IDE
Maven installed link: https://maven.apache.org/download.cgi

##Getting Started
To have a local copy of this repo follow the beloew instructions;
* Fork the repository into your own git hub account
* Access your your own accounts repository and copy the url of the forked repository.
* Create a folder on your local computer naming it IMS.
* Inside the newly created folder open git bash from it.
* Enter the below command.
* git clone "paste url link here"
* Press enter and it will now copy it into the folder. 

### Installing
Installing Java.
* https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
* Click on the link above 
* Then find the download ink with this name "jdk-14.0.1_window-x64_bin.exe"/"jdk-8u221-windows-x64.exe".
* Once downloaded follow the installation instructions to have it fully installed on the local computer.
* Once installed opened the environment variables and select new to add a new system variable.
* Inside the new window we can name the new variable "JAVA_HOME" and select the absoulute file location for where the previous java file was installed.
* Click "OK" and the new variable will now so up in the variables box
* Next the path variable needs to be edited
* Add the following ";%JAVA_HOME%\bin;" to the end of the variable value.
* Once done you can check to see if this is all up and running by opening the command line client entering "java" and running. 



To open the porject inside eclipse
* Go to file and select import.
* Then slect Maven and click-on eisting maven project.?????????????????????????????????????
* In the root directory select the file that you have repo'd.
* Once selected a pom file should appear indicating successful selection. 
* Click finish and the programme will begin to load in everything.
* The project can now be selected from the project explorer tab on the left.

## Running the tests

### Unit Tests 

Unit tests are testing all methods inside one class file. This is done to ensure that all coding inside the class file are functioning as intended.
All unit testing inside this project fall under this file path. 
* To run unit tests enter the "src/test/java/com.qa.hwa.service" files. 
* Select the single unit test file inside called "SpendServiceTest".
* Right Click anywhere inside the Class Window and select "Run Configuration" inside "Run As". 
* Next ensure that the Run a single test button is selected. 
* Then inside the Project input ensure this project name is inside "HWA". 
* Also inside the Test Class this file path is inputted "com.qa.hwa.service.SpendServiceTest". 
* Moving onto the last check ensure the test runner is running JUnit 5.
* Now the unit test configurations are complete you can select run at the bottom of the window.  
* On the left in the same window as the project explorer a new tab named JUnit will list all unit tests and whether they were successful or not.

###Integration Tests
Integration tests check whether the communication between each objects functions as intended.

All integration testing inside this project fall under this file path. 
* To run the integration tests enter the "src/test/java/com.qa.hwa.controller" files. 
* Select the single unit test file inside called "SpendControllerIntegrationTest".
* Right Click anywhere inside the Class Window and select "Run Configuration" inside "Run As". 
* Next ensure that the Run a single test button is selected. 
* Then inside the Project input ensure this project name is inside "HWA". 
* Also inside the Test Class this file path is inputted "com.qa.hwa.service.SpendControllerIntegrationTest". 
* Moving onto the last check ensure the test runner is running JUnit 5.
* Now the unit test configurations are complete you can select run at the bottom of the window.  
* On the left in the same window as the project explorer a new tab named JUnit will list all unit tests and whether they were successful or not.

###Selenium Tests
Unlike with the previous two testing methods that dealt with the back-end. Selenium tests look at the front end  

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [mysql](https://mvnrepository.com/artifact/mysql/mysql-connector-java) 
* [junit](https://mvnrepository.com/artifact/junit/junit)

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors
* **Kevin Tse** -*Completeion of Items and Order section

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

Thanks to my trainers Aswene Sivaraj, Savannah Vaithilingam, Aproviding assisstance when any issues arrised.