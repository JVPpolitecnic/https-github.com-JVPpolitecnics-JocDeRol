import javax.swing.*;
import java.awt.*;

public class GameVisuals {

    public static JLabel getArrowRight(boolean clicked){
        JLabel arrw_righy = new JLabel();
        arrw_righy.setSize(50,35);
        ImageIcon arrow_red = new ImageIcon("src/img/dungeon/arrow_right_red.png");
        Icon icon_red = new ImageIcon(arrow_red.getImage().getScaledInstance(arrw_righy.getWidth(), arrw_righy.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon arrow_white = new ImageIcon("src/img/dungeon/arrow_right.png");
        Icon icon_white = new ImageIcon(arrow_white.getImage().getScaledInstance(arrw_righy.getWidth(), arrw_righy.getHeight(), Image.SCALE_DEFAULT));
        if (clicked){
            arrw_righy.setIcon(icon_red);
        } else {
            arrw_righy.setIcon(icon_white);
        }
        return arrw_righy;
    }
    public static JLabel getArrowLeft(boolean clicked){
        JLabel arrw_left = new JLabel();
        arrw_left.setSize(50,35);
        ImageIcon arrow_red = new ImageIcon("src/img/dungeon/arrow_left_red.png");
        Icon icon_red = new ImageIcon(arrow_red.getImage().getScaledInstance(arrw_left.getWidth(), arrw_left.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon arrow_white = new ImageIcon("src/img/dungeon/arrow_left.png");
        Icon icon_white = new ImageIcon(arrow_white.getImage().getScaledInstance(arrw_left.getWidth(), arrw_left.getHeight(), Image.SCALE_DEFAULT));
        if (clicked){
            arrw_left.setIcon(icon_red);
        } else {
            arrw_left.setIcon(icon_white);
        }
        return arrw_left;
    }
public static JLabel heart(boolean full_heart){
    JLabel heart = new JLabel();
        heart.setSize(30,30);
    ImageIcon image_full_heart = new ImageIcon("src/img/heart_full.png");
    Icon icon_full_heart = new ImageIcon(image_full_heart.getImage().getScaledInstance(heart.getWidth(), heart.getHeight(), Image.SCALE_DEFAULT));
    ImageIcon image_empty_heart = new ImageIcon("src/img/heart_empty.png");
    Icon icon_empty_heart = new ImageIcon(image_empty_heart.getImage().getScaledInstance(heart.getWidth(), heart.getHeight(), Image.SCALE_DEFAULT));
    if (full_heart){
        heart.setIcon(icon_full_heart);
    } else {
        heart.setIcon(icon_empty_heart);
    }

return heart;
    }

    public static JLabel getCharachter(int for_Character_option, int size) {

        JLabel selectChar = new JLabel();
        selectChar.setSize(new Dimension(size, size));
        ImageIcon imageWizard = new ImageIcon("src/img/wizard/wizard_down.gif");
        Icon icon_wizard = new ImageIcon(imageWizard.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon imageWarrior = new ImageIcon("src/img/warrior/warrior_down.gif");
        Icon icon_warrior = new ImageIcon(imageWarrior.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon imagePriest = new ImageIcon("src/img/priest/priest_down.gif");
        Icon icon_priest = new ImageIcon(imagePriest.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        if (for_Character_option == 1) {
            selectChar.setIcon(icon_wizard);

        } else if (for_Character_option <= 0) {
            selectChar.setIcon(icon_warrior);
        } else if (for_Character_option >= 2) {
            selectChar.setIcon(icon_priest);


        }

return selectChar;
    }
    public static Icon getIconMovingGIF(int for_Character_option, int size, String direction) {
        Icon iconToReturn = new ImageIcon();
        JLabel selectChar = new JLabel();
        selectChar.setSize(new Dimension(size, size));
    if (direction.toUpperCase().equals("LEFT")) {

    ImageIcon imageWizard = new ImageIcon("src/img/wizard/wizard_left.gif");
    Icon icon_wizard = new ImageIcon(imageWizard.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

    ImageIcon imageWarrior = new ImageIcon("src/img/warrior/warrior_left.gif");
    Icon icon_warrior = new ImageIcon(imageWarrior.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

    ImageIcon imagePriest = new ImageIcon("src/img/priest/priest_left.gif");
    Icon icon_priest = new ImageIcon(imagePriest.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

    if (for_Character_option == 1) {
        iconToReturn = icon_wizard;

    } else if (for_Character_option <= 0) {
      iconToReturn = icon_warrior;
    } else if (for_Character_option >= 2) {
       iconToReturn = icon_priest;


    }
} else if (direction.toUpperCase().equals("UP")) {
        ImageIcon imageWizard = new ImageIcon("src/img/priest/priest_up.gif");
        Icon icon_wizard = new ImageIcon(imageWizard.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon imageWarrior = new ImageIcon("src/img/warrior/warrior_up.gif");
        Icon icon_warrior = new ImageIcon(imageWarrior.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon imagePriest = new ImageIcon("src/img/priest/priest_up.gif");
        Icon icon_priest = new ImageIcon(imagePriest.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        if (for_Character_option == 1) {
            iconToReturn = icon_wizard;

        } else if (for_Character_option <= 0) {
            iconToReturn = icon_warrior;
        } else if (for_Character_option >= 2) {
            iconToReturn = icon_priest;


        }

    } else if (direction.toUpperCase().equals("DOWN")) {
        ImageIcon imageWizard = new ImageIcon("src/img/priest/priest_down.gif");
        Icon icon_wizard = new ImageIcon(imageWizard.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon imageWarrior = new ImageIcon("src/img/warrior/warrior_down.gif");
        Icon icon_warrior = new ImageIcon(imageWarrior.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon imagePriest = new ImageIcon("src/img/priest/priest_down.gif");
        Icon icon_priest = new ImageIcon(imagePriest.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        if (for_Character_option == 1) {
            iconToReturn = icon_wizard;

        } else if (for_Character_option <= 0) {
            iconToReturn = icon_warrior;
        } else if (for_Character_option >= 2) {
            iconToReturn = icon_priest;


        }
    }else if (direction.toUpperCase().equals("RIGHT")) {
        ImageIcon imageWizard = new ImageIcon("src/img/priest/priest_right.gif");
        Icon icon_wizard = new ImageIcon(imageWizard.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon imageWarrior = new ImageIcon("src/img/warrior/warrior_right.gif");
        Icon icon_warrior = new ImageIcon(imageWarrior.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon imagePriest = new ImageIcon("src/img/priest/priest_right.gif");
        Icon icon_priest = new ImageIcon(imagePriest.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        if (for_Character_option == 1) {
            iconToReturn = icon_wizard;

        } else if (for_Character_option <= 0) {
            iconToReturn = icon_warrior;
        } else if (for_Character_option >= 2) {
            iconToReturn = icon_priest;


        }
    }

        return iconToReturn;
    }
    public static void placeTiles(JPanel panel){
        JLabel floorTile = new JLabel();
        Dimension dimen = new Dimension(32, 32);
        floorTile.setSize(dimen);
        ImageIcon image_floor = new ImageIcon("src/img/dungeon/tile001.png");
        Icon icon_floor = new ImageIcon(image_floor.getImage().getScaledInstance(floorTile.getWidth(), floorTile.getHeight(), Image.SCALE_DEFAULT));
        floorTile.setIcon(icon_floor);
        JLabel[] floorTileArray = new JLabel[37];
        for (int i = 0; i < floorTileArray.length; i++) {
            floorTileArray[i] = floorTile;
        }

        //place tiles
        int x = 0;
        int y = 0;
        for (int i = 0; i < panel.getWidth(); i += 32) {

            for (int j = 0; j < panel.getHeight(); j += 32) {
                floorTile = new JLabel();
                floorTile.setSize(dimen);
                floorTile.setIcon(icon_floor);
                floorTile.setLocation(i, j);
                panel.add(floorTile);

            }
        }

    }



}
