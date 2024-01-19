package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        loginPage.openPage();
        loginPage.login(user, password);
        assertEquals(dashboardPage.getTitle(), "All Projects", "User is not logged in or wrong page is open");
    }

    @Test
    public void emptyUserPassword() {
        loginPage.openPage();
        loginPage.login(user, "");
        assertEquals(loginPage.getErrorMessage(), "Password is required.", "User is not logged in or wrong notification");
    }

    @Test
    public void emptyUserLogin() {
        loginPage.openPage();
        loginPage.login("", password);
        assertEquals(loginPage.getErrorMessage(), "Email/Login is required.", "User is not logged in or wrong notification");
    }

    @Test
    public void negativeLogin() {
        loginPage.openPage();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessage(), "Email/Login is required.", "User is not logged in or wrong notification");
    }
}
