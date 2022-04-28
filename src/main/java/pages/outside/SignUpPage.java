package pages.outside;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SignUpPage extends BasePage
{
    @FindBy(css = ".field-first-name .input-wrapper>input")
    private WebElement nameInput;
    @FindBy(css = ".field-last-name .input-wrapper>input")
    private WebElement lastNameInput;
    @FindBy(css = ".field-group .field-email .input-wrapper>input")
    private WebElement emailInput;
    @FindBy(css = ".field-group .field-new-password .input-wrapper>input")
    private WebElement passwordInput;
    @FindBy(css = ".section-submit .btn-group .btn-primary")
    private WebElement signUpButton;

    public SignUpPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public void createProfile(String name, String lastName, String email, String password)
    {
        waitToVisibility(nameInput);
        this.nameInput.click();
        this.nameInput.sendKeys(name);

        this.lastNameInput.click();
        this.lastNameInput.sendKeys(lastName);

        this.emailInput.click();
        this.emailInput.sendKeys(email);

        this.passwordInput.click();
        this.passwordInput.sendKeys(password);

        this.waitToBeClickeable(this.signUpButton);
        this.signUpButton.click();
    }

    public void getInputFields()
    {
        waitToVisibility(nameInput);
        System.out.println("name : "+this.nameInput.getAttribute("placeholder"));
        System.out.println("lastname : "+this.lastNameInput.getAttribute("placeholder"));
        System.out.println("email : "+this.emailInput.getAttribute("placeholder"));
        System.out.println("password : "+this.passwordInput.getAttribute("placeholder"));
        System.out.println("sign up : "+this.signUpButton.getText());
    }
}
