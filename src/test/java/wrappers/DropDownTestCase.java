package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

@Log4j2
public class DropDownTestCase {
    String label;
    public static String DROPDOWN_TEST_CASE_XPATH = "//*[contains(text(),'%s')]/../*/*[contains(@class,'chzn-single')]";
    public static String CLICK_DROPDOWN_XPATH = "//*[contains(@class,'chzn-container-active')]//li[contains(text(),'%s')]";

    public DropDownTestCase(String label) {
        this.label = label;
    }
    public void selectForTestCase(String selectName) {
        log.info("Selecting '{}' inside dropdown '{}'",selectName,label);
        $(By.xpath(String.format(CLICK_DROPDOWN_XPATH,label))).click();
        $(By.xpath(String.format(DROPDOWN_TEST_CASE_XPATH,selectName))).click();

    }

}
