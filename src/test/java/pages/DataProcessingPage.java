package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import elements.DataProcessingElement;
import utils.LogUtils;

import static helper.TestInstrument.*;

/**
 * Created by Dika Brenda Angkasa on 05/07/2022
 */

public class DataProcessingPage extends DataProcessingElement {
    
    protected WebDriver driver;

    public DataProcessingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    /**
     * @TOP-NAV
     */

    public void clickSaveButtonInNav(){
        clickButton(DATAPROCESSINGPAGE_SAVE_BUTTON);
    }

    public void setNameWillBeSaved(String nameSaveAs){
        enterText(DATAPROCESSINGPAGE_SAVENAME_TEXTBOX, nameSaveAs);
    }

    public void clickSaveButton(String nameSaveAs){
        try {
            setNameWillBeSaved(nameSaveAs);
            clickSaveButtonInNav();
        } catch (Exception e) {
            throw new Error(e.getCause());
        }
    }

    /**
     * @DATA-SOURCE
     */

    public void clickDataSource(){
        clickButton(DATAPROCESSINGPAGE_DATASOURCE_BUTTON);
    }

    public void searchDataSource(String sourceName){
        enterText(DATAPROCESSINGPAGE_SEARCHSOURCE_SEARCHBAR, sourceName);
    }

    public void clickButtonSearchSource(){
        clickButton(DATAPROCESSINGPAGE_SEARCHSOURCE_BUTTON);
    }

    public void setDataSource(String sourceName){
        try {
            clickDataSource();
            searchDataSource(sourceName);
            clickButtonSearchSource();
        } catch (AssertionError e) {
            LogUtils.error("message", e);
        }
    }

    /**
     * @QUERY-COMMANDS
     */

    public void setQueryTabularView(){
        clickButton(DATAPROCESSING_DATATABULAR_QUERYCOMMANDS_BUTTON);
    }

    public void setQuerySearchFile(){
        clickButton(DATAPROCESSING_SEARCHFILE_QUERYCOMMANDS_BUTTON);
    }

    /**
     * @COMMANDS-PROPERTIES
     */
 
    public void clickQueryCommands(){
        clickButton(DATAPROCESSING_DATATABULAR_QUERYCOMMANDS_BUTTON);
    }

    public void setFilePathQueryCommands(String filePath){
        enterText(DATAPROCESSING_FILEPATH_SEARCHBOX_TEXT, filePath);
    }

    public void setSeparatorQueryCommands(String separator){
        enterText(DATAPROCESSING_SEPARATOR_SEARCHBOX_TEXT, separator);
    }

    public void getDefaultOptionValue(String defaultValue){
        if(isElementExist(DATAPROCESSING_OPTION_DEFAULT_DROPDOWN, 2)) {
            String actual = DATAPROCESSING_OPTION_DEFAULT_DROPDOWN.getText();
            assertEquals(defaultValue, actual);
        }
    }

    public void setDropdownOptionQueryCommands(String value){
        try {
            String actual = DATAPROCESSING_OPTION_FIRST_ROW_TEXT.getText();
            assertEquals(actual, value);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public void setRowLimitQueryCommands(String rowLimit){
        enterText(DATAPROCESSING_ROW_LIMIT_SEARCHBOX_TEXT, rowLimit);
    }

    /**
     * @MODAL
     */

     public void sas(){
        
     }

     public void successSaveNewQuery(String expected){
        try {
            if(isElementExist(DATAPROCESSING_SUCCESS_SAVE_QUERY_MODAL_TEXT, 2000)){
                String actual = DATAPROCESSING_SUCCESS_SAVE_QUERY_MODAL_TEXT.getText();
                assertEquals(expected, actual);
            }
        } catch (Exception e) {
            throw new Error(e.getCause());
        } finally {
            clickButton(DATAPROCESSING_OKE_MODAL_BUTTON);
        }
     }

     public void clickPaquesAdvanceQuery(){
        clickButton(DATAPROCESSING_PQL_BUTTON);
     }

     public void clickEditPaquesAdvanceQuery(){
        clickButton(DATAPROCESSING_ADVANCE_PQL_BUTTON);
        if(isElementExist(DATAPROCESSING_OKE_MODAL_BUTTON, 2)){
            clickButton(DATAPROCESSING_OKE_MODAL_BUTTON);
        }
     }

     public void setPaquesQueryLanguage(String query) {
        if(isElementExist(DATAPROCESSING_ADVANCE_PQL_TEXT, 2)){
            enterText(DATAPROCESSING_ADVANCE_PQL_TEXT, query);
            delay(4000);
        }
     }

     public void setQueryUsingPQL(String query){
        try {
            clickPaquesAdvanceQuery();
            clickEditPaquesAdvanceQuery();
            setPaquesQueryLanguage(query);
        } catch (Exception e) {
            throw new Error(e.getCause());
        }
     }

     public void clickRunButtonInNavBar() {
        clickButton(DATAPROCESSINGPAGE_EXECUTE_BUTTON);
    }

    public void getFirstRowDataTable(String expected){
        if(isElementExist(DATAPROCESSING_DATATABLE_POLICENUMBER_TEXT, 2)){
            String actual = DATAPROCESSING_DATATABLE_POLICENUMBER_TEXT.getText().trim();
            assertEquals(actual, expected);
        }
    }

    public void getHeaderDataTable(String expected){
        if(isElementExist(DATAPROCESSINGPAGE_RESULT_EVENT_TEXT, 2)){
            String actual = DATAPROCESSINGPAGE_RESULT_EVENT_TEXT.getText().trim();
            assertEquals(expected, actual);
        }
    }

    public void clickMetaDataSetting(){
        if(isElementExist(DATAPROCESSING_METADATA_SETTING_BTN, 2)){
            clickButton(DATAPROCESSING_METADATA_SETTING_BTN);
        }
    }

    public void checklistDateTimeMetaData(){
        if(isElementExist(DATAPROCESSING_DATETIME_CHECKBOX, 2)){
            clickButton(DATAPROCESSING_DATETIME_CHECKBOX);
        }
    }

    public void getTextErrorMessage(String expected){
        if(isElementExist(DATAPROCESSING_POPUP_MESSAGE_TXT, 2)){
            String actual = DATAPROCESSING_POPUP_MESSAGE_TXT.getText();
            assertEquals(expected, actual);
        }
    }
}
