package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage {
    private final String MESSAGE_SUCCESSFUL_RESULT_CSS = "[data-testid=messageSuccessDivBox]";
    private final String PROJECT_NAME_CSS = ".hoverSensitive a";
    private final String PROJECT_NAMES_CSS = ".hoverSensitive";
    private final String DELETE_BUTTON_CSS = "[data-testid=projectDeleteButton]";
    private final String DELETE_DIALOG_BUTTON_OK_CSS = "[data-testid=caseFieldsTabDeleteDialogButtonOk]";
    private final String DEFECTS_MENU_BUTTON_CSS = "#projects-tabs-defects";
    private  final String ADD_DEFECT_URL_INPUT_CSS = "#defect_add_url";
    private final String SAFE_PROJECT_BUTTON_CSS = "[data-testid=addEditProjectAddButton]";
    private final String ACCESS_MENU_BUTTON_CSS = "#projects-tabs-access";
    private final String DEFAULT_ACCESS_DROP_DOWN_CSS = "[data-testid=addEditProjectAccessTabAccess]";

    @Step("Opening projects page")
    public ProjectsPage openPage() {
        log.info("Opening projects page");
        open(BASE_URL + "admin/projects/overview");
        return this;
    }

    @Step("Opening project by name: '{nameProject}'")
    public ProjectsPage openProject(String nameProject) {
        log.info("Opening project by name: '{}'",nameProject);
        $$(PROJECT_NAMES_CSS).findBy(text(nameProject)).click();
        return this;
    }

    @Step("Getting а message about a successful result")
    public String getMessageSuccessfulResult() {
        log.info("Getting а message about a successful result");
        return $(MESSAGE_SUCCESSFUL_RESULT_CSS).getText();
    }

    @Step("Deletion project by name: '{nameProject}'")
    public void deleteProject(String nameProject) {
        log.info("Deletion project by name: '{}'",nameProject);
        $$(PROJECT_NAME_CSS).findBy(text(nameProject)).find(DELETE_BUTTON_CSS).click();
        executeJavaScript("document.getElementsByName('deleteCheckbox')[2].click();");
        $(DELETE_DIALOG_BUTTON_OK_CSS).click();
    }

    @Step("Getting name of first project in the page")
    public String getNameOfFirstProject() {
        log.info("Getting name of first project in the page");
        return $$(PROJECT_NAME_CSS).get(0).getText();
    }

    @Step("Editing the project")
    public void editProject(String defectUrl) {
        log.info("Editing the project");
        $(ACCESS_MENU_BUTTON_CSS).click();
        $(DEFAULT_ACCESS_DROP_DOWN_CSS).selectOption("Tester");
        $(DEFECTS_MENU_BUTTON_CSS).click();
        $(ADD_DEFECT_URL_INPUT_CSS).sendKeys(defectUrl);
        $(SAFE_PROJECT_BUTTON_CSS).click();
    }
}


