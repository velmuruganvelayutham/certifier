#certifier

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

# Setup and Installation

## Installation from source files
This option let you download source files, configure, build and deploy the application to any servlet container or JEE application server. This option let you configure the software to the target database and other required sub systems. This approach should be used to run in a production environment. 

- Make sure you meet [software requirements](#Software Requirements)
- [Download certifier](https://github.com/velmuruganvelayutham/certifier/zipball/master)
- [Configure](#Configure) your database (mandatory)
- [Build][#Build] the application
- Copy the war file to your Java application server (optional)


## Software Requirements
- Java version 6 or 7
- A [JEE servlet container](#Application server / servlet container) or any JEE application server (see the instructions for [Apache Tomcat](#Apache Tomcat))
- [Maven](#Apache Maven installation) for building source files.

## Java version
Check if java is installed, for this open a shell or batch window.
To check if you have java installed by typing type following command <br/>
`java -version`.
<br/><br/>

## Apache Maven installation
Download Maven from **[Maven website](http://maven.apache.org/download.cgi).Follow the installation instructions on the Apache Maven download page 

## Application server / servlet container
 Certifer was tested on these servlet containers and application servers
-  Apache Tomcat
- Jetty

## Apache Tomcat
Shopizer was tested with Tomcat 6 and Tomcat 7.To run Shopizer on tomcat, please follow these instructions
- [Download Apache Tomcat](http://maven.apache.org/download.cgi)
- Follow tomcat installation instructions.
- Copy `certifier-1.0.0.BUILD-SNAPSHOT.war` to tomcat webapps folder.
- Start tomcat with following command

###### Mac or Linux: `/bin/startup.sh`
###### Window : `/bin/startup.bat `

Check application logs in `/logs/catalina.out`

## Build the application
With a shell or dos command cd to you unzip source directory.Run the following command (requires [Apache Maven](#Apache Maven installation) installed)

`cd certifier` <br/>
`mvn clean`<br/>
`mvn package`<br/>



