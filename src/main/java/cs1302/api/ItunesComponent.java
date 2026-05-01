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
import javafx.scene.control.Label;



/**
 * A custom component for searching the iTunes Store.
 * Extends VBox to serve as a self-contained UI module.
 */
public class ItunesComponent extends VBox {

    private TextField searchField;
    private Button searchButton;
    private VBox resultsContainer;
    private Label selectionLabel;
    private ItunesResult selectedResult;
    private Button bridgeButton;
    private LyricsComponent lyricsBridge;

    /**
     * Constructs the ItunesComponent and initializes its children.
     */
    public ItunesComponent() {
        super(10); // Sets vertical spacing to 10px
        this.setAlignment(Pos.TOP_CENTER);
        this.setStyle("-fx-padding: 10; -fx-border-color: lightgray; -fx-border-width: 2;");

        Label title = new Label("iTunes Media Search");
        Label searchLabel = new Label("Search for a song: ");
        searchField = new TextField();

        searchButton = new Button("Search");
        resultsContainer = new VBox(5);

        ScrollPane scrollPane = new ScrollPane(resultsContainer);
        scrollPane.setFitToWidth(true);
        this.setMaxWidth(Double.MAX_VALUE);
        scrollPane.setPrefHeight(300);
        searchField.setPrefWidth(500);

        this.selectionLabel = new Label("Select a song to see details");
        this.selectionLabel.setWrapText(true);
        this.selectionLabel.setStyle("-fx-background-color: #f4f4f4; -fx-padding: 10;");
        // Add nodes to this VBox
        this.getChildren().addAll(title, searchLabel, searchField, searchButton, resultsContainer,
                                  selectionLabel, scrollPane);
        searchButton.setOnAction(e -> {
            String term = searchField.getText();


            if (term != null && !term.trim().isEmpty()) {
                this.queryItunes(term);
            }
        });

        this.bridgeButton = new Button("Use this Song for Lyrics");
        this.bridgeButton.setVisible(false);
        this.bridgeButton.setManaged(false);

        // Add it to the layout after the selectionLabel
        this.getChildren().add(bridgeButton);

        // Set the action: This is the ONLY place the bridge happens now
        bridgeButton.setOnAction(e -> {
            if (selectedResult != null && lyricsBridge != null) {
                long totalSeconds = selectedResult.trackTimeMillis / 1000;
                lyricsBridge.setFields(
                    selectedResult.artistName,
                    selectedResult.trackName,
                    selectedResult.collectionName,
                    totalSeconds
                );
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
       @param response the itunes response
    */
    private void displayResults(ItunesResponse response) {
        resultsContainer.getChildren().clear(); // Wipe the old search
        selectionLabel.setVisible(true);
        if (response != null && response.results != null) {
            for (ItunesResult result : response.results) {

                HBox songRow = new HBox(10);
                songRow.setStyle("-fx-padding: 5; -fx-border-color: #ddd;" +
                                 "-fx-background-color: white;");

                // Load the image from the URL

                Image image = new Image(result.artworkUrl100, true);
                ImageView albumArt = new ImageView(image);

                albumArt.setFitHeight(60);
                albumArt.setFitWidth(60);
                albumArt.setPreserveRatio(true);

                // the text container
                VBox textInfo = new VBox(2);
                Label title = new Label(result.trackName);
                title.setStyle("-fx-font-weight: bold;");
                Label artist = new Label(result.artistName);

                textInfo.getChildren().addAll(title, artist);

                // Add artwork and text to the row
                songRow.getChildren().addAll(albumArt, textInfo);


                songRow.setOnMouseClicked(event -> {
                    for (javafx.scene.Node node : resultsContainer.getChildren()) {
                        node.setStyle("-fx-padding: 5; -fx-border-color:" +
                                      " #ddd; -fx-background-color: white;");
                    }

                    // highlight the clicked row
                    songRow.setStyle("-fx-padding: 5; -fx-border-color: #007bff; " +
                                     "-fx-border-width: 2; -fx-background-color: #e7f3ff;");
                    handleResultClick(result);
                });
                resultsContainer.getChildren().add(songRow);
            } //for


        } //if
    } //displayResults


    /**
       Prints the song information in a nice format.
       @param result the itunes result clicked
     */
    private void handleResultClick(ItunesResult result) {
        this.selectedResult = result;

        long totalSeconds = result.trackTimeMillis / 1000;
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;
        String duration = String.format("%d:%02d", minutes, seconds);

        String details = String.format(
            "Selected: %s\n" +
            "Artist: %s\n" +
            "Album: %s\n" +
            "Genre: %s | Country: %s\n" +
            "Duration: %s (%d total seconds)",
            result.trackName,
            result.artistName,
            result.collectionName,
            result.primaryGenreName,
            result.country,
            duration,
            totalSeconds
        );

        selectionLabel.setText(details);

        bridgeButton.setVisible(true);
        bridgeButton.setManaged(true);
    }


    /**
       Connects Lyrics to Itunes.
       @param bridge the bridge
     */
    public void setLyricsBridge(LyricsComponent bridge) {
        this.lyricsBridge = bridge;
    }
} //ItunesComponent
