/*
 * Brady Heinz 7/12/2026 7.2 Assignment
 */

package heinz_mod_7;

import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Circles extends Application {

    private Circle circle1;
    private Circle circle2;
    private Circle circle3;
    private Circle circle4;

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();

        Rectangle border = new Rectangle(18, 15, 65, 250);
        border.setFill(Color.TRANSPARENT);
        border.setStroke(Color.BLACK);
        border.setStrokeWidth(5);

        circle1 = new Circle(50, 135, 30);
        circle2 = new Circle(120, 135, 30);
        circle3 = new Circle(190, 135, 30);
        circle4 = new Circle(260, 135, 30);

        circle1.getStyleClass().add("white-circle");
        circle2.getStyleClass().add("white-circle");

        circle3.setId("red-circle");
        circle4.setId("green-circle");

        pane.getChildren().addAll(
                border,
                circle1,
                circle2,
                circle3,
                circle4
        );

        Scene scene = new Scene(pane, 310, 280);

        URL css = getClass().getResource("/heinz_mod_7/mystyle.css");

        if (css == null) {
            throw new RuntimeException("mystyle.css not found.");
        }

        scene.getStylesheets().add(css.toExternalForm());

        primaryStage.setTitle("Circles");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.applyCss();
        runTests();
    }

    private void runTests() {

        boolean classTest =
                circle1.getStyleClass().contains("white-circle")
                && circle2.getStyleClass().contains("white-circle");

        boolean idTest =
                "red-circle".equals(circle3.getId())
                && "green-circle".equals(circle4.getId());

        boolean whiteCircleTest =
                Color.WHITE.equals(circle1.getFill())
                && Color.BLACK.equals(circle1.getStroke())
                && Color.WHITE.equals(circle2.getFill())
                && Color.BLACK.equals(circle2.getStroke());

        boolean colorCircleTest =
                Color.RED.equals(circle3.getFill())
                && Color.GREEN.equals(circle4.getFill());

        System.out.println("Test Results");
        System.out.println("Style class test: "
                + (classTest ? "PASS" : "FAIL"));
        System.out.println("Style ID test: "
                + (idTest ? "PASS" : "FAIL"));
        System.out.println("White circle CSS test: "
                + (whiteCircleTest ? "PASS" : "FAIL"));
        System.out.println("Red and green CSS test: "
                + (colorCircleTest ? "PASS" : "FAIL"));

        boolean allTestsPassed =
                classTest
                && idTest
                && whiteCircleTest
                && colorCircleTest;

        System.out.println("Overall test: "
                + (allTestsPassed ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}