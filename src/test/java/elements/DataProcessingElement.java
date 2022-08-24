package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dika Brenda Angkasa on 05/07/2022
 */

public class DataProcessingElement {

    /**
     * @TOP-NAVBAR
     */
    @FindBy(css = "button[data-original-title='Run']")
    protected WebElement DATAPROCESSINGPAGE_EXECUTE_BUTTON;
    
    @FindBy(css = "button[data-original-title='Preview']")
    protected WebElement DATAPROCESSINGPAGE_PREVIEW_BUTTON;

    @FindBy(css = "input[placeholder='Default']")
    protected WebElement DATAPROCESSINGPAGE_SAVENAME_TEXTBOX;

    @FindBy(css = ".ti-save")
    protected WebElement DATAPROCESSINGPAGE_SAVE_BUTTON;

    /**
     * @DATA-SOURCE
     */
    
    @FindBy(xpath = "//span[normalize-space()='DATA SOURCE']")
    protected WebElement DATAPROCESSINGPAGE_DATASOURCE_BUTTON;

    @FindBy(css = "div[class='col-sm-10 pr-2'] div[class='input-group']")
    protected WebElement DATAPROCESSINGPAGE_SEARCHSOURCE_SEARCHBAR;

    @FindBy(css = "div[class='col-sm-10 pr-2'] a[class='input-group-text p-0 pt-1']")
    protected WebElement DATAPROCESSINGPAGE_SEARCHSOURCE_TEXT;

    @FindBy(css = "div[class='col-sm-10 pr-2'] span[class='input-group-addon mx-2']")
    protected WebElement DATAPROCESSINGPAGE_SEARCHSOURCE_BUTTON;


    /**
     * @QUERY-COMMANDS
     */

    @FindBy(id = "pq-cmd-10")
    protected WebElement DATAPROCESSING_SEARCHFILE_QUERYCOMMANDS_BUTTON;

    @FindBy(id = "pq-cmd-12")
    protected WebElement DATAPROCESSING_DATATABULAR_QUERYCOMMANDS_BUTTON;

    @FindBy(id = "pq-cmd-30")
    protected WebElement DATAPROCESSING_EXTRACT_SPLIT_QUERYCOMMANDS_BUTTON;

    @FindBy(id = "pq-cmd-61")
    protected WebElement DATAPROCESSING_LIMIT_QUERYCOMMANDS_BUTTON;

    /**
     * @IN-OUT
     */

    @FindBy(id = "out-search_data_tabular_2022070710425521")
    protected WebElement DATAPROCESSING_DATATABULAR_OUTLINE_BUTTON;

    @FindBy(id = "in-limit_2022070710425961")
    protected WebElement DATAPROCESSING_LIMIT_INLINE_BUTTON;

    /**
     * @COMMANDS-PROPERTIES
     */

    @FindBy(id = "search_data_tabular0_filename")
    protected WebElement DATAPROCESSING_FILEPATH_DATATABULAR_SEARCHBOX_TEXT;

    @FindBy(css = "#search_data_tabular0_separator")
    protected WebElement DATAPROCESSING_SEPARATOR_SEARCHBOX_TEXT;

    @FindBy(xpath = "//option[normalize-space()='Default']")
    protected WebElement DATAPROCESSING_OPTION_DEFAULT_DROPDOWN;

    @FindBy(css = ".form-control.show-tick.ms.select2.ng-pristine.ng-valid.ng-star-inserted.ng-touched")
    protected WebElement DATAPROCESSING_SELECT_DROPDOWN;

    @FindBy(css = "body > kt-base:nth-child(3) > div:nth-child(1) > div:nth-child(2) > pq-pds:nth-child(3) > pq-dataprocessing:nth-child(2) > aside:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")
    protected WebElement DATAPROCESSING_OPTION_DROPDOWN;

    @FindBy(xpath = "//option[normalize-space()='First Row as a Header']")
    protected WebElement DATAPROCESSING_OPTION_FIRST_ROW_TEXT;

    @FindBy(css = "#search_data_tabular0_row_limit")
    protected WebElement DATAPROCESSING_ROW_LIMIT_SEARCHBOX_TEXT;

    /**
     * @TEST-DATA
     */

    @FindBy(css = "label[title='Brenda_Test - ']")
    protected WebElement DATAPROCESSINGPAGE_FOLDERDATA_SOURCE_BUTTON;

