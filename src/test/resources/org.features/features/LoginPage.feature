@smoke                       //add in regression also
Feature:Login page features
Scenario:verify login page fields
Given user is on login page
Then verify username field is displayed
And verify password field is displayed
And verify loginbutton is displayed
And verify loginlogos are displayed
@regression @smoke
Scenario:verify login functionality
Given  user is on login page
When user enters username
And user enters password
And user click on login button
Then user navigated to  the prouct search page
