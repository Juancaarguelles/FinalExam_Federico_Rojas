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
    @Parameters("chrome-browser")
    public void beforeTest(String chrome)
    {
        this.driver = new Driver(chrome);
    }

    @BeforeClass
    @Parameters({"chrome-browser","url"})
    public void beforeTest(String chrome, String url)
    {
        this.getDriver().getDriver().manage().window().maximize();
        this.welcomePage = new WelcomePage(this.getDriver().getDriver(), url);
        System.out.println("Before class");
    }

     @AfterClass
     public void afterClass()
     {
         this.welcomePage.dispose();
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
