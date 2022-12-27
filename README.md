# Getting Started

Retail cashier is an application to give you a discount based on your purchase

## Requirements

*Java 17
* Preferred IDE IntellijIDEA

## Resources

* Check the [Help file](./HELP.md)

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
