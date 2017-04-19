FROM tomcat:8
LABEL maintainer "velmuruganv"
ADD target/*.war /usr/local/tomcat/webapps/
