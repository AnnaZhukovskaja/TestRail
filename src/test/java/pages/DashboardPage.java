package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage extends BasePage {
    private final String TITLE_CSS = "[data-testid=testCaseContentHeaderTitle]";
    private final String ADD_PROJECT_BUTTON_CSS ="[data-testid=sidebarProjectsAddButton]";
    private final String PROJECT_NAME_INPUT_CSS ="[data-testid=addProjectNameInput]";
    private final String CREATE_PROJECT_BUTTON_CSS = "[data-testid=addEditProjectAddButton]";
    private final String NAMES_PROJECTS_CSS = ".summary-title > a";

    public void openPage() {
        open("/index.php?/dashboard");
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
}
