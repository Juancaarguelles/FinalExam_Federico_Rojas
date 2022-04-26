package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class BasePage
{
    private WebDriver driver;
    private WebDriverWait wait;


    public BasePage(WebDriver webDriver)
    {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 20);
        this.driver = webDriver;
    }

    public WebDriver getDriver()
    {
        return this.driver;
    }

    public void dispose()
    {
        if(this.driver != null)
            this.driver.close();
    }

    public WebDriverWait getWait()
    {
        return this.wait;
    }

    public void waitToVisibility(WebElement webElement)
    {
        this.wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitToBeClickeable(WebElement webElement)
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
