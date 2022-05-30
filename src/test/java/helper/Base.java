package helper;

import java.net.MalformedURLException;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by Dika Brenda Angkasa on 23/05/2022
 */

public class Base {

    protected static Dotenv dotenv = Dotenv.load();

    public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) throws MalformedURLException {
        switch (browserName) {
            case "Chrome":
                WebDriverManager.chromedriver().config();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito", "--headless", "--window-size=1325x744"); // "--headless", "--window-size=1325x744"
                options.setAcceptInsecureCerts(true);
                driver = new ChromeDriver(options);
                break;

            case "Firefox":
                WebDriverManager.firefoxdriver().config();
                driver = new FirefoxDriver();
                break;

            case "Safari":
                WebDriverManager.safaridriver().config();
                driver = new SafariDriver();
                break;
                
            default:
                throw new RuntimeException("Unsupported Browser : " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(4));

        switch (appURL) {
            case "Dev":
                driver.get(dotenv.get("ENV_DEV"));
                break;

            case "Staging":
                driver.get(dotenv.get("ENV_STAGING"));
                break;

            case "Production":
                driver.get(dotenv.get("BASEURL"));
                break;
        
            default:
                throw new RuntimeException("Unsupported Environtment : " + appURL);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(4));

        return driver;
    }
}
