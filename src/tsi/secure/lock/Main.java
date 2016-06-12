package tsi.secure.lock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tsi.secure.lock.components.*;
import tsi.secure.lock.data.UserData;
import tsi.secure.lock.data.UserDataGen;
import tsi.secure.lock.startic.Reference;

import java.util.List;

public class Main extends Application {

    private CenterComponent centerComponent;
    private TopComponent topComponent;

    private Stage primaryStage;
    private BorderPane root;
    private Scene scene;

    private TextFieldComponent screen;
    private ButtonComponent zeroButton;
    private ButtonComponent oneButton;
    private ButtonComponent twoButton;
    private ButtonComponent threeButton;
    private ButtonComponent fourButton;
    private ButtonComponent fiveButton;
    private ButtonComponent sixButton;
    private ButtonComponent sevenButton;
    private ButtonComponent eighthButton;
    private ButtonComponent nineButton;
    private ButtonComponent backButton;
    private ButtonComponent cancelButton;

    private TableComponent userDataTable;
    private ButtonComponent addUserDataButton;
    private ButtonComponent clearAllUserDataButton;
    private ButtonComponent deleteUserDataButton;

    private List<UserData> userData;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(Reference.TITLE);

        initRootLayout();
        final List<UserData> userData = initUserData();
        initTableData(userData);
    }

    private void initTableData(final List<UserData> userData) {
        userDataTable.setData(userData);
    }

    private List<UserData> initUserData() {
        final UserDataGen gen = new UserDataGen();
        return gen.createSomeData();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void initRootLayout() {
        centerComponent = new CenterComponent();
        topComponent = new TopComponent();

        screen = new TextFieldComponent();
        screen.setTextFieldPosition(100, 120);
        screen.setTextFieldSize(160, 50);
        screen.setTextFieldReadonly(true);

        oneButton = new ButtonComponent();
        oneButton.setButtonText("1");
        oneButton.setButtonPosition(100, 200);
        oneButton.setButtonSize(40, 40);

        twoButton = new ButtonComponent();
        twoButton.setButtonText("2");
        twoButton.setButtonPosition(160, 200);
        twoButton.setButtonSize(40, 40);

        threeButton = new ButtonComponent();
        threeButton.setButtonText("3");
        threeButton.setButtonPosition(220, 200);
        threeButton.setButtonSize(40, 40);

        fourButton = new ButtonComponent();
        fourButton.setButtonText("4");
        fourButton.setButtonPosition(100, 260);
        fourButton.setButtonSize(40, 40);

        fiveButton = new ButtonComponent();
        fiveButton.setButtonText("5");
        fiveButton.setButtonPosition(160, 260);
        fiveButton.setButtonSize(40, 40);

        sixButton = new ButtonComponent();
        sixButton.setButtonText("6");
        sixButton.setButtonPosition(220, 260);
        sixButton.setButtonSize(40, 40);

        sevenButton = new ButtonComponent();
        sevenButton.setButtonText("7");
        sevenButton.setButtonPosition(100, 320);
        sevenButton.setButtonSize(40, 40);

        eighthButton = new ButtonComponent();
        eighthButton.setButtonText("8");
        eighthButton.setButtonPosition(160, 320);
        eighthButton.setButtonSize(40, 40);

        nineButton = new ButtonComponent();
        nineButton.setButtonText("9");
        nineButton.setButtonPosition(220, 320);
        nineButton.setButtonSize(40, 40);

        cancelButton = new ButtonComponent();
        cancelButton.setButtonText("C");
        cancelButton.setButtonPosition(100, 380);
        cancelButton.setButtonSize(40, 40);

        zeroButton = new ButtonComponent();
        zeroButton.setButtonText("0");
        zeroButton.setButtonPosition(160, 380);
        zeroButton.setButtonSize(40, 40);

        backButton = new ButtonComponent();
        backButton.setButtonText("<-");
        backButton.setButtonPosition(220, 380);
        backButton.setButtonSize(40, 40);

        userDataTable = new TableComponent();
        userDataTable.setTableViewPosition(400, 200);
        userDataTable.setTableViewSize(300, 220);



        centerComponent.addComponent(screen.init());
        centerComponent.addComponent(oneButton.init());
        centerComponent.addComponent(twoButton.init());
        centerComponent.addComponent(threeButton.init());
        centerComponent.addComponent(fourButton.init());
        centerComponent.addComponent(fiveButton.init());
        centerComponent.addComponent(sixButton.init());
        centerComponent.addComponent(sevenButton.init());
        centerComponent.addComponent(eighthButton.init());
        centerComponent.addComponent(nineButton.init());
        centerComponent.addComponent(cancelButton.init());
        centerComponent.addComponent(zeroButton.init());
        centerComponent.addComponent(backButton.init());

        centerComponent.addComponent(userDataTable.init());

        root = new BorderPane();
        root.setCenter(centerComponent.init());
        root.setTop(topComponent.init());




        scene = new Scene(root, Reference.MAIN_WINDOW_WIDTH, Reference.MAIN_WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
