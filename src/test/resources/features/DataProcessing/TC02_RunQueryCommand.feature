@Run-Query-Commands
Feature: Data Processing - Run Query Commands

    @regression @positive-scenario
    Scenario: user run query commands using data tabular in PDS Application
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

    @regression @positive-scenario
    Scenario: user run query commands using search file in PDS Application
        Given user login with "PDS_NONADMIN"
        And user click on data processing
        And user create query using query command with "Search File"
        And user filled in filepath as "Brenda_Test/paques_data.csv" in section command property
        And user see the option value of option is "Default"
        When user click on run button at navbar
        Then user see the header datatable as "_event"
        And user signout the application