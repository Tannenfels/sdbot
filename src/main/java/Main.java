import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.*;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    private boolean verboseLoggingMode;
    private TextChannel logChannel;

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getAuthor().isBot()){
            return;
        }

        JDA jda = event.getJDA();
        long responseNumber = event.getResponseNumber();

        User author = event.getAuthor();
        Message message = event.getMessage();
        String msg = message.getContentDisplay();

        if(msg.startsWith("!sdbot start")){

        }else if(msg.startsWith("!sdbot verbose")){
            if (verboseLoggingMode){
                verboseLoggingMode = false;
                return;
            }
            verboseLoggingMode = true;
        }
    }

    public static void main(String[] args) throws LoginException {
        try {
            String token = "";
            JDA jda = new JDABuilder(token).addEventListeners(new Main()).build();
            jda.awaitReady();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
