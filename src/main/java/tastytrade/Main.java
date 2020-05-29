package tastytrade;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {

    MediaView videoPlayer = new MediaView();
    final var media = new Media(
      "https://bcovlive-a.akamaihd.net/r8ceb94e3229b4c0bb2dd461dacb3ab07/us-east-1/6057994532001/playlist.m3u8"
    );
    videoPlayer.setOnError(errorEvent -> {
      var stringWriter = new StringWriter();
      errorEvent.getMediaError().printStackTrace(new PrintWriter(stringWriter));

      var alert = new Alert(Alert.AlertType.ERROR, stringWriter.toString());
      alert.setResizable(true);
      alert.show();
    });
    final var mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setAutoPlay(true);
    videoPlayer.setMediaPlayer(mediaPlayer);

    StackPane root = new StackPane(videoPlayer);
    primaryStage.setTitle("tastytrade BrightCove Live Stream Test");
    primaryStage.setScene(new Scene(root, 640, 480));
    primaryStage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }
}
