import java.util.ArrayList;

public class Priest extends Character {
    private String charachterType;

    public Priest(String name, int lives, int goldCoins, int speed, String direction, ArrayList<String> objects, int positionX, int positionY, String charachterType) {
        super(name, lives, goldCoins, speed, direction, objects, positionX, positionY);
        this.charachterType = "priest";
    }
}
