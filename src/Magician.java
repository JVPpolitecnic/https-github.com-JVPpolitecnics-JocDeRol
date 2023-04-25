import java.util.ArrayList;

public class Magician extends Character {

    private String charachterType;

    public Magician(String name, int lives, int goldCoins, int speed, ArrayList<String> objects, int positionX, int positionY, String charachterType) {
        super(name, lives, goldCoins, speed, objects, positionX, positionY);
        this.charachterType = "magician";
    }
}
