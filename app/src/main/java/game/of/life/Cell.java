package game.of.life;
import java.util.Random;

public class Cell {
    private final int state;
    Random random = new Random();

    public Cell() {
        this.state = random.nextInt(2); // 0 ---> Dead / 1 --->Alive
    }

    public int getState() {
        return state;
    }
}
