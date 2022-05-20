@Forgot-Password
Feature: Forgot Password PDS

    @regression @positive-scenario
    Scenario: user want to forgot password in PDS Application
        Given user is on login page PDS
        And user click forgot password button
        When user filled in email as "dika.brenda@paques.id"
        Then user should be able to reset password successfully

    @regression @negative-scenario 
    Scenario: user forgot password using invalid email in PDS Application
        Given user is on login page PDS
        And user click forgot password button
        When user filled in notFound email as "dikabrenda@gmail.com"
        Then user Not able to reset password in PDS application
