Feature:  User must be able to Signup with valid credentials

Scenario: Validate that the app is open and user clicks on the Signup button and navigates to Signup page
    Given App is open and user is on sign up page
       
 Scenario: Validate that the data entered in both Password and Confirm password fields are masked
    When User enters the details in the Password and Confirmed Password field should be masked       
 
 Scenario: Validate that the password should be displayed on an eye click for Password fields
    Then User clicks on the Eye and Orginal value should be displayed in the password fields   
   
 Scenario: Validate the Confirm password field by comparing data entered in the Password field   
     When user enter same values of Password in the Confirmed field
     
 Scenario: Validate user is able to click on Sign Up with valid credentials
    When User enters valid credentials
    
   