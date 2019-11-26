package Entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SniperTower extends Tower
{
    public static final long price = 500;
    public static final long range = 300;
    public static final Image image = new Image("GameFiles/Image/Entities Image/SniperTower.png");
    public boolean withinFireRange = false;

    public SniperTower(Group group, double x, double y, double r, double dx, double dy, double dr, long health, double damage)
    {
        super(group, image, x, y, r, dx, dy, dr, health, damage);
        this.setDamage(Settings.SNIPER_BULLET_STRENGTH);
        targetRange = Settings.SNIPER_TOWER_RANGE;
        speed = Settings.SNIPER_TOWER_SPEED;
    }

    @Override
    public boolean CheckTarget(Enemy enemy)
    {
        double distance = Math.sqrt((this.getImageView().getLayoutX() - enemy.getImageView().getTranslateX()) * (this.getImageView().getLayoutX() - enemy.getImageView().getTranslateX()) + (this.getImageView().getLayoutY() - enemy.getImageView().getTranslateY()) * (this.getImageView().getLayoutY() - enemy.getImageView().getTranslateY()));
        if (distance <= this.range)
        {
            withinFireRange = true;
        }
        return withinFireRange;
    }
}
