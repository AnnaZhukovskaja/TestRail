package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test (description = "Checking of successful registration")
    public void successfulLogin() {
        loginPage.openPage();
        loginPage.login(user, password);
        assertEquals(dashboardPage.getTitle(), "All Projects", "User is not logged in or wrong page is open");
    }

    @Test (description = "Checking of registration without Password")
    public void emptyUserPassword() {
        loginPage.openPage();
        loginPage.login(user, "");
        assertEquals(loginPage.getErrorMessage(), "Password is required.", "User is not logged in or wrong notification");
    }

    @Test (description = "Checking of registration without Login")
    public void emptyUserLogin() {
        loginPage.openPage();
        loginPage.login("", password);
        assertEquals(loginPage.getErrorMessage(), "Email/Login is required.", "User is not logged in or wrong notification");
    }

    @Test (description = "Checking of unsuccessful registration")
    public void negativeLogin() {
        loginPage.openPage();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessage(), "Email/Login is required.", "User is not logged in or wrong notification");
    }
}
