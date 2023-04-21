import java.util.ArrayList;

public class Character {
    protected String name;
    protected int lives;
    protected int goldCoins;
    protected int speed;
    protected ArrayList<String> objects;
    protected int positionX;
    protected int positionY;

    public Character(String name, int lives, int goldCoins, int speed, ArrayList<String> objects, int positionX, int positionY) {
        this.name = name;
        this.lives = lives;
        this.goldCoins = goldCoins;
        this.speed = speed;
        this.objects = objects;
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
