import org.testng.annotations.*;
import pages.inside.UserPage;
import pages.outside.LoginPage;
import pages.outside.WelcomePage;

public class TestLogin extends TestBase
{

    private WelcomePage welcomePage;

    @BeforeClass
    @Parameters({"url"})
    public void beforeClass(String url)
    {
        this.welcomePage = new WelcomePage(this.getDriver().getDriver(), url);
    }

    @Test(priority = 0)
    public void login()
    {
        LoginPage loginPage = welcomePage.goToLogin();
        UserPage userPage = loginPage.doLogin("tester1@yopmail.com", "12345qwerty");
        userPage.goToProfileOptions();
    }

    @Test(priority = 1)
    public void logout()
    {
        System.out.println("logout");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("after method");
    }
}
