package Entities;

import java.util.List;

import Game.Config;
import Game.Coordinate;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public abstract class Tower extends SpriteBase
{
    public Bullet bullet;
    public double speed;

    double targetRange; // distance within tower can lock to enemy
    public long range;
    public Tower(Group group, Image image, double x, double y, double r, double dx, double dy, double dr, long health, double damage)
    {
        super(group, image, x, y, r, dx, dy, dr, health, damage);
    }
    public abstract boolean CheckTarget(Enemy enemy);
}
