import org.testng.annotations.Test;
import pages.outside.LoginPage;

public class TestSuite extends TestBase
{

    @Test(priority = 0)
    public void login()
    {
        LoginPage loginPage = getInitialPage().goToLogin();
        loginPage.doLogin("tester1@yopmail.com", "12345qwerty");
        System.out.println("Im here");
    }
}
