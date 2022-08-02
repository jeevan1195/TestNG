package TestCases;

import Base.Base;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends Base {

    HomePage homePage;
    LoginPage loginPage;

    public HomePageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setup() throws IOException {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        loginPage.login(properties.getProperty("username"),properties.getProperty("password"));

    }

    @Test
    public void homePageUserNameTest() {
       String userName = homePage.getUserName();
       Assert.assertEquals(userName,"Jeevan R");
    }

    @Test
    public void searchTest() {
        homePage.enterSearchText("Jeevan");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
