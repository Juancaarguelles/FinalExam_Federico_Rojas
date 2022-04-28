import pages.inside.EspnProfilePage;
import pages.inside.UserPage;
import pages.outside.AccessPage;
import pages.outside.WelcomePage;
import utils.driver.Driver;

public class Main
{
    private Driver driver;
    private String url;
    private WelcomePage welcomePage;

    public Main()
    {
        this.url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        this.driver = new Driver("chrome");
        this.driver.getDriver().manage().window().maximize();
        this.welcomePage = new WelcomePage(driver.getDriver(), url);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.welcomePage.goToOptions();
        System.out.println("Before logging in: "+main.welcomePage.getWelcomeLabel());
        AccessPage lp = main.welcomePage.goToAccess();
        UserPage up = lp.doLogin("tester1@yopmail.com", "123qwerty");
        up.goToProfileOptions();
        EspnProfilePage espnProfilePage = up.goToEspnProfile();
        espnProfilePage.findDeletebutton();
    }
}