@Change-Password
Feature: User Management - Change Password Users

    #Pre-Condition
    Background:
        Given user login with "PDS_NONADMIN"
        When user click on setting button
        And user click on user management button in the list
        Then user is on tab "User List" activated
        And user click change password button
        And user should be able to see form password

    @regression @positive-scenario @test
    Scenario: user want to update password in PDS Application
        And user filled password as "Qwerty*123" in form create user
        And user filled re-password as "Qwerty*123" in form create user
        When user click on save button
        Then user should be able to see a message "New user successfully"
        And user signout the application

    @regression @negative-scenario
    Scenario: user want to update password in PDS Application
        And user filled password as "Qwerty*123" in form create user
        And user filled re-password as "Qwerty123" in form create user
        When user click on save button
        Then user should be able to see an error "Passwords do not Match"
        And user signout the application