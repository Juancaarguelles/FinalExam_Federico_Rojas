import pages.InitialPage;
import utils.Driver;

public class Main
{
    public static void main(String[] args) {
        String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        Driver driver = new Driver("chrome");
        driver.getDriver().manage().window().maximize();
        InitialPage initialPage = new InitialPage(driver.getDriver(), url);

        initialPage.goToFirstMenu();
    }
}