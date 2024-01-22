package pages;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class DashboardPage extends BasePage {
    private final String TITLE_CSS = "[data-testid=testCaseContentHeaderTitle]";
    private final String ADD_PROJECT_BUTTON_CSS = "[data-testid=sidebarProjectsAddButton]";
    private final String PROJECT_NAME_INPUT_CSS = "[data-testid=addProjectNameInput]";
    private final String CREATE_PROJECT_BUTTON_CSS = "[data-testid=addEditProjectAddButton]";
    private final String PROJECT_NAMES_CSS = ".summary-title > a";

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
        $$(PROJECT_NAMES_CSS).findBy(text(nameProject)).click();
    }

    public String getNameOfFirstProject() {
        return $$(PROJECT_NAMES_CSS).first().getText();
    }
}
