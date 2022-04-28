import org.testng.Assert;
import org.testng.annotations.*;
import pages.inside.UserPage;
import pages.outside.AccessPage;
import utils.data.Data;

public class TestLogin extends TestBase
{
    private UserPage userPage;
    @Test
    public void login()
    {
        this.getWelcomePage().goToOptions();
        AccessPage accessPage = this.getWelcomePage().goToAccess();
        userPage = accessPage.doLogin(Data.email, Data.password);
        userPage.goToProfileOptions();
        Assert.assertTrue(!userPage.getWelcomeLabel().equals("Welcome!"), "He hasn't logged in");
        log.info("USER HAS LOGGED IN");
    }

    @AfterMethod
    @Parameters({"url"})
    public void afterMethodLogOut(String url)
    {
        userPage.goToProfileOptions();
        this.setWelcomePage(userPage.doLogout(url));
        log.info("LOGIN TEST FINISHED");
    }
}
