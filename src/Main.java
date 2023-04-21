import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {
    private JPanel panelMain;
    public JPanel panelFirst;

    public JButton buttonEnterGame;
    public JPanel panelTop;
    public Timer enemyTimer;
    public Timer characterTimer;
    public JLabel heart;
    public JLabel heart2;
    public JLabel heart3;

    public JLabel floorTile;

    public JLabel selectChar;
    public int characterOption;

    public JLabel[] floorTileArray;

    public Main() {

        // Wall and floor textures
        floorTile = new JLabel();
        Dimension dimen = new Dimension(32, 32);
        floorTile.setSize(dimen);
        ImageIcon image_floor = new ImageIcon("src/img/dungeon/tile001.png");
        Icon icon_floor = new ImageIcon(image_floor.getImage().getScaledInstance(floorTile.getWidth(), floorTile.getHeight(), Image.SCALE_DEFAULT));
        floorTile.setIcon(icon_floor);
        // buttons
        buttonEnterGame = new JButton();
        buttonEnterGame.setText("Enter game");
        buttonEnterGame.setLayout(null);
        buttonEnterGame.setSize(new Dimension(100,35));


        // panels


        panelMain.setPreferredSize(new Dimension(704, 480));
        panelMain.setLayout(null);
        panelMain.setFocusable(true);

        panelFirst = new JPanel();
        panelFirst.setSize(new Dimension(704, 480));
        panelFirst.setLayout(null);
        panelFirst.add(buttonEnterGame);
        panelFirst.add(floorTile);
        panelFirst.setFocusable(true);
        buttonEnterGame.setLocation(panelFirst.getWidth()/2-60, panelFirst.getWidth()/2);
        floorTileArray = new JLabel[37];
        for (int i = 0; i < floorTileArray.length ; i++) {
            floorTileArray[i]= floorTile;
        }

        //place tiles
        int x = 0;
        int y = 0;
        for (int i = 0; i <panelFirst.getWidth() ; i+=32) {

            for (int j = 0; j <panelFirst.getHeight() ; j+=32) {
                floorTile = new JLabel();
                floorTile.setSize(dimen);
                floorTile.setIcon(icon_floor);
                floorTile.setLocation(i,j);
                panelFirst.add(floorTile);
            }
        }


        panelMain.add(panelFirst);

        panelTop = new JPanel();
        panelTop.setSize(new Dimension(700, 50));
        panelTop.setBackground(Color.BLUE);
        //panelMain.add(panelTop);

        //Visuals

        // hearts:

        // heart1

        heart = new JLabel();
        heart.setSize(30, 30);
        ImageIcon image_full_heart = new ImageIcon("src/img/heart_full.png");
        Icon icon_full_heart = new ImageIcon(image_full_heart.getImage().getScaledInstance(heart.getWidth(), heart.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon image_empty_heart = new ImageIcon("src/img/heart_empty.png");
        Icon icon_empty_heart = new ImageIcon(image_empty_heart.getImage().getScaledInstance(heart.getWidth(), heart.getHeight(), Image.SCALE_DEFAULT));
        heart.setIcon(icon_full_heart);

        panelTop.add(heart);

        //heart2

        heart2 = new JLabel();
        heart2.setSize(30, 30);
        heart2.setIcon(icon_full_heart);


        panelTop.add(heart2);

        //heart3
        heart3 = new JLabel();
        heart3.setSize(30, 30);
        heart3.setIcon(icon_full_heart);

        panelTop.add(heart3);

        selectChar = new JLabel();
        selectChar.setLocation(panelFirst.getWidth()/2, panelFirst.getHeight()/2);
        characterOption = 0;
        chooseChar(characterOption);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocation(300, 200);
    }
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            characterOption = characterOption -1;
            chooseChar(characterOption);
        }

        if (key == KeyEvent.VK_RIGHT) {
            characterOption = characterOption +1;
            System.out.println(characterOption);
            chooseChar(characterOption);

        }

    }
    public void chooseChar(int for_Character_option) {


        selectChar.setSize(new Dimension(100,100));
        ImageIcon imageWizard = new ImageIcon("src/img/wizard/wizard_down.gif");
        Icon icon_wizard = new ImageIcon(imageWizard.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon imageWarrior = new ImageIcon("src/img/warrior/warrior_down.gif");
        Icon icon_warrior = new ImageIcon(imageWarrior.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));

        ImageIcon imagePriest = new ImageIcon("src/img/priest/priest_down.gif");
        Icon icon_priest = new ImageIcon(imagePriest.getImage().getScaledInstance(selectChar.getWidth(), selectChar.getHeight(), Image.SCALE_DEFAULT));
// hola
        if (for_Character_option == 1) {
            selectChar.setIcon(icon_wizard);
           panelFirst.add(selectChar, 0);
       } else if (for_Character_option <= 0) {
            selectChar.setIcon(icon_warrior);
            panelFirst.add(selectChar, 0);
       } else if (for_Character_option >= 2) {
            selectChar.setIcon(icon_priest);
            panelFirst.add(selectChar, 0);

        }



    }
}
