@Edit-Group
Feature: User Management - EDit Group
    
     @editgroup @positive-case
     Scenario: user want to update description
        Given user login with "PDS_NONADMIN"
        When user click on setting button
        And user click on user management button in the list
        When user click on group tab in user tab
        Then user is on tab group "Group List" activated
        When user click on Edit Group icon
        Then user should see form to update group
        And user edit Group Description as "group update" 
        When user click on Save button
      #   Then update group result message "group successfully updated" will be displayed
        And user signout the application

