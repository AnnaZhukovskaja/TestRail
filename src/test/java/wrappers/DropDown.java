package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DropDown {
    String label;
    public String DROPDOWN_XPATH ="//*[contains(@class,'chzn-container-active')]//li[contains(text(),'%s')]";

    public String CLICK_DROPDOWN_XPATH = "//*[contains(text(),'%s')]/../*/*[contains(@class,'chzn-single')]";

    public DropDown(String label) {
        this.label = label;
    }
    public void select(String selectName) {
        log.info("Selecting '{}' inside dropdown '{}'",selectName,label);
        $(By.xpath(String.format(CLICK_DROPDOWN_XPATH,label))).click();
        $(By.xpath(String.format(DROPDOWN_XPATH,selectName))).click();
    }
}
