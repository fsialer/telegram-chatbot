package com.telegram.chatbot;

import java.util.Map;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import static com.telegram.chatbot.TelegramBotContent.STEP_1_TEXT;
import static com.telegram.chatbot.TelegramBotContent.STEP_2_TEXT;
import static com.telegram.chatbot.TelegramBotContent.STEP_3_TEXT;
import static com.telegram.chatbot.TelegramBotContent.STEP_4_TEXT;
import static com.telegram.chatbot.TelegramBotContent.STEP_5_TEXT;
import static com.telegram.chatbot.TelegramBotContent.STEP_6_TEXT;
import static com.telegram.chatbot.TelegramBotContent.STEP_7_TEXT;
import static com.telegram.chatbot.TelegramBotContent.STEP_8_TEXT;
import static com.telegram.chatbot.TelegramBotContent.FINAL_TEXT;

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
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("¡Tomar una salchicha! +20 de fama", "step_2_btn",
                            "¡Tomar un pescado! +20 de fama", "step_2_btn",
                            "Tirar un lata de pepinillos! +20 de fama", "step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Romper al robot aspiradora", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspirador a por comida! +30 de fama", "step_4_btn",
                            "Dar un paseo en el robot aspirador! +30 de fama", "step_4_btn",
                            "Huir del robot aspirador! +30 de fama", "step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Poner y encender Gopro!! +30 de fama", "step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            setUserGlory(20);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Un paseo al parque!+20 de fama", "step_6_btn",
                            "Una visita al veterinario!+20 de fama", "step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            setUserGlory(20);
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackear contraseña!+20 de fama", "step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Ver final épico!!", "step_8_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(FINAL_TEXT);
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new TelegramChatbot());
    }
}
