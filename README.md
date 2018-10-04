Wanderset UI Automation
========================

This is a project for running Wanderset automated UI tests 

### Setup Notes (Ubuntu Linux)
 
* Install Oracle JDK 8 - https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04#installing-the-oracle-jdk
```
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
```
* Install Maven
```
sudo apt-get install maven
``` 

### How to run

Run tests:
```
mvn clean test
```

Build reports to temp folder and view:    
```
mvn allure:serve
```
Build reports and save to target/site
```
mvn allure:report
```


