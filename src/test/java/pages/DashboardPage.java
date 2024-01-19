package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class DashboardPage extends BasePage {
    private final String TITLE_CSS = "[data-testid=testCaseContentHeaderTitle]";
    private final String ADD_PROJECT_BUTTON_CSS = "[data-testid=sidebarProjectsAddButton]";
    private final String PROJECT_NAME_INPUT_CSS = "[data-testid=addProjectNameInput]";
    private final String CREATE_PROJECT_BUTTON_CSS = "[data-testid=addEditProjectAddButton]";
    private final String NAMES_PROJECTS_CSS = ".summary-title > a";
    private final String TEST_CASES_MENU_BUTTON_ID = "navigation-suites";
    private final String ADD_TEST_CASE_BUTTON_CSS = "[.button-add]";
    private final String ADD_TEST_CASE_SAVE_CSS = "[data-testid=addTestCaseButton]";
    private final String MESSAGE_SUCCESSFUL_ADDED_TEST_CASE = "[data-testid=messageSuccessDivBox]";

    public void openPage() {
        open("dashboard");
    }

    public String getTitle() {
        return $(TITLE_CSS).getText();
    }

    public void createProject(String name) {
        $(ADD_PROJECT_BUTTON_CSS).click();
        $(PROJECT_NAME_INPUT_CSS).sendKeys(name);
        $(CREATE_PROJECT_BUTTON_CSS).click();
    }

    public void openProject(String nameProject) {
        $$(NAMES_PROJECTS_CSS).findBy(text(nameProject)).click();
    }

    public void addTestCase(String nameProject) {
        $$(NAMES_PROJECTS_CSS).findBy(text(nameProject)).click();
        $(By.id(TEST_CASES_MENU_BUTTON_ID)).click();
        $(ADD_TEST_CASE_BUTTON_CSS).click();

        $(ADD_TEST_CASE_SAVE_CSS).click();
    }

    public String getNameOfFirstProject() {
        return $$(NAMES_PROJECTS_CSS).first().getText();
    }

    public String getMessageSuccessfulAddedTestCase() {
        return $(MESSAGE_SUCCESSFUL_ADDED_TEST_CASE).getText();
    }
}
