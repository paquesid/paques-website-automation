@Delete-User
Feature: User Management - Delete Users

    #Pre-Condition
    Background:
        Given user login with "PDS_NONADMIN"
        When user click on setting button
        And user click on user management button in the list
        Then user is on tab "User List" activated

    @regression @positive-scenario
    Scenario: user want to cancel delete user in PDS Application
        And user click delete button
        And user should see form delete user
        When user click "cancel" in the button
        Then user confirmed data still available in datatable user
        And user signout the application

    @regression @positive-scenario
    Scenario: user want to delete user in PDS Application
        And user click delete button
        And user should see form delete user
        When user click "yes" in the button
        Then user able to see a message "Dika Brenda successfully deleted"
        And user signout the application