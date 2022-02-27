package learnprogramming;

import java.awt.image.AffineTransformOp;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

    private final int maxNumber;
    private final int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int max, @MinNumber int min) {
        this.maxNumber = max;
        this.minNumber = min;
    }

    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

}
