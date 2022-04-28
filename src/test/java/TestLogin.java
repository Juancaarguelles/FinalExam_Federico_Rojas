import org.testng.Assert;
import org.testng.annotations.*;
import pages.inside.UserPage;
import pages.outside.AccessPage;

public class TestLogin extends TestBase
{
    private UserPage userPage;
    @Test
    public void login()
    {
        this.getWelcomePage().goToOptions();
        AccessPage accessPage = this.getWelcomePage().goToAccess();
        userPage = accessPage.doLogin("tester2@yopmail.com", "12345qwerty");
        userPage.goToProfileOptions();
        Assert.assertTrue(!userPage.getWelcomeLabel().equals("Welcome!"), "He hasn't logged in");
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
