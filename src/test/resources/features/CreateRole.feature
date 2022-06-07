Feature: create role

    Background:
        Given user login with "PDS_NONADMIN"
        When user click on setting button
        And user click on user management button in the list
        And user click on Roles tab
        And user click on Create Role button

    @a @positive-scenario
    Scenario: as a user want to create a role
        And user input Role Name as "Role111"
        And user input Role Description as "Role Description"
        And user select radio button as "Administrator" 
        And User select Application Scope as "Compare_app"
        And User check button as "Check All"
        When User click on Save button
        Then Result Message "New role successfully added" will be displayed

    @regression @negative-scenario
    Scenario Outline: Mandatory fields
        And user input Role Name as "<value1>"
        And user input Role Description as "<value2>"
        And user select radio button as "Administrator" 
        And User select Application Scope as "<droplist>"
        And User check button as "Check All"
        When User click on Save button
        Then Alert Message "<message>" will be displayed
        
        Examples:
            | value1  | value2      | droplist    | message                       |
            |         | description | Compare_app | Role name is required         |
            | Role111 |             | Compare_app | Role description is required  |
            | Role111 |             | Compare_app | Please check at least 1 scope |
