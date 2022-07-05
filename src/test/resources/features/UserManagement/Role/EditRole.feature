@EditRole
Feature: User Management - Update Role

    @abcd @positive-case
     Scenario: user want to update role description
        Given user login with "PDS_NONADMIN"
        When user click on setting button
        And user click on user management button in the list
        And user click on Roles tab
        When user click on Edit Role icon
        Then user should see form to update role
        And user input Role Description as "roleupdate" 
        And user select radio button as "Administrator"
        When User click on Save button
        Then update result message "nonadmin0706 successfully updated" will be displayed
        And user signout the application

