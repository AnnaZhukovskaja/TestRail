package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SuitesPage extends BasePage {

    private final String NAMES_SECTIONS_CSS = ".grid-title .title";
    private final String EDIT_SMALL_BUTTON_CSS = ".grid-title .icon-small-edit";
    private final String EDIT_SECTION_NAME_INPUT_CSS= "[data-testid=editSectionName]";
    private final String SAVE_EDITED_SECTION_BUTTON_CSS = ".editSectionEdit";
    private final String ADD_SECTION_BUTTON_CSS = "[data-testid=addSectionInline]";
    private final String TEST_CASES_MENU_BUTTON_ID = "navigation-suites";
    private final String ADD_NAME_SECTION_CSS = "[data-testid=editSectionName]";


    public void addSection(String nameSection) {
        $(By.id(TEST_CASES_MENU_BUTTON_ID)).click();
        $(ADD_SECTION_BUTTON_CSS).click();
        $(ADD_NAME_SECTION_CSS).sendKeys(nameSection);
        $(ADD_NAME_SECTION_CSS).pressEnter();
    }

    public String findSectionNameWithBooleanRezult(String nameSection) {

//        try {
//            $$(NAMES_SECTIONS_CSS).findBy(text(nameSection));
//        } catch (NoSuchElementException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//        return true;
        return $$(NAMES_SECTIONS_CSS).findBy(text(nameSection)).getText();

    }

    public void editSection(String information) {
        $(EDIT_SMALL_BUTTON_CSS).click();
        $(EDIT_SECTION_NAME_INPUT_CSS).sendKeys(information);
        $(SAVE_EDITED_SECTION_BUTTON_CSS).click();
    }

    public String findSectionName(String nameSection) {
        return $$(NAMES_SECTIONS_CSS).findBy(text(nameSection)).getText();
    }

    public void deleteSection(String nameSection) {
        //executeJavaScript("document.getElementsByClassName('icon-small-delete')[0].setAttribute('displayed', 'true');");
        //$$(NAMES_SECTIONS_CSS).findBy(text(nameSection)).$(".icon-small-delete").click();
        executeJavaScript("document.getElementsByClassName('icon-small-delete')[0].click();");
        executeJavaScript("document.getElementsByName('deleteCheckbox')[2].click();");
        //executeJavaScript("document.getElementsByClassName('dialog-confirm')[0].setAttribute('displayed', 'true');");
        //$(".dialog-confirm").pressEnter();
        //$(".button-ok-disabled").click();
        executeJavaScript("document.getElementsByClassName('button-ok')[17].click();");

    }

}
