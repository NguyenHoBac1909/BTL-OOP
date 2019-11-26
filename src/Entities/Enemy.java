package Entities;

import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;

import Game.Config;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Enemy extends SpriteBase
{
    public double HealthMax;
    public double speed;

    public double Shield;
    public double HP;
    public Rectangle HPBar = new Rectangle();
    public Rectangle HPMax = new Rectangle();

    public Enemy(Group EntitiesGroup, Image image, double x, double y, double r, double dx, double dy, double dr, long health, double shield, double damage)
    {
        super(EntitiesGroup, image, x, y, r, dx, dy, dr, health, damage);

        this.Shield = shield;

        //this.setHealth(HealthMax);

        this.setDamage(1);
    }
    public void ShowHP()
    {
        this.HPMax.setX(this.imageView.getTranslateX());
        this.HPMax.setY(this.imageView.getTranslateY() - 10);

        this.HPBar.setX(this.imageView.getTranslateX());
        this.HPBar.setY(this.imageView.getTranslateY() - 10);

        this.HPBar.setWidth(this.HP / HealthMax * 6);
    }
    public double getShield()
    {
        return this.Shield;
    }

    public void setShield(double shield)
    {
        this.Shield = shield;
    }

    public void SmallerEnemiesMove(Path path)
    {
        PathTransition MapPathTransition = new PathTransition();
        MapPathTransition.setDuration(Duration.millis(Config.SmallerEnemiesMovingTime));
        MapPathTransition.setPath(path);
        MapPathTransition.setNode(this.imageView);
        MapPathTransition.play();
        this.EntitiesGroup.getChildren().add(this.imageView);
    }

    public void NormalEnemiesMove(Path path)
    {
        PathTransition MapPathTransition = new PathTransition();
        MapPathTransition.setDuration(Duration.millis(Config.NormalEnemiesMovingTime));
        MapPathTransition.setPath(path);
        MapPathTransition.setNode(this.imageView);
        MapPathTransition.play();
        this.EntitiesGroup.getChildren().add(this.imageView);
    }

    public void TankerEnemiesMove(Path path)
    {
        PathTransition MapPathTransition = new PathTransition();
        MapPathTransition.setDuration(Duration.millis(Config.TankerEnemiesMovingTime));
        MapPathTransition.setPath(path);
        MapPathTransition.setNode(this.imageView);
        MapPathTransition.play();
        this.EntitiesGroup.getChildren().add(this.imageView);
    }

    public void BossEnemiesMove(Path path)
    {
        PathTransition MapPathTransition = new PathTransition();
        MapPathTransition.setDuration(Duration.millis(Config.BossEnemiesMovingTime));
        MapPathTransition.setPath(path);
        MapPathTransition.setNode(this.imageView);
        MapPathTransition.play();
        this.EntitiesGroup.getChildren().add(this.imageView);
    }

    /**
     * Health as a value from 0 to 1.
     * @return
     */
}