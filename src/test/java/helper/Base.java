package helper;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.dns.AdvancedHostResolver;

import org.openqa.selenium.Proxy;
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
                options.addArguments("--incognito", "--headless", "--window-size=1325x744"); // "--headless", "--window-size=1325x744"
                options.setAcceptInsecureCerts(true);
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
            case "Dev":
                driver.get(dotenv.get("ENV_DEV"));
                break;

            case "Staging":
                driver.get(dotenv.get("ENV_STAGING"));
                break;

            case "Production":
                driver.get(dotenv.get("PDS_BASEURL"));
                break;

            case "PCC_DEV":
                driver.get(dotenv.get("PCC_BASEURL"));
        
            default:
                throw new RuntimeException("Unsupported Environtment : " + appURL);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(4));

        return driver;
    }

    public static void setUpBrowserChrome(WebDriver driver){
        //Create Map of original hostname, remapped hostname
        Map<String, String> hostRemappings  = new HashMap<String, String>();
        hostRemappings.put("192.168.210.170", "dev.paques.dev");

        BrowserMobProxy browserMobProxy = new BrowserMobProxyServer();

        //will be using Java DNS host resolver.
        AdvancedHostResolver advancedHostResolver = ClientUtil.createNativeResolver();

        //clear existing DNS cache and host remapping.
        advancedHostResolver.clearDNSCache();
        advancedHostResolver.clearHostRemappings();

        //remapped host entries with our new one. Pointing to secondary server.
        advancedHostResolver.remapHosts(hostRemappings);

        //set host name resolver and start proxy server.
        browserMobProxy.setHostNameResolver(advancedHostResolver);
        browserMobProxy.start(0);

        //get the Selenium proxy object using browserMobProxy
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(browserMobProxy);

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // "--headless", "--window-size=1325x744"
        options.setProxy(seleniumProxy);
        driver = new ChromeDriver(options);
    }
}
