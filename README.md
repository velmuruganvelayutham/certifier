# CERTIFIER

Spring MVC application for Online assessment test, Candidate Screening, aptitude assessment tests.

1. Candidate Pre Screening.
2. Use Existing Tests from library.
3. Assign exams to your candidate.
4. Creating Tests 
   1. Reach out to the experts 
   2. collaborate and screen candidates 
   3. you can create exam questions in spreadsheets and then simply upload
   4. you have an exam ready to administer.
5. Administering Exams -
   1. Using this feature provides a great way to narrow down on promising candidates.
   2. Dont get overwhelmed with the number of applicants 
   3. use this feature combined with scoring and questionnaires to ensure you never lose out on the right candidates.
   4. get great hires!
   5. Download the exam report
   
## Demo Instance:

The demo  of this project is deployed [Click Here ] (http://52.10.55.149:8080/certifier-1.0.0-BUILD-SNAPSHOT/login)


## Setup and Installation

### Installation from source files

This option let you download source files, configure, build and deploy the application to any servlet container or JEE application server. This option let you configure the software to the target database and other required sub systems. This approach should be used to run in a production environment. 

- Make sure you meet [software requirements](#software_requirements).
- [Download certifier](https://github.com/velmuruganvelayutham/certifier/zipball/master).
- [Build](#build_the_application) the application.
- Copy the war file to your Java application server.


### Software_Requirements

- Java version 7 or greater.
- A JEE servlet container or any JEE application server. 
- [Maven](http://maven.apache.org/) for building source files.

### Build_the_application

With a shell or dos command cd to you unzip source directory.Run the following command requires [Apache Maven](http://maven.apache.org/) installed.

edit the **persistence-mysql.properties** file inside **certifier/src/main/resources/**   folder to point to the correct mysql port, username, password.

`cd certifier` <br/>
`mvn clean`<br/>
`mvn package`<br/> 

*war file will be generated inside the target folder.*

**mvn jetty:run** *- for making the application up and running inside embedded jetty server.*

_access the application at_ __[localhost:8080/certifier](http://localhost:8080/certifier)__






