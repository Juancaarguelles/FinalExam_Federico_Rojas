import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.inside.DeleteProfilePage;
import pages.inside.EspnProfilePage;
import pages.inside.UserPage;
import pages.outside.LoginPage;

public class TestDeleteProfile extends TestBase
{
    private UserPage userPage;

    @BeforeMethod
    public void beforeMethodLogIn()
    {
        System.out.println("before method");
        this.getWelcomePage().goToOptions();
        LoginPage loginPage = this.getWelcomePage().goToLogin();
        userPage = loginPage.doLogin("tester2@yopmail.com", "12345qwerty");
    }

    @Test
    public void deleteAccount()
    {
        this.userPage.goToProfileOptions();
        EspnProfilePage espnProfilePage = this.userPage.goToEspnProfile();
        DeleteProfilePage dp = espnProfilePage.goToDeleteProfile();
        System.out.println(dp.getTitle());
        dp.deleteAccount();
        log.info("DELETE ACCOUNT TEST FINISHED");
    }
}
