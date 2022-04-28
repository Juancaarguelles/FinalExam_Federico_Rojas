package pages.outside;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.inside.UserPage;

public class AccessPage extends BasePage
{
    @FindBy(css = ".field-group .field-username-email .input-wrapper>input")
    private WebElement emailInput;
    @FindBy(css = ".field-group .field-password .input-wrapper>input")
    private WebElement passwordInput;
    @FindBy(css = ".touch-print-btn-group-wrapper .btn-submit")
    private WebElement loginButton;
    @FindBy(css = "#did-ui .main .workflow-new .section-primary .btn-group-create-account>a")
    private WebElement signUpButton;

    public AccessPage(WebDriver webDriver) {
        super(webDriver);
        this.getDriver().switchTo().frame("disneyid-iframe");
    }

    public UserPage doLogin(String email, String password)
    {
        this.waitToVisibility(emailInput);
        this.emailInput.click();
        this.emailInput.sendKeys(email);

        this.passwordInput.click();
        this.passwordInput.sendKeys(password);

        this.loginButton.click();
        return new UserPage(this.getDriver());
    }

    public SignUpPage goToSignUp()
    {
        this.waitToVisibility(signUpButton);
        this.signUpButton.click();
        return new SignUpPage(this.getDriver());
    }
}
