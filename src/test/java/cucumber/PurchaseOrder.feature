
@tag
Feature: Purchase the order from ecommerce website


   Background: 
   Given I landed on Ecommerce site
@Regression
Scenario Outline: Positive test for submit order


Given login with username <name> and password <password>
When I add product <productName> in to the cart
And checkout with product <productName>
Then "THANKYOU FOR THE ORDER." is displayed on confirmation page
Examples: 

      | name                  | password  |productName|
      |deekshitha484@gmail.com|DeeRan@2122|ZARA COAT 3|
