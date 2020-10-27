# email-web-service 

This web service supports a get method which returns the number of disticnt email ids given a list of email addresses.

# Methodology Used - 
1. The email address is first parsed using Gmail account matching rules, i.e. '.' is ignored in the username and any charaters after '+' character in the username will be ignored.
2. Unique addresses are then maintained using a HashSet.
3. Any email address without username or domain has not been considered.
4. The username and domain part has been separated using the last occurence of '@' in the string.

# Build - 
The web serivce has been created using Java, Spring and Maven. 

Pre-requisites - Java 8, Apache Maven

Java Download - https://www.oracle.com/java/technologies/javase-downloads.html

Maven download link with steps - https://maven.apache.org/download.cgi

Build Steps - 
1. Clone/download the project.
2. From the directory where the project resides, run the command -  mvn spring-boot:run
3. Running this command will build the code, run test cases defined and start a server for the web service.
4. Note - error can occur if the port 8080 is not available for the web server. 

# Running the Web Service - 

Once the server starts successfully, open a internet browser window or Postman and type a url similar to the one below - 

http://localhost:8080/unique-emails?emails=test.email@gmail.com,test.email%2bspam@gmail.com,testemail@gmail.com

Note - '+' character might need to be replaced with '%2b' for correct results.
