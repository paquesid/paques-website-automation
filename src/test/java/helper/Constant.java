package helper;

import io.github.cdimascio.dotenv.Dotenv;

public interface Constant {
    Dotenv dotenv = Dotenv.load();
    String CHROME_PATH = dotenv.get("CHROME_PATH");
    String WEBDRIVER_CHROME = dotenv.get("WEBDRIVER_CHROME");

    // Credentials
    String USERNAME = dotenv.get("PDS_USERNAME");
    String PASSWORD = dotenv.get("PDS_PASSWORD");
    String CHROME = "Chrome";
    
    // Environtment
    String PRODUCTION = "Production";

    String SRC_TEST_RESOURCES = System.getProperty("user.dir") + "/src/test/resources";
    String ELEMENTS = SRC_TEST_RESOURCES + "/elements/homepage.properties";
}