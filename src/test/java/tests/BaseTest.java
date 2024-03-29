package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProjectsPage projectPage;
    SuitesPage suitesPage;
    ProjectsPage projectsPage;
    MilestonesPage milestonePage;
    TestRunsPage testRunsPage;
    String user;
    String password;
    Faker faker;
    String nameProject;
    String nameSection;
    String nameTestCase;
    String information;
    String description;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.timeout = 10000;
        open();
        getWebDriver().manage().window().maximize();

        faker = new Faker();
        nameProject = "Testrail " + faker.name().firstName();
        information = faker.company().name();
        nameSection = "Section " + faker.number().numberBetween(1, 1000);
        nameTestCase = "TestCase" + faker.number().numberBetween(1, 1000);
        description = "The information has been changed";

        projectsPage = new ProjectsPage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        projectPage = new ProjectsPage();
        suitesPage = new SuitesPage();
        milestonePage = new MilestonesPage();
        testRunsPage = new TestRunsPage();

        user = System.getProperty("user", PropertyReader.getProperty("tr.user"));
        password = System.getProperty("password", PropertyReader.getProperty("tr.password"));
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }

    @AfterSuite
    public void deleteAllProject() {
        loginPage.openPage().login(user, password);
        projectsPage.openPage().deleteAllProject(projectPage.getNumberAllProjects());
    }
}
