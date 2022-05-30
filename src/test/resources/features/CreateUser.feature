@Create-User
Feature: Create User

    @regression @positive-scenario
    Scenario: as a user, i want to create new user in PDS Application
        Given user login with user "PDS_NONADMIN"
        When user click on setting button
        Then user is on tab "User List" activated
        When user click on create user button in user tab
        Then user should see form to create user
        And user filled username as "username" in form create user
        And user filled email as "email" in form create user
        And user filled password as "password" in form create user
        And user filled re-password as "re_password" in form create user
        And user filled fist name as "first_name" in form create user
        And user filled last name as "last_name" in form create user
        And user selected group as "automation" in form create user
        When user click on save button
        Then user should be able to see a message "New user successfully added"





