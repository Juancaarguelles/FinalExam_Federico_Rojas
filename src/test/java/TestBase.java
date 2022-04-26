import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.InitialPage;
import utils.Driver;

public class TestBase
{
    private Driver driver;
    private InitialPage initialPage;

    @BeforeTest
    public void setup()
    {
        this.driver = new Driver("chrome");
        this.driver.getDriver().manage().window().maximize();
        //this.initialPage = new InitialPage()

    }

    @AfterTest
    public void afterTest()
    {
        this.initialPage.dispose();
    }
}
