import org.testng.annotations.Test;
import pages.inside.UserPage;
import pages.outside.AccessPage;
import pages.outside.SignUpPage;
import utils.data.Data;

public class TestCreateProfile extends TestBase
{
    private UserPage userPage;

    @Test(dataProvider = "create_accounts", dataProviderClass = Data.class)
    public void createAccount(String name, String lastname, String email, String password)
    {
        this.getWelcomePage().goToOptions();
        AccessPage accessPage = this.getWelcomePage().goToAccess();
        SignUpPage signUpPage = accessPage.goToSignUp();
        signUpPage.createProfile(name, lastname, email, password);
    }
}
