

import engine.Engine;
import engine.GameLoader;
import game.Element;
import game.Game;
import game.Tile;
import impl.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;

public class RaycastRunner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Button startGameButton = new Button("Start Game");
        Button highScoreButton = new Button("Highscores");

        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startGame(primaryStage);
            }
        });


        VBox vBox = new VBox();
        vBox.getChildren().addAll(startGameButton,highScoreButton);


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vBox);
        Scene scene = new Scene(borderPane,1600,900);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void startGame(Stage primaryStage){
        GameLoader gameLoader = new GameLoader();

        HashMap<Integer, Class<? extends Tile>> tileHashMap = new HashMap<>();
        
        tileHashMap.put(0, Tile_air.class);
        tileHashMap.put(1, Tile_goal.class);
        tileHashMap.put(2, Tile_wolf5.class);
        tileHashMap.put(3, Tile_wolf5_target.class);
        tileHashMap.put(4, Tile_wolf5_breakable.class);
        tileHashMap.put(5, Tile_wolf7.class);
        
        gameLoader.addTileConfiguration(tileHashMap);

        HashMap<Integer, Class<? extends Element>> elementHashMap = new HashMap<>();
        elementHashMap.put(0, Player.class);
//              elementHashMap.put(0, MouseCursor.class);
        gameLoader.addElementsConfiguration(elementHashMap);

        gameLoader.addLevel(1,"/resources/level1Tiles.txt","/resources/level1Elements.txt");

        Game game = gameLoader.load();

        //game.getLevels().get(0).setFocusedElement(game.getLevels().get(0).getElements().get(0));
        game.setActiveLevel(game.getLevels().get(0));
        
        Engine engine = new Engine(game);
        engine.addBehavior(MoveOnMouseMove.class,new MouseMoveManager());
        engine.start(primaryStage); 
        
    }
}
