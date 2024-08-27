package com.telegram.chatbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramChatbot extends MultiSessionTelegramBot {
    public static final String NAME = "USUARIO";
    public static final String TOKEN = "TOKEN";

    public TelegramChatbot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if (getMessageText().equals("/start")) {
            sendTextMessageAsync("Hola _futuro_ *programador* " + update.getMessage().getFrom().getFirstName());
        }

        if(getMessageText().contains("hola".toLowerCase())){
            sendTextMessageAsync("Hola, ¿Cual es tu nombre?");
        }

        if(getMessageText().contains("mi nombre es".toLowerCase()) || getMessageText().contains("me llamo".toLowerCase())){
            sendTextMessageAsync("Encantado de conocerte, soy Gato :)");
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new TelegramChatbot());
    }
}
