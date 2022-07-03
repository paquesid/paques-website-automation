package telegram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.json.JSONObject;
import org.testng.Assert;

import helper.Constant;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TelegramStep implements Constant {
    
    protected WebDriver driver;

    public TelegramStep(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
    
    public void setTelegramForStandUp(String standup) {

        if(standup.equalsIgnoreCase("dailyStandUp")){
            RestAssured.baseURI = TELEGRAM_BASEURL;
            RequestSpecification request = RestAssured.given();

            JSONObject params = new JSONObject();
            params.put("chat_id", TELEGRAM_CHATID);
            params.put("text", 
            "**Halo @channel!**, Don't forget to post your standup for today by making a reply in this thread. \n \n" + 
            "Make sure to include :" + 
            "   - **Your health status** \n" +
            "   - **What you worked on yesterday** \n" +
            "   - **What you plan on working today** \n" +
            "   - **Any blocker or help needed?**"
            );
            params.put("disable_notification", false);

            request.header(
                "Content-Type", "application/json");
                
            request.body(params.toString());
            Response response = request.post(
                "/bot"+ TELEGRAM_TOKEN +"/sendMessage");

            Assert.assertEquals(response.getStatusCode(), 200);

        } else {
            throw new Error("please check your bot!");
        }
    }
}
