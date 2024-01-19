package pages;

import com.github.javafaker.Faker;
import dto.TestCase;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class BasePage {

    Faker faker;
    TestCase testCase;

    BasePage() {
        faker = new Faker();
        testCase = new TestCase("Title"+faker.number().numberBetween(1, 1000),"5m","-",
                "You need to create a project.","Step"+faker.number().numberBetween(1, 1000),
                "The test case has been added.");
    }



}
