package pages;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class EditProjectPage extends BasePage {

    private final String EDIT_PROJECT_BUTTON_CSS = "[data-testid=editProjectButton]";
    private final String ANNOUNCEMENT_TEXTAREA_CSS = "[data-testid=addEditProjectAnnouncement]";
    private final String SAFE_PROJECT_BUTTON = "[data-testid=addEditProjectAddButton]";
    private final String MESSAGE_SUCCESSFUL_SAVING_CSS = "[data-testid=messageSuccessDivBox]";

    public void editProject(String information) {
        $(EDIT_PROJECT_BUTTON_CSS).click();
        $(ANNOUNCEMENT_TEXTAREA_CSS).sendKeys(information);
        $(SAFE_PROJECT_BUTTON).click();
    }

    public String geMessageSuccessfulSaving() {
        return $(MESSAGE_SUCCESSFUL_SAVING_CSS).getText();
    }
}
