# Getting Started

Retail cashier is an application to give you a discount based on your purchase

## Requirements

*Java 17
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

## PostMan Url
http://localhost:8080/check-out

* you can use the below body as refernce to create new cart
```
{
    "user": {
        "id": "1",
        "name": "ahmad",
        "customerType": "EMPLOYEE"
    },
    "products": [
        {
            "id": "1",
            "productName": "shoe",
            "productAmount": 100
        },
        {
            "id": "2",
            "productName": "t-shirt",
            "productAmount": 120
        }
    ]
}
```
