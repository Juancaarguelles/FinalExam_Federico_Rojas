import org.testng.annotations.*;
import pages.InitialPage;
import utils.Driver;

public class TestBase
{
    private Driver driver;
    private  InitialPage initialPage;

    @BeforeTest
    @Parameters({"chrome-browser", "url"})
    public void beforeTest(String chrome, String url)
    {
        this.driver = new Driver(chrome);
        this.driver.getDriver().manage().window().maximize();
        this.initialPage = new InitialPage(this.driver.getDriver(), url);
    }


    @AfterTest
    public void afterTest()
    {
        //this.initialPage.dispose();
    }


    public InitialPage getInitialPage()
    {
        return this.initialPage;
    }

    public Driver getDriver()
    {
        return this.driver;
    }

}
