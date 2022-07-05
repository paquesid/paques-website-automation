@DeleteRole
Feature: User Management - Delete Role
    Background:
        Given user login with "PDS_NONADMIN"
        When user click on setting button
        And user click on user management button in the list
        And user click on Roles tab

    @delrol @positive-case
    Scenario: user want to update role description
        When user click on delete icon
        Then form delete will be displayed
        When user clik on "yes" button
        Then result message "role0906 successfully deleted" will be displayed
        And user signout the application
    
    @delrol1 @positive-case
    Scenario: user want to cancel delete user in PDS Application
        When user click on delete icon
        Then form delete will be displayed
        When user clik on "cancel" button
        Then user confirmed data still available in datatable role
        And user signout the application


    