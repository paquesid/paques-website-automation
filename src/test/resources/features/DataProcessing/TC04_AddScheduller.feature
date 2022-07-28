@Scheduler
Feature: Executed Scheduller

    @sanity @positive-Scenario
    Scenario: user want to executed scheduller in PDS Application
        Given user login with "PDS_NONADMIN"
        And user click on data processing
        And user create query using query command with "Data Tabular"
        And user filled in filepath as "Brenda_Test/paques_data.csv" in section command property
        And user filled in separator as "," in section command property
        And user choose "First Row as a Header" in section command property
        And user filled in row limit as "20" in section command property
        When user click on run button at navbar
        Then user see first row as a header in datatable
        And user click on section query information tab
        When user set scheduller from time "5" minutes
        And user set scheduler time from today
        And user click on save button at navbar
        Then user should be able to see a message "Process Completed" will be displayed