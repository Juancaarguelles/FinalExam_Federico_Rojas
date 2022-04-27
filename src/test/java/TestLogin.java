import org.apache.commons.logging.Log;
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
        userPage = loginPage.doLogin("tester2@yopmail.com", "12345qwerty");
        userPage.goToProfileOptions();
        Assert.assertTrue(!userPage.getWelcomeLabel().equals("Welcome!"), "He hasn't logged in");
        //this.getListener().onTestSuccess();
        log.info("USER HAS LOGGED IN");
    }


    @AfterMethod
    @Parameters({"url"})
    public void afterMethodLogOut(String url)
    {
        userPage.goToProfileOptions();
        userPage.doLogout(url);
        log.info("LOGIN TEST FINISHED");
    }
}
