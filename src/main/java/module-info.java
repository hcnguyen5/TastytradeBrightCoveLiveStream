module TastytradeBrightCoveLiveStream.main {
  requires transitive javafx.media;
  requires transitive javafx.controls;
  opens tastytrade to javafx.graphics;
}