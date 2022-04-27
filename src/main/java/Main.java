import pages.outside.WelcomePage;
import utils.Driver;

public class Main
{
    public static void main(String[] args) {
        String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        Driver driver = new Driver("chrome");
        driver.getDriver().manage().window().maximize();
        WelcomePage initialPage = new WelcomePage(driver.getDriver(), url);

        initialPage.goToLogin();
    }
}