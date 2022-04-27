import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.inside.UserPage;
import pages.outside.LoginPage;
import pages.outside.WelcomePage;

public class TestLogOut extends TestBase
{
    private UserPage userPage;
    @BeforeMethod
    public void beforeMethodLogIn()
    {
        System.out.println("before method");
        this.getWelcomePage().goToOptions();
        LoginPage loginPage = this.getWelcomePage().goToLogin();
        userPage = loginPage.doLogin("tester1@yopmail.com", "1234qwerty");
    }

    @Test
    @Parameters({"url"})
    public void logout(String url)
    {
        this.userPage.goToProfileOptions();
        WelcomePage welcomePage = this.userPage.doLogout(url);
        welcomePage.goToOptions();
        System.out.println(welcomePage.getWelcomeLabel());
        Assert.assertTrue(welcomePage.getWelcomeLabel().equals("Welcome!"), "He hasn't logout");
    }
}
