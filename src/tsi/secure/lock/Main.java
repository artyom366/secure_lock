package tsi.secure.lock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tsi.secure.lock.components.*;
import tsi.secure.lock.data.UserData;
import tsi.secure.lock.data.UserDataGen;
import tsi.secure.lock.startic.Reference;
import tsi.secure.lock.ui.MainLayout;

import java.util.List;

public class Main extends Application {

    private Stage primaryStage;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final MainLayout mainLayout = new MainLayout();
        final BorderPane root = mainLayout.initRootLayout();

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(Reference.TITLE);

        scene = new Scene(root, Reference.MAIN_WINDOW_WIDTH, Reference.MAIN_WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        mainLayout.InitTableData();
    }



    public static void main(String[] args) {
        launch(args);
    }




}
