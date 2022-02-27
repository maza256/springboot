package learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator{

    private final Game game;

    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == init ==
    @PostConstruct
    public void reset() {
        log.debug("M: Game is: {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()) {
            return "You've won! Number was " + game.getNumber();
        } else if(game.isGameLost()) {
            return "You've lost! Number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "You're guess outside of the valid range" + getMainMessage();
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is the first guess?";
        } else {
            String direction = "Lower";
            if(game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
        }
    }

}
