# telegram-chatbot
Es un pequeño código que te ayudara entender como realizar un chatbot en telegram.

Pasos para crear el bot en telegram
- Primero busca en telegram el bot llamado **BotFather**.
- Una vez buscado digitar el comando **/start** o la opcion en la chat.
- Luego ingresar el comando **/newbot** para crear el bot, sigue las indicaciones que te aparezcan.
- Una vez creado el bot, te dara un usuario y token ,el cuál servira para poder autenticarte.
        public class TelegramChatbot extends MultiSessionTelegramBot {
- Por ultimo reemplazar el USUARIO y el TOKEN en el clase **TelegramChatbot.java** fragmento de código.

        public class TelegramChatbot extends MultiSessionTelegramBot {

        public static final String NAME = "USUARIO";
        public static final String TOKEN = "TOKEN";
        ...
        }

Pasos para compilar



- Compilar el proyecto

        mvn compile

- Ejecutar el codigo compilado

        mvn exec:java -Dexec.mainClass="com.telegram.chatbot.TelegramChatbot"