import org.testng.annotations.*;
import pages.outside.WelcomePage;
import utils.driver.Driver;
import utils.listener.Listener;

public class TestBase
{
    private Driver driver;
    private WelcomePage welcomePage;
    private Listener listener;

    @BeforeSuite
    @Parameters({"chrome-browser"})
    public void beforeSuite(String chrome)
    {
        this.driver = new Driver(chrome);
        this.driver.getDriver().manage().window().maximize();
        this.listener = new Listener();
    }

    @BeforeTest
    @Parameters("url")
    public void beforeTest(String url)
    {
        System.out.println("Before Test");
        this.welcomePage = new WelcomePage(this.driver.getDriver(), url);
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
