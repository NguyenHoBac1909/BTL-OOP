package Game;

import javafx.scene.Group;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Config
{
    // WIDTH,HEIGHT
    public static final long WIDTH = 1024;

    public static final long HEIGHT = 768;

    public static final long TPS = 20;

    public static final long GAME_NSPT = Math.round(1000000000.0 / TPS);

    // TILES
    public static final long TILE = 64;

    public static final long TILE_HORIZONTAL = 16;

    public static final long TILE_VERTICAL = 12;

    public static final int NUMBEROFTILES = (int) (TILE_HORIZONTAL * TILE_VERTICAL);

    public static final long SCREEN_WIDTH = TILE * TILE_HORIZONTAL;

    public static final long SCREEN_HEIGHT = TILE * TILE_VERTICAL;

    //TIME
    public static final double Tick = 500;

    //MAX NUMBER OF TOWERS
    public static final int MaxTowerNumber = 20;

    //MAX NUMBER OF ENEMIES
    public static final int MaxBossEnemyNumber = 4;
    public static final int MaxTankerEnemyNumber = 10;
    public static final int MaxNormalEnemyNumber = 25;
    public static final int MaxSmallerEnemyNumber = 64;
    public static final int MaxEnemies = MaxBossEnemyNumber + MaxNormalEnemyNumber + MaxSmallerEnemyNumber + MaxTankerEnemyNumber;

    //Path of the map1
    public static final double SpawnX1 = 0.0;
    public static final double SpawnY1 = 104.7;
    public static final double VanishX1 = 1024.0;
    public static final double VanishY1 = 648.3;

    //Path of the map2
    public static final double SpawnX2 = 510.0;
    public static final double SpawnY2 = 0.0;
    public static final double VanishX2 = 527.0;
    public static final double VanishY2 = 768.0;
    public static final double BulletSpeed = 100.0;
    public static final double EnemyMovingTime = 1000.0;
    public static final int CycleCount = 1;

    public static Path PathforMap1(Group group)
    {
        Path MapPath = new Path();
        MoveTo Spawn = new MoveTo(SpawnX1,SpawnY1);
        MapPath.getElements().add(Spawn);
        LineTo Line1 = new LineTo(251,SpawnY1);
        MapPath.getElements().add(Line1);
        LineTo Line2 = new LineTo(251,224.4);
        MapPath.getElements().add(Line2);
        LineTo Line3 = new LineTo(416.6,224.4);
        MapPath.getElements().add(Line3);
        LineTo Line4 = new LineTo(416.6,SpawnY1);
        MapPath.getElements().add(Line4);
        LineTo Line5 = new LineTo(597.3,SpawnY1);
        MapPath.getElements().add(Line5);
        LineTo Line6 = new LineTo(597.3,374);
        MapPath.getElements().add(Line6);
        LineTo Line7 = new LineTo(426.67,374);
        MapPath.getElements().add(Line7);
        LineTo Line8 = new LineTo(426.67,648.3);
        MapPath.getElements().add(Line8);
        LineTo Line9 = new LineTo(602.35,648.3);
        MapPath.getElements().add(Line9);
        LineTo Line10 = new LineTo(602.35,523.64);
        MapPath.getElements().add(Line10);
        LineTo Line11 = new LineTo(778,523.64);
        MapPath.getElements().add(Line11);
        LineTo Line12 = new LineTo(778,VanishY1);
        MapPath.getElements().add(Line12);
        LineTo Line13 = new LineTo (VanishX1,VanishY1);
        MapPath.getElements().add(Line13);
        return MapPath;
    }

    public static Path PathforMap2(Group group)
    {
        Path MapPath = new Path();
        MoveTo Spawn = new MoveTo(SpawnX2,SpawnY2);
        MapPath.getElements().add(Spawn);
        LineTo Line1 = new LineTo(SpawnX2,80.6);
        MapPath.getElements().add(Line1);
        LineTo Line2 = new LineTo(181,80.6);
        MapPath.getElements().add(Line2);
        LineTo Line3 = new LineTo(181,563.9);
        MapPath.getElements().add(Line3);
        LineTo Line4 = new LineTo(682.7,563.9);
        MapPath.getElements().add(Line4);
        LineTo Line5 = new LineTo(682.7,290);
        MapPath.getElements().add(Line5);
        LineTo Line6 = new LineTo(512,290);
        MapPath.getElements().add(Line6);
        LineTo Line7 = new LineTo(512,456);
        MapPath.getElements().add(Line7);
        LineTo Line8 = new LineTo(336.2,456);
        MapPath.getElements().add(Line8);
        LineTo Line9 = new LineTo(336.2,177.2);
        MapPath.getElements().add(Line9);
        LineTo Line10 = new LineTo(848.2,177.2);
        MapPath.getElements().add(Line10);
        LineTo Line11 = new LineTo(848.2,682);
        MapPath.getElements().add(Line11);
        LineTo Line12 = new LineTo(VanishX2,682);
        MapPath.getElements().add(Line12);
        LineTo Line13 = new LineTo (VanishX2,VanishY2);
        MapPath.getElements().add(Line13);
        return MapPath;
    }
    //Timelines
    public static double PreparingTime = 15000;
    public static double BreakTime = 10000; //15000

    //Enemy speed
    public static final double SmallerEnemiesMovingTime = 30000.0;
    public static final double NormalEnemiesMovingTime = 45000.0;
    public static final double TankerEnemiesMovingTime = 70000.0;
    public static final double BossEnemiesMovingTime = 12000.0;
}
