@Data-Source
Feature: Create Folder

    Background: 
        Given user login with "PDS_NONADMIN"
        And user click on data processing

    @sanity @positive-scenario
    Scenario: user can create folder from data source in PDS Application
        And user click on create folder icon
        When user input folder name as "Automation Test"
        And user click on save button to save new folder
        Then user should be able to created new folder