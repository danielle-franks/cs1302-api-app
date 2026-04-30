package cs1302.api;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.geometry.Pos;
import javafx.application.Platform;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;


/**
   Makes the custom component for the Lyrics Finder.
 */
public class LyricsComponent extends VBox {

    private TextField artistField;
    private TextField songField;
    private TextField albumField;
    private TextField durationField;
    private Button fetchButton;
    private TextArea lyricsDisplay;
    private ItunesResult selectedResult;
    private Button bridgeButton;


    /**
       Constructor for LyricsComponent.
     */
    public LyricsComponent() {
        super(10);
        this.setAlignment(Pos.TOP_CENTER);
        this.setStyle("-fx-padding: 10; -fx-border-color: lightgray; -fx-border-width: 2;");

        Label title = new Label("Lyrics Finder");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 1.2em;");


        artistField = new TextField();
        artistField.setPromptText("Artist Name...");

        songField = new TextField();
        songField.setPromptText("Song Name...");

        albumField = new TextField();
        albumField.setPromptText("Album Name...");

        durationField = new TextField();
        durationField.setPromptText("Duration (seconds)...");

        artistField.setPrefWidth(300);
        songField.setPrefWidth(300);
        albumField.setPrefWidth(300);
        durationField.setPrefWidth(300);


        fetchButton = new Button("Get Lyrics");

        lyricsDisplay = new TextArea();
        lyricsDisplay.setEditable(false);
        lyricsDisplay.setPromptText("Lyrics will appear here...");
        lyricsDisplay.setWrapText(true);
        lyricsDisplay.setPrefHeight(350);

        // add all components to the layout
        this.getChildren().addAll(
            title,
            new Label("Artist:"), artistField,
            new Label("Song:"), songField,
            new Label("Album:"), albumField,
            new Label("Duration (seconds):"), durationField,
            fetchButton,
            lyricsDisplay
        );


        fetchButton.setOnAction(e -> queryLyrics());
    } //LyricsComponent


    /**
       Sets the fields to show song information.
       @param artist the artist name
       @param song the song name
       @param album the album of the song
       @param duration the length of the song
     */
    public void setFields(String artist, String song, String album, long duration) {
        artistField.setText(artist);
        songField.setText(song);
        albumField.setText(album);
        durationField.setText(String.valueOf(duration));
    }


    /**
     * Logic to fetch lyrics using the current text in the input fields.
     */
    private void queryLyrics() {
        String artist = artistField.getText();
        String song = songField.getText();
        String album = albumField.getText();
        String duration = durationField.getText();

        if (artist.isEmpty() || song.isEmpty() || album.isEmpty() || duration.isEmpty()) {
            lyricsDisplay.setText("Error: Artist and Song are required.");
            return;
        }


        String url = "https://lrclib.net/api/get?" +
            "artist_name=" + artist.replace(" ", "+") +
            "&track_name=" + song.replace(" ", "+") +
            "&album_name=" + album.replace(" ", "+") +
            "&duration=" + duration;
        Thread t = new Thread(() -> {
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

                // The simple "iTunes style" send
                HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

                Gson gson = new Gson();
                LyricsResponse lyricsRes = gson.fromJson(response.body(), LyricsResponse.class);

                // 4. Update the UI back on the main thread
                Platform.runLater(() -> {
                    if (lyricsRes != null && lyricsRes.plainLyrics != null) {
                        lyricsDisplay.setText(lyricsRes.plainLyrics);
                    } else {
                        lyricsDisplay.setText("No lyrics found for this version.");
                    }
                });

            } catch (Exception e) {
                Platform.runLater(() -> lyricsDisplay.setText("Error: " + e.getMessage()));
            }
        });
        t.start();
    }



} //LyricsComponent
