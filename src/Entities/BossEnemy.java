package Entities;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BossEnemy extends Enemy
{
    private final Image BossEnemyImage = new Image("GameFiles/Image/Entities Image/BossEnemy GIF.gif");
    public BossEnemy(Group group, Image image, double x, double y, double r, double dx, double dy, double dr, long health, double shield, double damage)
    {
        super(group,image, x, y, r, dx, dy, dr, health, shield, damage);
        this.image = BossEnemyImage;
        HealthMax = Settings.BOSS_ENEMY_HEALTH;
        speed = Settings.BOSS_ENEMY_SPEED;
        this.imageView = new ImageView(BossEnemyImage);
    }
}
