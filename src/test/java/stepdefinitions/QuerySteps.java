package stepdefinitions;

import helper.QueryCommands;
import helper.TestInstrument;
import io.cucumber.java8.En;

public class QuerySteps extends TestInstrument implements En {
    
    public QuerySteps(){
        And("^user click on data processing$", () -> {
            paques.homePage().goToDataProcessing();
        });

        And("^user create query using query command with \"([^\"]*)\"$", (String queryCommands) -> {
            if (queryCommands.equals(QueryCommands.DATATABULAR.toString())) {
                paques.dataProcessingPage().setQueryTabularView();
            } else if (queryCommands.equals(QueryCommands.SEARCHFILE.toString())){
                paques.dataProcessingPage().setQuerySearchFile();
            } else {
                throw new Error("query command not founded");
            }
        });

        And("^user create query by PQL$", () -> {
            paques.dataProcessingPage().setQueryUsingPQL("search from file '/Brenda_Test/paques_data.csv' into data");
        });

        And("^user filled in filepath as \"([^\"]*)\" in section command property$", (String filePath) -> {
            paques.dataProcessingPage().setFilePathQueryCommands(filePath);
        });

        And("^user filled in separator as \"([^\"]*)\" in section command property$", (String separator) -> {
            paques.dataProcessingPage().setSeparatorQueryCommands(separator);
        });

        And("^user see the option value of option is \"([^\"]*)\"", (String defaultValue) -> {
            paques.dataProcessingPage().getDefaultOptionValue(defaultValue);
        });

        And("^user choose \"([^\"]*)\" in section command property$", (String value) -> {
            paques.dataProcessingPage().setDropdownOptionQueryCommands(value);
        });

        And("^user filled in row limit as \"([^\"]*)\" in section command property$", (String rowLimit) -> {
            paques.dataProcessingPage().setRowLimitQueryCommands(rowLimit);
        });

        When("^user click on save button at navbar$", () -> {
            paques.dataProcessingPage().clickSaveButton(dotenv.get("PDS_SAVE_QUERY_NAME"));
        });

        Then("^user should be able to see a message \"([^\"]*)\" will be displayed$", (String successMessage) -> {
            paques.dataProcessingPage().successSaveNewQuery(successMessage);
        });

        When("^user click on run button at navbar$", () -> {
            paques.dataProcessingPage().clickRunButtonInNavBar();
        });

        Then("^user see first row as a header in datatable$", () -> {
            paques.dataProcessingPage().getFirstRowDataTable(dotenv.get("PDS_EXPECTED_QUERY_DATATABLE"));
        });

        Then("^user see the header datatable as \"([^\"]*)\"$", (String headerDataTable) -> {
            paques.dataProcessingPage().getHeaderDataTable(headerDataTable);
        });

        And("^user load data to editor$", () -> {
            paques.dataProcessingPage().clickPaquesAdvanceQuery();
            paques.dataProcessingPage().clickEditPaquesAdvanceQuery();
        });

        When("^user create query using PQL \"([^\"]*)\"$", (String queryPQL) -> {
            paques.dataProcessingPage().setPaquesQueryLanguage(queryPQL);
        });
    }
}