    @FindBy(css = "label[title='paques_data.csv - 6.0 kB']")
    protected WebElement DATAPROCESSINGPAGE_PAQUESDATA_SOURCE_BUTTON;

    @FindBy(css = ".elipstxt")
    protected WebElement DATAPROCESSINGPAGE_RESULT_EVENT_TEXT;

    @FindBy(xpath = "//span[normalize-space()='NoPolisi']")
    protected WebElement DATAPROCESSING_DATATABLE_POLICENUMBER_TEXT;

    /**
     * @MODAL-ELEMENT
     */

     @FindBy(css = ".f-15.m-auto.ng-star-inserted")
     protected WebElement DATAPROCESSING_SUCCESS_SAVE_QUERY_MODAL_TEXT;

     @FindBy(css = ".btn.btn-info.btn-outline.btn-sm.f-12.mx-auto.mt-3")
     protected WebElement DATAPROCESSING_OKE_MODAL_BUTTON;

     /**
      * @PQL
      */

    @FindBy(id = "pqlHeader")
    protected WebElement DATAPROCESSING_PQL_BUTTON;

    @FindBy(css = "div[class='footer text-center py-3'] button[class='btn btn-info btn-outline btn-sm py-0 px-2']")
    protected WebElement DATAPROCESSING_ADVANCE_PQL_BUTTON;

    @FindBy(css = ".template-editor.ng-valid.ng-dirty.ng-touched")
    protected WebElement DATAPROCESSING_ADVANCE_PQL_TEXT;

    /**
     * @DATATABLE
     */

    private final String dropdownValue = "";
    @FindBy(css = dropdownValue)
    protected WebElement DATAPROCESSING_DROPDOWN_VALUE;

    /**
     * @META-DATA-SETTING
     */

    //  private final String metaData = "Metadata Setting";
    @FindBy(xpath = "//button[normalize-space()='Metadata Setting']")
    protected WebElement DATAPROCESSING_METADATA_SETTING_BTN;

    @FindBy(id = "mat-checkbox-81")
    protected WebElement DATAPROCESSING_DATETIME_CHECKBOX;

    @FindBy(xpath = "//h5[normalize-space()='Process failed']")
    protected WebElement DATAPROCESSING_POPUP_MESSAGE_TXT;

    
    /**
     * @SCHEDULLER
     * @DESCRIPTION this func to hands-on element executed date picker
     */

     @FindBy(xpath = "//*[text()='Close']")
     protected WebElement DATAPROCESSING_CLOSE_QUERY_EDITOR_BUTTON;

     @FindBy(id = "headingOne_1")
     protected WebElement DATAPROCESSING_QUERY_INFORMATION_BUTTON;

     @FindBy(css = "label[for='chck0']")
     protected WebElement DATAPROCESSING_SPAWN_SCHEDULER_BUTTON;

     @FindBy(id = "selectedSchedulerMode")
     protected WebElement DATAPROCESSING_SELECTED_SCHEDULER_DROPDOWN;

     @FindBy(id = "start_time")
     protected WebElement DATAPROCESSING_START_TIME_DATEPICKER;

     @FindBy(css = "div[id='dtp_ZMQiK'] button[class='dtp-btn-ok btn btn-flat btn-sm']")
     protected WebElement DATAPROCESSING_DATEPICKER_OKE_BUTTON;

     /**
      * @CREATE-FOLDER
      * @author Dika Brenda Angkasa
      * {@summary} Create New Folder in Data Source
      */

      @FindBy(css = "button[data-original-title='Create Folder']")
      protected WebElement DATAPROCESSING_CREATE_FOLDER_BUTTON;

      @FindBy(css = "input[placeholder='Folder Name']")
      protected WebElement DATAPROCESSING_INPUT_FOLDER_NAME_TEXT;

      @FindBy(css = ".modal-title")
      protected WebElement DATAPROCESSING_NEW_FOLDER_MODAL_TEXT;

      @FindBy(css = "button[class='btn btn-info btn-outline btn-sm f-12']")
      protected WebElement DATAPROCESSING_NEW_FOLDER_SAVE_BUTTON;

      @FindBy(css = ".btn.btn-neutral.btn-simple.btn-sm.close.px-0")
      protected WebElement DATAPROCESSING_NEW_FOLDER_CANCEL_BUTTON;

      @FindBy(xpath = "//label[normalize-space()='Automation_Test']")
      protected WebElement DATAPROCESSING_EXPECTED_FOLDER_TEXT;
}