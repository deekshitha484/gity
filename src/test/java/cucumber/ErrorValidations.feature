
@tag
Feature: Purchase the order from ecommerce website


  
@ErrorValidations
Scenario Outline: negative test for submit order

Given I landed on Ecommerce site
When login with username <name> and password <password>
Then "Incorrect email or password." is displayed on login page
Examples: 

      | name               | password  |
      |deekshith4@gmail.com|DeeRan@2122|
