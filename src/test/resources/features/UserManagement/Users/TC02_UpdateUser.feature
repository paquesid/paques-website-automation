@Update-User
Feature: User Management - Update Users

    @regression @positive-case
    Scenario: user want to update email information in PDS Application
        Given user login with "PDS_NONADMIN"
        When user click on setting button
        And user click on user management button in the list
        Then user is on tab "User List" activated
        When user click on edit button in user tab
        Then user should see form to update user
        And user filled email as "qaengineer@mailnesia.com" in form create user
        When user click on save button
        Then user should be able to see a message "New user successfully added"
        And user signout the application


