import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Example extends Application {

    private static final double MIN = 300, MAX = 700, DELTA = 100;
    private Button centerBtn;
    @Override
    public void start(Stage stage) throws Exception   {

        Button leftBtn = new Button("Left");
        HBox.setHgrow(leftBtn, Priority.NEVER);

        centerBtn = new Button("Click to change width");
        HBox.setHgrow(leftBtn, Priority.NEVER);
        centerBtn.widthProperty().addListener((obs, oldValue,newValue)-> {
            //change the logic as needed
            leftBtn.setPrefWidth(newValue.doubleValue() >= 600 ? 200 : 250);
        });
        centerBtn.setPrefSize(600, 0);
        centerBtn.setOnAction(e-> changeCenterBtnWidth());
        Button rightBtn = new Button("Right");
        HBox.setHgrow(rightBtn, Priority.ALWAYS);
        Pane root = new HBox(leftBtn,centerBtn,rightBtn);
        root.setPrefSize(1000, 150);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void changeCenterBtnWidth() {
        double newWidth = centerBtn.getWidth() +  DELTA;
        newWidth = newWidth < MAX ? newWidth : MIN;
        centerBtn.setPrefWidth(newWidth);
    }

    public static void main(String[] args) {
        launch(args);
    }
}