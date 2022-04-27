package pages.outside;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPage extends BasePage
{
    @FindBy(css = ".field-group .field-username-email .input-wrapper>input")
    private WebElement emailInput;
    @FindBy(css = ".field-group .field-password .input-wrapper>input")
    private WebElement passwordInput;
    @FindBy(css = ".touch-print-btn-group-wrapper .btn-submit")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        this.getDriver().switchTo().frame("disneyid-iframe");
    }

    public void doLogin(String email, String password)
    {
        this.waitToVisibility(emailInput);
        this.emailInput.click();
        this.emailInput.sendKeys(email);

        this.passwordInput.click();
        this.passwordInput.sendKeys(password);

        this.submitButton.click();

    }
}
