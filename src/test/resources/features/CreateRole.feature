Feature: create role

    Background:
        Given user login to PDS
        And user click on Setting
        And user select User Management
        And user click on Roles tab
        And user click on Create Role button

    Scenario: as a user want to create a role
        And user input Role Name as "Role111"
        And user input Role Description as "Role Description"
        And user select "Administrator" radio button
        And User select Application Scope as "Compare_app"
        And User check button as "Check All"
        When User click on Save button
        Then Result Message "New role successfully added" will be displayed

    Scenario Outline: Mandatory fields
        And user empty Role Name as "<value1>"
        And user input Role Description as "<value2>"
        And user select "Administrator" radio button
        And User select Application Scope as "<droplist>"
        And User check button as "Check All"
        When User click on Save button
        Then Result Message "<message>" will be displayed

        Examples:
            | value1  | value2      | droplist    | message                       |
            |         | description | Compare_app | Role name is required         |
            | Role111 |             | Compare_app | Role description is required  |
            | Role111 |             | Compare_app | Please check at least 1 scope |
