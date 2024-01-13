package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage extends BasePage {
    private final String MESSAGE_SUCCESS_CREATION_PROJECT_CSS = "[data-testid=messageSuccessDivBox]";
    private final String NAMES_PROJECTS_CSS = ".hoverSensitive";
    private final String DELETE_BUTTON_CSS = "[data-testid=projectDeleteButton]";
    private final String DELETE_CHECKBOX_MESSAGE_CSS = "[data-testid=deleteCheckBoxTestId]";
    private final String DELETE_DIALOG_BUTTON_OK_CSS = "[data-testid=caseFieldsTabDeleteDialogButtonOk]";
    private final String MESSAGE_SUCCESS_DELETION_PROJECT_CSS = "[data-testid=messageSuccessDivBox]";

    public void openPage() {
        open("/index.php?/admin/projects/overview");
    }

    public String getMessageCreationProject() {
        return $(MESSAGE_SUCCESS_CREATION_PROJECT_CSS).getText();
    }

    public void deleteProject(String nameProject) {
        $$(NAMES_PROJECTS_CSS).findBy(text(nameProject)).find(DELETE_BUTTON_CSS).click();
        $(DELETE_CHECKBOX_MESSAGE_CSS).click();
        $(DELETE_DIALOG_BUTTON_OK_CSS).click();
    }

    public String getMessageDeletionProject() {
        return $(MESSAGE_SUCCESS_DELETION_PROJECT_CSS).getText();
    }


}
