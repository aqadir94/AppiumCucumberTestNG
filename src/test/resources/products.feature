
Feature:Product Scenarios

Scenario Outline: Products page

Given I'm already logged in
Then the product is listed with the "<title>" and "<price>"

Examples:

|title|price|
|Sauce Labs Bolt T-Shirt|$15.99|
|Sauce Labs Onesie|$7.99|

Scenario Outline: Product details pag

Given I'm already logged in
When I tap on product "<title>"
Then I should be able to see "<title>" price"<price>" and "<description>"

Examples:

|title|price|description|
|Sauce Labs Backpack|$29.99|carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.|