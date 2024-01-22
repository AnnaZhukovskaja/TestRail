package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProjectsPage projectPage;
    EditProjectPage editProjectPage;
    SuitesPage suitesPage;
    ProjectsPage projectsPage;
    String user;
    String password;
    Faker faker;
    String nameProject;
    String nameSection;
    String nameTestCase;
    String information;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://nwcompany.testrail.io/index.php?/";
        open();
        getWebDriver().manage().window().maximize();

        faker = new Faker();
        nameProject = "Testrail " + faker.name().firstName();
        information = faker.company().name();
        nameSection = "Section " + faker.number().numberBetween(1, 1000);
        nameTestCase = "TestCase" + faker.number().numberBetween(1, 1000);

        projectsPage = new ProjectsPage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        projectPage = new ProjectsPage();
        editProjectPage = new EditProjectPage();
        suitesPage = new SuitesPage();

        user = System.getProperty("user", PropertyReader.getProperty("tr.user"));
        System.out.println(System.getenv(user));
        password = System.getProperty("password", PropertyReader.getProperty("tr.password"));
        System.out.println(System.getenv(password));
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }
}
