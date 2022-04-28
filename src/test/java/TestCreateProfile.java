import org.testng.annotations.Test;
import pages.inside.UserPage;
import pages.outside.AccessPage;
import pages.outside.SignUpPage;

public class TestCreateProfile extends TestBase
{
    private UserPage userPage;

    @Test
    public void createAccount()
    {
        this.getWelcomePage().goToOptions();
        AccessPage accessPage = this.getWelcomePage().goToAccess();
        SignUpPage signUpPage = accessPage.goToSignUp();
        signUpPage.getInputFields();
    }
}
