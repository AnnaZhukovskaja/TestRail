package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

@Log4j2
public class SuitesPage extends BasePage {

    private final String SECTION_NAMES_CSS = ".grid-title .title";
    private final String EDIT_SMALL_BUTTON_CSS = ".grid-title .icon-small-edit";
    private final String EDIT_SECTION_NAME_INPUT_CSS= "[data-testid=editSectionName]";
    private final String SAVE_EDITED_SECTION_BUTTON_CSS = ".editSectionEdit";
    private final String ADD_SECTION_BUTTON_CSS = "[data-testid=addSectionInline]";
    private final String TEST_CASES_MENU_BUTTON_CSS = "#navigation-suites";
    private final String ADD_NAME_SECTION_CSS = "[data-testid=editSectionName]";
    private final String MESSAGE_NOT_TEST_CASES_CSS = "#groupsEmpty";
    private final String MESSAGE_SUCCESSFUL_RESULT_CSS = "[data-testid=messageSuccessDivBox]";
    private final String ADD_TEST_CASE_BUTTON_CSS = "[data-testid=sidebarCasesAdd]";
    private final String TEST_CASE_SAVE_BUTTON_CSS = "[data-testid=addTestCaseButton]";
    private final String TEST_CASE_TITLE_CSS = "[data-testid=addEditCaseTitle]";
    private final String TEST_CASE_ESTIMATE_CSS = "[data-testid=editCaseEstimate]";
    private final String TEST_CASE_REFERENCES_CSS = "[data-testid=editCaseRefs]";
    private final String TEST_CASE_PRECONDITIONS_CSS = "#custom_preconds_display";
    private final String TEST_CASE_STEP_CSS = "#custom_steps_display";
    private final String TEST_CASE_EXPECTED_RESULT_CSS = "#custom_expected_display";
    private final String TEST_CASE_EDIT_BUTTON_CSS = "[data-testid=testCaseEditButton]";
    private final String EDIT_CASE_DELETE_BUTTON_CSS = "[data-testid=editCaseDeleteButton]";
    private final String NAMES_OF_TEST_CASES_IN_SECTION_CSS ="[data-testid=sectionCaseTitle]";
    private final String TITLE_SECTION_CSS = ".grid-title";
    private final String DELETE_SECTION_SMALL_ICON_XPATH = "//*[@class='grid-title']//child::a[2]//following-sibling::div";
    private final String CHECKBOX_IN_DIALOG_MESSAGE_DELETE_CSS ="[data-testid=caseFieldsTabDeleteDialogCheckbox]";
    private final String BUTTON_OK_IN_DIALOG_MESSAGE_DELETE_CSS= "[data-testid=caseFieldsTabDeleteDialogButtonOk]";

    @Step("Adding section")
    public SuitesPage addSection(String nameSection) {
        log.info("Adding section");
        $(TEST_CASES_MENU_BUTTON_CSS).click();
        $(ADD_SECTION_BUTTON_CSS).click();
        $(ADD_NAME_SECTION_CSS).sendKeys(nameSection);
        $(ADD_NAME_SECTION_CSS).pressEnter();
        return this;
    }

    @Step("Changing name of section")
    public void editSection(String information) {
        log.info("Changing name of section");
        $(EDIT_SMALL_BUTTON_CSS).click();
        $(EDIT_SECTION_NAME_INPUT_CSS).sendKeys(information);
        $(SAVE_EDITED_SECTION_BUTTON_CSS).click();
    }

    @Step("Searching name of section")
    public String findSectionName(String nameSection) {
        log.info("Searching name of section");
        return $$(SECTION_NAMES_CSS).findBy(text(nameSection)).getText();
    }

    @Step("Deleting section")
    public void deleteSection() {
        log.info("Deleting section");
        $(TITLE_SECTION_CSS).hover();
        $(By.xpath(DELETE_SECTION_SMALL_ICON_XPATH)).click();
        sleep(1000);
        $(CHECKBOX_IN_DIALOG_MESSAGE_DELETE_CSS).click();
        sleep(1000);
        $(BUTTON_OK_IN_DIALOG_MESSAGE_DELETE_CSS).click();
        sleep(1000);
    }

    @Step("Getting а message about a successful deletion selection")
    public String getMessageSuccessfulDeletedSection() {
        log.info("Getting а message about a successful deletion selection");
        return $(MESSAGE_NOT_TEST_CASES_CSS).getText();
    }

    @Step("Creating test-case")
    public void addTestCase(String nameTestCase) {
        log.info("Creating test-case");
        $(TEST_CASES_MENU_BUTTON_CSS).click();
        $(ADD_TEST_CASE_BUTTON_CSS).click();
        waitTillOpened();
        $(TEST_CASE_TITLE_CSS).sendKeys(nameTestCase);
        sleep(1000);
        $(TEST_CASE_ESTIMATE_CSS).sendKeys(testCase.getEstimate());
        $(TEST_CASE_REFERENCES_CSS).sendKeys((testCase.getReferences()));
        $(TEST_CASE_PRECONDITIONS_CSS).sendKeys(testCase.getPreconditions());
        $(TEST_CASE_STEP_CSS).sendKeys(testCase.getSteps());
        $(TEST_CASE_EXPECTED_RESULT_CSS).sendKeys(testCase.getExpectedResult());
        $(TEST_CASE_SAVE_BUTTON_CSS).click();
    }

    @Step("Getting а message about a successful result")
    public String getMessageSuccessfulResult() {
        log.info("Getting а message about a successful result");
        return $(MESSAGE_SUCCESSFUL_RESULT_CSS).getText();
    }

    @Step("Changing the test-case")
    public void editTestCase(String information) {
        log.info("Changing the test-case");
        refresh();
        $(TEST_CASE_EDIT_BUTTON_CSS).click();
        $(TEST_CASE_PRECONDITIONS_CSS).sendKeys(information);
        $(TEST_CASE_SAVE_BUTTON_CSS).click();
    }

    @Step("Deleting the test-case by name")
    public void deleteTestCase(String nameTestCase) {
        log.info("Deleting the test-case by name");
        $(TEST_CASES_MENU_BUTTON_CSS).click();
        $$(NAMES_OF_TEST_CASES_IN_SECTION_CSS).findBy(text(nameTestCase)).click();
        $(TEST_CASE_EDIT_BUTTON_CSS).click();
        $(EDIT_CASE_DELETE_BUTTON_CSS).click();
        executeJavaScript("document.getElementsByClassName('dialog-action-default')[15].click();");
    }
}