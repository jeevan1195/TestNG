package Pages;

import Base.Base;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;

public class ContactsPage extends Base{
    public ContactsPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class=\"ui warning message\"]")
    WebElement errorMessage;

    public String errorMessage() {
        return errorMessage.getText();
    }

}
