FROM mysql:5.7
LABEL maintainer "velmuruganv"
ADD schema.sql /docker-entrypoint-initdb.d/schema.sql
ENV MYSQL_ROOT_PASSWORD=root MYSQL_DATABASE=tradeshow MYSQL_PASSWORD=root
EXPOSE 3306
