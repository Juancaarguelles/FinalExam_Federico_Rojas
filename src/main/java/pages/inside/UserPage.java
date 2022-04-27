package pages.inside;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class UserPage extends BasePage
{

    @FindBy(css = "#global-user-trigger")
    private WebElement accessButton;
    @FindBy(css = ".tools .account-management li:nth-child(9)>a")
    private WebElement logoutButton;
    @FindBy(css = ".tools .account-management li:nth-child(1)")
    private WebElement welcomeLabel;

    public UserPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToProfileOptions()
    {
        this.waitToVisibility(accessButton);
        Actions action = new Actions(this.getDriver());
        action.moveToElement(accessButton).perform();
    }

    public void doLogout()
    {
        this.waitToBeClickeable(logoutButton);
        this.logoutButton.click();
        System.out.println("done until here!");
    }

    public String getWelcomeLabel()
    {
        return this.welcomeLabel.getText();
    }
}
