package Entities;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TankerEnemy extends Enemy
{
    public final Image TankerEnemyImage = new Image("GameFiles/Image/Entities Image/TankerEnemy GIF.gif");
    public TankerEnemy(Group group, Image image, double x, double y, double r, double dx, double dy, double dr, long health, double shield, double damage) throws FileNotFoundException
    {
        super(group, image, x, y, r, dx, dy, dr, health, shield, damage);
        HealthMax = Settings.TANKER_ENEMY_HEALTH;
        speed = Settings.TANKER_ENEMY_SPEED;
        this.imageView = new ImageView(TankerEnemyImage);
    }
}
