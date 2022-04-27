package pages.inside;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class DeleteProfilePage extends BasePage
{
    @FindBy(css = ".main .workflow-deactivate .btn-group .btn-primary")
    private WebElement confirmButton;

    public DeleteProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void deleteAccount()
    {
        this.waitToBeClickeable(confirmButton);
        this.confirmButton.click();
    }

    public String getTitle()
    {
        return this.confirmButton.getText();
    }


}
