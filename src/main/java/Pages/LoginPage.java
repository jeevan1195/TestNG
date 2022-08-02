package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;

public class LoginPage extends Base {

    public LoginPage() throws IOException {

        PageFactory.initElements(driver , this); // this indicates current class object i.e. LoginPage.class
    }


    @FindBy(xpath="//input[@name='email']")
    WebElement username;

    @FindBy(xpath="//input[@name='password']")
    WebElement password;

    @FindBy(xpath="//div[@class=\"ui fluid large blue submit button\"]")
    WebElement loginBtn;

    @FindBy(xpath="//button[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath="//div[@class=\"header item\"]")
    WebElement crmLogo;

    public String getPageTitle() {
        return driver.getTitle();
    }

    public Boolean crmLogo() {
        return crmLogo.isDisplayed();
    }

    public void login(String username , String passwrod) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.username.sendKeys(username);
        this.password.sendKeys(passwrod);
        loginBtn.click();
    }
}
