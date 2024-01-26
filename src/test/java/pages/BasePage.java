package pages;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import dto.TestCase;
import lombok.extern.log4j.Log4j2;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class BasePage {

    Faker faker;
    TestCase testCase;
    final String BASE_URL = PropertyReader.getProperty("tr.base.url");

    BasePage() {
       faker = new Faker();
       testCase = new TestCase("Title " + faker.number().numberBetween(1, 1000),
                "5m",
                "-",
                "You need to create a project.",
                "Step" + faker.number().numberBetween(1, 1000),
                "The test case has been added.");
    }
    public void waitTillOpened() {
        $("[data-testid=testCaseContentHeaderTitle]").shouldHave(Condition.text("Add Test Case"));
    }
}
