import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.inside.UserPage;
import pages.outside.LoginPage;

public class TestLogOut extends TestBase
{
    private UserPage userPage;
    @BeforeMethod
    public void beforeMethodLogIn()
    {
        System.out.println("before method");
        this.getWelcomePage().goToOptions();
        LoginPage loginPage = this.getWelcomePage().goToLogin();
        userPage = loginPage.doLogin("tester1@yopmail.com", "12345qwerty");
    }

    @Test
    public void logout()
    {
        this.userPage.goToProfileOptions();
        this.userPage.doLogout();
    }
}
