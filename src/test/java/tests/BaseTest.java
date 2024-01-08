package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProjectsPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProjectsPage projectPage;
    String user;
    String password;
    Faker faker;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.baseUrl ="https://newcompany58.testrail.io";
        open();
        getWebDriver().manage().window().maximize();
        faker = new Faker();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        projectPage = new ProjectsPage();

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
