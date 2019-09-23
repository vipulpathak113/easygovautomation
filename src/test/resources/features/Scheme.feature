Feature: User Applies for a scheme

@tear_up
Scenario: Verify user is able to select language from select language modal
Given lang 'English' exists
Then User is able to select English language successfully

Scenario: Verify user is able to select state from select state modal
Given state 'Delhi' exists
Then User is able to select Delhi state successfully

Scenario: Verify user is able to select district from select state modal
Given district 'Central Delhi' exists
Then User is able to select Central Delhi district successfully

Scenario: Verify user is able to select any category from category panel
Given category 'Women and Child Development' exists
Then User is able to select category successfully

Scenario: Verify user is able to start the survey after selecting a scheme
Given scheme 'Swadhar' exists
Then User clicks on check Eligibility button
Then User fills phone number '9795868023' and password '123456'
Then User is able to start the survey successfully


Scenario: Verify user is able to apply for a scheme
Given user apply scheme for 'Myself'
When user answers all the survey questions:
| Fields                 | Values          |
| Gender                 | Female          |
| DOB                    | 8/18/1992       |
| Domicile               | Delhi           |
| Beneficiary abled      | Yes             |

Then user is able to check eligibilty for user
And user is able to apply for a scheme successfully 

@tearDown
Scenario: Verify user is able signout of the application
When User clicks on Logout button
Then User is able to signout successfully