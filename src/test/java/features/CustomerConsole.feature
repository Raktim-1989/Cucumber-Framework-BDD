Feature: My Hp Customer Console

Scenario: Home Page default login validation
Given User is on My HpGas login page 
When User cracks the security verification successfully
And User login into application with password
Then Home page is displayed
And Customer console is displayed
And User closes out the browser successfully

Scenario: Distributor Details validation
Given User is on My HpGas login page 
When User cracks the security verification successfully
And User login into application with password
Then Home page is displayed
And User verifies the distributor details succesfully
And User closes out the browser successfully

Scenario: Disclaimer link validation
Given User is on My HpGas login page 
When User cracks the security verification successfully
And User login into application with password
Then Home page is displayed
And User successfully verifies the customer console disclaimer section
And User closes out the browser successfully

Scenario: Disclaimer logo click event validation
Given User is on My HpGas login page 
When User cracks the security verification successfully
And User login into application with password
Then Home page is displayed
When User clicks on the HP Gas logo from the disclaimer
Then User is succcessfully able to navigate into MyHp home page
And User successfully verifies the title of the home page
And User successfully comes back into the my hp customer console page
And User closes out the browser successfully
