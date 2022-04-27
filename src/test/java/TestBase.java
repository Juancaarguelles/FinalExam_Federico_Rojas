import org.testng.annotations.*;
import pages.outside.WelcomePage;
import utils.Driver;

public class TestBase
{
    private Driver driver;

    @BeforeTest
    @Parameters({"chrome-browser"})
    public void beforeTest(String chrome)
    {
        this.driver = new Driver(chrome);
        this.driver.getDriver().manage().window().maximize();
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

}
