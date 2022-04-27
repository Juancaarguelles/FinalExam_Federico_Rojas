package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class InitialPage extends BasePage
{

    @FindBy(css = "#global-user-trigger")
    private WebElement accessButton;
    @FindBy(css = ".tools .account-management li:nth-child(7)>a")
    private WebElement loginButton;

    public InitialPage(WebDriver webDriver, String url) {
        super(webDriver);
        this.getDriver().get(url);
    }

    public void goToFirstMenu()
    {
        this.waitToVisibility(accessButton);
        Actions action = new Actions(this.getDriver());
        action.moveToElement(accessButton).perform();
        this.loginButton.click();
    }

}