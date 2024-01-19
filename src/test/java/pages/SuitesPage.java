package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SuitesPage extends BasePage {

    private final String NAMES_SECTIONS_CSS = ".grid-title .title";
    private final String EDIT_SMALL_BUTTON_CSS = ".grid-title .icon-small-edit";
    private final String EDIT_SECTION_NAME_INPUT_CSS= "[data-testid=editSectionName]";
    private final String SAVE_EDITED_SECTION_BUTTON_CSS = ".editSectionEdit";
    private final String ADD_SECTION_BUTTON_CSS = "[data-testid=addSectionInline]";
    private final String TEST_CASES_MENU_BUTTON_ID = "navigation-suites";
    private final String ADD_NAME_SECTION_CSS = "[data-testid=editSectionName]";
    private final String MESSAGE_NOT_TEST_CASES_CSS = "[data-testid=sectionCaseGridGroups]";
    private final String MESSAGE_SUCCESSFUL_ADDED_TEST_CASE = "[data-testid=messageSuccessDivBox]";
    private final String ADD_TEST_CASE_BUTTON_CSS = "[data-testid=sidebarCasesAdd]";
    private final String ADD_TEST_CASE_SAVE_CSS = "[data-testid=addTestCaseButton]";
    private final String TEST_CASE_TITLE_CSS = "[data-testid=addEditCaseTitle]";
    private final String TEST_CASE_ESTIMATE_CSS = "[data-testid=editCaseEstimate]";
    private final String TEST_CASE_REFERENCES_CSS = "[data-testid=editCaseRefs]";
    private final String TEST_CASE_PRECONTITIONS_CSS = "#custom_preconds_display";
    private final String TEST_CASE_STEP_CSS = "#custom_steps_display";
    private final String TEST_CASE_EXPECTED_RESULT_CSS = "#custom_expected_display";


    public void addSection(String nameSection) {
        $(By.id(TEST_CASES_MENU_BUTTON_ID)).click();
        $(ADD_SECTION_BUTTON_CSS).click();
        $(ADD_NAME_SECTION_CSS).sendKeys(nameSection);
        $(ADD_NAME_SECTION_CSS).pressEnter();
    }

    public String findSectionNameWithBooleanResult(String nameSection) {

//        try {
//            $$(NAMES_SECTIONS_CSS).findBy(text(nameSection));
//        } catch (NoSuchElementException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//        return true;
        return $$(NAMES_SECTIONS_CSS).findBy(text(nameSection)).getText();

    }

    public void editSection(String information) {
        $(EDIT_SMALL_BUTTON_CSS).click();
        $(EDIT_SECTION_NAME_INPUT_CSS).sendKeys(information);
        $(SAVE_EDITED_SECTION_BUTTON_CSS).click();
    }

    public String findSectionName(String nameSection) {
        return $$(NAMES_SECTIONS_CSS).findBy(text(nameSection)).getText();
    }

    public void deleteSection(String nameSection) {
        //executeJavaScript("document.getElementsByClassName('icon-small-delete')[0].setAttribute('displayed', 'true');");
        //$$(NAMES_SECTIONS_CSS).findBy(text(nameSection)).$(".icon-small-delete").click();
        executeJavaScript("document.getElementsByClassName('icon-small-delete')[0].click();");
        $("[data-testid=deleteCheckBoxTestId]").pressEnter().click();
        executeJavaScript("document.getElementsByName('deleteCheckbox')[2].click();");
        //executeJavaScript("document.getElementsByClassName('dialog-confirm')[0].setAttribute('displayed', 'true');");
        executeJavaScript("document.getElementsByClassName('button-ok')[17].click();");
    }

    public String getMessage() {
        return $(MESSAGE_NOT_TEST_CASES_CSS).getText();
    }

    public void addTestCase(String nameProject) {
        $(By.id(TEST_CASES_MENU_BUTTON_ID)).click();
        $(ADD_TEST_CASE_BUTTON_CSS).click();
        $(TEST_CASE_TITLE_CSS).sendKeys(testCase.getTitle());
        $(TEST_CASE_ESTIMATE_CSS).sendKeys(testCase.getEstimate());
        $(TEST_CASE_REFERENCES_CSS).sendKeys((testCase.getReferences()));
        $(TEST_CASE_PRECONTITIONS_CSS).sendKeys(testCase.getPreconditions());
        $(TEST_CASE_STEP_CSS).sendKeys(testCase.getSteps());
        $(TEST_CASE_EXPECTED_RESULT_CSS).sendKeys(testCase.getExpectedResult());
        $(ADD_TEST_CASE_SAVE_CSS).click();
    }

    public String getMessageSuccessfulAddedTestCase() {
        return $(MESSAGE_SUCCESSFUL_ADDED_TEST_CASE).getText();
    }

}
