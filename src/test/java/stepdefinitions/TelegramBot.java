package stepdefinitions;

import helper.TestInstrument;
import io.cucumber.java8.En;

public class TelegramBot extends TestInstrument implements En {
    
    public TelegramBot(){
        Given("^telegram send a message \"([^\"]*)\" every weekday$", (String message) -> {
            // paques.telegramStep().setTelegramForStandUp(message);
        });
    }
}