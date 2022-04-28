import org.testng.annotations.*;
import org.testng.log4testng.Logger;
import pages.outside.AccessPage;
import pages.outside.SignUpPage;
import pages.outside.WelcomePage;
import utils.data.Data;
import utils.driver.Driver;

public class TestBase
{
    private Driver driver;
    private WelcomePage welcomePage;
    protected Logger log = Logger.getLogger(TestBase.class);

    @BeforeSuite
    @Parameters({"chrome-browser", "url"})
    public void beforeSuite(String chrome, String url)
    {
        this.driver = new Driver(chrome);
        this.driver.getDriver().manage().window().maximize();
        this.welcomePage = new WelcomePage(this.getDriver().getDriver(), url);
        generateAccount();
    }

    @BeforeTest
    @Parameters({"chrome-browser","url"})
    public void beforeTest(String chrome, String url)
    {
        this.driver = new Driver(chrome);
        //this.driver.getDriver().manage().window().maximize();
        this.welcomePage = new WelcomePage(this.getDriver().getDriver(), url);
    }

    private void generateAccount()
    {
        this.getWelcomePage().goToOptions();
        AccessPage accessPage = this.getWelcomePage().goToAccess();
        SignUpPage signUpPage = accessPage.goToSignUp();
        Data.generateEmail();
        signUpPage.createProfile(Data.name, Data.lastName, Data.email, Data.password);
    }

    @AfterSuite
    @Parameters("url")
    public void afterTest(String url)
    {
        this.welcomePage.dispose();
    }


    public Driver getDriver()
    {
        return this.driver;
    }

    public WelcomePage getWelcomePage()
    {
        return this.welcomePage;
    }

    public void setWelcomePage(WelcomePage welcomePage)
    {
        this.welcomePage = welcomePage;
    }
}
