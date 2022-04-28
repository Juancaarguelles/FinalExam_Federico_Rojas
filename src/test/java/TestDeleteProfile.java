import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.inside.DeleteProfilePage;
import pages.inside.EspnProfilePage;
import pages.inside.UserPage;
import pages.outside.AccessPage;
import utils.data.Data;

public class TestDeleteProfile extends TestBase
{
    private UserPage userPage;

    @BeforeMethod
    public void beforeMethodLogIn()
    {
        this.getWelcomePage().goToOptions();
        AccessPage accessPage = this.getWelcomePage().goToAccess();
        userPage = accessPage.doLogin(Data.email, Data.password);
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
