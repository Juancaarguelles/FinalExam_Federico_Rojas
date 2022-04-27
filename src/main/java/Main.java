import pages.inside.UserPage;
import pages.outside.LoginPage;
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
        System.out.println("Before logging in: "+main.welcomePage.getWelcomeText());
        LoginPage lp = main.welcomePage.goToLogin();
        UserPage up = lp.doLogin("tester1@yopmail.com", "12345qwerty");
        up.goToProfileOptions();
        System.out.println("After loggin in: "+up.getWelcomeLabel());
        up.doLogout();

    }
}