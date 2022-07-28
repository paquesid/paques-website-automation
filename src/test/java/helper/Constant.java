package helper;

import io.github.cdimascio.dotenv.Dotenv;

public interface Constant {
    Dotenv dotenv = Dotenv.load();
    String CHROME_PATH = dotenv.get("CHROME_PATH");
    String WEBDRIVER_CHROME = dotenv.get("WEBDRIVER_CHROME");

    // Credentials
    String USERNAME = dotenv.get("PDS_NONADMIN_USERNAME");
    String PASSWORD = dotenv.get("PDS_NONADMIN_PASSWORD");
    String CHROME = "Chrome";

    // Telegram
    String TELEGRAM_TOKEN = dotenv.get("TELEGRAM_TOKEN");
    String TELEGRAM_CHATID = dotenv.get("TELEGRAM_ID_CHANNEL_PAQUES_BOT");
    String TELEGRAM_BASEURL = dotenv.get("TELEGRAM_BASEURL");
    
    // Environtment
    String PRODUCTION = "Production";

    String SRC_TEST_RESOURCES = System.getProperty("user.dir") + "/src/test/resources";
    String ELEMENTS = SRC_TEST_RESOURCES + "/elements/homepage.properties";
}