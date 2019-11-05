# Cameltest4

## Description.

Test of Camel using Spring boot (auto configuration). 
* ActiveMQ or ArtemisMQ as input
* Logging headers (key, value) to logfile
* Adding headers
* Adding content to body
* Textfile as output
* Unittests using ActiveProfiles

## How to build locally
```
cd to directory where pom.xml (root pom) is locaded
mvn clean package spring-boot:repackage
```

## How to run locally
```
cd to taget directory
java -jar cameltest3-1.0.0-SNAPSHOT.jar
```
