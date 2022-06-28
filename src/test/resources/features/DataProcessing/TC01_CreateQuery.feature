@Create-Query
Feature: Data Processing - Create New Query

    @regression @positive-scenario
    Scenario: as a user, i want to create new query using query commands
        Given user login with "PDS_NONADMIN"
        And user click on data processing
        And user create query using query command with "Data Tabular"
        And user filled in filepath as "Brenda_Test/paques_data.csv" in section command property
        And user filled in separator as "," in section command property
        And user filled in row limit as "20" in section command property
        When user click on save button at navbar
        Then user should be able to see a message "Process Completed" will be displayed