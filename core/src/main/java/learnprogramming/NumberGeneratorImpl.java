package learnprogramming;

import java.awt.image.AffineTransformOp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
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
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

    @Override
    public int getMinNumber() { return minNumber; }
}
