package pages.outside;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class WelcomePage extends BasePage
{

    @FindBy(css = "#global-user-trigger")
    private WebElement accessButton;
    @FindBy(css = ".tools .account-management li:nth-child(7)>a")
    private WebElement loginButton;
    @FindBy(css = ".tools .account-management li:nth-child(1)")
    private WebElement welcomeLabel;
    @FindBy(css = "#global-viewport")
    private WebElement globalViewport;

    public WelcomePage(WebDriver webDriver, String url) {
        super(webDriver);
        this.getDriver().get(url);
    }


    public WelcomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void goToOptions()
    {
        this.waitToVisibility(accessButton);
        Actions action = new Actions(this.getDriver());
        action.moveToElement(accessButton).perform();
    }

    public LoginPage goToLogin()
    {
        this.waitToBeClickeable(loginButton);
        this.loginButton.click();
        return new LoginPage(this.getDriver());
    }

    public String getWelcomeLabel()
    {
        return this.welcomeLabel.getText();
    }

    public void waitForGlobalViewPort()
    {
        waitToVisibility(globalViewport);
    }

}
