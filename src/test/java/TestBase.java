import org.testng.annotations.*;
import pages.outside.WelcomePage;
import utils.driver.Driver;
import utils.listener.Listener;

public class TestBase
{
    private Driver driver;
    private WelcomePage welcomePage;
    private Listener listener;

    @BeforeTest
    @Parameters({"chrome-browser", "url"})
    public void beforeTest(String chrome, String url)
    {
        this.driver = new Driver(chrome);
        this.driver.getDriver().manage().window().maximize();
        this.welcomePage = new WelcomePage(this.driver.getDriver(), url);
        this.listener = new Listener();
    }

    @AfterTest
    public void afterTest()
    {
        //this.initialPage.dispose();
    }

    public Driver getDriver()
    {
        return this.driver;
    }

    public WelcomePage getWelcomePage()
    {
        return this.welcomePage;
    }

    public Listener getListener()
    {
        return this.listener;
    }

}
