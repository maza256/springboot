package learnprogramming.console;

import learnprogramming.Game;
import learnprogramming.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    private final Game game;

    private final MessageGenerator messageGenerator;

    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == Events ==
    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEventStart() {   // instead of the eventlistener argument (ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Start --> Container ready for use");

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play Again? Y/N");
                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }
                game.reset();
            }

        }
    }
}
