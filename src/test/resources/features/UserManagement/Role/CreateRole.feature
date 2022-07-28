Feature: create role

    Background:
        Given user login with "PDS_NONADMIN"
        When user click on setting button
        And user click on user management button in the list
        And user click on Roles tab
        And user click on Create Role button

    @role @positive-scenario
    Scenario: as a user want to create a role
        And user input Role Name as "role0906"
        And user input Role Description as "Role Description"
        And user select radio button as "Administrator" 
        And User select Application Scope as "Compare_app"
        And User check button as "Check All"
        When User click on Save button
        Then Result Message "New role successfully added" will be displayed
        And user signout the application

    @role1 @negative-scenario
    Scenario Outline: Mandatory fields
        And user input Role Name as "<value1>"
        And user input Role Description as "<value2>"
        And user select radio button as "<value3>" 
        And User select Application Scope as "<droplist>"
        And User check button as "Check All"
        When User click on Save button
        Then Alert Message "<message>" will be displayed
        
        Examples:
            | value1    | value2      | value3        |droplist     | message                       |
            |           | description | Administrator | Compare_app | Role name is required         |
            | role0906  |             | Administrator | Compare_app | Role description is required  |
            
