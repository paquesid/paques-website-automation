package helper;

import java.net.MalformedURLException;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class Base {

    protected static WebDriver driver;
    protected static Dotenv dotenv = Dotenv.load();

    public static WebDriver startApplication(String browserName, String appURL) throws MalformedURLException {
        switch (browserName) {
            case "Chrome":
                getChromeDriver();
                break;

            case "Firefox":
                getFirefoxDriver();
                break;

            case "Safari":
                getSafariDriver();
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

    private static void getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--headless", "--window-size=1325x744"); // "--headless", "--window-size=1325x744"
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
    }

    private static void getFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private static void getSafariDriver(){
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
    }
}
