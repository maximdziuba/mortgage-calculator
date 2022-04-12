# Mortgage calculator

This is test task for ElifTech School.
My stack is: Java, Spring Boot, in-memory H2 database,
template-engine Thymeleaf.
This app has web-UI and API.

You can run app from any Java IDE or run jar-file
from command line(Terminal in Mac/Linux).

Also this app is deployed to heroku, you can access it with link below
	https://eliftech-credit-calculator.herokuapp.com/

### Running guide

    1. git clone - clone this repository
    2. cd <path to project directory>
    3. java -jar mortgage.jar - running jar-file
    4. localhost:8080 - main web-page
    
As i mentioned this app has an API, here are mappings:

    GET localhost:8080/api/banks/all - get all banks
    POST localhost:8080/api/banks/save - save new banks(example of request body is below)
    {
        "name": "Api Bank",
        "interestRate": 5,
        "maximumLoan": 1000000,
        "minimumDownPayment": 100,
        "loanTerm": 2
    }
    PUT localhost:8080/api/banks/update- update bank(example of request body is below)
    {
        "id": 1,
        "name": "Api Bank",
        "interestRate": 5,
        "maximumLoan": 1000000,
        "minimumDownPayment": 100,
        "loanTerm": 2
    }
    DELETE localhost:8080/api/banks/delete/{bankId} - delete bank by id(path variable)
    POST localhost:8080/api/mortgage/count?initLoan=<val>&downPayment=<val>&bank=<name of bank> - count mortgage(request body is below)
    
