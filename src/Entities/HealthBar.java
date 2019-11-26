package Entities;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class HealthBar extends Group
{
    public long health;
    Rectangle outerHealthRect;
    Rectangle innerHealthRect;

    public HealthBar(long health)
    {
        double height = 10;

        double outerWidth = 60;
        double innerWidth = 40;

        double x = 0.0;
        double y = 0.0;

        outerHealthRect = new Rectangle(x, y, outerWidth, height);
        outerHealthRect.setStroke(Color.BLACK);
        outerHealthRect.setStrokeWidth(2);
        outerHealthRect.setStrokeType( StrokeType.OUTSIDE);
        outerHealthRect.setFill(Color.RED);

        innerHealthRect = new Rectangle(x, y, innerWidth, height);
        innerHealthRect.setStrokeType( StrokeType.OUTSIDE);
        innerHealthRect.setFill(Color.LIMEGREEN);
        innerHealthRect.setWidth( outerHealthRect.getWidth() * health / 100);

        getChildren().addAll(outerHealthRect, innerHealthRect);
    }

    public void setHealth(double health)
    {
        innerHealthRect.setWidth( outerHealthRect.getWidth() * health / 100);
    }
}