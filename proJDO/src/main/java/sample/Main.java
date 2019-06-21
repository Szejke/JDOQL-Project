package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.jdo.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.scene.control.Button;

public class Main extends Application {

     Gui gui = new Gui();
     Database database = new Database();


    @Override
    public void start(Stage primaryStage) throws Exception{

       gui.startGui(primaryStage);


        primaryStage.show();

        database.pmf.close();
    }




    public static void main(String[] args) {

        launch(args);
    }
}
