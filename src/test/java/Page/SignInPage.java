package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    @FindBy(xpath = "//button[contains(text(),'Sign in')][1]")
    public WebElement btnHomeSignIn;
    @FindBy(id = "username")
    WebElement txtEmail;
    @FindBy(id = "password")
    WebElement txtPassword;
    @FindBy(id = "kc-login")
    WebElement buttonSignIn;
    @FindBy(id = "input-error")
    WebElement invalidEmailOrPass;
    WebDriver driver;
    public SignInPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    public void homeSignIn() {
        btnHomeSignIn.click();
    }
    public void doLoginValidCreds(String email, String pass) throws InterruptedException {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(pass);
        buttonSignIn.click();
    }
    public void doLoginInValidCreds1() throws InterruptedException {
        txtEmail.sendKeys("afifa@yopmail.co");
        txtPassword.sendKeys("12345Qwer");
        buttonSignIn.click();
    }
    public void doLoginInValidCreds2() throws InterruptedException {
        txtEmail.sendKeys("afifa@yopmail.com");
        txtPassword.sendKeys("12345qwer");
        buttonSignIn.click();
    }
}
