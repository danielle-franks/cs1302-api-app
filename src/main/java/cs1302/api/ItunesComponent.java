package cs1302.api;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
/**
 * A custom component for searching the iTunes Store.
 * Extends VBox to serve as a self-contained UI module.
 */
public class ItunesComponent extends VBox {

    private TextField searchField;
    private Button searchButton;
    private VBox resultsContainer;

    /**
     * Constructs the ItunesComponent and initializes its children.
     */
    public ItunesComponent() {
        super(10); // Sets vertical spacing to 10px
        this.setAlignment(Pos.TOP_CENTER);
        this.setStyle("-fx-padding: 10; -fx-border-color: lightgray; -fx-border-width: 2;");

        Label title = new Label("iTunes Media Search");
        searchField = new TextField();
        searchField.setPromptText("Search for a song...");
        searchButton = new Button("Search");
        resultsContainer = new VBox(5);

        // Add nodes to this VBox
        this.getChildren().addAll(title, searchField, searchButton, resultsContainer);
        searchButton.setOnAction(e -> {
            String term = searchField.getText();


            if (term != null && !term.trim().isEmpty()) {
                this.queryItunes(term);
            }
        });
    }


    /**
     * Sends a request to the iTunes Search API and returns the response object.
     * @param term The search term entered by the user.
     *
     */
    public void queryItunes(String term) {
        try {

            String url = "https://itunes.apple.com/search?term=" +
                term.replace(" ", "+") + "&limit=10&media=music&entity=song";


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();


            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());


            Gson gson = new Gson();
            ItunesResponse itunesResponse =  gson.fromJson(response.body(), ItunesResponse.class);

            Platform.runLater(() -> {
                this.displayResults(itunesResponse);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
       Displays search results.
     */
    private void displayResults(ItunesResponse response) {
        resultsContainer.getChildren().clear(); // Wipe the old search

        if (response != null && response.results != null) {
            for (ItunesResult result : response.results) {
                // 1. Create a horizontal container for the 'Row'
                HBox songRow = new HBox(10);
                songRow.setStyle("-fx-padding: 5; -fx-border-color: #ddd; -fx-background-color: white;");

                // 2. Load the image from the URL
                // The 'true' parameter tells JavaFX to load it in the background
                Image image = new Image(result.artworkUrl100, true);
                ImageView albumArt = new ImageView(image);

                // 3. Size the image so it doesn't take over the screen
                albumArt.setFitHeight(60);
                albumArt.setFitWidth(60);
                albumArt.setPreserveRatio(true);

                // 4. Create the text container
                VBox textInfo = new VBox(2);
                Label title = new Label(result.trackName);
                title.setStyle("-fx-font-weight: bold;");
                Label artist = new Label(result.artistName);

                textInfo.getChildren().addAll(title, artist);

                // 5. Add artwork and text to the row
                songRow.getChildren().addAll(albumArt, textInfo);

                // 6. Add the row to your resultsContainer
                resultsContainer.getChildren().add(songRow);
            }
        }
    } //displayResults

    } //ItunesComponent
