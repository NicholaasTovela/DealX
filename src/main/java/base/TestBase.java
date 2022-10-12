package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
                    + "/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"/src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("Edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();

        driver.get(prop.getProperty("url"));
    }

}
