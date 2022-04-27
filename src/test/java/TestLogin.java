import org.testng.annotations.*;
import pages.inside.UserPage;
import pages.outside.LoginPage;
import pages.outside.WelcomePage;

public class TestLogin extends TestBase
{
    private UserPage userPage;


    @Test(priority = 0)
    public void login()
    {
        this.getWelcomePage().goToOptions();
        LoginPage loginPage = this.getWelcomePage().goToLogin();
        userPage = loginPage.doLogin("tester1@yopmail.com", "12345qwerty");
    }


    @AfterMethod
    @Parameters({"url"})
    public void afterMethodLogOut(String url)
    {
        userPage.goToProfileOptions();
        userPage.doLogout();
        System.out.println("after method");
    }
}
