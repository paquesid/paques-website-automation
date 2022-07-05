Feature: edit role

    Background:
        Given user login to PDS
        When user click on setting button
        And user select User Management
        And user click on Roles tab
        And user search Role Name as "Role111"
        And user click on Search icon
        And user click on Edit icon

    @regression @positive-scenario
    Scenario: as a user want to edit role
        And user Role Description as "roledescriptionedit"
        And user select "Administrator" radio button
        And User select Application Scope as "Compare_app"
        And User check button as "Check All"
        When User click on Save button
        Then Result Message "Role111 successfully updated" will be displayed 

    @regression @negative-scenario
    Scenario Outline: Mandatory fields
        And user empty Role Description as ""
        When User click on Save button
        Then Alert Message "Role description is required" will be displayed
