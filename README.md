# Getting Started

Retail cashier is an application to give you a discount based on your purchase

## Requirements

* Java 11
* Spring boot 2.7.5
* H2 Database
* Preferred IDE IntellijIDEA

## Resources

* Check the [Help file](./HELP.md)

## Generating Coverage Report
execute the folowing commands on terminal
1. mvn clean
2. mvn test

- navigate to the target > site > jacoco > index.html > right-click > Open In > Browser > And your preferred browser. So basically index.html is your code coverage report file. 

**note ! :**
The green color shows that all lines of code have been covered which means you have written the test cases for all the units. If you have encountered the yellow color line then partial code has been covered and if you have encountered with the red color then the code has not been covered. 

## for running the project , kindly follow the below steps

1-  Go to the project directory 
2-  mvn clean pachage
3-  docker build -t retail-cashier:1.0 . 
4-  docker run -d -p 9090:8080 retail-cashier:1.0

* you can find the swagger link below
http://localhost:9090/swagger-ui/index.html
