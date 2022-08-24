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
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments(
                    "--incognito",
                    "--ignore-ssl-errors=yes",
                    "--ignore-certificate-errors",
                    "--headless",
                    "--window-size=1325x744"
                );
                driver = new ChromeDriver(options);
                break;

            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "Safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
                
            default:
                throw new RuntimeException("Unsupported Browser : " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(4));

        switch (appURL) {
            case "PDS":
                driver.get(dotenv.get("PDS_BASEURL"));
                break;

            case "PCC":
                driver.get(dotenv.get("PCC_BASEURL"));
                break;

            case "PAMEDI":
                driver.get(dotenv.get("PAMEDI_BASEURL"));
                break;
        
            default:
                throw new RuntimeException("Unsupported Environtment : " + appURL);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(4));

        return driver;
    }
}
