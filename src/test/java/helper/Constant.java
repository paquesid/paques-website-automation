package helper;

import io.github.cdimascio.dotenv.Dotenv;

public interface Constant {
    Dotenv dotenv = Dotenv.load();
    String CHROME_PATH = dotenv.get("CHROME_PATH");
    String WEBDRIVER_CHROME = dotenv.get("WEBDRIVER_CHROME");
    String USERNAME = dotenv.get("USERNAME");
    String PASSWORD = dotenv.get("PASSWORD");
    String CHROME = "Chrome";
    String PRODUCTION = "Production";
    String SRC_TEST_RESOURCES = System.getProperty("user.dir") + "/src/test/resources";
    String ELEMENTS = SRC_TEST_RESOURCES + "/elements/homepage.properties";
}