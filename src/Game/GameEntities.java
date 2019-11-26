package Game;

import Entities.*;
import javafx.animation.KeyFrame;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

import java.security.Key;
import java.util.*;
import java.util.Arrays;

public interface GameEntities
{
    //Towers
    Coordinate[] TowerCoordinate = new Coordinate[10];
    List<Coordinate> TowersCoordinate = new ArrayList<Coordinate>();
    ImageView[] ViewMachineGunTowerSample = new ImageView[Config.MaxTowerNumber];
    ImageView[] ViewSniperTowerSample = new ImageView[Config.MaxTowerNumber];
    ImageView[] ViewNormalTowerSample = new ImageView[Config.MaxTowerNumber];

    List<Tower> Towers = new ArrayList<Tower>();
    List<Tower> TowerSouls = new ArrayList<Tower>();

    //Enemies
    BossEnemy[] BOSS_ENEMIES = new BossEnemy[Config.MaxBossEnemyNumber];
    TankerEnemy[]TANKER_ENEMIES = new TankerEnemy[Config.MaxTankerEnemyNumber];
    NormalEnemy[] NORMAL_ENEMIES = new NormalEnemy[Config.MaxNormalEnemyNumber];
    SmallerEnemy[] SMALLER_ENEMIES = new SmallerEnemy[Config.MaxSmallerEnemyNumber];

    List<BossEnemy> BossEnemies = new ArrayList<BossEnemy>();
    List<TankerEnemy> TankerEnemies = new ArrayList<TankerEnemy>();
    List<NormalEnemy> NormalEnemies = new ArrayList<NormalEnemy>();
    List<SmallerEnemy> SmallerEnemies = new ArrayList<SmallerEnemy>();
    List<Enemy> Enemies = new ArrayList<Enemy>();

    //Health Bars
    List<HealthBar> SmallerEnemiesHealthBars = new ArrayList<HealthBar>();
    List<HealthBar> NormalEnemiesHealthBars = new ArrayList<HealthBar>();
    List<HealthBar> BossEnemiesHealthBars = new ArrayList<HealthBar>();

    //KeyFrame
    KeyFrame[] Keys = new KeyFrame[Config.MaxEnemies];
}
