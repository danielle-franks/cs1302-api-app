package cs1302.api;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *This app allows the user to look up songs/albums/artists on Itunes. The user will
 recieve a list of matches. The user can automatically copy a search result's
 info over to the lyric lookup, or can choose to look up a different song.
 */
public class ApiApp extends Application {
    Stage stage;
    Scene scene;
    VBox root;

    /**
     * Constructs an {@code ApiApp} object. This default (i.e., no argument)
     * constructor is executed in Step 2 of the JavaFX Application Life-Cycle.
     */
    public ApiApp() {
        root = new VBox();
    } // ApiApp

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {

        this.stage = stage;
        ItunesComponent itunes = new ItunesComponent();
        LyricsComponent lyrics = new LyricsComponent();

        itunes.setLyricsBridge(lyrics);

        HBox mainLayout = new HBox(20);
        HBox.setHgrow(itunes, Priority.ALWAYS);
        HBox.setHgrow(lyrics, Priority.ALWAYS);
        mainLayout.getChildren().addAll(itunes, lyrics);


        scene = new Scene(mainLayout, 1100, 700);
        stage.setTitle("iTunes Search");

        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.sizeToScene();
        stage.show();

    } // start

} // ApiApp
