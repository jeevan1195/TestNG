package Pages;

import Base.Base;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;

public class HomePage extends Base {


    public HomePage() throws IOException {
        PageFactory.initElements(driver , this);
    }

    @FindBy(xpath="//span[contains(text(),'Jeevan R')]")
    WebElement userName;


    @FindBy(xpath="//input[@placeholder=\"Search\"]")
    WebElement searchBox;

    @FindBy(xpath = "//a[@href=\"/contacts\"]")
    WebElement contactsPage;


    public String getUserName() {
        return userName.getText();
    }

    public void enterSearchText(String searchText) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void checkContactsPage() {
        contactsPage.click();
    }

}
