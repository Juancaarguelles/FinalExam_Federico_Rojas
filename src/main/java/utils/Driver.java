package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver
{
    private WebDriver driver;

    public Driver(String webBrowser)
    {
        switch (webBrowser.toLowerCase())
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                /*
                System.out.println();
                this.driver = new FirefoxDriver();
                 */
                break;

        }
    }

    public WebDriver getDriver()
    {
        return this.driver;
    }
}
