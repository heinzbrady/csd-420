/*
 * Brady Heinz 7/12/26 Module 8 Assignment
 */

package mod_8;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BradyThreeThreads extends Application {

    public static final int CHARACTER_COUNT = 10000;
    public static final String SPECIAL_CHARACTERS = "!@#$%&*^";

    private static final Random RANDOM = new Random();

    private final TextArea outputArea = new TextArea();
    private final Label statusLabel =
            new Label("Press Start to generate characters.");
    private final Button startButton = new Button("Start Threads");

    @Override
    public void start(Stage primaryStage) {

        outputArea.setWrapText(true);
        outputArea.setEditable(false);

        startButton.setOnAction(event -> startCharacterThreads());

        HBox controls = new HBox(15, startButton, statusLabel);
        controls.setPadding(new Insets(10));

        BorderPane pane = new BorderPane();
        pane.setCenter(outputArea);
        pane.setBottom(controls);
        pane.setPadding(new Insets(10));

        Scene scene = new Scene(pane, 850, 600);

        primaryStage.setTitle("Brady Three Threads");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startCharacterThreads() {

        outputArea.clear();
        startButton.setDisable(true);
        statusLabel.setText("Generating 30,000 characters...");

        AtomicInteger completedThreads = new AtomicInteger();

        Thread letterThread = new Thread(() ->
                generateCharacters(completedThreads, 1));

        Thread numberThread = new Thread(() ->
                generateCharacters(completedThreads, 2));

        Thread specialThread = new Thread(() ->
                generateCharacters(completedThreads, 3));

        letterThread.setDaemon(true);
        numberThread.setDaemon(true);
        specialThread.setDaemon(true);

        letterThread.start();
        numberThread.start();
        specialThread.start();
    }

    private void generateCharacters(
            AtomicInteger completedThreads, int characterType) {

        for (int i = 0; i < CHARACTER_COUNT; i++) {

            char character;

            switch (characterType) {
                case 1:
                    character = generateRandomLetter();
                    break;

                case 2:
                    character = generateRandomDigit();
                    break;

                default:
                    character = generateRandomSpecialCharacter();
                    break;
            }

            final char displayedCharacter = character;

            Platform.runLater(() ->
                    outputArea.appendText(
                            String.valueOf(displayedCharacter)));

            if (i % 100 == 0) {
                Thread.yield();
            }
        }

        if (completedThreads.incrementAndGet() == 3) {
            Platform.runLater(() -> {
                statusLabel.setText(
                        "Complete: 10,000 letters, 10,000 digits, "
                        + "and 10,000 special characters.");
                startButton.setDisable(false);
            });
        }
    }

    public static char generateRandomLetter() {
        return (char) ('a' + RANDOM.nextInt(26));
    }

    public static char generateRandomDigit() {
        return (char) ('0' + RANDOM.nextInt(10));
    }

    public static char generateRandomSpecialCharacter() {
        int index = RANDOM.nextInt(SPECIAL_CHARACTERS.length());
        return SPECIAL_CHARACTERS.charAt(index);
    }

    public static void main(String[] args) {
        launch(args);
    }
}