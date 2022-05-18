package config;

import java.net.MalformedURLException;
import java.time.Duration;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import helper.Constant;

public class Base {

    protected static RemoteWebDriver redrive;
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
        System.setProperty(Constant.WEBDRIVER_CHROME, Constant.CHROME_PATH);
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    // public void getRemoteDriver(){
    //     DesiredCapabilities caps = new DesiredCapabilities();

    // }

    private static void getFirefoxDriver(){
        System.out.println("Firefox");
    }
}
