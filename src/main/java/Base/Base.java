package Base;

import Util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Base {

   public static WebDriver driver;
   public static Properties properties;
   public static EventFiringDecorator e_driver;
   public static WebEventListener eventListener;


    public Base() throws IOException {

        properties = new Properties();
        FileInputStream inputStream = new FileInputStream("C:\\Users\\91776\\Documents\\TestNG\\FirstFrameWork\\src\\main\\java\\Config\\properties");
        properties.load(inputStream);

    }

    public static void initialization() throws IOException {

        String browserName =  properties.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\91776\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty("url"));

    }


}
