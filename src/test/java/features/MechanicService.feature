Feature: My Hp Servicing

Scenario: Mechanic Service link validation
Given User is on My HpGas login page 
When User cracks the security verification successfully
And User login into application with password
Then Home page is displayed
And User verifies the mechanic service link to raise a request
And User closes out the browser successfully

Scenario: Mechanic Service page title validation

Given User is on My HpGas login page 
When User cracks the security verification successfully
And User login into application with password
Then Home page is displayed
And User verifies the mechanic service link to raise a request
When User clicks on the mechanic service link
Then User navigates into mechanic service page
And User verifies the title of the mechanic service page
And User closes out the browser successfully

Scenario: Back to Customer Console page validation
Given User is on My HpGas login page 
When User cracks the security verification successfully
And User login into application with password
Then Home page is displayed
And User verifies the mechanic service link to raise a request
When User clicks on the mechanic service link
Then User navigates into mechanic service page
And User successfully comes back into the Customer Console page by switching the window
And User closes out the browser successfully 




