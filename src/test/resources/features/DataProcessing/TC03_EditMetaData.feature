@edit-metadata
Feature: Edit Metadata

    @regression @positive-scenario
    Scenario: user edit metadata
        Given user login with "PDS_NONADMIN"
        And user click on data processing
        And user create query using query command with "Data Tabular"
        And user filled in filepath as "Brenda_Test/paques_data.csv" in section command property
        And user filled in separator as "," in section command property
        And user choose "First Row as a Header" in section command property
        And user filled in row limit as "20" in section command property
        When user click on run button at navbar
        Then user see first row as a header in datatable
        And user click metadata setting
        When user check Date time flag to yes
        And user click on save button at navbar
        Then user should be able to see a popup message "Process Completed"

#     @regression @negative-scenario
#     Scenario: Edit Metadata not match with data
#     And user click metadata setting
#     When user check Date time flag to yes
#     And user click on save button at navbar
#     Then user should be able to see a popup message "Process failed"