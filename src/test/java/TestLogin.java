import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import pages.inside.UserPage;
import pages.outside.LoginPage;
import pages.outside.WelcomePage;

public class TestLogin extends TestBase
{
    private UserPage userPage;
    @Test
    public void login()
    {
        this.getWelcomePage().goToOptions();
        LoginPage loginPage = this.getWelcomePage().goToLogin();
        userPage = loginPage.doLogin("tester1@yopmail.com", "1234qwerty");
        userPage.goToProfileOptions();
        Assert.assertTrue(!userPage.getWelcomeLabel().equals("Welcome!"), "He hasn't logged in");
        //this.getListener().onTestSuccess();
        System.out.println("Test succesful");
    }


    @AfterMethod
    @Parameters({"url"})
    public void afterMethodLogOut(String url)
    {
        userPage.goToProfileOptions();
        userPage.doLogout(url);
    }
}
