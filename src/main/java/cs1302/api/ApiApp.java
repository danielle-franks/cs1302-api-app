package cs1302.api;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        // demonstrate how to load local asset using "file:resources/"
        Image bannerImage = new Image("file:resources/readme-banner.png");
        ImageView banner = new ImageView(bannerImage);
        banner.setPreserveRatio(true);
        banner.setFitWidth(640);

        // some labels to display information
        Label notice = new Label("Modify the starter code to suit your needs.");

        // setup scene
        root.getChildren().addAll(banner, notice);
        scene = new Scene(root);

        // setup stage
        stage.setTitle("ApiApp!");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.sizeToScene();
        stage.show();

    } // start


    /**
     * Sends a request to the iTunes Search API and returns the response object.
     * @param term The search term entered by the user.
     * @return An ItunesResponse object containing the results.
     */
    public ItunesResponse queryItunes(String term) {
        try {

            String url = "https://itunes.apple.com/search?term=" +
                term.replace(" ", "+") + "&limit=10";


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();


            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());


            Gson gson = new Gson();
            return gson.fromJson(response.body(), ItunesResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
} // ApiApp
