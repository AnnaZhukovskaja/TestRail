package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage {
    private final String MESSAGE_SUCCESSFUL_RESULT_CSS = "[data-testid=messageSuccessDivBox]";
    private final String PROJECT_NAMES_CSS = ".hoverSensitive";
    private final String DELETE_BUTTON_CSS = "[data-testid=projectDeleteButton]";
    private final String DELETE_DIALOG_BUTTON_OK_CSS = "[data-testid=caseFieldsTabDeleteDialogButtonOk]";

    @Step("Opening projects page")
    public ProjectsPage openPage() {
        log.info("Opening projects page");
        open(BASE_URL + "admin/projects/overview");
        return this;
    }

    @Step("Opening project by name: '{nameProject}'")
    public void openProject(String nameProject) {
        log.info("Opening project by name: '{}'",nameProject);
        $$(PROJECT_NAMES_CSS).findBy(text(nameProject)).click();
    }

    @Step("Getting а message about a successful creation project")
    public String getMessageCreationProject() {
        log.info("Getting а message about a successful creation project");
        return $(MESSAGE_SUCCESSFUL_RESULT_CSS).getText();
    }

    @Step("Deletion project by name: '{nameProject}'")
    public void deleteProject(String nameProject) {
        log.info("Deletion project by name: '{}'",nameProject);
        $$(PROJECT_NAMES_CSS).findBy(text(nameProject)).find(DELETE_BUTTON_CSS).click();
        executeJavaScript("document.getElementsByName('deleteCheckbox')[2].click();");
        $(DELETE_DIALOG_BUTTON_OK_CSS).click();
    }

    @Step("Getting а message about a successful deletion project")
    public String getMessageDeletionProject() {
        log.info("Getting а message about a successful deletion project");
        return $(MESSAGE_SUCCESSFUL_RESULT_CSS).getText();
    }

    @Step("Getting name of first project in the page")
    public String getNameOfFirstProject() {
        log.info("Getting name of first project in the page");
        return $$(PROJECT_NAMES_CSS).first().getText();
    }
}


