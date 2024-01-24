package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage {
    private final String MESSAGE_SUCCESS_CREATION_PROJECT_CSS = "[data-testid=messageSuccessDivBox]";
    private final String PROJECT_NAMES_CSS = ".hoverSensitive";
    private final String DELETE_BUTTON_CSS = "[data-testid=projectDeleteButton]";
    private final String DELETE_DIALOG_BUTTON_OK_CSS = "[data-testid=caseFieldsTabDeleteDialogButtonOk]";
    private final String MESSAGE_SUCCESS_DELETION_PROJECT_CSS = "[data-testid=messageSuccessDivBox]";

    public void openPage() {
        log.info("Opening projects page");
        open("admin/projects/overview");
    }

    @Step("Opening project by name: '{nameProject}'")
    public void openProject(String nameProject) {
        log.info("Opening project by name: '{}'",nameProject);
        $$(PROJECT_NAMES_CSS).findBy(text(nameProject)).click();
    }

    public String getMessageCreationProject() {
        log.info("Getting а message about a successful creation project");
        return $(MESSAGE_SUCCESS_CREATION_PROJECT_CSS).getText();
    }

    @Step("Deletion project by name: '{nameProject}'")
    public void deleteProject(String nameProject) {
        log.info("Deletion project by name: '{}'",nameProject);
        $$(PROJECT_NAMES_CSS).findBy(text(nameProject)).find(DELETE_BUTTON_CSS).click();
        executeJavaScript("document.getElementsByName('deleteCheckbox')[2].click();");
        $(DELETE_DIALOG_BUTTON_OK_CSS).click();
    }

    public String getMessageDeletionProject() {
        log.info("Getting а message about a successful deletion project");
        return $(MESSAGE_SUCCESS_DELETION_PROJECT_CSS).getText();
    }

    public String getNameOfFirstProject() {
        log.info("Getting name of first project in the page");
        return $$(PROJECT_NAMES_CSS).first().getText();
    }
}


