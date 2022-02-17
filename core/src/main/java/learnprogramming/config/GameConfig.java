package learnprogramming.config;

import learnprogramming.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "learnprogramming")
@PropertySource("classpath:config/application.properties")
public class GameConfig {
    // == Fields ==
    @Value("${game.maxNumber:20}")
    private int maxNumber;
    @Value("${game.guessCount:5}")
    private int guessCount;
    @Value("${game.minNumber:0}")
    private int minNumber;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int MaxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int getCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int getMinNumber() {
        return minNumber;
    }

}
