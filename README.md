# CERTIFIER

# ! Work in progress !

[![Join the chat at https://gitter.im/velmuruganvelayutham/certifier](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/velmuruganvelayutham/certifier?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![build status](https://gitlab.com/velmuruganv/mock-labs-1/badges/master/build.svg)](https://gitlab.com/velmuruganv/mock-labs-1/commits/master)

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
6. 
   1. Using this feature provides a great way to narrow down on promising candidates.
   2. Dont get overwhelmed with the number of applicants 
   3. use this feature combined with scoring and questionnaires to ensure you never lose out on the right candidates.
   4. get great hires!
   5. Download the exam report
   
## Demo Instance:

[[!http://mocklabs.com/certifier](http://104.199.146.224/certifier/)]

username/password  --> admin@admin.com/admin 



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


### Debug Locally ###

https://velmuruganv.wordpress.com/2015/10/11/eclipse-maven-jetty-remote-java-web-application-debugging/


### Docker ###

To start the mysql container.

docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -p3036:3036 -d mysql:latest

To start the Certifier Application Tomcat container.

docker run --rm -p8080:8080 --link localhost:mysql certifier 

### Docker Compose ###

docker-compose build && 
docker-compose up -d

Access the application at http://localhost/certifier




