import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.InitialPage;

public class TestSuite extends TestBase
{

    @Test(priority = 0)
    public void login()
    {
        getInitialPage().goToFirstMenu();
        System.out.println("Im here");
    }
}
