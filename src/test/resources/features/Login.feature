@Login
Feature: Login PDS

    Background:
        Given user is on login page PDS

    @regression @negative-scenario
    Scenario Outline: as a user, i want to login with an invalid credentials
        And user filled in invalid username
        And user filled in invalid password
        And user filled in capcha
        When user click button login
        Then user should have an alert "<message>" invalid login with "<state>"

        Examples:
            | message                         | value           |
            | user email or password is wrong | invalidPassword |
            | user not found                  | invalidUsername |
            | user not found                  | sqlInjection    |

    @regression @positive-scenario
    Scenario: as a user, i want to login with a valid credentials
        And user filled in valid username
        And user filled in valid password
        And user filled in capcha
        When user click button login
        Then user should be able to login successfully