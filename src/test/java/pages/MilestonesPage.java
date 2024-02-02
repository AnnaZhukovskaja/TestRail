package pages;

import com.codeborne.selenide.Condition;
import dto.Milestone;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class MilestonesPage extends BasePage{

    private  final String MILESTONE_MENU_BUTTON_CSS = "#navigation-milestones";
    private  final String MILESTONE_ADD_BUTTON_CSS = "[data-testid=navigationMilestonesAdd]";
    private  final String MILESTONE_NAME_BUTTON_CSS = "[data-testid=addEditMilestoneName]";
    private  final String MILESTONE_REFERENCE_BUTTON_CSS = "[data-testid=addEditMilestoneReference]";
    private  final String MILESTONE_DESCRIPTION_TEXTAREA_CSS = "[data-testid=editSectionDescription]";
    private  final String MILESTONE_BUTTON_OK_CSS = "[data-testid=milestoneButtonOk]";
    private  final String NAME_OF_MILESTONE_CSS = ".summary-title a";
    private final String MESSAGE_SUCCESSFUL_RESULT_CSS = "[data-testid=messageSuccessDivBox]";
    private final String DELETE_BUTTON_CSS = "[data-testid=buttonDelete]";
    private final String DELETE_DIALOG_BUTTON_OK_CSS = "[data-testid=caseFieldsTabDeleteDialogButtonOk]";
    private final String BUTTON_EDIT_CSS = ".content-header .button-edit";


    @Step("Creation a milestone by name: '{name}'")
    public MilestonesPage createMilestone(Milestone milestone) {
        log.info("Creation a milestone by name: '{}'",milestone.getName());
        $(MILESTONE_MENU_BUTTON_CSS).click();
        $(MILESTONE_ADD_BUTTON_CSS).click();
        $("[data-testid=testCaseContentHeaderTitle]").shouldBe(visible);
        $(MILESTONE_NAME_BUTTON_CSS).sendKeys(milestone.getName());
        $(MILESTONE_REFERENCE_BUTTON_CSS).sendKeys(milestone.getReferences());
        $(MILESTONE_DESCRIPTION_TEXTAREA_CSS).sendKeys(milestone.getDescription());
        $(MILESTONE_BUTTON_OK_CSS).click();
        return this;
    }

    @Step("Verification of creation a milestone by name: '{name}'")
    public MilestonesPage sectionShouldExist(String nameMilestone) {
        log.info("Verification of creation a milestone by name: '{}'",nameMilestone);
        $$(NAME_OF_MILESTONE_CSS).find(text(nameMilestone)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Verification of deletion a milestone by name: '{name}'")
    public MilestonesPage deleteMilestone(String nameMilestone) {
        log.info("Verification of deletion a milestone by name: '{}'",nameMilestone);
        $$(NAME_OF_MILESTONE_CSS).findBy(text(nameMilestone)).click();
        $(BUTTON_EDIT_CSS).click();
        $(DELETE_BUTTON_CSS).click();
        executeJavaScript("document.getElementsByName('deleteCheckbox')[2].click();");
        $(DELETE_DIALOG_BUTTON_OK_CSS).click();
        return this;
    }

    @Step("Getting a message about successful result")
    public String getMessageSuccess() {
        log.info("Getting a message about successful result");
        return $(MESSAGE_SUCCESSFUL_RESULT_CSS).getText();
    }

    @Step("Verification of edition a milestone by name: '{name}'")
    public MilestonesPage editMilestone(String nameMilestone, String information) {
        log.info("Verification of edition a milestone by name: '{}'",nameMilestone);
        $$(NAME_OF_MILESTONE_CSS).findBy(text(nameMilestone)).click();
        $(BUTTON_EDIT_CSS).click();
        $(MILESTONE_DESCRIPTION_TEXTAREA_CSS).sendKeys(information);
        $(MILESTONE_BUTTON_OK_CSS).click();
        return this;
    }
}
