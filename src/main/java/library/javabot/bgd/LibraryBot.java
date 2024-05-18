package library.javabot.bgd;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
public class LibraryBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
       return "library_ldubgd_bot";
    }

    @Override
    public String getBotToken() {
        return "5957300741:AAGg2Gvdb2lDJWTPG6Zu5Ibq3r3oWRBZHEo";
    }

    @Override
    public void onUpdateReceived(Update update) {

    }
}
