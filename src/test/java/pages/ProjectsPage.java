package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage {
    private final String MESSAGE_SUCCESS_CREATION_PROJECT_CSS = "[data-testid=messageSuccessDivBox]";
    private final String NAMES_PROJECTS_CSS = ".hoverSensitive";
    private final String DELETE_BUTTON_CSS = "[data-testid=projectDeleteButton]";
    private final String DELETE_CHECKBOX_MESSAGE_CSS = "[data-testid=deleteCheckBoxTestId]";
    private final String DELETE_DIALOG_BUTTON_OK_CSS = "[data-testid=caseFieldsTabDeleteDialogButtonOk]";
    private final String MESSAGE_SUCCESS_DELETION_PROJECT_CSS = "[data-testid=messageSuccessDivBox]";

    public void openPage() {
        open("admin/projects/overview");
    }

    public void openProject(String nameProject) {
        $$(NAMES_PROJECTS_CSS).findBy(text(nameProject)).click();
    }

    public String getMessageCreationProject() {
        return $(MESSAGE_SUCCESS_CREATION_PROJECT_CSS).getText();
    }

    public void deleteProject(String nameProject) {
        $$(NAMES_PROJECTS_CSS).findBy(text(nameProject)).find(DELETE_BUTTON_CSS).click();
        executeJavaScript("document.getElementsByName('deleteCheckbox')[2].click();");
        //$(DELETE_CHECKBOX_MESSAGE_CSS).sendKeys(Keys.SPACE);
        $(DELETE_DIALOG_BUTTON_OK_CSS).click();
    }

    public String getMessageDeletionProject() {
        return $(MESSAGE_SUCCESS_DELETION_PROJECT_CSS).getText();
    }

    public String getNameOfFirstProject() {
        return $$(NAMES_PROJECTS_CSS).first().getText();
    }
}


