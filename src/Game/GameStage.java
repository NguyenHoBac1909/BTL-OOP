package Game;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public final class GameStage
{
    private long Height;
    private long Width;
    private Stage Game;

    public GameStage(long height,long width,Stage Game,Group group) throws FileNotFoundException
    {
        this.Game = Game;
        this.Height = height;
        this.Width = width;

        //Group of things
        Group StageGroup = new Group();

        //Background
        Image Background = new Image(new FileInputStream("C:\\Users\\ADMIN\\IdeaProjects\\Tower of Defense FX\\src\\GameFiles\\Image\\Map selection background.png"));
        ImageView ViewBackground = new ImageView(Background);
        ViewBackground.setX(0);
        ViewBackground.setY(0);
        ViewBackground.setFitHeight(this.Height);
        ViewBackground.setFitWidth(this.Width);

        StageGroup.getChildren().add(ViewBackground);

        /*Map for selection and Text*/
        //Map1
        Image Map1 = new Image("GameFiles/Image/Map 1 - Thumbnail.png");
        ImageView ViewMap1 = new ImageView(Map1);
        Button Map1Button = new Button("",ViewMap1);
        Map1Button.setShape(new Rectangle(300,210));
        Map1Button.setPrefSize(320,220);
        Map1Button.setLayoutX(150);
        Map1Button.setLayoutY(270);

        StageGroup.getChildren().add(Map1Button);

        Text Map1Text = new Text();
        Map1Text.setText("Easy");
        Map1Text.setX(290);
        Map1Text.setY(545);
        Map1Text.setFont(Font.font("helvetica", FontWeight.BOLD, FontPosture.REGULAR, 30));
        Map1Text.setFill(Color.BLUE);

        StageGroup.getChildren().add(Map1Text);

        //Map2
        Image Map2 = new Image("GameFiles/Image/Map 2 - Thumbnail.jpg");
        ImageView ViewMap2 = new ImageView(Map2);
        Button Map2Button = new Button("",ViewMap2);
        Map2Button.setShape(new Rectangle(300,210));
        Map2Button.setPrefSize(320,220);
        Map2Button.setLayoutX(550);
        Map2Button.setLayoutY(270);

        StageGroup.getChildren().add(Map2Button);

        Text Map2Text = new Text();
        Map2Text.setText("Hard");
        Map2Text.setX(675);
        Map2Text.setY(545);
        Map2Text.setFont(Font.font("helvetica", FontWeight.BOLD, FontPosture.REGULAR, 30));
        Map2Text.setFill(Color.BLUE);

        StageGroup.getChildren().add(Map2Text);

        //Selection Text
        Text MapSelectionText = new Text();
        MapSelectionText.setText("Choose Map:");
        MapSelectionText.setX(100);
        MapSelectionText.setY(180);
        MapSelectionText.setFont(Font.font("helvetica", FontWeight.BOLD, FontPosture.REGULAR, 50));
        MapSelectionText.setFill(Color.FORESTGREEN);

        StageGroup.getChildren().add(MapSelectionText);

        //Music for Map Selection
        String MapSelectionSoundPath = "C:\\Users\\ADMIN\\IdeaProjects\\Tower of Defense FX\\src\\GameFiles\\Sound\\Map selection sound.mp3";
        Media MapSelectionSound = new Media(new File(MapSelectionSoundPath).toURI().toString());
        MediaPlayer MapSelectionSoundPlayer = new MediaPlayer(MapSelectionSound);
        MapSelectionSoundPlayer.setAutoPlay(true);
        MediaView ViewMapSelectionSound = new MediaView(MapSelectionSoundPlayer);
        MapSelectionSoundPlayer.setCycleCount(5);
        MapSelectionSoundPlayer.play();

        StageGroup.getChildren().add(ViewMapSelectionSound);

        /*If Map button is clicked*/
        //If Map1 button is clicked
        Map1Button.setOnMouseClicked(e ->
                {
                    MapSelectionSoundPlayer.stop();
                    try
                    {
                        GameField1 Field1 = new GameField1(Config.HEIGHT,Config.WIDTH,this.Game,group);
                    }
                    catch (FileNotFoundException ex)
                    {
                        ex.printStackTrace();
                    }
                }
        );
        //If Map2 button is clicked
        Map2Button.setOnMouseClicked(e ->
                {
                    MapSelectionSoundPlayer.stop();
                    try
                    {
                        GameField2 Field2 = new GameField2(Config.HEIGHT,Config.WIDTH,this.Game,group);
                    }
                    catch (FileNotFoundException ex)
                    {
                        ex.printStackTrace();
                    }
                }
        );

        Game.setScene(new Scene(StageGroup,this.Width,this.Height));
        Game.show();
    }
}
