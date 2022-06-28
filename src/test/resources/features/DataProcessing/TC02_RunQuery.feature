@Run-Query
Feature: Data Processing - Run Query

    @regression @positive-scenario
    Scenario: as a user, i want to run query using query commands in PDS Application
        Given user login with "PDS_NONADMIN"
        And user click on data processing
        And user create query using query command with "Data Tabular"
        And user filled in filepath as "Brenda_Test/paques_data.csv" in section command property
        And user filled in separator as "," in section command property
        And user choose "First Row as a Header" in section command property
        And user filled in row limit as "20" in section command property
        When user click on run button at navbar
        Then user see first row as a header in datatable
        And user signout the application

    @sanity @positive-scenario @toautomated
    Scenario: as a user, i want to run query using PQL in PDS Application
        Given user login with "PDS_NONADMIN"
        And user click on data processing
        And user create query using query command with "Data Tabular"
        And user filled in filepath as "" in section command property
        And user filled in separator as "," in section command property
        And user choose "First Row as a Header" in section command property
        And user filled in row limit as "10" in section command property
        When user click on run button at navbar
        Then user see first row as a header in datatable
        And user signout the application