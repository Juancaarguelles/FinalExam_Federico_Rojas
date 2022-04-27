package pages.inside;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class UserPage extends BasePage
{

    @FindBy(css = "#global-user-trigger")
    private WebElement accessButton;

    public UserPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToProfileOptions()
    {
        this.waitToVisibility(accessButton);
        Actions action = new Actions(this.getDriver());
        action.moveToElement(accessButton).perform();
        System.out.println("done by now");
    }
}
