Feature: Login Scenarios
@test
Scenario Outline: Login with invalid user name
When I enter username "<username>"
And Enter "<password>"
And Tap on the Login button
Then the "<err>" message should be displayed

Examples:
| username | password| err |
| InvalidUserName | secret_sauce | ggUsername and password do not match any user in this service.|


Scenario Outline: Login with invalid password
When I enter username "<username>"
And Enter "<password>"
And Tap on the Login button
Then the "<err>" message should be displayed

Examples:
| username | password| err |
| standard_user | secret_sauop | Username and password do not match any user in this service. |

Scenario Outline: Login with valid username and password
When I enter username "<username>"
And Enter "<password>"
And Tap on the Login button
Then the product page with "<title>" should be displayed

Examples:
| username | password| title |
| standard_user | secret_sauce | PRODUCTS |