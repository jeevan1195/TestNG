package TestCases;

import Base.Base;
import Listener.CustomListener;
import Pages.LoginPage;
import Util.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(CustomListener.class)
public class LoginPageTest extends Base {
    LoginPage loginPage;


    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setup() throws IOException {
        initialization();
        loginPage =new LoginPage();

    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
       String title = loginPage.getPageTitle();

       Assert.assertEquals(title ,"Cogmento CRM1");
    }

    @Test(priority = 2)
    public void loginTest() {
        loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
