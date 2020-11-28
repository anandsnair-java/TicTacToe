package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {
    private final GameLogic game;

    public TicTacToeApplication() {
        game = new GameLogic();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);

    }

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane layout = new BorderPane();
        Label turnLabel = new Label(game.gameInfo());
        GridPane buttonGrid = new GridPane();
        buttonGrid.setPadding(new Insets(20, 20, 20, 20));
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        Button button5 = new Button();
        Button button6 = new Button();
        Button button7 = new Button();
        Button button8 = new Button();
        Button button9 = new Button();
        buttonGrid.add(button1, 0, 0);
        buttonGrid.add(button2, 1, 0);
        buttonGrid.add(button3, 2, 0);
        buttonGrid.add(button4, 0, 1);
        buttonGrid.add(button5, 1, 1);
        buttonGrid.add(button6, 2, 1);
        buttonGrid.add(button7, 0, 2);
        buttonGrid.add(button8, 1, 2);
        buttonGrid.add(button9, 2, 2);
        button1.setFont(Font.font("Monospaced", 40));
        button2.setFont(Font.font("Monospaced", 40));
        button3.setFont(Font.font("Monospaced", 40));
        button4.setFont(Font.font("Monospaced", 40));
        button5.setFont(Font.font("Monospaced", 40));
        button6.setFont(Font.font("Monospaced", 40));
        button7.setFont(Font.font("Monospaced", 40));
        button8.setFont(Font.font("Monospaced", 40));
        button9.setFont(Font.font("Monospaced", 40));
        button1.setPrefSize(80, 80);
        button2.setPrefSize(80, 80);
        button3.setPrefSize(80, 80);
        button4.setPrefSize(80, 80);
        button5.setPrefSize(80, 80);
        button6.setPrefSize(80, 80);
        button7.setPrefSize(80, 80);
        button8.setPrefSize(80, 80);
        button9.setPrefSize(80, 80);

        button1.setOnAction(actionEvent -> {updateGUI(button1,0,turnLabel);});
        button2.setOnAction(actionEvent -> {updateGUI(button2,1,turnLabel);});
        button3.setOnAction(actionEvent -> {updateGUI(button3,2,turnLabel);});
        button4.setOnAction(actionEvent -> {updateGUI(button4,3,turnLabel);});
        button5.setOnAction(actionEvent -> {updateGUI(button5,4,turnLabel);});
        button6.setOnAction(actionEvent -> {updateGUI(button6,5,turnLabel);});
        button7.setOnAction(actionEvent -> {updateGUI(button7,6,turnLabel);});
        button8.setOnAction(actionEvent -> {updateGUI(button8,7,turnLabel);});
        button9.setOnAction(actionEvent -> {updateGUI(button9,8,turnLabel);});

        layout.setTop(turnLabel);
        layout.setCenter(buttonGrid);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    private void updateGUI(Button buttonPressed, int buttonNumber, Label turnLabel) {
        Player currentPlayer = game.getPlayerTurn();
        if (game.play(buttonNumber)) {
            buttonPressed.setText(String.valueOf(currentPlayer.getMark()));
            turnLabel.setText(game.gameInfo());
        }

    }
}
