package Game;

import java.io.File;
import java.util.*;

import Entities.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.FileNotFoundException;

import java.io.FileInputStream;

public final class GameField2 implements GameEntities
{
    public int i;
    public int step;
    private long Height;
    private long Width;
    private Stage Game;

    public long PlayerHealth = 1000;

    Group Map2FieldGroup = new Group();

    Text goldText1 = new Text();
    Text goldText2 = new Text();

    Text PlayerHealthText1 = new Text();
    Text PlayerHealthText2 = new Text();

    long gold = 200;

    public Image SmallerEnemiesImage = new Image("GameFiles/Image/Entities Image/SmallerEnemy GIF.gif");
    public Image NormalEnemiesImage = new Image("GameFiles/Image/Entities Image/NormalEnemy GIF.gif");
    public Image TankerEnemiesImage = new Image("GameFiles/Image/Entities Image/TankerEnemy GIF.gif");
    public Image BossEnemiesImage = new Image("GameFiles/Image/Entities Image/BossEnemy GIF.gif");

    public ImageView ViewSmallerEnemies = new ImageView(SmallerEnemiesImage);
    public ImageView ViewNỏrmalEnemies = new ImageView(NormalEnemiesImage);
    public ImageView ViewTankerEnemies = new ImageView(TankerEnemiesImage);
    public ImageView ViewBossEnemies = new ImageView(BossEnemiesImage);

    private void createPlayerHealthLayer()
    {
        //Player HP text 1
        PlayerHealthText1.setFont(Font.font( null, FontWeight.BOLD, 35));
        PlayerHealthText1.setStroke(Color.BLACK);
        PlayerHealthText1.setFill(Color.RED);

        Map2FieldGroup.getChildren().add(PlayerHealthText1);

        PlayerHealthText1.setText(String.valueOf(PlayerHealth));

        PlayerHealthText1.relocate(650, 705);

        PlayerHealthText1.setBoundsType(TextBoundsType.VISUAL);

        //Player HP text 2
        PlayerHealthText2.setFont(Font.font( null, FontWeight.BOLD, 35));
        PlayerHealthText2.setStroke(Color.BLACK);
        PlayerHealthText2.setFill(Color.RED);

        Map2FieldGroup.getChildren().add(PlayerHealthText2);

        PlayerHealthText2.setText("HP: ");

        PlayerHealthText2.relocate(580, 705);

        PlayerHealthText2.setBoundsType(TextBoundsType.VISUAL);
    }
    private void createGoldLayer()
    {
        //Gold text 1
        goldText1.setFont(Font.font( null, FontWeight.BOLD, 40));
        goldText1.setStroke(Color.BLACK);
        goldText1.setFill(Color.GOLD);

        Map2FieldGroup.getChildren().add(goldText1);

        goldText1.setText(String.valueOf(gold));

        goldText1.relocate(900, 700);

        goldText1.setBoundsType(TextBoundsType.VISUAL);

        //Gold text 2
        goldText2.setFont(Font.font( null, FontWeight.BOLD, 40));
        goldText2.setStroke(Color.BLACK);
        goldText2.setFill(Color.GOLD);

        Map2FieldGroup.getChildren().add(goldText2);

        goldText2.setText("Gold: ");

        goldText2.relocate(800, 700);

        goldText2.setBoundsType(TextBoundsType.VISUAL);
    }

    private void updatePlayerHealth()
    {
        PlayerHealthText1.setText(String.valueOf(PlayerHealth));
    }

    private void updateScore()
    {
        goldText1.setText(String.valueOf(gold));
    }

