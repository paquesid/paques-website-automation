@Create-Group
Feature: User Management - Create Group


    Background:
        Given user login with "PDS_NONADMIN"
        When user click on setting button
        And user click on user management button in the list
        When user click on group tab in user tab
        Then user is on tab "Group List" activated
        And user click on create group button
        Then user should see crate group form

    @creategroup @positive-case
    Scenario: user want to create group
        And user input Group name as "Grp2108"   
        And user input Group Description as "Group Description" 
        And user select role as nonadmin0706 
        When user click on Save button
        # Then Result message "New group successfully added" will be displayed
        And user signout the application

    @neg @negative-scenario
    Scenario Outline: Mandatory Field
        And user input Group name as "<groupname>"   
        And user input Group Description as "Group Description" 
        And user select role as nonadmin0706 
        When user click on Save button
        Then Alert message "<message>" will be displayed
        And user signout the application

        Examples:
        |groupname      |message        |
        |               |Group name is required |

        
        
