@Create-User
Feature: User Management - Create Users

    #Pre-Condition
    Background:
        Given user login with "PDS_NONADMIN"
        When user click on setting button
        And user click on user management button in the list
        Then user is on tab "User List" activated
        When user click on create user button in user tab
        Then user should see form to create user

    @regression @positive-scenario
    Scenario: user want to create new user in PDS Application
        And user filled username as "dikabrenda01" in form create user
        And user filled email as "dikabrenda01@mailnesia.com" in form create user
        And user filled password as "Qwerty*123" in form create user
        And user filled re-password as "Qwerty*123" in form create user
        And user filled fist name as "Dika" in form create user
        And user filled last name as "Brenda" in form create user
        And user selected group as automation in form create user
        When user click on save button
        Then user should be able to see a message "New user successfully"
        And user signout the application

    @regression @negative-Scenario
    Scenario Outline: user cannot create new user with an empty data in PDS Application
        And user filled username as "<username>" in form create user
        And user filled email as "<email>" in form create user
        And user filled password as "<password>" in form create user
        And user filled re-password as "<re_password>" in form create user
        And user filled fist name as "<first_name>" in form create user
        And user filled last name as "<last_name>" in form create user
        And user selected group as automation in form create user
        When user click on save button
        Then user should be able to see an error "<message>"
        And user signout the application

        Examples:
            | username | email                    | password   | re_password | first_name | last_name | message              |
            |          | dikabrenda@mailnesia.com | Qwerty*123 | Qwerty*123  | Dika       | Brenda    | Username is required |
# | dikabrenda | dikabrenda@mailnesia.com | Qwerty*123 | qwerty*123  | dika       | brenda    | Passwords do not Match            |
# | dikabrenda | dikabrenda@com           | Qwerty*123 | Qwerty*123  | dika       | brenda    | email is not valid email          |
# | dikabrenda | dikabrenda@mailnesia.com | Qwerty*123 |             | dika       | brenda    | Password confirmation is required |
# | dikabrenda | dikabrenda@mailnesia.com | Qwerty*123 | Qwerty*123  |            | brenda    | First name is required            |
# | dikabrenda | dikabrenda@mailnesia.com | Qwerty*123 | Qwerty*123  | dika       |           | Last name is required             |