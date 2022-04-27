package pages.inside;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class EspnProfilePage extends BasePage
{

    @FindBy(css = "#cancel-account")
    private WebElement deleteButton;

    @FindBy(css = "#did-ui")
    private WebElement ui;


    public EspnProfilePage(WebDriver webDriver) {
        super(webDriver);
        this.getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("disneyid-iframe"));
    }

    public void findDeletebutton()
    {
        //((JavascriptExecutor) this.getDriver()).executeScript("window.scrollBy(0,850)", "");
    }

    public DeleteProfilePage goToDeleteProfile()
    {
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.deleteButton));

        int attempts = 0;

        while (attempts < 2)
        {
            try
            {
                this.getDriver().findElement(By.cssSelector("#cancel-account")).click();
                return new DeleteProfilePage(this.getDriver());
            }catch (StaleElementReferenceException ex)
            {
                System.out.println(ex.getMessage());
            }
            attempts++;
        }
        return null;
    }

    public String getDeleteButton()
    {
        return this.deleteButton.getText();
    }
}
