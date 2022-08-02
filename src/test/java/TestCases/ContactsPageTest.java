package TestCases;

import Base.Base;
import Pages.ContactsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Util.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import java.io.IOException;

public class ContactsPageTest extends Base{
    public ContactsPageTest() throws IOException {
        super();
    }

    HomePage homePage;
    LoginPage loginPage;
    ContactsPage contactsPage;
    String sheetName = "Owner";
/*
    @BeforeMethod
    public void setup() throws IOException {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
    }
*/

    @Test
    public void verifyContactsPage() {
        homePage.checkContactsPage();
        String errorMessage = contactsPage.errorMessage();
        Assert.assertEquals(errorMessage ,"No records found");
    }

    @DataProvider
    public Object[][] getOwnerTestData()
    {
       Object data[][] = Utils.getTestData(sheetName);
       return data;
    }

    @DataProvider
    public Object[][] testData() {
        Object[][] result = new Object[2][3];
        result[0][0] = "One";
        result[0][1] = "two";
        result[0][2] = "three";
        result[1][0] = "four";
        result[1][1] = "four";
        result[1][2] = "four";

        return result;

    }

    @Test(dataProvider = "getOwnerTestData" )
    public void verifyTestDataFromExcel(String title, String name, String location) {

        System.out.println(title + name + location);

    }

    @Test(dataProvider = "testData" )
    public void verifyTestDataFromMethod(String name, String password, String third) {

        System.out.println(name + password + third);

    }
}
