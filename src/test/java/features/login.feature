Feature: Application Login

Scenario Outline: Home page default login
Given User initiates Chrome browser
And User is on Netbanking landing page
When User logs in into application with "john@gmail.com "and "12345" 
Then Homepage is populated
And Credit cards are displayed