    public GameField2(long height, long width, Stage Game, Group group) throws FileNotFoundException
    {
        this.Game = Game;
        this.Height = height;
        this.Width = width;
        //this.Map2FieldGroup = group;

        //Map 2
        Image Map2 = new Image("GameFiles/Image/Map 2.png");
        ImageView ViewMap2 = new ImageView(Map2);
        ViewMap2.setX(0);
        ViewMap2.setY(0);
        ViewMap2.setFitHeight(this.Height);
        ViewMap2.setFitWidth(this.Width);
        Map2FieldGroup.getChildren().add(ViewMap2);

        //Create Money Text
        createGoldLayer();

        //Create Player HP Text
        createPlayerHealthLayer();

        //Sounds for Map2
        String Map1SoundPath = "C:\\Users\\ADMIN\\IdeaProjects\\Tower of Defense FX\\src\\GameFiles\\Sound\\Shamburger.mp3";
        Media Map1Sound = new Media(new File(Map1SoundPath).toURI().toString());
        MediaPlayer PlayMap1Sound = new MediaPlayer(Map1Sound);
        MediaView ViewMap1Sound = new MediaView(PlayMap1Sound);
        Map2FieldGroup.getChildren().add(ViewMap1Sound);
        PlayMap1Sound.setCycleCount(1);
        PlayMap1Sound.play();

        /*Create Tower Buttons Selection*/
        //Create MachineGunTower Button
        Image MachineGunTowerImage = new Image("GameFiles/Image/Entities Image/MachineGunTower.png");
        ImageView ViewMachineGunTower = new ImageView(MachineGunTowerImage);
        Button MachineGunTowerButton = new Button("",ViewMachineGunTower);
        MachineGunTowerButton.setShape(new Circle(30));
        MachineGunTowerButton.setLayoutX(190);
        MachineGunTowerButton.setLayoutY(658);
        MachineGunTowerButton.setPrefSize(60,60);
        Map2FieldGroup.getChildren().add(MachineGunTowerButton);

        Text MachineGunTowerPriceText = new Text();
        MachineGunTowerPriceText.setFont(Font.font( "helvetica", FontWeight.BOLD, 30));
        MachineGunTowerPriceText.setStroke(Color.BLACK);
        MachineGunTowerPriceText.setFill(Color.GOLD);
        MachineGunTowerPriceText.setText(String.valueOf(MachineGunTower.price  + "$"));
        MachineGunTowerPriceText.relocate(198, 717);
        MachineGunTowerPriceText.setBoundsType(TextBoundsType.VISUAL);
        Map2FieldGroup.getChildren().add(MachineGunTowerPriceText);

        //Create NormalTower Button
        Image NormalTowerImage = new Image("GameFiles/Image/Entities Image/NormalTower.png");
        ImageView ViewNormalTower = new ImageView(NormalTowerImage);
        Button NormalTowerButton = new Button("",ViewNormalTower);
        NormalTowerButton.setShape(new Circle(30));
        NormalTowerButton.setLayoutX(283);
        NormalTowerButton.setLayoutY(658);
        NormalTowerButton.setPrefSize(60,60);
        Map2FieldGroup.getChildren().add(NormalTowerButton);

        Text NormalTowerPriceText = new Text();
        NormalTowerPriceText.setFont(Font.font( "helvetica", FontWeight.BOLD, 30));
        NormalTowerPriceText.setStroke(Color.BLACK);
        NormalTowerPriceText.setFill(Color.GOLD);
        NormalTowerPriceText.setText(String.valueOf(NormalTower.price  + "$"));
        NormalTowerPriceText.relocate(300, 717);
        NormalTowerPriceText.setBoundsType(TextBoundsType.VISUAL);
        Map2FieldGroup.getChildren().add(NormalTowerPriceText);

        //Create SniperTower Button
        Image SniperTowerImage = new Image("GameFiles/Image/Entities Image/SniperTower.png");
        ImageView ViewSniperTower = new ImageView(SniperTowerImage);
        Button SniperTowerButton = new Button("",ViewSniperTower);
        SniperTowerButton.setShape(new Circle(30));
        SniperTowerButton.setLayoutX(377);
        SniperTowerButton.setLayoutY(658);
        SniperTowerButton.setPrefSize(60,60);
        Map2FieldGroup.getChildren().add(SniperTowerButton);

        Text SniperTowerPriceText = new Text();
        SniperTowerPriceText.setFont(Font.font( "helvetica", FontWeight.BOLD, 30));
        SniperTowerPriceText.setStroke(Color.BLACK);
        SniperTowerPriceText.setFill(Color.GOLD);
        SniperTowerPriceText.setText(String.valueOf(SniperTower.price  + "$"));
        SniperTowerPriceText.relocate(390, 717);
        SniperTowerPriceText.setBoundsType(TextBoundsType.VISUAL);
        Map2FieldGroup.getChildren().add(SniperTowerPriceText);

        //Setting places to place towers
        TowerCoordinate[0] = new Coordinate(51.7,429.6);
        TowerCoordinate[1] = new Coordinate(51.7,241.7);
        TowerCoordinate[2] = new Coordinate(217.2,188);
        TowerCoordinate[3] = new Coordinate(217.2,386.79);
        TowerCoordinate[4] = new Coordinate(382.7,311.5);
        TowerCoordinate[5] = new Coordinate(574,69.8);
        TowerCoordinate[6] = new Coordinate(574,392);
        TowerCoordinate[7] = new Coordinate(822.3,80.56);
        TowerCoordinate[8] = new Coordinate(734.4,424.3);
        TowerCoordinate[9] = new Coordinate(910.2,290);

        for (i = 0;i < 10;i++)
        {
            TowerCoordinate[i].PlaceTowerStatus = true;
            TowersCoordinate.add(TowerCoordinate[i]);
        }

        /*Processing the Game*/
        Queue<ImageView> ViewMachineGunTowerQueue = new LinkedList<>();
        Queue<ImageView> ViewNormalTowerQueue = new LinkedList<>();
        Queue<ImageView> ViewSniperTowerQueue = new LinkedList<>();
        Queue<ImageView> ViewTowerQueue = new LinkedList<>();

        //EventHandler for MachineGunTower
        Image MachineGunTowerImageSample = new Image("GameFiles/Image/Entities Image/MachineGunTower.png");
        for (i = 0;i < Config.MaxTowerNumber;i++)
        {
            ViewMachineGunTowerSample[i] = new ImageView(MachineGunTowerImageSample);
        }
        for (i = 0;i < Config.MaxTowerNumber;i++)
        {
            ViewMachineGunTowerQueue.add(ViewMachineGunTowerSample[i]);
        }
        EventHandler<MouseEvent> PlaceMachineGunTowerEvents = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                step = 1;
                Map2FieldGroup.getChildren().add(ViewMachineGunTowerQueue.peek());
                EventHandler<MouseEvent> mouseMove = new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event1)
                    {
                        if (step == 1)
                        {
                            (ViewMachineGunTowerQueue.peek()).setLayoutX(event1.getX() - (ViewMachineGunTowerQueue.peek()).getLayoutBounds().getWidth()/2);
                            (ViewMachineGunTowerQueue.peek()).setLayoutY(event1.getY() - (ViewMachineGunTowerQueue.peek()).getLayoutBounds().getHeight()/2);
                        }
                    }
                };

                EventHandler<MouseEvent> mouseClick = new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event2)
                    {
                        double x = event2.getX() - (ViewMachineGunTowerQueue.peek()).getLayoutBounds().getWidth() / 2;
                        double y = event2.getY() - (ViewMachineGunTowerQueue.peek()).getLayoutBounds().getHeight() / 2;

                        for (i = 0;i < TowersCoordinate.size();i++)
                        {
                            if (step == 1 && gold >= MachineGunTower.price && x >= TowersCoordinate.get(i).getX() - 1 && x <= TowersCoordinate.get(i).getX() + Config.TILE && y >= TowersCoordinate.get(i).getY() - 1 && y <= TowersCoordinate.get(i).getY() + Config.TILE && TowersCoordinate.get(i).PlaceTowerStatus == true)
                            {
                                (ViewMachineGunTowerQueue.peek()).setLayoutX(x);
                                (ViewMachineGunTowerQueue.peek()).setLayoutY(y);
                                Towers.add(new MachineGunTower(Map2FieldGroup,x,y,0,0,0,0,100,Settings.MACHINE_GUN_BULLET_STRENGTH));

                                //Play sound
                                String PlacingTowerSoundPath = "C:\\Users\\ADMIN\\IdeaProjects\\Tower of Defense FX\\src\\GameFiles\\Sound\\Placing Towers Sound.mp3";
                                Media PlacingTowerSound = new Media(new File(PlacingTowerSoundPath).toURI().toString());
                                MediaPlayer PlayPlacingTowerSound = new MediaPlayer(PlacingTowerSound);
                                MediaView ViewPlacingTowerSound = new MediaView(PlayPlacingTowerSound);
                                Map2FieldGroup.getChildren().add(ViewPlacingTowerSound);
                                PlayPlacingTowerSound.play();

                                TowersCoordinate.get(i).PlaceTowerStatus = false;
                                TowersCoordinate.remove(i);

                                gold = gold - MachineGunTower.price;
                                updateScore();

                                step = 0;
                                ViewMachineGunTowerQueue.remove();
                            }
                        }
                    }
                };
                Map2FieldGroup.setOnMouseMoved(mouseMove);
                Map2FieldGroup.setOnMouseClicked(mouseClick);
            }
        };

        //EventHandler for NormalTower
        Image NormalTowerImageSample = new Image("GameFiles/Image/Entities Image/NormalTower.png");
        for (i = 0;i < Config.MaxTowerNumber;i++)
        {
            ViewNormalTowerSample[i] = new ImageView(NormalTowerImageSample);
        }
        for (i = 0;i < Config.MaxTowerNumber;i++)
        {
            ViewNormalTowerQueue.add(ViewNormalTowerSample[i]);
        }
        EventHandler<MouseEvent> PlaceNormalTowerEvents = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                step = 1;
                Map2FieldGroup.getChildren().add(ViewNormalTowerQueue.peek());
                EventHandler<MouseEvent> mouseMove = new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event1)
                    {
                        if (step == 1)
                        {
                            (ViewNormalTowerQueue.peek()).setLayoutX(event1.getX() - (ViewNormalTowerQueue.peek()).getLayoutBounds().getWidth()/2);
                            (ViewNormalTowerQueue.peek()).setLayoutY(event1.getY() - (ViewNormalTowerQueue.peek()).getLayoutBounds().getHeight()/2);
                        }
                    }
                };

                EventHandler<MouseEvent> mouseClick = new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event2)
                    {
                        double x = event2.getX() - (ViewNormalTowerQueue.peek()).getLayoutBounds().getWidth() / 2;
                        double y = event2.getY() - (ViewNormalTowerQueue.peek()).getLayoutBounds().getHeight() / 2;

                        for (i = 0;i < TowersCoordinate.size();i++)
                        {
                            if (step == 1 && gold >= NormalTower.price && x >= TowersCoordinate.get(i).getX() - 1 && x <= TowersCoordinate.get(i).getX() + Config.TILE && y >= TowersCoordinate.get(i).getY() - 1 && y <= TowersCoordinate.get(i).getY() + Config.TILE && TowersCoordinate.get(i).PlaceTowerStatus == true)
                            {
                                (ViewNormalTowerQueue.peek()).setLayoutX(x);
                                (ViewNormalTowerQueue.peek()).setLayoutY(y);
                                Towers.add(new NormalTower(Map2FieldGroup, x, y, 0, 0, 0, 0, 100, Settings.NORMAL_BULLET_STRENGTH));

                                //Play sound
                                String PlacingTowerSoundPath = "C:\\Users\\ADMIN\\IdeaProjects\\Tower of Defense FX\\src\\GameFiles\\Sound\\Placing Towers Sound.mp3";
                                Media PlacingTowerSound = new Media(new File(PlacingTowerSoundPath).toURI().toString());
                                MediaPlayer PlayPlacingTowerSound = new MediaPlayer(PlacingTowerSound);
                                MediaView ViewPlacingTowerSound = new MediaView(PlayPlacingTowerSound);
                                Map2FieldGroup.getChildren().add(ViewPlacingTowerSound);
                                PlayPlacingTowerSound.play();

                                TowersCoordinate.get(i).PlaceTowerStatus = false;
                                TowersCoordinate.remove(i);

                                gold = gold - NormalTower.price;
                                updateScore();

                                step = 0;
                                ViewNormalTowerQueue.remove();
                            }
                        }
                    }
                };
                Map2FieldGroup.setOnMouseMoved(mouseMove);
                Map2FieldGroup.setOnMouseClicked(mouseClick);
            }
        };

        //EventHandler for NormalTower
        Image SniperTowerImageSample = new Image("GameFiles/Image/Entities Image/SniperTower.png");
        for (i = 0;i < Config.MaxTowerNumber;i++)
        {
            ViewSniperTowerSample[i] = new ImageView(SniperTowerImageSample);
        }
        for (i = 0;i < Config.MaxTowerNumber;i++)
        {
            ViewSniperTowerQueue.add(ViewSniperTowerSample[i]);
        }
        EventHandler<MouseEvent> PlaceSniperTowerEvents = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                step = 1;
                Map2FieldGroup.getChildren().add(ViewSniperTowerQueue.peek());
                EventHandler<MouseEvent> mouseMove = new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event1)
                    {
                        if (step == 1)
                        {
                            (ViewSniperTowerQueue.peek()).setLayoutX(event1.getX() - (ViewSniperTowerQueue.peek()).getLayoutBounds().getWidth()/2);
                            (ViewSniperTowerQueue.peek()).setLayoutY(event1.getY() - (ViewSniperTowerQueue.peek()).getLayoutBounds().getHeight()/2);
                        }
                    }
                };

                EventHandler<MouseEvent> mouseClick = new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event2)
                    {
                        double x = event2.getX() - (ViewSniperTowerQueue.peek()).getLayoutBounds().getWidth() / 2;
                        double y = event2.getY() - (ViewSniperTowerQueue.peek()).getLayoutBounds().getHeight() / 2;

                        for (i = 0;i < TowersCoordinate.size();i++)
                        {
                            if (step == 1 && gold >= SniperTower.price && x >= TowersCoordinate.get(i).getX() - 1 && x <= TowersCoordinate.get(i).getX() + Config.TILE && y >= TowersCoordinate.get(i).getY() - 1 && y <= TowersCoordinate.get(i).getY() + Config.TILE && TowersCoordinate.get(i).PlaceTowerStatus == true)
                            {
                                (ViewSniperTowerQueue.peek()).setLayoutX(x);
                                (ViewSniperTowerQueue.peek()).setLayoutY(y);
                                Towers.add(new SniperTower(Map2FieldGroup, x, y, 0, 0, 0, 0, 100, Settings.SNIPER_BULLET_STRENGTH));

                                //Play sound
                                String PlacingTowerSoundPath = "C:\\Users\\ADMIN\\IdeaProjects\\Tower of Defense FX\\src\\GameFiles\\Sound\\Placing Towers Sound.mp3";
                                Media PlacingTowerSound = new Media(new File(PlacingTowerSoundPath).toURI().toString());
                                MediaPlayer PlayPlacingTowerSound = new MediaPlayer(PlacingTowerSound);
                                MediaView ViewPlacingTowerSound = new MediaView(PlayPlacingTowerSound);
                                Map2FieldGroup.getChildren().add(ViewPlacingTowerSound);
                                PlayPlacingTowerSound.play();

                                TowersCoordinate.get(i).PlaceTowerStatus = false;
                                TowersCoordinate.remove(i);

                                gold = gold - SniperTower.price;
                                updateScore();

                                step = 0;
                                ViewSniperTowerQueue.remove();
                            }
                        }
                    }
                };
                Map2FieldGroup.setOnMouseMoved(mouseMove);
                Map2FieldGroup.setOnMouseClicked(mouseClick);
            }
        };
        MachineGunTowerButton.setOnMouseClicked(PlaceMachineGunTowerEvents);
        SniperTowerButton.setOnMouseClicked(PlaceSniperTowerEvents);
        NormalTowerButton.setOnMouseClicked(PlaceNormalTowerEvents);

        //Create Enemy Units
        for (i = 0;i < Config.MaxBossEnemyNumber;i++)
        {
            BOSS_ENEMIES[i] = new BossEnemy(Map2FieldGroup, BossEnemiesImage,0,0,0,0,0,0, Settings.BOSS_ENEMY_HEALTH,Settings.BOSS_ENEMY_ARMOR,0);
            BossEnemies.add(BOSS_ENEMIES[i]);
        }

        for (i = 0;i < Config.MaxNormalEnemyNumber;i++)
        {
            NORMAL_ENEMIES[i] = new NormalEnemy(Map2FieldGroup, NormalEnemiesImage,0,0,0,0,0,0,Settings.NORMAL_ENEMY_HEALTH,Settings.NORMAL_ENEMY_ARMOR,0);
            NormalEnemies.add(NORMAL_ENEMIES[i]);
        }

        for (i = 0;i < Config.MaxTankerEnemyNumber;i++)
        {
            TANKER_ENEMIES[i] = new TankerEnemy(Map2FieldGroup, TankerEnemiesImage,0,0,0,0,0,0,Settings.TANKER_ENEMY_HEALTH,Settings.TANKER_ENEMY_ARMOR,0);
            TankerEnemies.add(TANKER_ENEMIES[i]);
        }

        for (i = 0;i < Config.MaxSmallerEnemyNumber;i++)
        {
            SMALLER_ENEMIES[i] = new SmallerEnemy(Map2FieldGroup,SmallerEnemiesImage,0,0,0,0,0,0,Settings.SMALLER_ENEMY_HEALTH,Settings.SMALLER_ENEMY_ARMOR,0);
            SmallerEnemies.add(SMALLER_ENEMIES[i]);
            //SmallerEnemiesHealthBars.add(new HealthBar(SMALLER_ENEMIES[i].getHealth()));
        }

        //Add all Enemies and Towers to list Enemies
        Enemies.addAll(SmallerEnemies);
        Enemies.addAll(BossEnemies);
        Enemies.addAll(NormalEnemies);

        //Enemies Queue
        Queue<Enemy> EnemiesQueue = new LinkedList<>();
        for (i = 0;i < SmallerEnemies.size();i++)
        {
            EnemiesQueue.add(SmallerEnemies.get(i));
        }
        for (i = 0;i < NormalEnemies.size();i++)
        {
            EnemiesQueue.add(NormalEnemies.get(i));
        }
        for (i = 0;i < BossEnemies.size();i++)
        {
            EnemiesQueue.add(BossEnemies.get(i));
        }

        //Enemies move & Transition on the path & Timelines
        Timeline TimeLine = new Timeline();
        for (i = 0;i < SmallerEnemies.size();i++)
        {
            Enemy enemy = SmallerEnemies.get(i);
            Keys[i] = new KeyFrame(Duration.millis(i * Config.Tick + Config.PreparingTime), event ->
            {
                enemy.SmallerEnemiesMove(Config.PathforMap2(Map2FieldGroup));
            });
            TimeLine.getKeyFrames().add(Keys[i]);
        }
        for (i = SmallerEnemies.size();i < SmallerEnemies.size() + NormalEnemies.size();i++)
        {
            Enemy enemy = NormalEnemies.get(i - SmallerEnemies.size());
            Keys[i] = new KeyFrame(Duration.millis(Config.PreparingTime + i * Config.Tick + Config.BreakTime),event ->
            {
                enemy.NormalEnemiesMove(Config.PathforMap2(Map2FieldGroup));
            });
            TimeLine.getKeyFrames().add(Keys[i]);
        }
        for (i = SmallerEnemies.size() + NormalEnemies.size();i < SmallerEnemies.size() + NormalEnemies.size() + TankerEnemies.size();i++)
        {
            Enemy enemy = TankerEnemies.get(i - SmallerEnemies.size() - NormalEnemies.size());
            Keys[i] = new KeyFrame(Duration.millis(Config.PreparingTime + i * Config.Tick + Config.BreakTime * 2),event ->
            {
                enemy.TankerEnemiesMove(Config.PathforMap2(Map2FieldGroup));
            });
            TimeLine.getKeyFrames().add(Keys[i]);
        }
        for (i = SmallerEnemies.size() + NormalEnemies.size() + TankerEnemies.size();i < Config.MaxEnemies;i++)
        {
            Enemy enemy = BossEnemies.get(i - SmallerEnemies.size() - NormalEnemies.size() - TankerEnemies.size());
            Keys[i] = new KeyFrame(Duration.millis(Config.PreparingTime + i * Config.Tick + Config.BreakTime * 3),event ->
            {
                enemy.BossEnemiesMove(Config.PathforMap2(Map2FieldGroup));
            });
            TimeLine.getKeyFrames().add(Keys[i]);
        }
        TimeLine.setAutoReverse(false);
        TimeLine.play();

        //Shoot the Enemies
        AnimationTimer gameLoop = new AnimationTimer()
        {
            private long lastUpdate_1 = System.currentTimeMillis() ;

            int t = 0;

            public void handle(long now)
            {
                long elapsedSeconds_1 = (System.currentTimeMillis() - lastUpdate_1)/1000;

                if (elapsedSeconds_1 == 1)
                {
                    //Shooting
                    for (Tower tower : Towers)
                    {
                        if (EnemiesQueue.peek().getImageView().getTranslateX() != 0 && EnemiesQueue.peek().getImageView().getTranslateY() != 0)
                        {
                            Image bullet = new Image("GameFiles/Image/Entities Image/NormalBullet GIF.gif");
                            ImageView Viewbullet = new ImageView(bullet);

                            Timeline BulletFly = new Timeline();
                            KeyFrame Fly = new KeyFrame(Duration.millis((2 * t) * Config.Tick), event ->
                            {
                                Map2FieldGroup.getChildren().add(Viewbullet);
                                Path path = new Path();
                                MoveTo Spawn = new MoveTo(tower.getImageView().getLayoutX(), tower.getImageView().getLayoutY());
                                path.getElements().add(Spawn);
                                LineTo line1 = new LineTo(EnemiesQueue.peek().getImageView().getTranslateX(), EnemiesQueue.peek().getImageView().getTranslateY());
                                path.getElements().add(line1);

                                PathTransition movebullet = new PathTransition();
                                movebullet.setNode(Viewbullet);
                                movebullet.setPath(path);
                                movebullet.setDuration(Duration.millis(Config.BulletSpeed));
                                movebullet.play();

                                EnemiesQueue.peek().Health -= tower.getDamage() - EnemiesQueue.peek().getShield();

                                if (EnemiesQueue.peek().Health <= 0)
                                {
                                    Map2FieldGroup.getChildren().remove(EnemiesQueue.peek().getImageView());
                                    EnemiesQueue.remove();
                                    gold = gold + 50;
                                }
                                if (EnemiesQueue.peek().getImageView().getTranslateX() == Config.VanishX2 && EnemiesQueue.peek().getImageView().getTranslateY() == Config.VanishY2)
                                {
                                    Map2FieldGroup.getChildren().remove(EnemiesQueue.peek().getImageView());
                                    EnemiesQueue.remove();
                                    PlayerHealth = PlayerHealth - 50;
                                }
                                /*if (PlayerHealth <= 0)
                                {

                                }*/
                            });
                            BulletFly.getKeyFrames().add(Fly);

                            KeyFrame RemoveBullet = new KeyFrame(Duration.millis((2 * t + 1) * Config.Tick), event ->
                            {
                                Map2FieldGroup.getChildren().remove(Viewbullet);
                                lastUpdate_1 = System.currentTimeMillis();

                                // update score, health, etc
                                updateScore();
                                updatePlayerHealth();
                            });

                            BulletFly.getKeyFrames().add(RemoveBullet);
                            BulletFly.setAutoReverse(false);
                            BulletFly.play();
                        }
                    }
                    lastUpdate_1 = System.currentTimeMillis();
                }
            }

        };
        gameLoop.start();

        //Group of things
        Game.setScene(new Scene(Map2FieldGroup,this.Width,this.Height));
        Game.show();
    }
}